package com.bennyhuo.tieguanyin.compiler.fragment;

import com.bennyhuo.tieguanyin.compiler.basic.RequiredField;
import com.bennyhuo.tieguanyin.compiler.utils.JavaTypes;
import com.bennyhuo.tieguanyin.compiler.utils.Utils;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;

import java.util.ArrayList;
import java.util.Set;

import javax.lang.model.element.Modifier;

/**
 * Created by benny on 1/31/18.
 */

public class SaveStateMethod {

    private MethodSpec.Builder methodBuilder;
    private FragmentClass fragmentClass;
    private ArrayList<RequiredField> visitedBindings = new ArrayList<>();

    public SaveStateMethod(FragmentClass fragmentClass) {
        this.fragmentClass = fragmentClass;
        methodBuilder = MethodSpec.methodBuilder("saveState")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(TypeName.VOID)
                .addParameter(JavaTypes.SUPPORT_FRAGMENT, "fragment")
                .addParameter(JavaTypes.BUNDLE, "outState")
                .beginControlFlow("if(fragment instanceof $T)", fragmentClass.getType())
        .addStatement("$T typedFragment = ($T) fragment", fragmentClass.getType(), fragmentClass.getType());

        methodBuilder.addStatement("$T intent = new $T()", JavaTypes.INTENT, JavaTypes.INTENT);
    }

    public void visitField(RequiredField binding) {
        String name = binding.getName();
        Set<Modifier> modifiers = binding.getSymbol().getModifiers();
        if(modifiers.contains(Modifier.PRIVATE)){
            methodBuilder.addStatement("intent.putExtra($S, typedFragment.get$L())", name, Utils.capitalize(name));
        } else {
            methodBuilder.addStatement("intent.putExtra($S, typedFragment.$L)", name, name);
        }
        visitedBindings.add(binding);
    }

    public void end() {
        methodBuilder.addStatement("outState.putAll(intent.getExtras())").endControlFlow();
    }

    public MethodSpec build() {
        return methodBuilder.build();
    }
}
