/*
   Copyright 2009-2013 Attila Szegedi

   Licensed under either the Apache License, Version 2.0 (the "Apache
   License") or the 3-clause BSD License (the "BSD License"), with licensee
   being free to choose either of the two at their discretion.

   You may not use this file except in compliance with either the Apache
   License or the BSD License.

   A copy of the BSD License is available in the root directory of the
   source distribution of the project under the file name
   "LICENSE-BSD.txt".

   A copy of the Apache License is available in the root directory of the
   source distribution of the project under the file name
   "LICENSE-Apache-2.0.txt". Alternatively, you may obtain a copy of the
   Apache License at <http://www.apache.org/licenses/LICENSE-2.0>

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See your chosen License for the specific language governing permissions
   and limitations under that License.
*/

package org.dynalang.dynalink.beans;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import org.dynalang.dynalink.MonomorphicCallSite;
import org.dynalang.dynalink.linker.GuardedInvocation;
import org.dynalang.dynalink.support.CallSiteDescriptorFactory;

public class RelinkCountingCallSite extends MonomorphicCallSite {
    private int relinkCount;

    public RelinkCountingCallSite(String name, MethodType type) {
        super(CallSiteDescriptorFactory.create(MethodHandles.publicLookup(), name, type));
    }

    @Override
    public void relink(GuardedInvocation guardedInvocation, MethodHandle relink) {
        super.relink(guardedInvocation, relink);
        ++relinkCount;
    }

    public int getRelinkCount() {
        return relinkCount;
    }
}
