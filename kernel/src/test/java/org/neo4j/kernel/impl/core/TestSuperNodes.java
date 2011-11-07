/**
 * Copyright (c) 2002-2011 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.kernel.impl.core;

import org.junit.Test;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.kernel.impl.AbstractNeo4jTestCase;
import org.neo4j.kernel.impl.MyRelTypes;

public class TestSuperNodes extends AbstractNeo4jTestCase
{
    @Test
    public void convertToSuperNode() throws Exception
    {
        Node node = getGraphDb().createNode();
        for ( int i = 0; i < 101; i++ )
        {
            node.createRelationshipTo( getGraphDb().createNode(), MyRelTypes.values()[i%MyRelTypes.values().length] );
        }
        newTransaction();
        clearCache();
        
        for ( Relationship rel : node.getRelationships( MyRelTypes.TEST2 ) )
        {
            System.out.println( rel );
        }
    }
}
