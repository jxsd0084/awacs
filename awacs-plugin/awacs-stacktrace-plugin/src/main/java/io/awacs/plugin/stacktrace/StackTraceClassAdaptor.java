/**
 * Copyright 2016 AWACS Project.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.awacs.plugin.stacktrace;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

/**
 *
 * Created by pixyonly on 16/11/22.
 */
public class StackTraceClassAdaptor extends ClassNode {

    public StackTraceClassAdaptor(ClassVisitor cv) {
        super(Opcodes.ASM5);
        this.cv = cv;
    }

    public void visitEnd() {
        ClassTransformer ct = new FilteredClassTransformer();
        ct.visit(this);
        accept(cv);
    }
}