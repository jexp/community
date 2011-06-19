###
Copyright (c) 2002-2011 "Neo Technology,"
Network Engine for Objects in Lund AB [http://neotechnology.com]

This file is part of Neo4j.

Neo4j is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
###

define ['./JmxBackedModel','lib/backbone'], (JmxBackedModel) ->
  
  class DiskUsage extends JmxBackedModel
    
    beans :
      diskUsage : { domain : 'neo4j', name:'Store file sizes' }

    getDatabaseSize : =>
      @get("TotalStoreSize") - @get("LogicalLogSize")
      
    getDatabasePercentage : =>
      Math.round( ((@get("TotalStoreSize") - @get("LogicalLogSize")) / @get("TotalStoreSize")) * 100 )

    getLogicalLogSize : =>
      @get("LogicalLogSize")

    getLogicalLogPercentage : =>
      Math.round((@get("LogicalLogSize") / @get("TotalStoreSize")) * 100)