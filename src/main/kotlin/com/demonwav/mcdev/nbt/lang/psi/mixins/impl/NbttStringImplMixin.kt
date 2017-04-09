/*
 * Minecraft Dev for IntelliJ
 *
 * https://minecraftdev.org
 *
 * Copyright (c) 2017 minecraft-dev
 *
 * MIT License
 */

package com.demonwav.mcdev.nbt.lang.psi.mixins.impl

import com.demonwav.mcdev.nbt.lang.psi.mixins.NbttStringMixin
import com.demonwav.mcdev.nbt.tags.TagString
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

abstract class NbttStringImplMixin(node: ASTNode) : ASTWrapperPsiElement(node), NbttStringMixin {

    override fun getStringTag(): TagString {
        val noQuotes = text.let { it.substring(1, it.length - 1) }

        return TagString(noQuotes.replace("\\\\", "\\").replace("\\n", "\n").replace("\\\"", "\""))
    }
}
