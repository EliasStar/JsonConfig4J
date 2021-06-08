/*
 * Copyright (C) 2021 Elias*
 *
 * This file is part of JsonConfig4J.
 *
 * JsonConfig4J is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or any later version.
 *
 * JsonConfig4J is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * JsonConfig4J. If not, see <https://www.gnu.org/licenses/>.
 */
package eliasstar.config;

/**
 * SimpleConfig support for Lambda functions.
 *
 * @author Elias*
 * @since 1.0.0
 */
public final class SimpleConfigLambda extends SimpleConfig {

    private final Function setup;

    public SimpleConfigLambda(Function setup) {
        this.setup = setup;
    }

    @Override
    public void setup() {
        setup.call();
    }

    @FunctionalInterface
    public interface Function {
        public void call();
    }

}