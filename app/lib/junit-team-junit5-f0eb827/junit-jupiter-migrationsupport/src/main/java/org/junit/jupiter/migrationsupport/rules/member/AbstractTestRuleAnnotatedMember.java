/*
 * Copyright 2015-2024 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

package org.junit.jupiter.migrationsupport.rules.member;

import org.junit.rules.TestRule;

/**
 * @since 5.0
 */
abstract class AbstractTestRuleAnnotatedMember implements TestRuleAnnotatedMember {

	private final TestRule testRule;

	AbstractTestRuleAnnotatedMember(TestRule testRule) {
		this.testRule = testRule;
	}

	@Override
	public TestRule getTestRule() {
		return this.testRule;
	}

}
