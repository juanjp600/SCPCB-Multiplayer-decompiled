Function fillroom%(arg0.rooms)
    Local local0.doors
    Local local1.doors
    Local local2.securitycams
    Local local3.decals
    Local local4.rooms
    Local local5%
    Local local6.items
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local13.forest
    Local local14.emitters
    Local local15%
    Local local16%
    Local local17%
    Local local18%
    Local local19%
    Local local21#
    Local local22#
    Local local24%
    Local local26.waypoints
    Local local27.waypoints
    Local local28#
    Local local29%
    Local local31#
    Local local32$
    Local local33$
    Local local34%
    Local local37%
    Local local39#
    Local local47%
    Local local48%
    Local local49%
    Local local50%
    Local local51%
    Local local52$
    Local local53%
    Local local54%
    Local local56%
    Local local57#
    Local local59%
    Local local60%
    Local local61%
    Local local62#
    Local local63%
    Local local65.lighttemplates
    Local local66%
    Local local67.tempscreens
    Local local68.tempwaypoints
    allowroomdoorsinit = arg0
    If (getscripts() <> 0) Then
        public_inqueue($47, $00)
        public_addparam($00, (Str arg0\Field69), $01)
        public_addparam($00, (Str arg0\Field3), $02)
        public_addparam($00, (Str arg0\Field4), $02)
        public_addparam($00, (Str arg0\Field5), $02)
        public_addparam($00, "0.00390625", $02)
        callback($00)
    EndIf
    Select arg0\Field7\Field10
        Case "room860"
            arg0\Field25[$02] = loadmesh_strict("GFX\map\forest\door_frame.b3d", $00, $00)
            positionentity(arg0\Field25[$02], (arg0\Field3 + 0.71875), 0.0, arg0\Field5, $01)
            scaleentity(arg0\Field25[$02], (1.0 / 5.688889), (1.0 / 5.688889), (1.0 / 3.2), $01)
            entityparent(arg0\Field25[$02], arg0\Field2, $01)
            arg0\Field25[$03] = loadmesh_strict("GFX\map\forest\door.b3d", $00, $00)
            positionentity(arg0\Field25[$03], (arg0\Field3 + 0.4375), 0.0, (arg0\Field5 + 0.05), $01)
            entitytype(arg0\Field25[$03], $01, $00)
            scaleentity(arg0\Field25[$03], (1.0 / 5.565217), (1.0 / 5.688889), (1.0 / 5.565217), $01)
            entityparent(arg0\Field25[$03], arg0\Field2, $01)
            arg0\Field25[$04] = copyentity(arg0\Field25[$03], $00)
            positionentity(arg0\Field25[$04], (arg0\Field3 + 1.0), 0.0, (arg0\Field5 - 0.05), $01)
            rotateentity(arg0\Field25[$04], 0.0, 180.0, 0.0, $00)
            scaleentity(arg0\Field25[$04], (1.0 / 5.565217), (1.0 / 5.688889), (1.0 / 5.565217), $01)
            entityparent(arg0\Field25[$04], arg0\Field2, $01)
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 + 3.625), 0.0, (arg0\Field5 + 2.5), 0.0, arg0, server\Field21, $00, $00, "ABCD", $00)
            arg0\Field29[$00]\Field21 = (server\Field21 = $00)
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 + 3.625), 0.0, (arg0\Field5 - 2.5), 0.0, arg0, $01, $00, $00, "ABCD", $00)
            arg0\Field29[$01]\Field21 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + 1.625), 0.0, (arg0\Field5 - 2.5), 0.0, arg0, $00, $00, $01, "", $00)
            local0 = createdoor(arg0\Field0, (arg0\Field3 + 1.625), 0.0, (arg0\Field5 + 2.5), 0.0, arg0, $00, $00, $01, "", $00)
            If (i_zone\Field1 = $00) Then
                local13 = (New forest)
                arg0\Field11 = local13
                genforestgrid(local13)
                placeforest(local13, arg0\Field3, (arg0\Field4 + 100.0), arg0\Field5, arg0)
            EndIf
            If (server\Field21 = $00) Then
                local6 = createitem("Document SCP-860-1", "paper", (arg0\Field3 + 2.625), (arg0\Field4 + 0.6875), (arg0\Field5 + 1.308594), $00, $00, $00, 1.0, $00, $01)
                rotateentity(local6\Field1, 0.0, (Float (arg0\Field6 + $0A)), 0.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
                local6 = createitem("Document SCP-860", "paper", (arg0\Field3 + 4.5), (arg0\Field4 + 0.6875), (arg0\Field5 - 1.5), $00, $00, $00, 1.0, $00, $01)
                rotateentity(local6\Field1, 0.0, (Float (arg0\Field6 + $AA)), 0.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (arg0\Field3 + 2.625), (arg0\Field4 + 0.6875), (arg0\Field5 + 1.308594), $00, $00, $00, 1.0, $00, $01)
                rotateentity(local6\Field1, 0.0, (Float (arg0\Field6 + $0A)), 0.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
                local6 = createitem("Rocket Launcher", "rpg", (arg0\Field3 + 4.5), (arg0\Field4 + 0.6875), (arg0\Field5 - 1.5), $00, $00, $00, 1.0, $00, $01)
                rotateentity(local6\Field1, 0.0, (Float (arg0\Field6 + $AA)), 0.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
        Case "lockroom"
            local0 = createdoor(arg0\Field0, (arg0\Field3 - 2.875), 0.0, (arg0\Field5 - 0.40625), 0.0, arg0, $01, $00, $00, "", $00)
            local0\Field10 = (((server\Field21 * $05) + $05) * $46)
            local0\Field21 = $00
            local0\Field5 = $00
            entityparent(local0\Field3[$00], $00, $01)
            positionentity(local0\Field3[$00], (arg0\Field3 - 1.125), 0.7, (arg0\Field5 - 2.5), $00)
            entityparent(local0\Field3[$00], arg0\Field2, $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local1 = createdoor(arg0\Field0, (arg0\Field3 + 0.40625), 0.0, (arg0\Field5 + 2.875), 270.0, arg0, $01, $00, $00, "", $00)
            local1\Field10 = (((server\Field21 * $05) + $05) * $46)
            local1\Field21 = $00
            local1\Field5 = $00
            entityparent(local1\Field3[$00], $00, $01)
            positionentity(local1\Field3[$00], (arg0\Field3 + 2.5), 0.7, (arg0\Field5 + 1.125), $00)
            rotateentity(local1\Field3[$00], 0.0, 90.0, 0.0, $00)
            entityparent(local1\Field3[$00], arg0\Field2, $01)
            freeentity(local1\Field3[$01])
            local1\Field3[$01] = $00
            local0\Field22 = local1
            local1\Field22 = local0
            local2 = createsecuritycam((arg0\Field3 - 2.6875), (arg0\Field4 + 1.5), (arg0\Field5 + 2.6875), arg0, $01)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            local2\Field9 = $01
            entitytexture(local2\Field4, screentexs[local2\Field9], $00, $00)
            turnentity(local2\Field3, 40.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, (arg0\Field3 + 2.609375), 1.1, (arg0\Field5 - 0.375), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 - 0.4375), (arg0\Field4 + 1.5), (arg0\Field5 + 0.4375), arg0, $01)
            local2\Field11 = 45.0
            local2\Field12 = 45.0
            local2\Field9 = $01
            entitytexture(local2\Field4, screentexs[local2\Field9], $00, $00)
            turnentity(local2\Field3, 40.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, (arg0\Field3 + 0.375), 1.1, (arg0\Field5 - 2.609375), $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            local14 = createemitter((arg0\Field3 - (1.0 / 1.462857)), 1.445312, (arg0\Field5 + 2.5625), $00, 0.0)
            turnentity(local14\Field0, 90.0, 0.0, 0.0, $01)
            entityparent(local14\Field0, arg0\Field2, $01)
            local14\Field10 = 20.0
            local14\Field9 = 0.05
            local14\Field11 = 0.007
            local14\Field12 = -0.006
            local14\Field4 = -0.24
            local14 = createemitter((arg0\Field3 - 2.558594), 1.445312, (arg0\Field5 + 0.9375), $00, 0.0)
            turnentity(local14\Field0, 90.0, 0.0, 0.0, $01)
            entityparent(local14\Field0, arg0\Field2, $01)
            local14\Field10 = 20.0
            local14\Field9 = 0.05
            local14\Field11 = 0.007
            local14\Field12 = -0.006
            local14\Field4 = -0.24
        Case "lockroom2"
            For local7 = $00 To $05 Step $01
                local3 = createdecal(rand($02, $03), (arg0\Field3 + (rnd(-392.0, 520.0) * (1.0 / 256.0))), (rnd(0.0, 0.001) + (1.0 / 85.33334)), (arg0\Field5 + (rnd(-392.0, 520.0) * (1.0 / 256.0))), 90.0, rnd(360.0, 0.0), 0.0)
                local3\Field2 = rnd(0.3, 0.6)
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                createdecal(rand($0F, $10), (arg0\Field3 + (rnd(-392.0, 520.0) * (1.0 / 256.0))), (rnd(0.0, 0.001) + (1.0 / 85.33334)), (arg0\Field5 + (rnd(-392.0, 520.0) * (1.0 / 256.0))), 90.0, rnd(360.0, 0.0), 0.0)
                local3\Field2 = rnd(0.1, 0.6)
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                createdecal(rand($0F, $10), (arg0\Field3 + rnd(-0.5, 0.5)), (rnd(0.0, 0.001) + (1.0 / 85.33334)), (arg0\Field5 + rnd(-0.5, 0.5)), 90.0, rnd(360.0, 0.0), 0.0)
                local3\Field2 = rnd(0.1, 0.6)
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
            Next
            local2 = createsecuritycam((arg0\Field3 + 2.0), (arg0\Field4 + 1.5), (arg0\Field5 + 1.5), arg0, $01)
            local2\Field11 = 135.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 40.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, (arg0\Field3 + 2.609375), 1.1, (arg0\Field5 - 0.375), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 - 1.5), (arg0\Field4 + 1.5), (arg0\Field5 - 2.0), arg0, $01)
            local2\Field11 = 315.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 40.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, (arg0\Field3 + 0.375), 1.1, (arg0\Field5 - 2.609375), $00)
            entityparent(local2\Field4, arg0\Field2, $01)
        Case "gatea"
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 - 15.875), (arg0\Field4 - 5.0), (arg0\Field5 + 15.4375), 0.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$02]\Field5 = $00
            local1 = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, (arg0\Field5 - 4.0), 0.0, arg0, $00, $00, $00, "", $00)
            local1\Field21 = $00
            local1\Field5 = $00
            local1\Field4 = $01
            local1 = createdoor(arg0\Field0, (arg0\Field3 - 5.625), (arg0\Field4 - 1.875), (arg0\Field5 + 9.09375), 0.0, arg0, $00, $00, $02, "", $00)
            If (selectedending = "A2") Then
                local1\Field21 = $00
                local1\Field5 = $01
                local1\Field4 = $01
            Else
                local1\Field21 = $00
                local1\Field5 = $00
                local1\Field4 = $00
            EndIf
            positionentity(local1\Field3[$00], (arg0\Field3 - 5.15625), entityy(local1\Field3[$00], $01), (arg0\Field5 + 8.9375), $01)
            positionentity(local1\Field3[$01], (arg0\Field3 - 6.1875), entityy(local1\Field3[$00], $01), (arg0\Field5 + 9.71875), $01)
            rotateentity(local1\Field3[$01], 0.0, 90.0, 0.0, $01)
            local1 = createdoor(arg0\Field0, (arg0\Field3 - 5.625), (arg0\Field4 - 1.875), (arg0\Field5 + 17.0), 0.0, arg0, $00, $00, $02, "", $00)
            If (selectedending = "A2") Then
                local1\Field21 = $00
                local1\Field5 = $01
                local1\Field4 = $01
            Else
                local1\Field21 = $00
                local1\Field5 = $00
                local1\Field4 = $00
            EndIf
            positionentity(local1\Field3[$00], (arg0\Field3 - 5.15625), entityy(local1\Field3[$00], $01), (arg0\Field5 + 17.125), $01)
            rotateentity(local1\Field3[$00], 0.0, 180.0, 0.0, $01)
            positionentity(local1\Field3[$01], (arg0\Field3 - 6.1875), entityy(local1\Field3[$00], $01), (arg0\Field5 + 16.53125), $01)
            rotateentity(local1\Field3[$01], 0.0, 90.0, 0.0, $01)
            For local4 = Each rooms
                If (local4\Field7\Field10 = "exit1") Then
                    arg0\Field25[$01] = local4\Field25[$01]
                    arg0\Field25[$02] = local4\Field25[$02]
                ElseIf (local4\Field7\Field10 = "gateaentrance") Then
                    arg0\Field29[$01] = createdoor($00, (arg0\Field3 + 6.03125), arg0\Field4, (arg0\Field5 - 0.25), 90.0, arg0, $00, $03, $00, "", $00)
                    arg0\Field29[$01]\Field21 = $00
                    arg0\Field29[$01]\Field5 = $00
                    positionentity(arg0\Field29[$01]\Field3[$00], (arg0\Field3 + 6.1875), entityy(arg0\Field29[$01]\Field3[$00], $01), (arg0\Field5 + (1.0 / 3.2)), $01)
                    positionentity(arg0\Field29[$01]\Field3[$01], (arg0\Field3 + 5.6875), entityy(arg0\Field29[$01]\Field3[$01], $01), (arg0\Field5 - 0.8125), $01)
                    local4\Field25[$01] = createpivot($00)
                    positionentity(local4\Field25[$01], (arg0\Field3 + 7.21875), (arg0\Field4 + 0.9375), (arg0\Field5 - 0.25), $01)
                    entityparent(local4\Field25[$01], arg0\Field2, $01)
                EndIf
            Next
            arg0\Field25[$03] = createpivot($00)
            positionentity(arg0\Field25[$03], (arg0\Field3 + 4.75), arg0\Field4, (arg0\Field5 + 8.25), $01)
            entityparent(arg0\Field25[$03], arg0\Field2, $01)
            arg0\Field25[$04] = createpivot($00)
            positionentity(arg0\Field25[$04], arg0\Field3, (arg0\Field4 + 0.375), (arg0\Field5 + 25.0), $01)
            entityparent(arg0\Field25[$04], arg0\Field2, $01)
            arg0\Field25[$05] = createpivot($00)
            positionentity(arg0\Field25[$05], (arg0\Field3 + 6.96875), (arg0\Field4 + 8.296875), (arg0\Field5 + 17.625), $01)
            entityparent(arg0\Field25[$05], arg0\Field2, $01)
            arg0\Field25[$06] = createpivot($00)
            positionentity(arg0\Field25[$06], (arg0\Field3 - 19.71875), (arg0\Field4 + 7.46875), (arg0\Field5 + 18.1875), $01)
            entityparent(arg0\Field25[$06], arg0\Field2, $01)
            arg0\Field25[$07] = createpivot($00)
            positionentity(arg0\Field25[$07], (arg0\Field3 + 7.125), (arg0\Field4 + 0.875), (arg0\Field5 + 27.5625), $01)
            entityparent(arg0\Field25[$07], arg0\Field2, $01)
            arg0\Field25[$08] = createpivot($00)
            positionentity(arg0\Field25[$08], (arg0\Field3 - 7.125), (arg0\Field4 + 0.875), (arg0\Field5 + 27.5625), $01)
            entityparent(arg0\Field25[$08], arg0\Field2, $01)
            arg0\Field25[$09] = createpivot($00)
            positionentity(arg0\Field25[$09], (arg0\Field3 + 10.25), (arg0\Field4 + 3.875), (arg0\Field5 + 24.05078), $01)
            entityparent(arg0\Field25[$09], arg0\Field2, $01)
            arg0\Field25[$0B] = createpivot($00)
            positionentity(arg0\Field25[$0B], (arg0\Field3 - 15.875), (arg0\Field4 - 4.875), (arg0\Field5 - 6.625), $01)
            entityparent(arg0\Field25[$0B], arg0\Field2, $01)
            local15 = createcube($00)
            entityalpha(local15, 0.0)
            positionentity(local15, (arg0\Field3 - 16.25), (arg0\Field4 - 4.082031), (arg0\Field5 - 7.5), $00)
            moveentity(local15, 0.3, 0.0, -0.3)
            scaleentity(local15, 0.55, 0.55, 0.55, $00)
            entitytype(local15, $01, $00)
            entityparent(local15, arg0\Field2, $01)
            arg0\Field25[$1B] = createpivot($00)
            positionentity(arg0\Field25[$1B], (arg0\Field3 - 16.25), (arg0\Field4 - 4.082031), (arg0\Field5 - 7.5), $00)
            moveentity(arg0\Field25[$1B], 0.3, 0.1, 30.0)
            entityparent(arg0\Field25[$1B], arg0\Field2, $01)
            arg0\Field25[$0D] = loadmesh_strict("GFX\map\gateawall1.b3d", arg0\Field2, $00)
            positionentity(arg0\Field25[$0D], (arg0\Field3 - 16.82812), (arg0\Field4 - 4.082031), (arg0\Field5 + 2.125), $01)
            entitycolor(arg0\Field25[$0D], 25.0, 25.0, 25.0)
            entitytype(arg0\Field25[$0D], $01, $00)
            arg0\Field25[$0E] = loadmesh_strict("GFX\map\gateawall2.b3d", arg0\Field2, $00)
            positionentity(arg0\Field25[$0E], (arg0\Field3 - 14.92188), (arg0\Field4 - 4.082031), (arg0\Field5 + 2.125), $01)
            entitycolor(arg0\Field25[$0E], 25.0, 25.0, 25.0)
            entitytype(arg0\Field25[$0E], $01, $00)
            hideentity(arg0\Field25[$0D])
            hideentity(arg0\Field25[$0E])
            arg0\Field25[$0F] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$0F], (arg0\Field3 - 13.9375), (arg0\Field4 - 4.253906), (arg0\Field5 + 19.3125), $01)
            arg0\Field25[$10] = loadmesh_strict("GFX\map\gatea_hitbox1.b3d", arg0\Field2, $00)
            entitypickmode(arg0\Field25[$10], $02, $01)
            entitytype(arg0\Field25[$10], $01, $00)
            entityalpha(arg0\Field25[$10], 0.0)
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 - 5.33914), (arg0\Field4 + 0.302002), (arg0\Field5 - 1.065562), -45.0)
            local16 = createcube($00)
            scaleentity(local16, 2.12, 6.0, 2.59, $00)
            positionentity(local16, (arg0\Field3 + 3.560786), (arg0\Field4 - 2.996094), (arg0\Field5 + 4.148674), $00)
            moveentity(local16, 0.5, 0.0, 0.1)
            entitytype(local16, $09, $00)
            entityalpha(local16, 0.0)
            entityparent(local16, arg0\Field2, $01)
            local16 = createcube($00)
            scaleentity(local16, 2.12, 6.0, 2.59, $00)
            positionentity(local16, (arg0\Field3 - 3.538257), (arg0\Field4 - 2.996094), (arg0\Field5 + 4.225296), $00)
            moveentity(local16, -0.5, 0.0, 0.0)
            entitytype(local16, $09, $00)
            entityalpha(local16, 0.0)
            entityparent(local16, arg0\Field2, $01)
        Case "gateaentrance"
            arg0\Field29[$00] = createdoor($00, (arg0\Field3 + 2.90625), 0.0, (arg0\Field5 + 2.0), 90.0, arg0, $01, $03, $00, "", $00)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $01
            positionentity(arg0\Field29[$00]\Field3[$01], (arg0\Field3 + 2.6875), entityy(arg0\Field29[$00]\Field3[$01], $01), (arg0\Field5 + 1.4375), $01)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + 3.0625), entityy(arg0\Field29[$00]\Field3[$00], $01), (arg0\Field5 + 2.5625), $01)
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (arg0\Field3 + 4.09375), 0.0, (arg0\Field5 + 2.0), $01)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            arg0\Field29[$01] = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - 1.40625), 0.0, arg0, $00, $01, $05, "", $00)
            arg0\Field29[$01]\Field9 = $01
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field5 = $00
            positionentity(arg0\Field29[$01]\Field3[$01], (arg0\Field3 + 1.648438), entityy(arg0\Field29[$00]\Field3[$01], $01), (arg0\Field5 - 2.25), $01)
            rotateentity(arg0\Field29[$01]\Field3[$01], 0.0, ((Float arg0\Field6) - 90.0), 0.0, $01)
            positionentity(arg0\Field29[$01]\Field3[$00], (arg0\Field3 - 2.039062), entityy(arg0\Field29[$01]\Field3[$00], $01), entityz(arg0\Field29[$01]\Field3[$00], $01), $01)
            rotateentity(arg0\Field29[$01]\Field3[$00], 0.0, ((Float arg0\Field6) - 225.0), 0.0, $01)
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 + 1.613648), (arg0\Field4 + 0.302), (arg0\Field5 + 3.142031), -179.0)
        Case "exit1"
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 + 17.01562), 38.15234, (arg0\Field5 + 10.10938), $01)
            arg0\Field29[$04] = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - 1.25), 0.0, arg0, $00, $01, $05, "", $00)
            arg0\Field29[$04]\Field9 = $01
            arg0\Field29[$04]\Field21 = $00
            arg0\Field29[$04]\Field5 = $00
            positionentity(arg0\Field29[$04]\Field3[$01], (arg0\Field3 + 1.398438), entityy(arg0\Field29[$04]\Field3[$01], $01), (arg0\Field5 - 2.0625), $01)
            rotateentity(arg0\Field29[$04]\Field3[$01], 0.0, ((Float arg0\Field6) - 90.0), 0.0, $01)
            positionentity(arg0\Field29[$04]\Field3[$00], entityx(arg0\Field29[$04]\Field3[$00], $01), entityy(arg0\Field29[$04]\Field3[$00], $01), (arg0\Field5 - (1.0 / 1.292929)), $01)
            rotateentity(arg0\Field29[$04]\Field3[$00], 0.0, ((Float arg0\Field6) - 180.0), 0.0, $01)
            arg0\Field25[$03] = createpivot($00)
            positionentity(arg0\Field25[$03], (arg0\Field3 - 30.0), 42.9375, (arg0\Field5 - 105.6562), $01)
            entityparent(arg0\Field25[$03], arg0\Field2, $01)
            arg0\Field25[$04] = createpivot($00)
            positionentity(arg0\Field25[$04], (arg0\Field3 + 20.32562), 47.375, (arg0\Field5 - 6.793711), $01)
            entityparent(arg0\Field25[$04], arg0\Field2, $01)
            arg0\Field25[$05] = createpivot($00)
            positionentity(arg0\Field25[$05], (arg0\Field3 + 17.04305), 41.15625, (arg0\Field5 + 10.80531), $01)
            entityparent(arg0\Field25[$05], arg0\Field2, $01)
            arg0\Field25[$06] = createpivot($00)
            positionentity(arg0\Field25[$06], (arg0\Field3 + 20.28125), 47.625, (arg0\Field5 - 6.875), $01)
            entityparent(arg0\Field25[$06], arg0\Field2, $01)
            arg0\Field25[$07] = createpivot($00)
            positionentity(arg0\Field25[$07], (arg0\Field3 + 20.28125), 47.625, (arg0\Field5 - 17.0), $01)
            entityparent(arg0\Field25[$07], arg0\Field2, $01)
            arg0\Field29[$00] = createdoor($00, (arg0\Field3 + 2.8125), 0.0, (arg0\Field5 + 5.59375), 0.0, arg0, $01, $03, $00, "", $00)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $01
            moveentity(arg0\Field29[$00]\Field3[$00], 0.0, 0.0, (1.0 / 11.63636))
            moveentity(arg0\Field29[$00]\Field3[$01], 0.0, 0.0, (1.0 / 11.63636))
            arg0\Field25[$08] = createpivot($00)
            positionentity(arg0\Field25[$08], (arg0\Field3 + 2.8125), 0.0, (arg0\Field5 + 6.8125), $01)
            entityparent(arg0\Field25[$08], arg0\Field2, $01)
            arg0\Field29[$01] = createdoor($00, (arg0\Field3 - 21.1875), 42.125, (arg0\Field5 - 5.390625), 0.0, arg0, $00, $03, $00, "", $00)
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field5 = $00
            moveentity(arg0\Field29[$01]\Field3[$00], 0.0, 0.0, (1.0 / 11.63636))
            moveentity(arg0\Field29[$01]\Field3[$01], 0.0, 0.0, (1.0 / 11.63636))
            arg0\Field25[$09] = createpivot($00)
            positionentity(arg0\Field25[$09], (arg0\Field3 - 21.1875), 42.125, (arg0\Field5 - 4.171875), $01)
            entityparent(arg0\Field25[$09], arg0\Field2, $01)
            arg0\Field29[$02] = createdoor($00, (arg0\Field3 + 17.0), 42.125, (arg0\Field5 - 1.921875), 0.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$02]\Field5 = $00
            arg0\Field29[$03] = createdoor($00, (arg0\Field3 + 17.0), 42.125, (arg0\Field5 + (1.0 / 0.512)), 0.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$03]\Field21 = $00
            arg0\Field29[$03]\Field5 = $00
            arg0\Field25[$0A] = createpivot($00)
            positionentity(arg0\Field25[$0A], (arg0\Field3 + 17.0), 42.10156, (arg0\Field5 + 5.25), $01)
            entityparent(arg0\Field25[$0A], arg0\Field2, $01)
            arg0\Field25[$0B] = createpivot($00)
            positionentity(arg0\Field25[$0B], (arg0\Field3 + 11.0), 43.0625, (arg0\Field5 - 11.0), $01)
            entityparent(arg0\Field25[$0B], arg0\Field2, $01)
            arg0\Field29[$05] = createdoor($00, (arg0\Field3 + 12.6875), 38.5, (arg0\Field5 + 25.0), 0.0, arg0, $00, $00, $00, "28084020", $00)
            arg0\Field29[$05]\Field21 = $00
            arg0\Field29[$05]\Field5 = $00
            local0 = createdoor($00, (arg0\Field3 + 12.0), 38.5, (arg0\Field5 + 22.65625), 90.0, arg0, $00, $00, $03, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            arg0\Field25[$0E] = createpivot($00)
            positionentity(arg0\Field25[$0E], (arg0\Field3 + 13.8125), 40.0625, (arg0\Field5 + 21.53125), $01)
            entityparent(arg0\Field25[$0E], arg0\Field2, $01)
            arg0\Field25[$0F] = createpivot($00)
            positionentity(arg0\Field25[$0F], (arg0\Field3 + 13.8125), 40.0625, (arg0\Field5 + 22.75), $01)
            entityparent(arg0\Field25[$0F], arg0\Field2, $01)
            arg0\Field25[$10] = createpivot($00)
            positionentity(arg0\Field25[$10], (arg0\Field3 + 15.0625), 40.0625, (arg0\Field5 + 21.53125), $01)
            entityparent(arg0\Field25[$10], arg0\Field2, $01)
            arg0\Field25[$11] = createpivot($00)
            positionentity(arg0\Field25[$11], (arg0\Field3 + 15.0625), 40.0625, (arg0\Field5 + 22.75), $01)
            entityparent(arg0\Field25[$11], arg0\Field2, $01)
            arg0\Field25[$12] = createpivot($00)
            positionentity(arg0\Field25[$12], (arg0\Field3 + 12.69531), 38.65625, (arg0\Field5 + 25.87109), $01)
            entityparent(arg0\Field25[$12], arg0\Field2, $01)
            arg0\Field25[$13] = createpivot($00)
            positionentity(arg0\Field25[$13], (arg0\Field3 + 14.875), 48.125, (arg0\Field5 - 53.0), $01)
            entityparent(arg0\Field25[$13], arg0\Field2, $01)
            arg0\Field25[$1A] = createpivot($00)
            positionentity(arg0\Field25[$1A], (arg0\Field3 + 17.0), 42.125, (arg0\Field5 + (1.0 / 0.512)), $00)
            moveentity(arg0\Field25[$1A], 0.0, 0.3, -8.0)
            entityparent(arg0\Field25[$1A], arg0\Field2, $01)
            arg0\Field25[$1B] = createpivot($00)
            positionentity(arg0\Field25[$1B], (arg0\Field3 + 12.0), 38.5, (arg0\Field5 + 22.65625), $00)
            entityparent(arg0\Field25[$1B], arg0\Field2, $01)
            If (server\Field21 <> 0) Then
                arg0\Field25[$16] = createbutton((arg0\Field3 + 15.50659), (arg0\Field4 + 38.96456), (arg0\Field5 + 22.76515), 80.0, -90.0, 0.0)
                entityparent(arg0\Field25[$16], arg0\Field2, $01)
            EndIf
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 + 3.409651), 0.0, (arg0\Field5 - (1.0 / 3.898312)), 115.0)
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 + -21.4809), (arg0\Field4 + 40.05485), (arg0\Field5 - 14.81771), 0.0)
        Case "roompj"
            If (server\Field21 = $00) Then
                local6 = createitem("Document SCP-372", "paper", (arg0\Field3 + 3.125), (arg0\Field4 + 0.6875), (arg0\Field5 + 4.328125), $00, $00, $00, 1.0, $00, $01)
                rotateentity(local6\Field1, 0.0, (Float arg0\Field6), 0.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("Small First Aid Kit", "finefirstaid", (arg0\Field3 + 3.125), (arg0\Field4 + 0.6875), (arg0\Field5 + 4.328125), $00, $00, $00, 1.0, $00, $01)
                rotateentity(local6\Field1, 0.0, (Float arg0\Field6), 0.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("Radio Transceiver", "radio", (arg0\Field3 + 3.125), (arg0\Field4 + 0.4375), (arg0\Field5 + 3.6875), $00, $00, $00, 1.0, $00, $01)
            local6\Field13 = 80.0
            entityparent(local6\Field1, arg0\Field2, $01)
            arg0\Field25[$03] = loadmesh_strict("GFX\map\372_hb.b3d", arg0\Field2, $00)
            entitypickmode(arg0\Field25[$03], $02, $01)
            entitytype(arg0\Field25[$03], $01, $00)
            entityalpha(arg0\Field25[$03], 0.0)
            arg0\Field29[$00] = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, (arg0\Field5 - 1.4375), 0.0, arg0, $01, $01, $02, "", $00)
            arg0\Field29[$00]\Field21 = $00
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 - 1.9375), 0.7, (arg0\Field5 - 1.0625), $01)
            turnentity(arg0\Field29[$00]\Field3[$00], 0.0, 90.0, 0.0, $00)
        Case "room079"
            arg0\Field29[$02] = createdoor(arg0\Field0, arg0\Field3, -1.75, (arg0\Field5 + 4.4375), 0.0, arg0, $00, $01, $04, "", $00)
            arg0\Field29[$02]\Field9 = $01
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$02]\Field5 = $00
            positionentity(arg0\Field29[$02]\Field3[$01], (arg0\Field3 + 0.875), (1.0 / -1.024), (arg0\Field5 + 3.585938), $01)
            positionentity(arg0\Field29[$02]\Field3[$00], (arg0\Field3 - 0.9375), (1.0 / -1.024), (arg0\Field5 + 5.335938), $01)
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 + 5.6875), -1.75, (arg0\Field5 + 3.8125), 0.0, arg0, $00, $01, $03, "", $00)
            arg0\Field29[$00]\Field9 = $01
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $00
            positionentity(arg0\Field29[$00]\Field3[$01], (arg0\Field3 + 6.875), (1.0 / -1.024), (arg0\Field5 + 4.828125), $01)
            turnentity(arg0\Field29[$00]\Field3[$00], 0.0, -180.0, 0.0, $01)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + 6.875), -0.9375, (arg0\Field5 + 2.890625), $01)
            turnentity(arg0\Field29[$00]\Field3[$01], 0.0, 0.0, 0.0, $01)
            arg0\Field29[$01] = createdoor($00, (arg0\Field3 + 4.46875), -1.75, (arg0\Field5 + 2.75), 90.0, arg0, $00, $00, $FFFFFFFF, "", $00)
            arg0\Field25[$00] = loadanimmesh_strict("GFX\map\079.b3d", $00, $00)
            scaleentity(arg0\Field25[$00], 1.3, 1.3, 1.3, $01)
            positionentity(arg0\Field25[$00], (arg0\Field3 + 7.25), -2.1875, (arg0\Field5 - 2.625), $01)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            turnentity(arg0\Field25[$00], 0.0, 180.0, 0.0, $01)
            arg0\Field25[$01] = createsprite(arg0\Field25[$00])
            spriteviewmode(arg0\Field25[$01], $02)
            positionentity(arg0\Field25[$01], 0.082, 0.119, 0.01, $00)
            scalesprite(arg0\Field25[$01], 0.09, 0.0725)
            turnentity(arg0\Field25[$01], 0.0, 13.0, 0.0, $00)
            moveentity(arg0\Field25[$01], 0.0, 0.0, -0.022)
            entitytexture(arg0\Field25[$01], oldaipics($00), $00, $00)
            hideentity(arg0\Field25[$01])
            arg0\Field25[$02] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$02], (arg0\Field3 + 4.625), -1.75, (arg0\Field5 + 7.0), $01)
            local3 = createdecal($03, (arg0\Field3 + 4.625), -1.74, (arg0\Field5 + 7.0), 90.0, rnd(360.0, 0.0), 0.0)
            local3\Field2 = 0.5
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityparent(local3\Field0, arg0\Field2, $01)
        Case "checkpoint1"
            arg0\Field29[$00] = createdoor($00, (arg0\Field3 + 0.1875), 0.0, (arg0\Field5 - 0.5), 0.0, arg0, $00, $00, ($03 - server\Field21), "", $00)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 - 0.59375), entityy(arg0\Field29[$00]\Field3[$00], $01), (arg0\Field5 - 1.375), $01)
            positionentity(arg0\Field29[$00]\Field3[$01], (arg0\Field3 - 0.59375), entityy(arg0\Field29[$00]\Field3[$01], $01), (arg0\Field5 + 0.375), $01)
            arg0\Field29[$01] = createdoor($00, (arg0\Field3 - 1.375), 0.0, (arg0\Field5 - 0.5), 0.0, arg0, $00, $00, ($03 - server\Field21), "", $00)
            arg0\Field29[$01]\Field22 = arg0\Field29[$00]
            arg0\Field29[$00]\Field22 = arg0\Field29[$01]
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 + 2.8125), 0.46875, (arg0\Field5 + 1.300781), $01)
            arg0\Field29[$00]\Field10 = $15E
            arg0\Field29[$01]\Field10 = $15E
            local2 = createsecuritycam((arg0\Field3 + 0.75), (arg0\Field4 + 2.75), (arg0\Field5 - 3.75), arg0, $00)
            local2\Field11 = 45.0
            local2\Field12 = 0.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            arg0\Field25[$02] = copyentity(monitor2, arg0\Field2)
            scaleentity(arg0\Field25[$02], 2.0, 2.0, 2.0, $00)
            positionentity(arg0\Field25[$02], (arg0\Field3 - 0.59375), 1.5, (arg0\Field5 + 0.484375), $01)
            rotateentity(arg0\Field25[$02], 0.0, 180.0, 0.0, $00)
            entityfx(arg0\Field25[$02], $01)
            arg0\Field25[$03] = copyentity(monitor2, arg0\Field2)
            scaleentity(arg0\Field25[$03], 2.0, 2.0, 2.0, $00)
            positionentity(arg0\Field25[$03], (arg0\Field3 - 0.59375), 1.5, (arg0\Field5 - 1.484375), $01)
            rotateentity(arg0\Field25[$03], 0.0, 0.0, 0.0, $00)
            entityfx(arg0\Field25[$03], $01)
            If (maptemp((Int floor((arg0\Field3 / 8.0))), (Int (floor((arg0\Field5 / 8.0)) - 1.0))) = $00) Then
                local1 = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - 4.0), 0.0, arg0, $00, $00, $00, "GEAR", $00)
                local1\Field4 = $01
            EndIf
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 - 3.145789), (arg0\Field4 + 0.302), (arg0\Field5 + 1.321121), -80.0)
        Case "checkpoint2"
            arg0\Field29[$00] = createdoor($00, (arg0\Field3 - 0.1875), 0.0, (arg0\Field5 + 0.5), 0.0, arg0, $00, $00, ($05 - (server\Field21 Shl $01)), "", $00)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + 0.59375), entityy(arg0\Field29[$00]\Field3[$00], $01), (arg0\Field5 - 0.375), $01)
            positionentity(arg0\Field29[$00]\Field3[$01], (arg0\Field3 + 0.59375), entityy(arg0\Field29[$00]\Field3[$01], $01), (arg0\Field5 + 1.375), $01)
            arg0\Field29[$01] = createdoor($00, (arg0\Field3 + 1.375), 0.0, (arg0\Field5 + 0.5), 0.0, arg0, $00, $00, ($05 - (server\Field21 Shl $01)), "", $00)
            arg0\Field29[$01]\Field22 = arg0\Field29[$00]
            arg0\Field29[$00]\Field22 = arg0\Field29[$01]
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 - 2.8125), 0.46875, (arg0\Field5 + 1.8125), $01)
            arg0\Field25[$02] = copyentity(monitor3, arg0\Field2)
            scaleentity(arg0\Field25[$02], 2.0, 2.0, 2.0, $00)
            positionentity(arg0\Field25[$02], (arg0\Field3 + 0.59375), 1.5, (arg0\Field5 + 1.484375), $01)
            rotateentity(arg0\Field25[$02], 0.0, 180.0, 0.0, $00)
            entityfx(arg0\Field25[$02], $01)
            arg0\Field25[$03] = copyentity(monitor3, arg0\Field2)
            scaleentity(arg0\Field25[$03], 2.0, 2.0, 2.0, $00)
            positionentity(arg0\Field25[$03], (arg0\Field3 + 0.59375), 1.5, (arg0\Field5 - 0.484375), $01)
            rotateentity(arg0\Field25[$03], 0.0, 0.0, 0.0, $00)
            entityfx(arg0\Field25[$03], $01)
            arg0\Field29[$00]\Field10 = $15E
            arg0\Field29[$01]\Field10 = $15E
            If (maptemp((Int floor((arg0\Field3 / 8.0))), (Int (floor((arg0\Field5 / 8.0)) - 1.0))) = $00) Then
                local1 = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - 4.0), 0.0, arg0, $00, $00, $00, "GEAR", $00)
                local1\Field4 = $01
            EndIf
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 + 2.951149), (arg0\Field4 + 0.302), (arg0\Field5 - 1.745691), 72.0)
        Case "room2pit"
            local7 = $00
            For local8 = $FFFFFFFF To $01 Step $02
                For local10 = $FFFFFFFF To $01 Step $01
                    local14 = createemitter((arg0\Field3 + ((1.0 / 1.267327) * (Float local8))), (1.0 / 32.0), (arg0\Field5 + (1.0 * (Float local10))), $00, 0.0)
                    local14\Field10 = 30.0
                    local14\Field9 = 0.0045
                    local14\Field11 = 0.007
                    local14\Field12 = -0.016
                    arg0\Field25[local7] = local14\Field0
                    If (local7 < $03) Then
                        turnentity(local14\Field0, 0.0, -90.0, 0.0, $01)
                    Else
                        turnentity(local14\Field0, 0.0, 90.0, 0.0, $01)
                    EndIf
                    turnentity(local14\Field0, -45.0, 0.0, 0.0, $01)
                    entityparent(local14\Field0, arg0\Field2, $01)
                    local7 = (local7 + $01)
                Next
            Next
            arg0\Field25[$06] = createpivot($00)
            positionentity(arg0\Field25[$06], (arg0\Field3 + 2.5), (1.0 / 32.0), (arg0\Field5 - 3.5), $00)
            entityparent(arg0\Field25[$06], arg0\Field2, $01)
            arg0\Field25[$07] = createpivot($00)
            positionentity(arg0\Field25[$07], (arg0\Field3 - 3.375), (1.0 / -0.64), (arg0\Field5 - 2.46875), $00)
            entityparent(arg0\Field25[$07], arg0\Field2, $01)
        Case "room2testroom2"
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (arg0\Field3 - 2.5), 0.5, (arg0\Field5 - 3.5625), $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            arg0\Field25[$01] = createpivot($00)
            positionentity(arg0\Field25[$01], (arg0\Field3 - 2.613281), 0.5, (arg0\Field5 - (1.0 / 16.0)), $00)
            entityparent(arg0\Field25[$01], arg0\Field2, $01)
            local17 = loadtexture_strict("GFX\map\glass.png", $03, $00)
            arg0\Field25[$02] = createsprite($00)
            entitytexture(arg0\Field25[$02], local17, $00, $00)
            spriteviewmode(arg0\Field25[$02], $02)
            scalesprite(arg0\Field25[$02], (1.0 / 2.813187), 0.375)
            positionentity(arg0\Field25[$02], (arg0\Field3 - 2.46875), 0.875, (arg0\Field5 - 0.8125), $00)
            turnentity(arg0\Field25[$02], 0.0, 180.0, 0.0, $00)
            entityparent(arg0\Field25[$02], arg0\Field2, $01)
            hideentity(arg0\Field25[$02])
            freetexture(local17)
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 - 0.9375), 0.0, (arg0\Field5 + 2.5), 90.0, arg0, $00, $00, $01, "", $00)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $00
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 - 2.0), 0.0, (arg0\Field5 + 1.5), 0.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field5 = $00
            local6 = createitem("Level 2 Key Card", "key2", (arg0\Field3 - 3.570312), (arg0\Field4 + (1.0 / 1.868613)), (arg0\Field5 + (1.0 / 4.196721)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            If (server\Field21 = $00) Then
                local6 = createitem("S-NAV 300 Navigator", "nav", (arg0\Field3 - 1.21875), (arg0\Field4 + 1.03125), (arg0\Field5 + 0.6875), $00, $00, $00, 1.0, $00, $01)
                local6\Field13 = 20.0
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (arg0\Field3 - 1.21875), (arg0\Field4 + 1.03125), (arg0\Field5 + 0.6875), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
                local6 = createitem("Level 2 Key Card", "key2", (arg0\Field3 - 3.554688), (arg0\Field4 + (1.0 / 1.868613)), (arg0\Field5 + (1.0 / 4.196721)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 - 3.417507), 0.0, (arg0\Field5 + 2.496274), -90.0)
        Case "room3tunnel"
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 - (1.0 / 1.347368)), (1.0 / 64.0), (arg0\Field5 + (1.0 / 1.347368)), $01)
        Case "room2toilets"
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (arg0\Field3 + 4.0625), 0.75, arg0\Field5, $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            arg0\Field25[$01] = createpivot($00)
            positionentity(arg0\Field25[$01], (arg0\Field3 + 5.976562), 0.5, (arg0\Field5 + 2.0), $00)
            entityparent(arg0\Field25[$01], arg0\Field2, $01)
            arg0\Field25[$02] = createpivot($00)
            positionentity(arg0\Field25[$02], (arg0\Field3 + 5.996094), (arg0\Field4 + (1.0 / 1.706667)), (arg0\Field5 + 2.0), $00)
            entityparent(arg0\Field25[$02], arg0\Field2, $01)
        Case "room2storage"
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 - 5.03125), 0.0, arg0\Field5, 270.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 - 2.96875), 0.0, arg0\Field5, 270.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 - 1.03125), 0.0, arg0\Field5, 270.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$03] = createdoor(arg0\Field0, (arg0\Field3 + 1.03125), 0.0, arg0\Field5, 270.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$04] = createdoor(arg0\Field0, (arg0\Field3 + 2.96875), 0.0, arg0\Field5, 270.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$05] = createdoor(arg0\Field0, (arg0\Field3 + 5.03125), 0.0, arg0\Field5, 270.0, arg0, $00, $00, $00, "", $00)
            For local7 = $00 To $05 Step $01
                moveentity(arg0\Field29[local7]\Field3[$00], 0.0, 0.0, -8.0)
                moveentity(arg0\Field29[local7]\Field3[$01], 0.0, 0.0, -8.0)
                arg0\Field29[local7]\Field21 = $00
                arg0\Field29[local7]\Field5 = $00
            Next
            local6 = createitem("Document SCP-939", "paper", (arg0\Field3 + 1.375), (arg0\Field4 + 0.6875), (arg0\Field5 + 1.0), $00, $00, $00, 1.0, $00, $01)
            rotateentity(local6\Field1, 0.0, (Float (arg0\Field6 + $04)), 0.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Gas Mask", "gasmask", (arg0\Field3 + 1.375), (arg0\Field4 + 0.4375), (arg0\Field5 + 1.75), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            If (server\Field21 = $00) Then
                local6 = createitem("Empty Cup", "emptycup", (arg0\Field3 - 2.625), 0.9375, (arg0\Field5 + 1.125), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (arg0\Field3 - 2.625), 0.9375, (arg0\Field5 + 1.125), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem((("Level " + (Str (server\Field21 + $01))) + " Key Card"), ("key" + (Str (server\Field21 + $01))), (arg0\Field3 - 2.625), (arg0\Field4 + 0.9375), (arg0\Field5 + 0.875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room2sroom"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + 5.625), 0.875, (arg0\Field5 + 0.125), 90.0, arg0, $00, $00, $04, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            local6 = createitem("Some SCP-420-J", "420", (arg0\Field3 + 6.9375), (arg0\Field4 + (1.0 / 0.64)), (arg0\Field5 + 1.667969), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Some SCP-420-J", "420", (arg0\Field3 + 7.0625), (arg0\Field4 + (1.0 / 0.64)), (arg0\Field5 + 1.699219), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Level 5 Key Card", "key5", (arg0\Field3 + 8.71875), (arg0\Field4 + 1.53125), (arg0\Field5 + 1.511719), $00, $00, $00, 1.0, $00, $01)
            rotateentity(local6\Field1, 0.0, (Float arg0\Field6), 0.0, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Nuclear Device Document", "paper", (arg0\Field3 + 8.78125), (arg0\Field4 + 1.71875), (arg0\Field5 + 1.453125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Radio Transceiver", "radio", (arg0\Field3 + 8.75), (arg0\Field4 + 1.25), (arg0\Field5 + 0.5), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room2shaft"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + 6.0625), arg0\Field4, (arg0\Field5 + 2.15625), 0.0, arg0, $00, $00, $00, "", $00)
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (arg0\Field5 + 2.023438), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (arg0\Field5 + 2.246094), $01)
            local0\Field21 = $00
            local0\Field5 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + 1.0), arg0\Field4, (arg0\Field5 + 2.90625), 90.0, arg0, $00, $00, $02, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            local6 = createitem("Level 3 Key Card", "key3", (arg0\Field3 + 4.371094), (arg0\Field4 + (1.0 / 1.098712)), (arg0\Field5 + 1.929688), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("First Aid Kit", "firstaid", (arg0\Field3 + 4.042969), (arg0\Field4 + (1.0 / 1.765517)), (arg0\Field5 + 0.21875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
            local6 = createitem("9V Battery", "bat", (arg0\Field3 + 7.539062), (arg0\Field4 + (1.0 / 2.639175)), (arg0\Field5 + 1.0), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("9V Battery", "bat", (arg0\Field3 + 4.144531), (arg0\Field4 + (1.0 / 1.590062)), (arg0\Field5 + 1.929688), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("ReVision Eyedrops", "eyedrops", (arg0\Field3 + 7.539062), (arg0\Field4 + (1.0 / 1.137778)), (arg0\Field5 + 0.5), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 + 6.09375), arg0\Field4, (arg0\Field5 + (1.0 / 1.024)), $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 + 5.25), -2.9375, (arg0\Field5 - 1.5), $01)
            local3 = createdecal($03, (arg0\Field3 + 5.210938), -3.099375, (arg0\Field5 - 0.859375), 90.0, rnd(360.0, 0.0), 0.0)
            local3\Field2 = 0.25
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityparent(local3\Field0, arg0\Field2, $01)
            arg0\Field25[$02] = createbutton((arg0\Field3 + 4.613281), (arg0\Field4 + 0.703125), (arg0\Field5 - 2.0), 0.0, 270.0, 0.0)
            entityparent(arg0\Field25[$02], arg0\Field2, $01)
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 + 3.235352), (arg0\Field4 + 0.302), (arg0\Field5 - 2.375324), 90.0)
        Case "room2poffices"
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 + 0.9375), 0.0, (arg0\Field5 + 1.75), 90.0, arg0, $00, $00, $00, (Str accesscode), $00)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + 0.96875), entityy(arg0\Field29[$00]\Field3[$00], $01), entityz(arg0\Field29[$00]\Field3[$00], $01), $01)
            positionentity(arg0\Field29[$00]\Field3[$01], (arg0\Field3 + 0.90625), entityy(arg0\Field29[$00]\Field3[$01], $01), entityz(arg0\Field29[$00]\Field3[$01], $01), $01)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $00
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 - 1.9375), 0.0, arg0\Field5, 90.0, arg0, $00, $00, $00, "ABCD", $00)
            positionentity(arg0\Field29[$01]\Field3[$00], (arg0\Field3 - 1.90625), entityy(arg0\Field29[$01]\Field3[$00], $01), entityz(arg0\Field29[$01]\Field3[$00], $01), $01)
            positionentity(arg0\Field29[$01]\Field3[$01], (arg0\Field3 - 1.96875), entityy(arg0\Field29[$01]\Field3[$01], $01), entityz(arg0\Field29[$01]\Field3[$01], $01), $01)
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field5 = $00
            arg0\Field29[$01]\Field4 = $01
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 + 0.9375), 0.0, (arg0\Field5 - 2.25), 90.0, arg0, $00, $00, $00, "7816", $00)
            positionentity(arg0\Field29[$02]\Field3[$00], (arg0\Field3 + 0.96875), entityy(arg0\Field29[$02]\Field3[$00], $01), entityz(arg0\Field29[$02]\Field3[$00], $01), $01)
            positionentity(arg0\Field29[$02]\Field3[$01], (arg0\Field3 + 0.90625), entityy(arg0\Field29[$02]\Field3[$01], $01), entityz(arg0\Field29[$02]\Field3[$01], $01), $01)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$02]\Field5 = $00
            local6 = createitem("Mysterious Note", "paper", (arg0\Field3 + 2.875), (arg0\Field4 + 0.875), (arg0\Field5 + 2.125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Ballistic Vest", "vest", (arg0\Field3 + 2.375), (arg0\Field4 + 0.4375), (arg0\Field5 + 0.125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
            If (server\Field21 = $00) Then
                local6 = createitem("Incident Report SCP-106-0204", "paper", (arg0\Field3 + 2.75), (arg0\Field4 + (1.0 / 1.398907)), (arg0\Field5 - 2.25), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
                local6 = createitem("Journal Page", "paper", (arg0\Field3 + 3.5625), (arg0\Field4 + 0.6875), (arg0\Field5 - 0.625), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("FN P90", "p90", (arg0\Field3 + 2.75), (arg0\Field4 + (1.0 / 1.398907)), (arg0\Field5 - 2.25), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
                local6 = createitem("Rocket Launcher", "rpg", (arg0\Field3 + 3.5625), (arg0\Field4 + 0.6875), (arg0\Field5 - 0.625), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("First Aid Kit", "firstaid", (arg0\Field3 + 3.5625), (arg0\Field4 + 0.4375), (arg0\Field5 - 1.3125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
        Case "room2poffices2"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + 0.9375), 0.0, (arg0\Field5 + 0.1875), 270.0, arg0, $00, $00, $03, "", $00)
            positionentity(local0\Field3[$00], (arg0\Field3 + 0.875), entityy(local0\Field3[$00], $01), (arg0\Field5 + 0.6875), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 + 1.0), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0\Field21 = $00
            local0\Field5 = $00
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 - 1.6875), 0.0, arg0\Field5, 90.0, arg0, $00, $00, $00, "1234", $00)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 - 1.625), entityy(arg0\Field29[$00]\Field3[$00], $01), (arg0\Field5 + 0.6875), $01)
            freeentity(arg0\Field29[$00]\Field3[$01])
            arg0\Field29[$00]\Field3[$01] = $00
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $00
            arg0\Field29[$00]\Field4 = $01
            local3 = createdecal($00, (arg0\Field3 - 3.15625), 0.005, (arg0\Field5 - 0.28125), 90.0, (Float rand($168, $01)), 0.0)
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createdecal($02, (arg0\Field3 - 3.15625), 0.01, (arg0\Field5 - 0.28125), 90.0, (Float rand($168, $01)), 0.0)
            local3\Field2 = 0.3
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createdecal($00, (arg0\Field3 - 1.6875), 0.01, arg0\Field5, 90.0, (Float rand($168, $01)), 0.0)
            entityparent(local3\Field0, arg0\Field2, $01)
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 - 3.15625), 1.0, (arg0\Field5 - 0.28125), $01)
            If (server\Field21 = $00) Then
                local6 = createitem("Dr. L's Burnt Note", "paper", (arg0\Field3 - 2.6875), 1.0, (arg0\Field5 - (1.0 / 16.0)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
                local6 = createitem("Dr L's Burnt Note", "paper", (arg0\Field3 - 3.15625), 1.0, (arg0\Field5 - 0.28125), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("FN P90", "p90", (arg0\Field3 - 2.6875), 1.0, (arg0\Field5 - (1.0 / 16.0)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
                local6 = createitem("Rocket Launcher", "rpg", (arg0\Field3 - 3.15625), 1.0, (arg0\Field5 - 0.28125), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("The Modular Site Project", "paper", (arg0\Field3 + 2.429688), (arg0\Field4 + (1.0 / 2.048)), (arg0\Field5 - (1.0 / 3.506849)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room2elevator"
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 + 3.46875), 0.9375, arg0\Field5, $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], ((arg0\Field3 + 4.0) - 0.01), 0.46875, arg0\Field5, $01)
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 + 1.75), 0.0, arg0\Field5, 90.0, arg0, $00, $03, $00, "", $00)
            positionentity(arg0\Field29[$00]\Field3[$01], (arg0\Field3 + 1.625), entityy(arg0\Field29[$00]\Field3[$01], $01), (arg0\Field5 - 0.8125), $01)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + 1.875), entityy(arg0\Field29[$00]\Field3[$00], $01), (arg0\Field5 + 0.71875), $01)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $01
            arg0\Field29[$00]\Field4 = $01
        Case "room2cafeteria"
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 + 7.214844), -0.9375, (arg0\Field5 - 1.253906), $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 + 6.953125), -0.96875, (arg0\Field5 - 1.078125), $01)
            local6 = createitem("cup", "cup", (arg0\Field3 - 1.984375), (1.0 / -1.368984), (arg0\Field5 + 1.109375), $F0, $AF, $46, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6\Field0 = "Cup of Orange Juice"
            local6 = createitem("cup", "cup", (arg0\Field3 + 5.515625), (1.0 / -1.368984), (arg0\Field5 - 2.796875), $57, $3E, $2D, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6\Field0 = "Cup of Coffee"
            If (server\Field21 = $00) Then
                local6 = createitem("Empty Cup", "emptycup", (arg0\Field3 - 2.109375), (1.0 / -1.368984), (arg0\Field5 + 0.484375), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (arg0\Field3 - 2.109375), (1.0 / -1.368984), (arg0\Field5 + 0.484375), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("Quarter", "25ct", (arg0\Field3 - 1.746094), (arg0\Field4 - 1.304688), (arg0\Field5 + 0.140625), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Quarter", "25ct", (arg0\Field3 + 5.503906), (arg0\Field4 - 1.304688), (arg0\Field5 - 2.859375), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 - 2.255336), (arg0\Field4 - 1.5), (arg0\Field5 - 3.152867), -25.0)
        Case "room2nuke"
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 + 2.25), 0.0, (arg0\Field5 + 0.59375), 90.0, arg0, $00, $00, $05, "", $00)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$02]\Field5 = $00
            positionentity(arg0\Field29[$02]\Field3[$00], (arg0\Field3 + 2.351562), entityy(arg0\Field29[$02]\Field3[$00], $01), (arg0\Field5 + (1.0 / 12.8)), $01)
            positionentity(arg0\Field29[$02]\Field3[$01], (arg0\Field3 + 2.148438), entityy(arg0\Field29[$02]\Field3[$01], $01), (arg0\Field5 + (1.0 / 12.8)), $01)
            freeentity(arg0\Field29[$02]\Field1)
            arg0\Field29[$02]\Field1 = $00
            arg0\Field29[$03] = createdoor(arg0\Field0, (arg0\Field3 - 2.125), 5.875, (arg0\Field5 + 2.882812), 90.0, arg0, $00, $00, $05, "", $00)
            arg0\Field29[$03]\Field21 = $00
            arg0\Field29[$03]\Field5 = $00
            positionentity(arg0\Field29[$03]\Field3[$00], entityx(arg0\Field29[$03]\Field3[$00], $01), entityy(arg0\Field29[$03]\Field3[$00], $01), (arg0\Field5 + 2.375), $01)
            positionentity(arg0\Field29[$03]\Field3[$01], entityx(arg0\Field29[$03]\Field3[$01], $01), entityy(arg0\Field29[$03]\Field3[$01], $01), (arg0\Field5 + 2.375), $01)
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 + 4.65625), 0.0, arg0\Field5, 90.0, arg0, $01, $03, $00, "", $00)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $01
            arg0\Field25[$04] = createpivot($00)
            positionentity(arg0\Field25[$04], (arg0\Field3 + 5.84375), 0.9375, arg0\Field5, $00)
            entityparent(arg0\Field25[$04], arg0\Field2, $01)
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 + 2.65625), 5.875, arg0\Field5, 90.0, arg0, $00, $03, $00, "", $00)
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field5 = $00
            arg0\Field25[$05] = createpivot($00)
            positionentity(arg0\Field25[$05], (arg0\Field3 + 3.84375), 6.8125, arg0\Field5, $00)
            entityparent(arg0\Field25[$05], arg0\Field2, $01)
            For local18 = $00 To $01 Step $01
                arg0\Field25[(local18 Shl $01)] = copyentity(leverbaseobj, $00)
                arg0\Field25[((local18 Shl $01) + $01)] = copyentity(leverobj, $00)
                arg0\Field28[local18] = arg0\Field25[((local18 Shl $01) + $01)]
                For local7 = $00 To $01 Step $01
                    scaleentity(arg0\Field25[((local18 Shl $01) + local7)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field25[((local18 Shl $01) + local7)], (arg0\Field3 - 3.808594), (arg0\Field4 + 6.6875), (arg0\Field5 - ((502.0 - (132.0 * (Float local18))) * (1.0 / 256.0))), $01)
                    entityparent(arg0\Field25[((local18 Shl $01) + local7)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field25[(local18 Shl $01)], 0.0, -270.0, 0.0, $00)
                rotateentity(arg0\Field25[((local18 Shl $01) + $01)], 10.0, -450.0, 0.0, $00)
                entitypickmode(arg0\Field25[((local18 Shl $01) + $01)], $01, $00)
                entityradius(arg0\Field25[((local18 Shl $01) + $01)], 0.1, 0.0)
            Next
            local6 = createitem("Nuclear Device Document", "paper", (arg0\Field3 - 3.0), (arg0\Field4 + 6.578125), (arg0\Field5 - 3.0), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Ballistic Vest", "vest", (arg0\Field3 - 3.6875), (arg0\Field4 + 6.453125), (arg0\Field5 - 2.5625), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, -90.0, 0.0, $00)
            local2 = createsecuritycam((arg0\Field3 + 2.4375), (arg0\Field4 + 7.375), (arg0\Field5 - 1.21875), arg0, $00)
            local2\Field11 = 90.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            arg0\Field25[$06] = createpivot($00)
            positionentity(arg0\Field25[$06], (arg0\Field3 + 4.335938), (arg0\Field4 + 0.140625), (arg0\Field5 - 0.8125), $00)
            entityparent(arg0\Field25[$06], arg0\Field2, $01)
        Case "room2tunnel"
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (arg0\Field3 + 10.3125), -9.75, (arg0\Field5 + (1.0 / 0.64)), $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            arg0\Field25[$01] = createpivot($00)
            positionentity(arg0\Field25[$01], (arg0\Field3 - 16.9375), -9.75, (arg0\Field5 - 9.8125), $00)
            entityparent(arg0\Field25[$01], arg0\Field2, $01)
            arg0\Field25[$02] = createpivot($00)
            rotateentity(arg0\Field25[$02], 0.0, 180.0, 0.0, $01)
            positionentity(arg0\Field25[$02], (arg0\Field3 + 2.15625), 0.9375, (arg0\Field5 + 2.5625), $00)
            entityparent(arg0\Field25[$02], arg0\Field2, $01)
            arg0\Field25[$04] = createpivot($00)
            positionentity(arg0\Field25[$04], (arg0\Field3 - 2.15625), 0.9375, (arg0\Field5 - 2.5625), $00)
            entityparent(arg0\Field25[$04], arg0\Field2, $01)
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 + 1.03125), 0.0, (arg0\Field5 + 2.5625), 90.0, arg0, $01, $03, $00, "", $00)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $01
            positionentity(arg0\Field29[$00]\Field3[$01], (arg0\Field3 + 0.875), 0.7, (arg0\Field5 + 1.875), $01)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + 1.1875), 0.7, (arg0\Field5 + 3.25), $01)
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 - 1.03125), 0.0, (arg0\Field5 - 2.5625), 90.0, arg0, $01, $03, $00, "", $00)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$02]\Field5 = $01
            positionentity(arg0\Field29[$02]\Field3[$00], (arg0\Field3 - 0.875), 0.7, (arg0\Field5 - 1.875), $01)
            positionentity(arg0\Field29[$02]\Field3[$01], (arg0\Field3 - 1.1875), 0.7, (arg0\Field5 - 3.25), $01)
            local19 = ((accesscode * $03) Mod $2710)
            If (local19 < $3E8) Then
                local19 = (local19 + $3E8)
            EndIf
            local0 = createdoor($00, arg0\Field3, arg0\Field4, arg0\Field5, 0.0, arg0, $00, $01, $00, (Str local19), $00)
            positionentity(local0\Field3[$00], (arg0\Field3 + 0.875), (arg0\Field4 + 0.7), (arg0\Field5 - 1.5), $01)
            rotateentity(local0\Field3[$00], 0.0, -90.0, 0.0, $01)
            positionentity(local0\Field3[$01], (arg0\Field3 - 0.875), (arg0\Field4 + 0.7), (arg0\Field5 + 1.5), $01)
            rotateentity(local0\Field3[$01], 0.0, 90.0, 0.0, $01)
            local3 = createdecal($00, (arg0\Field3 + 0.25), 0.005, (arg0\Field5 + 0.5625), 90.0, (Float rand($168, $01)), 0.0)
            entityparent(local3\Field0, arg0\Field2, $01)
            local6 = createitem("Gas Mask", "gasmask", (arg0\Field3 + 0.25), (arg0\Field4 + 0.5625), (arg0\Field5 + 0.5), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Scorched Note", "paper", (arg0\Field3 + 0.25), (arg0\Field4 + 0.5625), (arg0\Field5 - 1.5), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "008"
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 + 1.140625), (1.0 / 1.969231), (arg0\Field5 + 2.015625), $01)
            arg0\Field25[$01] = loadmesh_strict("GFX\map\008_2.b3d", $00, $00)
            scaleentity(arg0\Field25[$01], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field25[$01], (arg0\Field3 + 1.140625), (1.0 / 1.695364), (arg0\Field5 + 2.25), $00)
            entityparent(arg0\Field25[$01], arg0\Field2, $01)
            rotateentity(arg0\Field25[$01], 89.0, 0.0, 0.0, $01)
            arg0\Field28[$00] = arg0\Field25[$01]
            local17 = loadtexture_strict("GFX\map\glass.png", $03, $00)
            arg0\Field25[$02] = createsprite($00)
            entitytexture(arg0\Field25[$02], local17, $00, $00)
            spriteviewmode(arg0\Field25[$02], $02)
            scalesprite(arg0\Field25[$02], 0.5, (1.0 / 2.639175))
            positionentity(arg0\Field25[$02], (arg0\Field3 - 0.6875), 0.875, (arg0\Field5 + 1.75), $00)
            turnentity(arg0\Field25[$02], 0.0, 90.0, 0.0, $00)
            entityparent(arg0\Field25[$02], arg0\Field2, $01)
            freetexture(local17)
            arg0\Field25[$03] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$03], (arg0\Field3 - 1.738281), 0.46875, (arg0\Field5 + 2.125), $01)
            arg0\Field25[$04] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$04], (arg0\Field3 + (1.0 / 3.820895)), 0.46875, (arg0\Field5 + 1.8125), $01)
            arg0\Field25[$05] = createsprite($00)
            positionentity(arg0\Field25[$05], (arg0\Field3 - (1.0 / 1.620253)), 1.4375, (arg0\Field5 + 1.164062), $00)
            scalesprite(arg0\Field25[$05], 0.02, 0.02)
            entitytexture(arg0\Field25[$05], lightspritetex($01), $00, $00)
            entityblend(arg0\Field25[$05], $03)
            entityparent(arg0\Field25[$05], arg0\Field2, $01)
            hideentity(arg0\Field25[$05])
            local0 = createdoor(arg0\Field0, (arg0\Field3 + 1.15625), 0.0, (arg0\Field5 - 2.625), 180.0, arg0, $01, $00, $04, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$01], (arg0\Field3 + 0.640625), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            arg0\Field29[$00] = local0
            local1 = createdoor(arg0\Field0, (arg0\Field3 + 1.15625), 0.0, (arg0\Field5 - 0.5625), 0.0, arg0, $00, $00, $00, "", $00)
            local1\Field21 = $00
            positionentity(local1\Field3[$00], (arg0\Field3 + 1.6875), entityy(local1\Field3[$00], $01), (arg0\Field5 - 1.875), $01)
            rotateentity(local1\Field3[$00], 0.0, -90.0, 0.0, $01)
            positionentity(local1\Field3[$01], (arg0\Field3 + 0.640625), entityy(local1\Field3[$00], $01), (arg0\Field5 - 0.5), $01)
            freeentity(local1\Field1)
            local1\Field1 = $00
            arg0\Field29[$01] = local1
            local0\Field22 = local1
            local1\Field22 = local0
            local0 = createdoor(arg0\Field0, (arg0\Field3 - 1.5), 0.0, (arg0\Field5 - 2.625), 0.0, arg0, $00, $00, $04, "", $00)
            local0\Field21 = $00
            local0\Field4 = $01
            arg0\Field29[$02] = local0
            local6 = createitem("Hazmat Suit", "hazmatsuit", (arg0\Field3 - 0.296875), 0.5, (arg0\Field5 - 1.546875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
            If (server\Field21 = $00) Then
                local6 = createitem("Document SCP-008", "paper", (arg0\Field3 - (1.0 / 1.044898)), (arg0\Field4 + 0.75), (arg0\Field5 + 1.4375), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (arg0\Field3 - (1.0 / 1.044898)), (arg0\Field4 + 0.75), (arg0\Field5 + 1.4375), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            arg0\Field25[$06] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$06], (arg0\Field3 + 0.625), 2.625, (arg0\Field5 - 1.5), $01)
            arg0\Field25[$07] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$07], arg0\Field3, 2.625, (arg0\Field5 + 1.375), $01)
            local2 = createsecuritycam((arg0\Field3 + 2.261547), (arg0\Field4 + 1.738109), (arg0\Field5 + 3.015625), arg0, $00)
            local2\Field11 = 135.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room035"
            local0 = createdoor(arg0\Field0, (arg0\Field3 - 1.15625), 0.0, (arg0\Field5 - 2.625), 180.0, arg0, $01, $00, $05, "", $00)
            local0\Field21 = $00
            local0\Field4 = $01
            arg0\Field29[$00] = local0
            positionentity(local0\Field3[$01], (arg0\Field3 - 0.640625), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local1 = createdoor(arg0\Field0, (arg0\Field3 - 1.15625), 0.0, (arg0\Field5 - 0.5625), 0.0, arg0, $00, $00, $00, "", $00)
            local1\Field21 = $00
            local1\Field4 = $01
            arg0\Field29[$01] = local1
            positionentity(local1\Field3[$00], (arg0\Field3 - 1.6875), entityy(local1\Field3[$00], $01), (arg0\Field5 - 1.875), $01)
            rotateentity(local1\Field3[$00], 0.0, 90.0, 0.0, $01)
            freeentity(local1\Field3[$01])
            local1\Field3[$01] = $00
            freeentity(local1\Field1)
            local1\Field1 = $00
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 + 1.5), 0.0, (arg0\Field5 - 2.625), 180.0, arg0, $00, $00, $05, "", $00)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$03] = createdoor($00, (arg0\Field3 + 3.0), 0.0, (arg0\Field5 + 2.0), 90.0, arg0, $00, $00, $00, "5731", $00)
            arg0\Field29[$03]\Field21 = $00
            local0\Field22 = local1
            local1\Field22 = local0
            For local7 = $00 To $01 Step $01
                arg0\Field25[(local7 Shl $01)] = copyentity(leverbaseobj, $00)
                arg0\Field25[((local7 Shl $01) + $01)] = copyentity(leverobj, $00)
                arg0\Field28[local7] = arg0\Field25[((local7 Shl $01) + $01)]
                For local18 = $00 To $01 Step $01
                    scaleentity(arg0\Field25[((local7 Shl $01) + local18)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field25[((local7 Shl $01) + local18)], (arg0\Field3 + (1.0 / 1.219048)), (arg0\Field4 + 0.875), (arg0\Field5 - ((Float ($D0 - (local7 * $4C))) * (1.0 / 256.0))), $01)
                    entityparent(arg0\Field25[((local7 Shl $01) + local18)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field25[(local7 Shl $01)], 0.0, -270.0, 0.0, $00)
                rotateentity(arg0\Field25[((local7 Shl $01) + $01)], -80.0, -90.0, 0.0, $00)
                entitypickmode(arg0\Field25[((local7 Shl $01) + $01)], $01, $00)
                entityradius(arg0\Field25[((local7 Shl $01) + $01)], 0.1, 0.0)
            Next
            arg0\Field25[$03] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$03], (arg0\Field3 + 1.78125), 0.5, (arg0\Field5 + (1.0 / 0.64)), $01)
            arg0\Field25[$04] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$04], (arg0\Field3 - 2.25), 0.5, (arg0\Field5 + 2.5), $01)
            For local7 = $00 To $01 Step $01
                local14 = createemitter((arg0\Field3 - 1.0625), 10.0, (arg0\Field5 + ((624.0 - (Float (local7 Shl $09))) * (1.0 / 256.0))), $00, 0.0)
                turnentity(local14\Field0, 90.0, 0.0, 0.0, $01)
                entityparent(local14\Field0, arg0\Field2, $01)
                local14\Field10 = 15.0
                local14\Field9 = 0.05
                local14\Field11 = 0.007
                local14\Field12 = -0.006
                local14\Field4 = -0.24
                arg0\Field25[($05 + local7)] = local14\Field0
            Next
            arg0\Field25[$07] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$07], (arg0\Field3 - 2.8125), 0.5, (arg0\Field5 + 3.4375), $01)
            arg0\Field25[$08] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$08], (arg0\Field3 + 0.6875), 0.5, (arg0\Field5 - 0.5625), $01)
            local6 = createitem("SCP-035 Addendum", "paper", (arg0\Field3 + 0.96875), (arg0\Field4 + 0.859375), (arg0\Field5 + 2.25), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            If (server\Field21 = $00) Then
                local6 = createitem("Radio Transceiver", "radio", (arg0\Field3 - 2.125), 0.5, (arg0\Field5 + 2.75), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (arg0\Field3 - 2.125), 0.5, (arg0\Field5 + 2.75), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("SCP-500-01", "scp500", (arg0\Field3 + 4.5625), 0.875, (arg0\Field5 + 2.25), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Metal Panel", "scp148", (arg0\Field3 - 1.40625), 0.5, (arg0\Field5 + 2.515625), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Document SCP-035", "paper", (arg0\Field3 + 4.5625), 0.40625, (arg0\Field5 + 2.375), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room513"
            local0 = createdoor(arg0\Field0, (arg0\Field3 - 2.75), 0.0, (arg0\Field5 + 1.1875), 0.0, arg0, $00, $00, $02, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (arg0\Field5 + 1.125), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (arg0\Field5 + 1.25), $01)
            local2 = createsecuritycam((arg0\Field3 - 1.21875), (arg0\Field4 + 1.617188), (arg0\Field5 + 2.5625), arg0, $00)
            local2\Field20 = $01
            local6 = createitem("SCP-513", "scp513", (arg0\Field3 - 0.234375), (arg0\Field4 + 0.765625), (arg0\Field5 + 2.6875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Blood-stained Note", "paper", (arg0\Field3 + 2.875), 1.0, (arg0\Field5 + 0.1875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Document SCP-513", "paper", (arg0\Field3 - 1.875), 0.40625, (arg0\Field5 - 0.6875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            If ((rand($00, $01) And server\Field21) <> 0) Then
                local6 = createitem("SCP-035", "scp035", (arg0\Field3 - 2.34375), (arg0\Field4 + 0.765625), (arg0\Field5 + 2.6875), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
        Case "room966"
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (1.0 / 0.64)), 0.0, arg0\Field5, -90.0, arg0, $00, $00, $03, "", $00)
            local0 = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - 1.875), 180.0, arg0, $00, $00, $03, "", $00)
            local2 = createsecuritycam((arg0\Field3 - 1.21875), (arg0\Field4 + 1.617188), (arg0\Field5 + 2.5625), arg0, $00)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], arg0\Field3, 0.5, (arg0\Field5 + 2.0), $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 + 0.25), 0.5, (arg0\Field5 - 2.5), $01)
            arg0\Field25[$02] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$02], arg0\Field3, 0.5, arg0\Field5, $01)
            arg0\Field25[$03] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$03], (arg0\Field3 + 1.25), 0.5, (arg0\Field5 + 2.75), $01)
            local6 = createitem("Night Vision Goggles", "nvgoggles", (arg0\Field3 + 1.25), 0.5, (arg0\Field5 + 2.75), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6\Field13 = 300.0
        Case "room3storage"
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], arg0\Field3, 0.9375, (arg0\Field5 + 2.9375), $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 + 22.8125), -21.0625, (arg0\Field5 + 5.3125), $01)
            arg0\Field25[$02] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$02], (arg0\Field3 + 2.375), 0.9375, (arg0\Field5 - 2.4375), $01)
            arg0\Field25[$03] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$03], (arg0\Field3 - 1.78125), -21.0625, (arg0\Field5 - 4.4375), $01)
            arg0\Field25[$04] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$04], (arg0\Field3 + 8.3125), -21.67969, (arg0\Field5 + 8.0), $01)
            arg0\Field25[$05] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$05], (arg0\Field3 + 8.3125), -21.67969, (arg0\Field5 - 4.4375), $01)
            arg0\Field25[$06] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$06], (arg0\Field3 + 14.9375), -21.67969, (arg0\Field5 - 4.5625), $01)
            arg0\Field25[$07] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$07], (arg0\Field3 + 14.6875), -21.67969, (arg0\Field5 + 8.0), $01)
            arg0\Field25[$08] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$08], (arg0\Field3 + 18.9375), -21.67969, (arg0\Field5 + 0.4375), $01)
            arg0\Field25[$09] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$09], (arg0\Field3 + 2.3125), -21.67969, (arg0\Field5 + 24.8125), $01)
            arg0\Field25[$0A] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$0A], (arg0\Field3 + 11.4375), -21.67969, (arg0\Field5 + 24.8125), $01)
            arg0\Field25[$0B] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$0B], (arg0\Field3 + 11.4375), -21.67969, (arg0\Field5 + 20.3125), $01)
            arg0\Field25[$0C] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$0C], (arg0\Field3 + 2.3125), -21.67969, (arg0\Field5 + 20.3125), $01)
            arg0\Field25[$0D] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$0D], (arg0\Field3 + 4.4375), -21.67969, (arg0\Field5 + 11.5), $01)
            arg0\Field25[$0E] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$0E], (arg0\Field3 + 4.3125), -21.67969, (arg0\Field5 + 4.625), $01)
            arg0\Field25[$0F] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$0F], (arg0\Field3 - 1.8125), -21.67969, (arg0\Field5 + 4.75), $01)
            arg0\Field25[$10] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$10], (arg0\Field3 - 1.6875), -21.67969, (arg0\Field5 + 11.625), $01)
            arg0\Field25[$14] = loadmesh_strict("GFX\map\room3storage_hb.b3d", arg0\Field2, $00)
            entitypickmode(arg0\Field25[$14], $02, $01)
            entitytype(arg0\Field25[$14], $01, $00)
            entityalpha(arg0\Field25[$14], 0.0)
            arg0\Field29[$00] = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 + 1.75), 0.0, arg0, $01, $03, $00, "", $00)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $01
            positionentity(arg0\Field29[$00]\Field3[$01], (arg0\Field3 - 0.625), 0.7, (arg0\Field5 + 1.875), $01)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + 0.625), 0.7, (arg0\Field5 + 1.625), $01)
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 + 22.8125), -22.0, (arg0\Field5 + 4.09375), 0.0, arg0, $00, $03, $00, "", $00)
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field5 = $00
            positionentity(arg0\Field29[$01]\Field3[$00], (arg0\Field3 + 23.4375), entityy(arg0\Field29[$01]\Field3[$00], $01), (arg0\Field5 + 3.9375), $01)
            positionentity(arg0\Field29[$01]\Field3[$01], (arg0\Field3 + 22.1875), entityy(arg0\Field29[$01]\Field3[$01], $01), (arg0\Field5 + 4.25), $01)
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 + 2.375), 0.0, (arg0\Field5 - 1.21875), 0.0, arg0, $01, $03, $00, "", $00)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$02]\Field5 = $01
            positionentity(arg0\Field29[$02]\Field3[$01], (arg0\Field3 + 1.75), 0.7, (arg0\Field5 - 1.0625), $01)
            positionentity(arg0\Field29[$02]\Field3[$00], (arg0\Field3 + 3.0), 0.7, (arg0\Field5 - 1.375), $01)
            arg0\Field29[$03] = createdoor(arg0\Field0, (arg0\Field3 - 1.78125), -22.0, (arg0\Field5 - 3.21875), 0.0, arg0, $00, $03, $00, "", $00)
            arg0\Field29[$03]\Field21 = $00
            arg0\Field29[$03]\Field5 = $00
            positionentity(arg0\Field29[$03]\Field3[$00], (arg0\Field3 - 1.09375), entityy(arg0\Field29[$03]\Field3[$00], $01), (arg0\Field5 - 3.375), $01)
            positionentity(arg0\Field29[$03]\Field3[$01], (arg0\Field3 - 2.46875), entityy(arg0\Field29[$03]\Field3[$01], $01), (arg0\Field5 - 3.0625), $01)
            local14 = createemitter((arg0\Field3 + 20.38281), -21.8125, (arg0\Field5 - 2.34375), $00, 0.0)
            turnentity(local14\Field0, 20.0, -100.0, 0.0, $01)
            entityparent(local14\Field0, arg0\Field2, $01)
            local14\Field7 = arg0
            local14\Field10 = 15.0
            local14\Field9 = 0.03
            local14\Field11 = 0.01
            local14\Field12 = -0.006
            local14\Field4 = -0.2
            Select rand($03, $01)
                Case $01
                    local21 = 2312.0
                    local22 = -952.0
                Case $02
                    local21 = 3032.0
                    local22 = 1288.0
                Case $03
                    local21 = 2824.0
                    local22 = 2808.0
            End Select
            local6 = createitem("Black Severed Hand", "hand2", (arg0\Field3 + (local21 * (1.0 / 256.0))), -20.85938, (arg0\Field5 + (local22 * (1.0 / 256.0))), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Night Vision Goggles", "nvgoggles", (arg0\Field3 + 7.5625), (arg0\Field4 - 21.46875), (arg0\Field5 - 3.6875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6\Field13 = 450.0
            local3 = createdecal($03, (arg0\Field3 + (local21 * (1.0 / 256.0))), -21.99, (arg0\Field5 + (local22 * (1.0 / 256.0))), 90.0, rnd(360.0, 0.0), 0.0)
            local3\Field2 = 0.5
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityparent(local3\Field0, arg0\Field2, $01)
            For local18 = $0A To $0B Step $01
                arg0\Field25[(local18 Shl $01)] = copyentity(leverbaseobj, $00)
                arg0\Field25[((local18 Shl $01) + $01)] = copyentity(leverobj, $00)
                arg0\Field28[(local18 - $0A)] = arg0\Field25[((local18 Shl $01) + $01)]
                For local7 = $00 To $01 Step $01
                    scaleentity(arg0\Field25[((local18 Shl $01) + local7)], 0.04, 0.04, 0.04, $00)
                    If (local18 = $0A) Then
                        positionentity(arg0\Field25[((local18 Shl $01) + local7)], (arg0\Field3 + 12.11328), (arg0\Field4 - 21.33203), (arg0\Field5 + 25.65625), $01)
                    Else
                        positionentity(arg0\Field25[((local18 Shl $01) + local7)], (arg0\Field3 + 4.722656), (arg0\Field4 - 21.33203), (arg0\Field5 + 12.35938), $01)
                    EndIf
                    entityparent(arg0\Field25[((local18 Shl $01) + local7)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field25[(local18 Shl $01)], 0.0, 0.0, 0.0, $00)
                rotateentity(arg0\Field25[((local18 Shl $01) + $01)], -10.0, -180.0, 0.0, $00)
                entitypickmode(arg0\Field25[((local18 Shl $01) + $01)], $01, $00)
                entityradius(arg0\Field25[((local18 Shl $01) + $01)], 0.1, 0.0)
            Next
            arg0\Field29[$04] = createdoor(arg0\Field0, (arg0\Field3 + 0.21875), (arg0\Field4 - 22.0), (arg0\Field5 + 24.78125), 90.0, arg0, $00, $02, $00, "", $00)
            arg0\Field29[$04]\Field21 = $00
            arg0\Field29[$04]\Field5 = $00
            For local7 = $00 To $01 Step $01
                freeentity(arg0\Field29[$04]\Field3[local7])
                arg0\Field29[$04]\Field3[local7] = $00
            Next
            local0 = createdoor(arg0\Field0, (arg0\Field3 + 4.519531), (arg0\Field4 - 22.0), (arg0\Field5 + 2.578125), 0.0, arg0, $00, $02, $00, "", $00)
            local0\Field4 = $01
            local0\Field5 = $00
            local0\Field21 = $00
            For local7 = $00 To $01 Step $01
                freeentity(local0\Field3[local7])
                local0\Field3[local7] = $00
            Next
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (1.0 / 1.094017)), (arg0\Field4 - 22.0), (arg0\Field5 + 20.46484), 90.0, arg0, $00, $02, $00, "", $00)
            local0\Field4 = $01
            local0\Field5 = $00
            local0\Field21 = $00
            For local7 = $00 To $01 Step $01
                freeentity(local0\Field3[local7])
                local0\Field3[local7] = $00
            Next
            local0 = createdoor(arg0\Field0, (arg0\Field3 + 13.46094), (arg0\Field4 - 22.0), (arg0\Field5 + 24.87891), 90.0, arg0, $00, $02, $00, "", $00)
            local0\Field4 = $01
            local0\Field5 = $00
            local0\Field21 = $00
            For local7 = $00 To $01 Step $01
                freeentity(local0\Field3[local7])
                local0\Field3[local7] = $00
            Next
        Case "room049"
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 + 2.5), 0.9375, (arg0\Field5 + 2.5625), $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 + 12.54297), -12.8125, (arg0\Field5 + 7.125), $01)
            arg0\Field25[$02] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$02], (arg0\Field3 - 2.625), 0.9375, (arg0\Field5 - (1.0 / 2.752688)), $01)
            arg0\Field25[$03] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$03], (arg0\Field3 - 10.80469), -12.8125, (arg0\Field5 - 4.988281), $01)
            arg0\Field25[$04] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$04], (arg0\Field3 + 2.0625), -13.4375, (arg0\Field5 + 0.375), $01)
            arg0\Field25[$05] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$05], (arg0\Field3 + 0.25), -13.4375, (arg0\Field5 - (1.0 / 0.256)), $01)
            For local18 = $00 To $01 Step $01
                arg0\Field25[((local18 Shl $01) + $06)] = copyentity(leverbaseobj, $00)
                arg0\Field25[((local18 Shl $01) + $07)] = copyentity(leverobj, $00)
                arg0\Field28[local18] = arg0\Field25[((local18 Shl $01) + $07)]
                For local7 = $00 To $01 Step $01
                    scaleentity(arg0\Field25[(((local18 Shl $01) + $06) + local7)], 0.03, 0.03, 0.03, $00)
                    Select local18
                        Case $00
                            positionentity(arg0\Field25[(((local18 Shl $01) + $06) + local7)], (arg0\Field3 + 3.328125), (arg0\Field4 - 13.17969), (arg0\Field5 - 3.335938), $01)
                        Case $01
                            positionentity(arg0\Field25[(((local18 Shl $01) + $06) + local7)], (arg0\Field3 - 3.257812), (arg0\Field4 - 13.28125), (arg0\Field5 + 4.269531), $01)
                    End Select
                    entityparent(arg0\Field25[(((local18 Shl $01) + $06) + local7)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field25[((local18 Shl $01) + $06)], 0.0, (Float (((local18 = $00) * $5A) + $B4)), 0.0, $00)
                rotateentity(arg0\Field25[((local18 Shl $01) + $07)], (Float ($51 - ($5C * local18))), (Float ((local18 = $00) * $5A)), 0.0, $00)
                entitypickmode(arg0\Field25[((local18 Shl $01) + $07)], $01, $00)
                entityradius(arg0\Field25[((local18 Shl $01) + $07)], 0.1, 0.0)
            Next
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 + 1.289062), 0.0, (arg0\Field5 + 2.5625), 90.0, arg0, $01, $03, $00, "", $00)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $01
            positionentity(arg0\Field29[$00]\Field3[$01], (arg0\Field3 + 1.125), 0.7, (arg0\Field5 + 2.0), $01)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + 1.4375), 0.7, (arg0\Field5 + 3.28125), $01)
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 + 11.32031), -13.75, (arg0\Field5 + 7.125), 90.0, arg0, $00, $03, $00, "", $00)
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field5 = $00
            positionentity(arg0\Field29[$01]\Field3[$01], (arg0\Field3 + 11.25391), entityy(arg0\Field29[$01]\Field3[$01], $01), (arg0\Field5 + 6.496094), $01)
            positionentity(arg0\Field29[$01]\Field3[$00], (arg0\Field3 + 11.46875), entityy(arg0\Field29[$01]\Field3[$00], $01), (arg0\Field5 + 7.847656), $01)
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 - 2.625), 0.0, (arg0\Field5 - 1.59375), 0.0, arg0, $01, $03, $00, "", $00)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$02]\Field5 = $01
            positionentity(arg0\Field29[$02]\Field3[$00], (arg0\Field3 - 1.902344), 0.7, (arg0\Field5 - 1.746094), $01)
            positionentity(arg0\Field29[$02]\Field3[$01], (arg0\Field3 - 3.347656), 0.7, (arg0\Field5 - 1.441406), $01)
            arg0\Field29[$03] = createdoor(arg0\Field0, (arg0\Field3 - 10.80469), -13.75, (arg0\Field5 - 6.21875), 0.0, arg0, $00, $03, $00, "", $00)
            arg0\Field29[$03]\Field21 = $00
            arg0\Field29[$03]\Field5 = $00
            positionentity(arg0\Field29[$03]\Field3[$00], (arg0\Field3 - 10.08203), entityy(arg0\Field29[$03]\Field3[$00], $01), (arg0\Field5 - 6.371094), $01)
            positionentity(arg0\Field29[$03]\Field3[$01], (arg0\Field3 - 11.52734), entityy(arg0\Field29[$03]\Field3[$01], $01), (arg0\Field5 - 6.066406), $01)
            arg0\Field29[$04] = createdoor(arg0\Field0, (arg0\Field3 + 1.0625), -13.875, (arg0\Field5 + 0.40625), 90.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$04]\Field21 = $00
            arg0\Field29[$04]\Field5 = $01
            arg0\Field29[$04]\Field4 = $01
            arg0\Field29[$05] = createdoor(arg0\Field0, (arg0\Field3 + 1.03125), -13.75, (arg0\Field5 - 7.125), 90.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$05]\Field21 = $00
            arg0\Field29[$05]\Field5 = $01
            arg0\Field29[$05]\Field4 = $01
            arg0\Field29[$06] = createdoor(arg0\Field0, (arg0\Field3 - 1.03125), -13.75, (arg0\Field5 + 7.125), 90.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$06]\Field21 = $00
            arg0\Field29[$06]\Field5 = $01
            arg0\Field29[$06]\Field4 = $01
            arg0\Field29[$07] = createdoor($00, arg0\Field3, 0.0, arg0\Field5, 0.0, arg0, $00, $02, $FFFFFFFE, "", $00)
            local6 = createitem("Document SCP-049", "paper", (arg0\Field3 - 2.375), (arg0\Field4 - 13.01562), (arg0\Field5 + 3.421875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Level 4 Key Card", "key4", (arg0\Field3 - 2.0), (arg0\Field4 - 13.32812), (arg0\Field5 + 3.375), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("First Aid Kit", "firstaid", (arg0\Field3 + 1.503906), (arg0\Field4 - 13.32812), (arg0\Field5 + 1.058594), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            arg0\Field29[$08] = createdoor(arg0\Field0, (arg0\Field3 - 1.0625), (arg0\Field4 - 13.875), (arg0\Field5 + (1.0 / 2.612245)), 90.0, arg0, $01, $01, $00, "", $00)
            arg0\Field29[$08]\Field21 = $00
            arg0\Field29[$08]\Field5 = $01
            arg0\Field29[$08]\Field24 = $00
            arg0\Field29[$08]\Field4 = $01
            For local7 = $00 To $01 Step $01
                freeentity(arg0\Field29[$08]\Field3[local7])
                arg0\Field29[$08]\Field3[local7] = $00
            Next
            local0 = createdoor(arg0\Field0, (arg0\Field3 - 11.67969), (arg0\Field4 - 13.75), (arg0\Field5 - 7.125), 90.0, arg0, $00, $02, $00, "", $00)
            local0\Field4 = $01
            local0\Field14 = $01
            local0 = createdoor(arg0\Field0, (arg0\Field3 - 3.5), arg0\Field4, (arg0\Field5 - 2.5), 90.0, arg0, $00, $02, $00, "", $00)
            local0\Field4 = $01
            local0\Field14 = $01
            arg0\Field25[$0A] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$0A], (arg0\Field3 - 3.25), (arg0\Field4 - 13.60938), (arg0\Field5 + 6.140625), $01)
            arg0\Field25[$0B] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$0B], (arg0\Field3 + 10.32031), (arg0\Field4 - 13.73438), (arg0\Field5 + 7.117188), $01)
            arg0\Field25[$0C] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$0C], (arg0\Field3 - 10.41406), (arg0\Field4 - 13.73438), (arg0\Field5 - 7.0), $01)
        Case "room2_2"
            For local4 = Each rooms
                If (local4 <> arg0) Then
                    If (local4\Field7\Field10 = "room2_2") Then
                        arg0\Field25[$00] = copyentity(local4\Field25[$00], $00)
                        Exit
                    EndIf
                EndIf
            Next
            If (arg0\Field25[$00] = $00) Then
                arg0\Field25[$00] = loadmesh_strict("GFX\map\fan.b3d", $00, $00)
            EndIf
            scaleentity(arg0\Field25[$00], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field25[$00], (arg0\Field3 - 0.96875), 2.0625, arg0\Field5, $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
        Case "room012"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + 1.03125), 0.0, (arg0\Field5 + 2.625), 270.0, arg0, $00, $00, $03, "", $00)
            positionentity(local0\Field3[$00], (arg0\Field3 + 0.875), entityy(local0\Field3[$00], $01), (arg0\Field5 + 2.109375), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 + 1.1875), entityy(local0\Field3[$01], $01), (arg0\Field5 + 3.28125), $01)
            turnentity(local0\Field3[$01], 0.0, 0.0, 0.0, $01)
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 - 2.0), -3.0, (arg0\Field5 - 1.3125), 0.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $00
            arg0\Field29[$00]\Field4 = $01
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + 0.6875), -2.0, (arg0\Field5 - 1.421875), $01)
            freeentity(arg0\Field29[$00]\Field3[$01])
            arg0\Field29[$00]\Field3[$01] = $00
            arg0\Field25[$00] = copyentity(leverbaseobj, $00)
            arg0\Field25[$01] = copyentity(leverobj, $00)
            arg0\Field28[$00] = arg0\Field25[$01]
            For local7 = $00 To $01 Step $01
                scaleentity(arg0\Field25[local7], 0.04, 0.04, 0.04, $00)
                positionentity(arg0\Field25[local7], (arg0\Field3 + 0.9375), (arg0\Field4 - 2.0), (arg0\Field5 - 1.421875), $01)
                entityparent(arg0\Field25[local7], arg0\Field2, $01)
            Next
            rotateentity(arg0\Field25[$01], 10.0, -180.0, 0.0, $00)
            entitypickmode(arg0\Field25[$01], $01, $00)
            entityradius(arg0\Field25[$01], 0.1, 0.0)
            arg0\Field25[$02] = loadmesh_strict("GFX\map\room012_2.b3d", $00, $00)
            scaleentity(arg0\Field25[$02], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field25[$02], (arg0\Field3 - 1.40625), (1.0 / -1.969231), (arg0\Field5 + 1.78125), $00)
            entityparent(arg0\Field25[$02], arg0\Field2, $01)
            arg0\Field25[$03] = createsprite($00)
            positionentity(arg0\Field25[$03], (arg0\Field3 - (1.0 / 5.885057)), -2.242188, (arg0\Field5 - 1.414062), $00)
            scalesprite(arg0\Field25[$03], 0.015, 0.015)
            entitytexture(arg0\Field25[$03], lightspritetex($01), $00, $00)
            entityblend(arg0\Field25[$03], $03)
            entityparent(arg0\Field25[$03], arg0\Field2, $01)
            hideentity(arg0\Field25[$03])
            arg0\Field25[$04] = loadmesh_strict("GFX\map\room012_3.b3d", $00, $00)
            local24 = loadtexture_strict("GFX\map\scp-012_0.jpg", $01, $00)
            entitytexture(arg0\Field25[$04], local24, $00, $01)
            scaleentity(arg0\Field25[$04], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field25[$04], (arg0\Field3 - 1.40625), (1.0 / -1.969231), (arg0\Field5 + 1.78125), $00)
            entityparent(arg0\Field25[$04], arg0\Field25[$02], $01)
            freetexture(local24)
            local6 = createitem("Document SCP-012", "paper", (arg0\Field3 - 0.21875), (arg0\Field4 - 2.25), (arg0\Field5 - 1.59375), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Severed Hand", "hand", (arg0\Field3 - 3.0625), -1.95, (arg0\Field5 + 2.5), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local3 = createdecal($03, (arg0\Field3 - 3.0625), -2.99, (arg0\Field5 + 2.5), 90.0, rnd(360.0, 0.0), 0.0)
            local3\Field2 = 0.5
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityparent(local3\Field0, arg0\Field2, $01)
        Case "tunnel2"
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], arg0\Field3, 2.125, (arg0\Field5 + 2.0), $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], arg0\Field3, 2.125, (arg0\Field5 - 2.0), $01)
        Case "room2pipes"
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 + 1.4375), 0.0, arg0\Field5, $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 - 1.4375), 0.0, arg0\Field5, $01)
            arg0\Field25[$02] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$02], ((arg0\Field3 + 0.875) - 0.005), 0.75, arg0\Field5, $01)
            arg0\Field25[$03] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$03], ((arg0\Field3 - 0.875) + 0.005), 0.75, arg0\Field5, $01)
        Case "room3pit"
            local14 = createemitter((arg0\Field3 + 2.0), -0.296875, (arg0\Field5 - 2.6875), $00, 0.0)
            turnentity(local14\Field0, -90.0, 0.0, 0.0, $00)
            entityparent(local14\Field0, arg0\Field2, $01)
            local14\Field10 = 55.0
            local14\Field9 = 0.0005
            local14\Field12 = -0.015
            local14\Field11 = 0.007
            local14 = createemitter((arg0\Field3 - 2.0), -0.296875, (arg0\Field5 - 2.6875), $00, 0.0)
            turnentity(local14\Field0, -90.0, 0.0, 0.0, $00)
            entityparent(local14\Field0, arg0\Field2, $01)
            local14\Field10 = 55.0
            local14\Field9 = 0.0005
            local14\Field12 = -0.015
            local14\Field11 = 0.007
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 + 2.75), 0.4375, (arg0\Field5 - 1.625), $01)
        Case "room2servers"
            local0 = createdoor($00, arg0\Field3, 0.0, arg0\Field5, 0.0, arg0, $00, $02, $00, "", $00)
            local0\Field4 = $01
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 - 0.8125), 0.0, (arg0\Field5 - 2.875), 90.0, arg0, $01, $00, $00, "", $01)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 - 0.8125), 0.0, (arg0\Field5 + 2.875), 90.0, arg0, $01, $00, $00, "", $01)
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 - 2.625), 0.0, (arg0\Field5 - 4.0), 0.0, arg0, $00, $00, $00, "GEAR", $00)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$02]\Field14 = $01
            arg0\Field29[$02]\Field4 = $01
            freeentity(arg0\Field29[$02]\Field3[$00])
            arg0\Field29[$02]\Field3[$00] = $00
            freeentity(arg0\Field29[$02]\Field3[$01])
            arg0\Field29[$02]\Field3[$01] = $00
            For local18 = $00 To $02 Step $01
                arg0\Field25[(local18 Shl $01)] = copyentity(leverbaseobj, $00)
                arg0\Field25[((local18 Shl $01) + $01)] = copyentity(leverobj, $00)
                arg0\Field28[local18] = arg0\Field25[((local18 Shl $01) + $01)]
                For local7 = $00 To $01 Step $01
                    scaleentity(arg0\Field25[((local18 Shl $01) + local7)], 0.03, 0.03, 0.03, $00)
                    Select local18
                        Case $00
                            positionentity(arg0\Field25[((local18 Shl $01) + local7)], (arg0\Field3 - 4.921875), (arg0\Field4 + (1.0 / 1.094017)), (arg0\Field5 + 2.929688), $01)
                        Case $01
                            positionentity(arg0\Field25[((local18 Shl $01) + local7)], (arg0\Field3 - 3.59375), (arg0\Field4 + 0.640625), (arg0\Field5 + 3.507812), $01)
                        Case $02
                            positionentity(arg0\Field25[((local18 Shl $01) + local7)], (arg0\Field3 - 3.269531), (arg0\Field4 + 0.59375), (arg0\Field5 + 3.460938), $01)
                    End Select
                    entityparent(arg0\Field25[((local18 Shl $01) + local7)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field25[((local18 Shl $01) + $01)], 81.0, -180.0, 0.0, $00)
                entitypickmode(arg0\Field25[((local18 Shl $01) + $01)], $01, $00)
                entityradius(arg0\Field25[((local18 Shl $01) + $01)], 0.1, 0.0)
            Next
            rotateentity(arg0\Field25[$03], -81.0, -180.0, 0.0, $00)
            rotateentity(arg0\Field25[$05], -81.0, -180.0, 0.0, $00)
            arg0\Field25[$06] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$06], (arg0\Field3 - 3.3125), 0.5, (arg0\Field5 - 2.25), $01)
            arg0\Field25[$07] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$07], (arg0\Field3 - 5.1875), 0.5, (arg0\Field5 + 2.0625), $01)
            arg0\Field25[$08] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$08], (arg0\Field3 - 5.375), 0.5, (arg0\Field5 + 0.125), $01)
            arg0\Field25[$09] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$09], (arg0\Field3 - 3.3125), 0.5, (arg0\Field5 + 2.25), $01)
        Case "room3servers"
            local6 = createitem("9V Battery", "bat", (arg0\Field3 - 0.515625), (arg0\Field4 - 1.4375), (arg0\Field5 - 2.53125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("9V Battery", "bat", (arg0\Field3 - 0.296875), (arg0\Field4 - 1.4375), (arg0\Field5 - 2.53125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("S-NAV 300 Navigator", "nav", (arg0\Field3 + 0.484375), (arg0\Field4 - 1.4375), (arg0\Field5 - 2.53125), $00, $00, $00, 1.0, $00, $01)
            local6\Field13 = 20.0
            entityparent(local6\Field1, arg0\Field2, $01)
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 + 2.875), -2.0, (arg0\Field5 - (1.0 / 0.64)), $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 - 2.15625), -2.0, (arg0\Field5 - 2.0625), $01)
            arg0\Field25[$02] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$02], (arg0\Field3 + 2.875), -2.0, (arg0\Field5 + 1.0625), $01)
            arg0\Field25[$03] = loadmesh_strict("GFX\npcs\duck_low_res.b3d", $00, $00)
            scaleentity(arg0\Field25[$03], 0.07, 0.07, 0.07, $00)
            local24 = loadtexture_strict("GFX\npcs\duck2.png", $01, $00)
            entitytexture(arg0\Field25[$03], local24, $00, $00)
            positionentity(arg0\Field25[$03], (arg0\Field3 + 3.625), -2.5, (arg0\Field5 + 2.75), $00)
            freetexture(local24)
            entityparent(arg0\Field25[$03], arg0\Field2, $01)
        Case "room3servers2"
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 - 1.96875), -2.0, (arg0\Field5 + 1.058594), $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 + 2.453125), -2.0, (arg0\Field5 + 1.058594), $01)
            arg0\Field25[$02] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$02], (arg0\Field3 - 2.078125), -2.0, (arg0\Field5 - 3.425781), $01)
            local6 = createitem("Document SCP-970", "paper", (arg0\Field3 + 3.75), (arg0\Field4 - 1.75), (arg0\Field5 + (1.0 / 1.01992)), $00, $00, $00, 1.0, $00, $01)
            rotateentity(local6\Field1, 0.0, (Float arg0\Field6), 0.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Gas Mask", "gasmask", (arg0\Field3 + 3.726562), (arg0\Field4 - 1.96875), (arg0\Field5 + (1.0 / 1.089362)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "testroom"
            For local8 = $00 To $01 Step $01
                For local10 = $FFFFFFFF To $01 Step $01
                    arg0\Field25[((local8 * $03) + (local10 + $01))] = createpivot($00)
                    positionentity(arg0\Field25[((local8 * $03) + (local10 + $01))], (arg0\Field3 + (((280.0 * (Float local8)) + -236.0) * (1.0 / 256.0))), -2.734375, (arg0\Field5 + ((384.0 * (Float local10)) * (1.0 / 256.0))), $00)
                    entityparent(arg0\Field25[((local8 * $03) + (local10 + $01))], arg0\Field2, $01)
                Next
            Next
            arg0\Field25[$06] = createpivot($00)
            positionentity(arg0\Field25[$06], (arg0\Field3 + 2.945312), (arg0\Field4 - 4.875), arg0\Field5, $00)
            entityparent(arg0\Field25[$06], arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 + 2.90625), (arg0\Field4 - 3.34375), (arg0\Field5 + 0.921875), arg0, $00)
            local2\Field20 = $01
            arg0\Field29[$00] = createdoor($00, (arg0\Field3 + 2.8125), 0.0, arg0\Field5, 0.0, arg0, $00, $02, $FFFFFFFF, "", $00)
            arg0\Field29[$01] = createdoor($00, (arg0\Field3 - 2.4375), -5.0, arg0\Field5, 90.0, arg0, $01, $00, $00, "", $00)
            local6 = createitem("Document SCP-682", "paper", (arg0\Field3 + 2.5625), (arg0\Field4 - 4.6875), (arg0\Field5 - (1.0 / 16.0)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room2closets"
            If (server\Field21 = $00) Then
                local6 = createitem("Document SCP-1048", "paper", (arg0\Field3 + 2.875), (arg0\Field4 + 0.6875), (arg0\Field5 + 2.875), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (arg0\Field3 + 2.875), (arg0\Field4 + 0.6875), (arg0\Field5 + 2.875), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("Gas Mask", "gasmask", (arg0\Field3 + 2.875), (arg0\Field4 + 0.6875), (arg0\Field5 + 2.125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            If (server\Field21 = $00) Then
                local6 = createitem("9V Battery", "bat", (arg0\Field3 + 2.875), (arg0\Field4 + 0.6875), (arg0\Field5 - 1.75), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
                local6 = createitem("9V Battery", "bat", (arg0\Field3 + 2.851562), (arg0\Field4 + 0.6875), (arg0\Field5 - 1.9375), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("Small First Aid Kit", "finefirstaid", (arg0\Field3 + 2.875), (arg0\Field4 + 0.6875), (arg0\Field5 - 1.75), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
                local6 = createitem("Small First Aid Kit", "finefirstaid", (arg0\Field3 + 2.851562), (arg0\Field4 + 0.6875), (arg0\Field5 - 1.9375), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("Level 1 Key Card", "key1", (arg0\Field3 + 2.875), (arg0\Field4 + 0.9375), (arg0\Field5 + 2.9375), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Clipboard", "clipboard", (arg0\Field3 + 2.875), (arg0\Field4 + 0.875), (arg0\Field5 - 1.875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Incident Report SCP-1048-A", "paper", (arg0\Field3 + 2.875), (arg0\Field4 + 0.875), (arg0\Field5 - 1.875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 - 4.375), -1.0, (arg0\Field5 + 3.5), $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 - 4.8125), -1.0, (arg0\Field5 - 0.625), $01)
            local0 = createdoor($00, (arg0\Field3 - 0.9375), 0.0, arg0\Field5, 90.0, arg0, $00, $00, $00, "", $00)
            positionentity(local0\Field3[$00], (arg0\Field3 - (1.0 / 1.113043)), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 - (1.0 / 1.024)), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0\Field5 = $00
            local0\Field21 = $00
            local2 = createsecuritycam(arg0\Field3, (arg0\Field4 + 2.75), (arg0\Field5 + 3.371094), arg0, $00)
            local2\Field11 = 180.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room2offices"
            If (server\Field21 = $00) Then
                local6 = createitem("Document SCP-106", "paper", (arg0\Field3 + 1.578125), (arg0\Field4 + (1.0 / 1.765517)), (arg0\Field5 + 2.183594), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (arg0\Field3 + 1.578125), (arg0\Field4 + (1.0 / 1.765517)), (arg0\Field5 + 2.183594), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("Level 2 Key Card", "key2", (arg0\Field3 - 0.609375), (arg0\Field4 + (1.0 / 1.695364)), (arg0\Field5 + 0.28125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("S-NAV 300 Navigator", "nav", (arg0\Field3 + 1.191406), (arg0\Field4 + (1.0 / 1.673203)), (arg0\Field5 + 3.6875), $00, $00, $00, 1.0, $00, $01)
            local6\Field13 = 20.0
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Notification", "paper", (arg0\Field3 - (1.0 / 1.868613)), (arg0\Field4 + (1.0 / 1.673203)), (arg0\Field5 + 1.8125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local26 = createwaypoint((arg0\Field3 - 0.125), (arg0\Field4 + (1.0 / 3.878788)), (arg0\Field5 + 1.125), Null, arg0)
            local27 = createwaypoint(arg0\Field3, (arg0\Field4 + (1.0 / 3.878788)), (arg0\Field5 - 1.75), Null, arg0)
            local26\Field4[$00] = local27
            local26\Field5[$00] = entitydistance(local26\Field0, local27\Field0)
            local27\Field4[$00] = local26
            local27\Field5[$00] = local26\Field5[$00]
        Case "room2offices2"
            local6 = createitem("Level 1 Key Card", "key1", (arg0\Field3 - 1.4375), (arg0\Field4 - 0.1875), (arg0\Field5 + (1.0 / 3.2)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Document SCP-895", "paper", (arg0\Field3 - 3.125), (arg0\Field4 - 0.1875), (arg0\Field5 + 1.4375), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Document SCP-860", "paper", (arg0\Field3 - 3.125), (arg0\Field4 - 0.1875), (arg0\Field5 - 1.8125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("S-NAV 300 Navigator", "nav", (arg0\Field3 - 1.3125), (arg0\Field4 - 0.1875), (arg0\Field5 - 1.875), $00, $00, $00, 1.0, $00, $01)
            local6\Field13 = 28.0
            entityparent(local6\Field1, arg0\Field2, $01)
            arg0\Field25[$00] = loadmesh_strict("GFX\npcs\duck_low_res.b3d", $00, $00)
            scaleentity(arg0\Field25[$00], 0.07, 0.07, 0.07, $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 - 3.15625), -0.28125, (arg0\Field5 - (1.0 / 6.4)), $01)
            arg0\Field25[$02] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$02], (arg0\Field3 - 1.90625), 0.625, (arg0\Field5 + 2.734375), $01)
            arg0\Field25[$03] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$03], (arg0\Field3 - 1.90625), 0.625, (arg0\Field5 - 2.609375), $01)
            arg0\Field25[$04] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$04], (arg0\Field3 - 2.234375), 1.367188, (arg0\Field5 - (1.0 / 64.0)), $01)
            local19 = rand($01, $04)
            positionentity(arg0\Field25[$00], entityx(arg0\Field25[local19], $01), entityy(arg0\Field25[local19], $01), entityz(arg0\Field25[local19], $01), $01)
        Case "room2offices3"
            local6 = createitem("Mobile Task Forces", "paper", (arg0\Field3 + 2.90625), (arg0\Field4 + 0.9375), (arg0\Field5 + 3.6875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Object Classes", "paper", (arg0\Field3 + 0.625), (arg0\Field4 + 0.9375), (arg0\Field5 + 2.21875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Document", "paper", (arg0\Field3 - 5.625), (arg0\Field4 + 2.4375), (arg0\Field5 + 0.59375), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Radio Transceiver", "radio", (arg0\Field3 - 4.625), (arg0\Field4 + 1.875), (arg0\Field5 - 3.125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("ReVision Eyedrops", "eyedrops", (arg0\Field3 - 5.972656), (arg0\Field4 + 2.199219), ((arg0\Field5 - 2.234375) + 0.0), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("9V Battery", "bat", (arg0\Field3 - 6.035156), (arg0\Field4 + 2.355469), (arg0\Field5 - 1.453125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("9V Battery", "bat", (arg0\Field3 - 6.015625), (arg0\Field4 + 2.355469), (arg0\Field5 - 1.328125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 - 4.125), 1.5, (arg0\Field5 + 1.132812), 90.0, arg0, $01, $00, $00, "", $00)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $01
            positionentity(arg0\Field29[$00]\Field3[$00], entityx(arg0\Field29[$00]\Field3[$00], $01), entityy(arg0\Field29[$00]\Field3[$00], $01), (arg0\Field5 + (1.0 / 1.590062)), $01)
            positionentity(arg0\Field29[$00]\Field3[$01], entityx(arg0\Field29[$00]\Field3[$01], $01), entityy(arg0\Field29[$00]\Field3[$01], $01), (arg0\Field5 + (1.0 / 1.590062)), $01)
        Case "room3"
            If (rand($00, $01) = $01) Then
                placehalloweenscene(arg0, $17, rand($00, ($03 - newyearindex)), (arg0\Field3 - (1.0 / 20.70979)), (arg0\Field4 + 0.302), (arg0\Field5 + 1.692062), -180.0)
            EndIf
        Case "start"
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 + 15.625), 1.5, (arg0\Field5 + 6.625), 90.0, arg0, $01, $01, $00, "", $00)
            arg0\Field29[$01]\Field4 = $00
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field9 = $01
            arg0\Field29[$01]\Field5 = $01
            freeentity(arg0\Field29[$01]\Field3[$00])
            arg0\Field29[$01]\Field3[$00] = $00
            freeentity(arg0\Field29[$01]\Field3[$01])
            arg0\Field29[$01]\Field3[$01] = $00
            arg0\Field29[$01]\Field24 = $00
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 + 10.5625), 1.5, (arg0\Field5 + 2.4375), 90.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$02]\Field5 = $00
            freeentity(arg0\Field29[$02]\Field3[$00])
            arg0\Field29[$02]\Field3[$00] = $00
            freeentity(arg0\Field29[$02]\Field3[$01])
            arg0\Field29[$02]\Field3[$01] = $00
            arg0\Field29[$02]\Field24 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + 5.4375), 1.5, (arg0\Field5 + 0.25), 90.0, arg0, $01, $00, $00, "", $00)
            local0\Field21 = $00
            local0\Field24 = $00
            local0\Field4 = $01
            local0 = createdoor(arg0\Field0, (arg0\Field3 - 2.5), 1.5, (arg0\Field5 + 0.25), 90.0, arg0, $00, $00, $00, "", $00)
            local0\Field4 = $01
            local0\Field21 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + 5.0), 1.5, (arg0\Field5 + 1.21875), 180.0, arg0, $01, $00, $00, "", $00)
            local0\Field4 = $01
            local0\Field21 = $00
            positionentity(local0\Field3[$00], (arg0\Field3 + 4.375), entityy(local0\Field3[$00], $01), (arg0\Field5 + 1.28125), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 + 4.375), entityy(local0\Field3[$01], $01), (arg0\Field5 + 1.15625), $01)
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0\Field24 = $00
            local0 = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 + 4.625), 0.0, arg0, $00, $00, $00, "", $00)
            local0\Field4 = $01
            arg0\Field25[$00] = loadmesh_strict("GFX\map\IntroDesk.b3d", $00, $00)
            scaleentity(arg0\Field25[$00], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field25[$00], (arg0\Field3 + 1.0625), 0.0, (arg0\Field5 + (1.0 / 0.64)), $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            local3 = createdecal($00, (arg0\Field3 + 1.0625), 0.005, (arg0\Field5 + 1.023438), 90.0, (Float rand($168, $01)), 0.0)
            entityparent(local3\Field0, arg0\Field2, $01)
            arg0\Field25[$01] = loadmesh_strict("GFX\map\IntroDrawer.b3d", $00, $00)
            scaleentity(arg0\Field25[$01], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field25[$01], (arg0\Field3 + 1.75), 0.0, (arg0\Field5 + 0.75), $00)
            entityparent(arg0\Field25[$01], arg0\Field2, $01)
            local3 = createdecal($00, (arg0\Field3 + 1.78125), 0.005, (arg0\Field5 + (1.0 / 1.896296)), 90.0, (Float rand($168, $01)), 0.0)
            entityparent(local3\Field0, arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 - 1.3125), (arg0\Field4 + 1.375), (arg0\Field5 + 0.1875), arg0, $01)
            local2\Field11 = 270.0
            local2\Field12 = 45.0
            local2\Field19 = arg0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, (arg0\Field3 + 5.6875), 2.375, (arg0\Field5 + 1.375), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 + 6.599336), (arg0\Field4 + 1.505125), (arg0\Field5 - 1.068605), 0.0)
            placehalloweenscene(arg0, $17, rand($00, ($03 - newyearindex)), (arg0\Field3 - 1.748793), (arg0\Field4 + 0.302), (arg0\Field5 + 3.804094), -115.0)
            arg0\Field25[$02] = createpivot($00)
            positionentity(arg0\Field25[$02], (entityx(arg0\Field2, $00) + (1.0 / 6.4)), 1.796875, (entityz(arg0\Field2, $00) + 4.1875), $00)
            arg0\Field25[$03] = createpivot($00)
            positionentity(arg0\Field25[$03], (entityx(arg0\Field2, $00) - (1.0 / 3.2)), (1.0 / 2.56), (entityz(arg0\Field2, $00) + 2.054688), $00)
            arg0\Field25[$04] = createpivot($00)
            positionentity(arg0\Field25[$04], (entityx(arg0\Field2, $00) - 0.5), (1.0 / 2.56), (entityz(arg0\Field2, $00) + 1.25), $00)
            arg0\Field25[$05] = createpivot($00)
            positionentity(arg0\Field25[$05], (entityx(arg0\Field2, $00) + 2.578125), (1.0 / 2.56), (entityz(arg0\Field2, $00) + 2.054688), $00)
            arg0\Field25[$06] = createpivot($00)
            positionentity(arg0\Field25[$06], (entityx(arg0\Field2, $00) + 2.734375), (1.0 / 2.56), (entityz(arg0\Field2, $00) + 1.25), $00)
            arg0\Field25[$07] = createpivot($00)
            positionentity(arg0\Field25[$07], (entityx(arg0\Field2, $00) + 5.75), (1.0 / 2.56), (entityz(arg0\Field2, $00) + 3.5625), $00)
            For local7 = $02 To $07 Step $01
                entityparent(arg0\Field25[local7], arg0\Field2, $01)
            Next
            createdevilemitter((arg0\Field3 + 13.21875), (arg0\Field4 + 1.992188), (arg0\Field5 + 9.375), arg0, $01, 4.0)
        Case "room2scps"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + 1.03125), 0.0, arg0\Field5, 90.0, arg0, $01, $00, $03, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], (arg0\Field3 + 1.25), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 + 0.875), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - 1.03125), 0.0, (arg0\Field5 + 0.125), 270.0, arg0, $01, $00, $03, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], (arg0\Field3 - 1.25), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 - 0.875), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 - 2.1875), 0.0, (arg0\Field5 - (1.0 / 1.057851)), 0.0, arg0, $01, $00, $03, "", $00)
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field5 = $00
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 + 2.1875), 0.0, (arg0\Field5 - 0.984375), 180.0, arg0, $01, $00, $03, "", $00)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$02]\Field5 = $00
            arg0\Field29[$03] = createdoor(arg0\Field0, (arg0\Field3 + 2.1875), 0.0, (arg0\Field5 + 1.0625), 180.0, arg0, $01, $00, $03, "", $00)
            arg0\Field29[$03]\Field21 = $00
            arg0\Field29[$03]\Field5 = $00
            arg0\Field29[$04] = createdoor(arg0\Field0, (arg0\Field3 - 2.1875), 0.0, (arg0\Field5 + 1.0625), 0.0, arg0, $01, $00, $03, "", $00)
            arg0\Field29[$04]\Field21 = $00
            arg0\Field29[$04]\Field5 = $00
            local6 = createitem("SCP-714", "scp714", (arg0\Field3 - 2.15625), (arg0\Field4 + 0.859375), (arg0\Field5 - 2.96875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("SCP-1025", "scp1025", (arg0\Field3 + 2.15625), (arg0\Field4 + 0.875), (arg0\Field5 - 2.960938), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            If (server\Field21 = $00) Then
                local6 = createitem("SCP-860", "scp860", (arg0\Field3 + 2.21875), (arg0\Field4 + (1.0 / 1.438202)), (arg0\Field5 + 2.96875), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local2 = createsecuritycam((arg0\Field3 + 2.1875), (arg0\Field4 + 1.507812), (arg0\Field5 - 1.625), arg0, $00)
            local2\Field11 = 180.0
            local2\Field12 = 30.0
            turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 - 2.1875), (arg0\Field4 + 1.507812), (arg0\Field5 - 1.625), arg0, $00)
            local2\Field11 = 180.0
            local2\Field12 = 30.0
            turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 + 2.1875), (arg0\Field4 + 1.507812), (arg0\Field5 + 1.875), arg0, $00)
            local2\Field11 = 0.0
            local2\Field12 = 30.0
            turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 - 2.1875), (arg0\Field4 + 1.507812), (arg0\Field5 + 1.875), arg0, $00)
            local2\Field11 = 0.0
            local2\Field12 = 30.0
            turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            local6 = createitem("Document SCP-714", "paper", (arg0\Field3 - 2.84375), (arg0\Field4 + 1.125), (arg0\Field5 - 1.40625), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Document SCP-427", "paper", (arg0\Field3 - 2.375), (arg0\Field4 + (1.0 / 3.878788)), (arg0\Field5 + 2.484375), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            For local7 = $00 To $0E Step $01
                Select local7
                    Case $00
                        local28 = -64.0
                        local31 = -516.0
                    Case $01
                        local28 = -96.0
                        local31 = -388.0
                    Case $02
                        local28 = -128.0
                        local31 = -292.0
                    Case $03
                        local28 = -128.0
                        local31 = -132.0
                    Case $04
                        local28 = -160.0
                        local31 = -36.0
                    Case $05
                        local28 = -192.0
                        local31 = 28.0
                    Case $06
                        local28 = -384.0
                        local31 = 28.0
                    Case $07
                        local28 = -448.0
                        local31 = 92.0
                    Case $08
                        local28 = -480.0
                        local31 = 124.0
                    Case $09
                        local28 = -512.0
                        local31 = 156.0
                    Case $0A
                        local28 = -544.0
                        local31 = 220.0
                    Case $0B
                        local28 = -544.0
                        local31 = 380.0
                    Case $0C
                        local28 = -544.0
                        local31 = 476.0
                    Case $0D
                        local28 = -544.0
                        local31 = 572.0
                    Case $0E
                        local28 = -544.0
                        local31 = 636.0
                End Select
                local3 = createdecal(rand($0F, $10), (arg0\Field3 + (local28 * (1.0 / 256.0))), 0.005, (arg0\Field5 + (local31 * (1.0 / 256.0))), 90.0, (Float rand($168, $01)), 0.0)
                If (local7 > $0A) Then
                    local3\Field2 = rnd(0.2, 0.25)
                Else
                    local3\Field2 = rnd(0.1, 0.17)
                EndIf
                entityalpha(local3\Field0, 1.0)
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                entityparent(local3\Field0, arg0\Field2, $01)
            Next
        Case "room205"
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 + 0.5), 0.0, (arg0\Field5 + 2.5), 90.0, arg0, $01, $00, $03, "", $00)
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field5 = $00
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 - 5.4375), -0.5, (arg0\Field5 - 1.5), 0.0, arg0, $01, $00, $03, "", $01)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $00
            freeentity(arg0\Field29[$00]\Field3[$00])
            arg0\Field29[$00]\Field3[$00] = $00
            freeentity(arg0\Field29[$00]\Field3[$01])
            arg0\Field29[$00]\Field3[$01] = $00
            local2 = createsecuritycam((arg0\Field3 - 4.5), (arg0\Field4 + 3.515625), (arg0\Field5 + 0.6875), arg0, $01)
            local2\Field11 = 90.0
            local2\Field12 = 0.0
            entityparent(local2\Field0, arg0\Field2, $01)
            local2\Field22 = $00
            local2\Field18 = 0.0
            entityparent(local2\Field4, $00, $01)
            positionentity(local2\Field4, (arg0\Field3 - 6.703125), (arg0\Field4 + 0.625), (arg0\Field5 + 0.6875), $01)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            scalesprite(local2\Field4, 1.75, 1.75)
            entityparent(local2\Field4, arg0\Field2, $01)
            camerazoom(local2\Field8, 1.5)
            hideentity(local2\Field10)
            hideentity(local2\Field1)
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 - 6.0), (arg0\Field4 + 2.851562), (arg0\Field5 + 0.75), $01)
            rotateentity(arg0\Field25[$00], 0.0, -90.0, 0.0, $01)
            arg0\Field25[$01] = local2\Field4
        Case "endroom"
            arg0\Field29[$00] = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 + 4.4375), 0.0, arg0, $00, $01, $06, "", $00)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $00
            arg0\Field29[$00]\Field4 = $01
            freeentity(arg0\Field29[$00]\Field3[$00])
            arg0\Field29[$00]\Field3[$00] = $00
            freeentity(arg0\Field29[$00]\Field3[$01])
            arg0\Field29[$00]\Field3[$01] = $00
        Case "endroomc"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + 4.0), 0.0, arg0\Field5, 0.0, arg0, $00, $02, $00, "", $00)
            local0\Field5 = $00
            local0\Field21 = $00
            local0\Field4 = $01
        Case "coffin"
            arg0\Field29[$00] = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - 1.75), 0.0, arg0, $00, $01, $02, "", $00)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $00
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 - 1.5), 0.7, (arg0\Field5 - 1.09375), $01)
            local2 = createsecuritycam((arg0\Field3 - 1.25), (arg0\Field4 + 2.75), (arg0\Field5 + 1.125), arg0, $01)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            local2\Field21 = $01
            turnentity(local2\Field3, 120.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            coffincam = local2
            positionentity(local2\Field4, (arg0\Field3 - 3.125), 1.125, (arg0\Field5 - 1.328125), $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            turnentity(local2\Field4, 0.0, 180.0, 0.0, $00)
            arg0\Field25[$02] = copyentity(leverbaseobj, $00)
            arg0\Field25[$03] = copyentity(leverobj, $00)
            arg0\Field28[$00] = arg0\Field25[$03]
            For local7 = $00 To $01 Step $01
                scaleentity(arg0\Field25[($02 + local7)], 0.04, 0.04, 0.04, $00)
                positionentity(arg0\Field25[($02 + local7)], (arg0\Field3 - 3.125), (arg0\Field4 + 0.703125), (arg0\Field5 - 1.3125), $01)
                entityparent(arg0\Field25[($02 + local7)], arg0\Field2, $01)
            Next
            rotateentity(arg0\Field25[$02], 0.0, 180.0, 0.0, $00)
            rotateentity(arg0\Field25[$03], 10.0, 0.0, 0.0, $00)
            entitypickmode(arg0\Field25[$03], $01, $00)
            entityradius(arg0\Field25[$03], 0.1, 0.0)
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], arg0\Field3, -5.15625, (arg0\Field5 + 9.0), $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            local6 = createitem("Document SCP-895", "paper", (arg0\Field3 - 2.6875), (arg0\Field4 + (1.0 / 1.924812)), (arg0\Field5 - 1.1875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Level 4 Key Card", "key4", (arg0\Field3 + 0.9375), (arg0\Field4 - 5.6875), (arg0\Field5 + 8.0625), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Night Vision Goggles", "nvgoggles", (arg0\Field3 + 1.09375), (arg0\Field4 - 5.6875), (arg0\Field5 + 8.453125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6\Field13 = 400.0
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 + 0.375), -5.984375, (arg0\Field5 + 7.875), $01)
        Case "room2tesla","room2tesla_lcz","room2tesla_hcz"
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (arg0\Field3 - (1.0 / 2.245614)), 0.0, arg0\Field5, $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            arg0\Field25[$01] = createpivot($00)
            positionentity(arg0\Field25[$01], (arg0\Field3 + (1.0 / 2.245614)), 0.0, arg0\Field5, $00)
            entityparent(arg0\Field25[$01], arg0\Field2, $01)
            arg0\Field25[$02] = createpivot($00)
            positionentity(arg0\Field25[$02], arg0\Field3, 0.0, arg0\Field5, $00)
            entityparent(arg0\Field25[$02], arg0\Field2, $01)
            arg0\Field25[$03] = createsprite($00)
            entitytexture(arg0\Field25[$03], teslatexture, $00, $00)
            spriteviewmode(arg0\Field25[$03], $02)
            entityblend(arg0\Field25[$03], $03)
            entityfx(arg0\Field25[$03], $19)
            positionentity(arg0\Field25[$03], arg0\Field3, 0.8, arg0\Field5, $00)
            hideentity(arg0\Field25[$03])
            entityparent(arg0\Field25[$03], arg0\Field2, $01)
            local26 = createwaypoint(arg0\Field3, (arg0\Field4 + (1.0 / 3.878788)), (arg0\Field5 + 1.140625), Null, arg0)
            local27 = createwaypoint(arg0\Field3, (arg0\Field4 + (1.0 / 3.878788)), (arg0\Field5 - 1.109375), Null, arg0)
            local26\Field4[$00] = local27
            local26\Field5[$00] = entitydistance(local26\Field0, local27\Field0)
            local27\Field4[$00] = local26
            local27\Field5[$00] = local26\Field5[$00]
            arg0\Field25[$04] = createsprite($00)
            positionentity(arg0\Field25[$04], (arg0\Field3 - 0.125), 2.21875, arg0\Field5, $00)
            scalesprite(arg0\Field25[$04], 0.03, 0.03)
            entitytexture(arg0\Field25[$04], lightspritetex($01), $00, $00)
            entityblend(arg0\Field25[$04], $03)
            entityparent(arg0\Field25[$04], arg0\Field2, $01)
            hideentity(arg0\Field25[$04])
            arg0\Field25[$05] = createpivot($00)
            positionentity(arg0\Field25[$05], arg0\Field3, 0.0, (arg0\Field5 - 3.125), $00)
            entityparent(arg0\Field25[$05], arg0\Field2, $01)
            arg0\Field25[$06] = createpivot($00)
            positionentity(arg0\Field25[$06], arg0\Field3, 0.0, (arg0\Field5 + 3.125), $00)
            entityparent(arg0\Field25[$06], arg0\Field2, $01)
        Case "room2doors"
            local0 = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 + 2.0625), 0.0, arg0, $01, $00, $00, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$00], (arg0\Field3 - 3.25), 0.7, (arg0\Field5 + 0.625), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 + 0.625), 0.7, (arg0\Field5 + 2.09375), $01)
            local1 = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - 2.0625), 180.0, arg0, $01, $00, $00, "", $00)
            local1\Field21 = $00
            freeentity(local1\Field3[$00])
            local1\Field3[$00] = $00
            positionentity(local1\Field3[$01], (arg0\Field3 + 0.625), 0.7, (arg0\Field5 - 2.09375), $01)
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (arg0\Field3 - 3.25), 0.5, arg0\Field5, $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            local1\Field22 = local0
            local0\Field22 = local1
            local0\Field5 = $00
            local1\Field5 = $01
        Case "room4"
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 + 1.427953), (arg0\Field4 + 1.625), (arg0\Field5 + (1.0 / 13.26732)), 90.0)
        Case "914"
            arg0\Field29[$02] = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - 1.4375), 0.0, arg0, $00, $01, $02, "", $00)
            arg0\Field29[$02]\Field9 = $01
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$02]\Field5 = $00
            positionentity(arg0\Field29[$02]\Field3[$00], (arg0\Field3 - 1.9375), 0.7, (arg0\Field5 - 1.0625), $01)
            turnentity(arg0\Field29[$02]\Field3[$00], 0.0, 90.0, 0.0, $00)
            arg0\Field25[$00] = loadmesh_strict("GFX\map\914key.x", $00, $00)
            arg0\Field25[$01] = loadmesh_strict("GFX\map\914knob.x", $00, $00)
            For local7 = $00 To $01 Step $01
                scaleentity(arg0\Field25[local7], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                entitypickmode(arg0\Field25[local7], $02, $01)
            Next
            positionentity(arg0\Field25[$00], arg0\Field3, (arg0\Field4 + (1.0 / 1.347368)), (arg0\Field5 + 1.460938), $00)
            positionentity(arg0\Field25[$01], arg0\Field3, (arg0\Field4 + (1.0 / 1.113043)), (arg0\Field5 + 1.460938), $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            entityparent(arg0\Field25[$01], arg0\Field2, $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - 2.4375), 0.0, (arg0\Field5 + 2.0625), 180.0, arg0, $01, $00, $00, "", $00)
            freeentity(local0\Field1)
            local0\Field1 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local0\Field9 = $04
            arg0\Field29[$00] = local0
            local0\Field21 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + 3.1875), 0.0, (arg0\Field5 + 2.0625), 180.0, arg0, $01, $00, $00, "", $00)
            freeentity(local0\Field1)
            local0\Field1 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local0\Field9 = $04
            arg0\Field29[$01] = local0
            local0\Field21 = $00
            arg0\Field25[$02] = createpivot($00)
            arg0\Field25[$03] = createpivot($00)
            positionentity(arg0\Field25[$02], (arg0\Field3 - 2.78125), 0.5, (arg0\Field5 + 2.5), $00)
            positionentity(arg0\Field25[$03], (arg0\Field3 + 2.84375), 0.5, (arg0\Field5 + 2.5), $00)
            entityparent(arg0\Field25[$02], arg0\Field2, $01)
            entityparent(arg0\Field25[$03], arg0\Field2, $01)
            local6 = createitem("Addendum: 5/14 Test Log", "paper", (arg0\Field3 + 3.726562), (arg0\Field4 + 0.890625), (arg0\Field5 + (1.0 / 2.015748)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("First Aid Kit", "firstaid", (arg0\Field3 + 3.75), (arg0\Field4 + 0.4375), (arg0\Field5 - (1.0 / 6.4)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
            local6 = createitem("Dr. L's Note", "paper", (arg0\Field3 - 3.625), 0.625, (arg0\Field5 - 0.625), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 - 3.385273), 0.0, (arg0\Field5 + (1.0 / 1.728305)), -90.0)
            local15 = createcube($00)
            entityalpha(local15, 0.0)
            positionentity(local15, arg0\Field3, arg0\Field4, (arg0\Field5 + 1.460938), $00)
            moveentity(local15, 0.0, 2.5, 0.0)
            scaleentity(local15, 2.92, 1.0, 3.39, $00)
            entitytype(local15, $09, $00)
            entityparent(local15, arg0\Field2, $01)
        Case "173"
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (entityx(arg0\Field2, $00) + (1.0 / 6.4)), 1.796875, (entityz(arg0\Field2, $00) + 4.1875), $00)
            arg0\Field25[$01] = createpivot($00)
            positionentity(arg0\Field25[$01], (entityx(arg0\Field2, $00) - (1.0 / 3.2)), (1.0 / 2.56), (entityz(arg0\Field2, $00) + 2.054688), $00)
            arg0\Field25[$02] = createpivot($00)
            positionentity(arg0\Field25[$02], (entityx(arg0\Field2, $00) - 0.5), (1.0 / 2.56), (entityz(arg0\Field2, $00) + 1.25), $00)
            arg0\Field25[$03] = createpivot($00)
            positionentity(arg0\Field25[$03], (entityx(arg0\Field2, $00) + 2.578125), (1.0 / 2.56), (entityz(arg0\Field2, $00) + 2.054688), $00)
            arg0\Field25[$04] = createpivot($00)
            positionentity(arg0\Field25[$04], (entityx(arg0\Field2, $00) + 2.734375), (1.0 / 2.56), (entityz(arg0\Field2, $00) + 1.25), $00)
            arg0\Field25[$05] = createpivot($00)
            positionentity(arg0\Field25[$05], (entityx(arg0\Field2, $00) + 5.75), (1.0 / 2.56), (entityz(arg0\Field2, $00) + 3.5625), $00)
            For local7 = $00 To $05 Step $01
                entityparent(arg0\Field25[local7], arg0\Field2, $01)
            Next
            arg0\Field29[$01] = createdoor(arg0\Field0, (entityx(arg0\Field2, $00) + 1.125), 0.0, (entityz(arg0\Field2, $00) + 1.5), 90.0, arg0, $00, $01, $00, "", $00)
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field9 = $01
            arg0\Field29[$01]\Field5 = $00
            freeentity(arg0\Field29[$01]\Field3[$00])
            arg0\Field29[$01]\Field3[$00] = $00
            freeentity(arg0\Field29[$01]\Field3[$01])
            arg0\Field29[$01]\Field3[$01] = $00
            local3 = createdecal(rand($04, $05), entityx(arg0\Field25[$05], $01), 0.002, entityz(arg0\Field25[$05], $01), 90.0, rnd(360.0, 0.0), 0.0)
            local3\Field2 = 1.2
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            For local8 = $00 To $01 Step $01
                For local10 = $00 To $01 Step $01
                    local3 = createdecal(rand($04, $06), (((arg0\Field3 + 2.734375) + (((Float local8) * 700.0) * (1.0 / 256.0))) + rnd(-0.5, 0.5)), rnd(0.001, 0.0018), ((arg0\Field5 + ((Float ($258 * local10)) * (1.0 / 256.0))) + rnd(-0.5, 0.5)), 90.0, rnd(360.0, 0.0), 0.0)
                    local3\Field2 = rnd(0.5, 0.8)
                    local3\Field5 = rnd(0.8, 1.0)
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Next
            Next
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 - 3.9375), 0.0, (arg0\Field5 - 2.6875), 90.0, arg0, $01, $00, $00, "", $01)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$02]\Field5 = $00
            arg0\Field29[$02]\Field4 = $01
            freeentity(arg0\Field29[$02]\Field3[$00])
            arg0\Field29[$02]\Field3[$00] = $00
            freeentity(arg0\Field29[$02]\Field3[$01])
            arg0\Field29[$02]\Field3[$01] = $00
            arg0\Field29[$03] = createdoor(arg0\Field0, (arg0\Field3 - 9.0625), 0.0, (arg0\Field5 - 4.875), 90.0, arg0, $01, $00, $00, "", $00)
            arg0\Field29[$03]\Field21 = $00
            arg0\Field29[$03]\Field5 = $01
            arg0\Field29[$03]\Field4 = $01
            arg0\Field29[$04] = createdoor(arg0\Field0, (arg0\Field3 - 17.0), 0.0, (arg0\Field5 - 4.875), 90.0, arg0, $01, $00, $00, "", $00)
            arg0\Field29[$04]\Field21 = $00
            arg0\Field29[$04]\Field5 = $01
            arg0\Field29[$04]\Field4 = $01
            arg0\Field29[$07] = createdoor(arg0\Field0, (arg0\Field3 - 14.5), -1.503906, (arg0\Field5 - 0.5), 0.0, arg0, $01, $00, $00, "", $00)
            arg0\Field29[$07]\Field21 = $00
            arg0\Field29[$07]\Field5 = $01
            local0 = createdoor(arg0\Field0, (arg0\Field3 - 14.5), -1.503906, (arg0\Field5 - 9.125), 0.0, arg0, $00, $00, $00, "", $00)
            local0\Field4 = $01
            local0\Field14 = $01
            local0 = createdoor(arg0\Field0, (arg0\Field3 - 26.8125), 0.0, (arg0\Field5 - 4.875), 90.0, arg0, $01, $00, $00, "", $00)
            local0\Field21 = $00
            local0\Field4 = $01
            local0 = createdoor(arg0\Field0, (arg0\Field3 - 22.875), 0.0, (arg0\Field5 - 5.875), 0.0, arg0, $00, $00, $00, "", $00)
            local0\Field4 = $01
            local0\Field14 = $01
            local0 = createdoor(arg0\Field0, (arg0\Field3 - 9.5), 0.0, (arg0\Field5 - (1.0 / 0.256)), 0.0, arg0, $00, $00, $00, "", $00)
            positionentity(local0\Field3[$00], (arg0\Field3 - 10.125), entityy(local0\Field3[$00], $01), (arg0\Field5 - 3.96875), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 - 10.125), entityy(local0\Field3[$00], $01), (arg0\Field5 - 3.84375), $01)
            local0\Field4 = $01
            local0\Field14 = $01
            local24 = loadtexture_strict("GFX\map\Door02.jpg", $01, $00)
            For local10 = $00 To $01 Step $01
                local0 = createdoor(arg0\Field0, (arg0\Field3 - 22.5), 0.0, (arg0\Field5 + ((Float (($380 * local10) + $140)) * (1.0 / 256.0))), 0.0, arg0, $00, $00, $00, "", $00)
                local0\Field4 = $01
                local0\Field14 = $01
                local0 = createdoor(arg0\Field0, (arg0\Field3 - 32.375), 0.0, (arg0\Field5 + ((Float (($380 * local10) + $140)) * (1.0 / 256.0))), 0.0, arg0, $00, $00, $00, "", $00)
                local0\Field4 = $01
                If (local10 = $00) Then
                    local0\Field5 = $01
                Else
                    local0\Field14 = $01
                EndIf
                For local8 = $00 To $02 Step $01
                    local0 = createdoor(arg0\Field0, (arg0\Field3 - ((7424.0 - (512.0 * (Float local8))) * (1.0 / 256.0))), 0.0, (arg0\Field5 + ((1008.0 - (480.0 * (Float local10))) * (1.0 / 256.0))), (Float ((local10 = $00) * $B4)), arg0, $00, $00, $00, "", $00)
                    entitytexture(local0\Field0, local24, $00, $00)
                    local0\Field4 = $01
                    freeentity(local0\Field1)
                    local0\Field1 = $00
                    freeentity(local0\Field3[$00])
                    local0\Field3[$00] = $00
                    freeentity(local0\Field3[$01])
                    local0\Field3[$01] = $00
                    local0\Field14 = $01
                Next
                For local8 = $00 To $04 Step $01
                    local0 = createdoor(arg0\Field0, (arg0\Field3 - ((5120.0 - (512.0 * (Float local8))) * (1.0 / 256.0))), 0.0, (arg0\Field5 + ((1008.0 - (480.0 * (Float local10))) * (1.0 / 256.0))), (Float ((local10 = $00) * $B4)), arg0, $00, $00, $00, "", $00)
                    entitytexture(local0\Field0, local24, $00, $00)
                    local0\Field4 = $01
                    freeentity(local0\Field1)
                    local0\Field1 = $00
                    freeentity(local0\Field3[$00])
                    local0\Field3[$00] = $00
                    freeentity(local0\Field3[$01])
                    local0\Field3[$01] = $00
                    local0\Field14 = $01
                    If (((local8 = $02) And (local10 = $01)) <> 0) Then
                        arg0\Field29[$06] = local0
                    EndIf
                Next
            Next
            createitem("Class D Orientation Leaflet", "paper", (arg0\Field3 - 15.38281), (1.0 / 1.505882), (arg0\Field5 + (1.0 / 6.4)), $00, $00, $00, 1.0, $00, $01)
            local2 = createsecuritycam((arg0\Field3 - 15.8125), (arg0\Field4 - 0.125), (arg0\Field5 - 4.8125), arg0, $01)
            local2\Field11 = 270.0
            local2\Field12 = 45.0
            local2\Field19 = arg0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, (arg0\Field3 - 8.8125), 0.875, (arg0\Field5 - 3.625), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            arg0\Field25[$09] = loadmesh_strict("GFX\map\173_2.b3d", arg0\Field2, $00)
            entitytype(arg0\Field25[$09], $01, $00)
            entitypickmode(arg0\Field25[$09], $02, $01)
            arg0\Field25[$0A] = loadmesh_strict("GFX\map\intro_labels.b3d", arg0\Field2, $00)
            freetexture(local24)
        Case "room2ccont"
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 + 0.25), 0.0, (arg0\Field5 + 1.4375), 180.0, arg0, $00, $00, $02, "", $00)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $00
            If (server\Field21 = $00) Then
                local6 = createitem("Note from Daniel", "paper", (arg0\Field3 - (1.0 / 0.64)), 4.0625, (arg0\Field5 + (1.0 / 2.226087)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("FN P90", "p90", (arg0\Field3 - (1.0 / 0.64)), 4.0625, (arg0\Field5 + (1.0 / 2.226087)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            For local18 = $00 To $02 Step $01
                arg0\Field25[(local18 Shl $01)] = copyentity(leverbaseobj, $00)
                arg0\Field25[((local18 Shl $01) + $01)] = copyentity(leverobj, $00)
                arg0\Field28[local18] = arg0\Field25[((local18 Shl $01) + $01)]
                For local7 = $00 To $01 Step $01
                    scaleentity(arg0\Field25[((local18 Shl $01) + local7)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field25[((local18 Shl $01) + local7)], (arg0\Field3 - 0.9375), (arg0\Field4 + 4.3125), (arg0\Field5 + ((632.0 - (64.0 * (Float local18))) * (1.0 / 256.0))), $01)
                    entityparent(arg0\Field25[((local18 Shl $01) + local7)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field25[(local18 Shl $01)], 0.0, -90.0, 0.0, $00)
                rotateentity(arg0\Field25[((local18 Shl $01) + $01)], 10.0, -270.0, 0.0, $00)
                entitypickmode(arg0\Field25[((local18 Shl $01) + $01)], $01, $00)
                entityradius(arg0\Field25[((local18 Shl $01) + $01)], 0.1, 0.0)
            Next
            local2 = createsecuritycam((arg0\Field3 - 1.035156), (arg0\Field4 + 5.0), (arg0\Field5 + (1.0 / 2.438095)), arg0, $00)
            local2\Field11 = 45.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room106"
            local6 = createitem("Level 5 Key Card", "key5", (arg0\Field3 - 2.9375), (arg0\Field4 - 2.3125), (arg0\Field5 + 11.82031), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Dr. Allok's Note", "paper", (arg0\Field3 - 1.625), (arg0\Field4 - 2.25), (arg0\Field5 + 9.734375), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Recall Protocol RP-106-N", "paper", (arg0\Field3 + 1.046875), (arg0\Field4 - 2.25), (arg0\Field5 + 10.12891), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - 3.78125), -2.984375, (arg0\Field5 + 5.4375), 0.0, arg0, $00, $00, $04, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            arg0\Field29[$00] = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - 1.8125), 0.0, arg0, $00, $00, $04, "", $00)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - 2.4375), -5.0, arg0\Field5, 90.0, arg0, $00, $00, $04, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            If (server\Field21 <> 0) Then
                local6 = createitem("Micro-HID", "microhid", (arg0\Field3 - (1.0 / 1.078485)), (arg0\Field4 - 2.25), (arg0\Field5 + 9.701817), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            arg0\Field25[$06] = loadmesh_strict("GFX\map\room1062.b3d", $00, $00)
            scaleentity(arg0\Field25[$06], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            entitytype(arg0\Field25[$06], $01, $00)
            entitypickmode(arg0\Field25[$06], $03, $01)
            positionentity(arg0\Field25[$06], (arg0\Field3 + 3.0625), -3.828125, (arg0\Field5 + 2.8125), $01)
            entityparent(arg0\Field25[$06], arg0\Field2, $01)
            For local18 = $00 To $02 Step $02
                arg0\Field25[local18] = copyentity(leverbaseobj, $00)
                arg0\Field25[(local18 + $01)] = copyentity(leverobj, $00)
                arg0\Field28[(local18 Sar $01)] = arg0\Field25[(local18 + $01)]
                For local7 = $00 To $01 Step $01
                    scaleentity(arg0\Field25[(local18 + local7)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field25[(local18 + local7)], (arg0\Field3 - ((555.0 - (81.0 * (Float (local18 Sar $01)))) * (1.0 / 256.0))), (arg0\Field4 - 2.25), (arg0\Field5 + 11.875), $01)
                    entityparent(arg0\Field25[(local18 + local7)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field25[local18], 0.0, 0.0, 0.0, $00)
                rotateentity(arg0\Field25[(local18 + $01)], 10.0, -180.0, 0.0, $00)
                entitypickmode(arg0\Field25[(local18 + $01)], $01, $00)
                entityradius(arg0\Field25[(local18 + $01)], 0.1, 0.0)
            Next
            rotateentity(arg0\Field25[$01], 81.0, -180.0, 0.0, $00)
            rotateentity(arg0\Field25[$03], -81.0, -180.0, 0.0, $00)
            arg0\Field25[$04] = createbutton((arg0\Field3 - (1.0 / 1.753425)), (arg0\Field4 - 2.25), (arg0\Field5 + 11.89453), 0.0, 0.0, 0.0)
            entityparent(arg0\Field25[$04], arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 + 3.0), (arg0\Field4 + 5.4375), (arg0\Field5 + 6.625), arg0, $01)
            local2\Field11 = 315.0
            local2\Field12 = 20.0
            turnentity(local2\Field3, 45.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            arg0\Field25[$07] = local2\Field3
            arg0\Field25[$08] = local2\Field0
            positionentity(local2\Field4, (arg0\Field3 - 1.0625), -2.125, (arg0\Field5 + 11.79688), $00)
            turnentity(local2\Field4, 0.0, -10.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            local2\Field21 = $00
            arg0\Field25[$05] = createpivot($00)
            turnentity(arg0\Field25[$05], 0.0, 180.0, 0.0, $00)
            positionentity(arg0\Field25[$05], (arg0\Field3 + 4.25), 4.3125, (arg0\Field5 + 7.375), $00)
            entityparent(arg0\Field25[$05], arg0\Field2, $01)
            arg0\Field25[$09] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$09], (arg0\Field3 - 1.0625), (arg0\Field4 - 2.625), (arg0\Field5 + 10.6875), $01)
            arg0\Field25[$0A] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$0A], arg0\Field3, arg0\Field4, (arg0\Field5 - 2.8125), $01)
        Case "room1archive"
            If (server\Field21 = $00) Then
                For local8 = $00 To $01 Step $01
                    For local9 = $00 To $02 Step $01
                        For local10 = $00 To $02 Step $01
                            local32 = "9V Battery"
                            local33 = "bat"
                            local34 = rand($FFFFFFF6, $64)
                            Select $01
                                Case (local34 < $00)
                                    Exit
                                Case (local34 < $28)
                                    local32 = "Document SCP-"
                                    Select rand($01, $06)
                                        Case $01
                                            local32 = (local32 + "1123")
                                        Case $02
                                            local32 = (local32 + "1048")
                                        Case $03
                                            local32 = (local32 + "939")
                                        Case $04
                                            local32 = (local32 + "682")
                                        Case $05
                                            local32 = (local32 + "079")
                                        Case $06
                                            local32 = (local32 + "096")
                                        Case $06
                                            local32 = (local32 + "966")
                                    End Select
                                    local33 = "paper"
                                Case ((local34 >= $28) And (local34 < $2D))
                                    local37 = rand($01, $02)
                                    local32 = (("Level " + (Str local37)) + " Key Card")
                                    local33 = ("key" + (Str local37))
                                Case ((local34 >= $2D) And (local34 < $32))
                                    local32 = "First Aid Kit"
                                    local33 = "firstaid"
                                Case ((local34 >= $32) And (local34 < $3C))
                                    local32 = "9V Battery"
                                    local33 = "bat"
                                Case ((local34 >= $3C) And (local34 < $46))
                                    local32 = "S-NAV 300 Navigator"
                                    local33 = "nav"
                                Case ((local34 >= $46) And (local34 < $55))
                                    local32 = "Radio Transceiver"
                                    local33 = "radio"
                                Case ((local34 >= $55) And (local34 < $5F))
                                    local32 = "Clipboard"
                                    local33 = "clipboard"
                                Case ((local34 >= $5F) And (local34 <= $64))
                                    local37 = rand($01, $03)
                                    Select local37
                                        Case $01
                                            local32 = "Playing Card"
                                        Case $02
                                            local32 = "Mastercard"
                                        Case $03
                                            local32 = "Origami"
                                    End Select
                                    local33 = "misc"
                            End Select
                            local21 = (((864.0 * (Float local8)) + -672.0) * (1.0 / 256.0))
                            local39 = (((96.0 * (Float local9)) + 96.0) * (1.0 / 256.0))
                            local22 = (((480.0 - (352.0 * (Float local10))) + rnd(-96.0, 96.0)) * (1.0 / 256.0))
                            local6 = createitem(local32, local33, (arg0\Field3 + local21), local39, (arg0\Field5 + local22), $00, $00, $00, 1.0, $00, $01)
                            If (local6 <> Null) Then
                                entityparent(local6\Field1, arg0\Field2, $01)
                            EndIf
                        Next
                    Next
                Next
            Else
                For local8 = $00 To $01 Step $01
                    For local9 = $00 To $02 Step $01
                        For local10 = $00 To $02 Step $01
                            local32 = "9V Battery"
                            local33 = "bat"
                            local34 = rand($FFFFFFF6, $64)
                            Select $01
                                Case (local34 < $00)
                                    Exit
                                Case (local34 < $28)
                                    local37 = rand($01, $06)
                                    Select local37
                                        Case $01
                                            local32 = "MP5-SD"
                                            local33 = "mp5sd"
                                        Case $02
                                            local32 = "Small First Aid Kit"
                                            local33 = "finefirstaid"
                                        Case $03
                                            local32 = "Box of ammo"
                                            local33 = "boxofammo"
                                        Case $04
                                            local32 = "FN P90"
                                            local33 = "p90"
                                        Case $05
                                            local32 = "USP Tactical"
                                            local33 = "usp"
                                        Case $06
                                            local32 = "Gas Mask"
                                            local33 = "gasmask"
                                    End Select
                                Case ((local34 >= $28) And (local34 < $2D))
                                    local37 = rand($01, $03)
                                    local32 = (("Level " + (Str local37)) + " Key Card")
                                    local33 = ("key" + (Str local37))
                                Case ((local34 >= $2D) And (local34 < $32))
                                    local32 = "First Aid Kit"
                                    local33 = "firstaid"
                                Case ((local34 >= $32) And (local34 < $3C))
                                    local37 = rand($01, $06)
                                    Select local37
                                        Case $01
                                            local32 = "MP5-SD"
                                            local33 = "mp5sd"
                                        Case $02
                                            local32 = "Rocket Launcher"
                                            local33 = "rpg"
                                        Case $03
                                            local32 = "Small First Aid Kit"
                                            local33 = "finefirstaid"
                                        Case $04
                                            local32 = "FN P90"
                                            local33 = "p90"
                                        Case $05
                                            local32 = "USP Tactical"
                                            local33 = "usp"
                                    End Select
                                Case ((local34 >= $3C) And (local34 < $46))
                                    local37 = rand($01, $06)
                                    Select local37
                                        Case $01
                                            local32 = "MP5-SD"
                                            local33 = "mp5sd"
                                        Case $02
                                            local32 = "Small First Aid Kit"
                                            local33 = "finefirstaid"
                                        Case $03
                                            local32 = "Minigun"
                                            local33 = "minigun"
                                        Case $04
                                            local32 = "FN P90"
                                            local33 = "p90"
                                        Case $05
                                            local32 = "USP Tactical"
                                            local33 = "usp"
                                    End Select
                                Case ((local34 >= $46) And (local34 < $55))
                                    local37 = rand($01, $06)
                                    Select local37
                                        Case $01
                                            local32 = "MP5-SD"
                                            local33 = "mp5sd"
                                        Case $02
                                            local32 = "Rocket Launcher"
                                            local33 = "rpg"
                                        Case $03
                                            local32 = "Small First Aid Kit"
                                            local33 = "finefirstaid"
                                        Case $04
                                            local32 = "FN P90"
                                            local33 = "p90"
                                        Case $05
                                            local32 = "USP Tactical"
                                            local33 = "usp"
                                    End Select
                                Case ((local34 >= $55) And (local34 < $5F))
                                    local37 = rand($01, $06)
                                    Select local37
                                        Case $01
                                            local32 = "Small First Aid Kit"
                                            local33 = "finefirstaid"
                                        Case $02
                                            local32 = "Rocket Launcher"
                                            local33 = "rpg"
                                        Case $03
                                            local32 = "Box of ammo"
                                            local33 = "boxofammo"
                                        Case $04
                                            local32 = "FN P90"
                                            local33 = "p90"
                                        Case $05
                                            local32 = "USP Tactical"
                                            local33 = "usp"
                                    End Select
                                Case ((local34 >= $5F) And (local34 <= $64))
                                    local37 = rand($01, $06)
                                    Select local37
                                        Case $01
                                            local32 = "MP5-SD"
                                            local33 = "mp5sd"
                                        Case $02
                                            local32 = "Small First Aid Kit"
                                            local33 = "finefirstaid"
                                        Case $03
                                            local32 = "Minigun"
                                            local33 = "minigun"
                                        Case $04
                                            local32 = "FN P90"
                                            local33 = "p90"
                                        Case $05
                                            local32 = "USP Tactical"
                                            local33 = "usp"
                                    End Select
                            End Select
                            local21 = (((864.0 * (Float local8)) + -672.0) * (1.0 / 256.0))
                            local39 = (((96.0 * (Float local9)) + 96.0) * (1.0 / 256.0))
                            local22 = (((480.0 - (352.0 * (Float local10))) + rnd(-96.0, 96.0)) * (1.0 / 256.0))
                            local6 = createitem(local32, local33, (arg0\Field3 + local21), local39, (arg0\Field5 + local22), $00, $00, $00, 1.0, $00, $01)
                            entityparent(local6\Field1, arg0\Field2, $01)
                        Next
                    Next
                Next
            EndIf
            arg0\Field29[$00] = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, (arg0\Field5 - 2.0625), 0.0, arg0, $00, $00, $06, "", $00)
            local2 = createsecuritycam((arg0\Field3 - 1.0), (arg0\Field4 + 1.5), (arg0\Field5 + 2.5), arg0, $00)
            local2\Field11 = 180.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room2test1074"
            arg0\Field29[$00] = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, arg0\Field5, 0.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$00]\Field4 = $01
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 + 1.3125), arg0\Field4, (arg0\Field5 + 2.621094), 90.0, arg0, $01, $00, $03, "", $00)
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 + 1.3125), arg0\Field4, (arg0\Field5 - 3.125), 90.0, arg0, $01, $00, $03, "", $00)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$03] = createdoor(arg0\Field0, (arg0\Field3 + 2.625), arg0\Field4, arg0\Field5, 0.0, arg0, $00, $00, $00, "", $00)
            arg0\Field35[$00] = loadtexture("GFX\map\1074tex0.jpg", $01)
            arg0\Field35[$01] = loadtexture("GFX\map\1074tex1.jpg", $01)
            textureblend(arg0\Field35[$00], $05)
            textureblend(arg0\Field35[$01], $05)
            local6 = createitem("Document SCP-1074", "paper", (arg0\Field3 + 1.171875), (arg0\Field4 + (1.0 / 12.8)), (arg0\Field5 + 2.621094), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (arg0\Field3 + 3.261719), (arg0\Field4 + (1.0 / 1.551515)), (arg0\Field5 + 2.109375), $01)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            arg0\Field25[$01] = createpivot($00)
            positionentity(arg0\Field25[$01], (arg0\Field3 + 3.261719), (arg0\Field4 + (1.0 / 25.6)), (arg0\Field5 + 1.171875), $01)
            entityparent(arg0\Field25[$01], arg0\Field2, $01)
            local47 = getchild(arg0\Field2, $02)
            arg0\Field34[$00] = getsurface(local47, $01)
            For local48 = $01 To countsurfaces(local47) Step $01
                local49 = getsurface(local47, local48)
                local50 = getsurfacebrush(local49)
                local51 = getbrushtexture(local50, $01)
                local52 = strippath(texturename(local51))
                If (lower(local52) = "1074tex1.jpg") Then
                    arg0\Field34[$00] = local49
                    freetexture(local51)
                    freebrush(local50)
                    Exit
                EndIf
                If (local52 <> "") Then
                    freetexture(local51)
                EndIf
                freebrush(local50)
            Next
        Case "room1123"
            If (server\Field21 = $00) Then
                local6 = createitem("Document SCP-1123", "paper", (arg0\Field3 + 1.996094), (arg0\Field4 + (1.0 / 2.048)), (arg0\Field5 - 3.65625), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (arg0\Field3 + 1.996094), (arg0\Field4 + (1.0 / 2.048)), (arg0\Field5 - 3.65625), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("SCP-1123", "1123", (arg0\Field3 + 3.25), (arg0\Field4 + (1.0 / 1.542169)), (arg0\Field5 + 3.0625), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            If (server\Field21 = $00) Then
                local6 = createitem("Leaflet", "paper", (arg0\Field3 - 3.1875), (arg0\Field4 + 2.75), (arg0\Field5 + 3.46875), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("FN P90", "p90", (arg0\Field3 - 3.1875), (arg0\Field4 + 2.75), (arg0\Field5 + 3.46875), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("Gas Mask", "gasmask", (arg0\Field3 + 1.785156), (arg0\Field4 + (1.0 / 1.706667)), (arg0\Field5 + 3.75), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 + 3.25), 0.0, (arg0\Field5 + 1.433594), 0.0, arg0, $00, $00, $03, "", $00)
            positionentity(local0\Field3[$00], (arg0\Field3 + 3.734375), entityy(local0\Field3[$00], $01), (arg0\Field5 + 1.375), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 + 2.785156), entityy(local0\Field3[$01], $01), (arg0\Field5 + 1.5), $01)
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + 1.09375), 0.0, (arg0\Field5 - 2.371094), 90.0, arg0, $00, $00, $00, "", $00)
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 + 1.09375), 2.0, (arg0\Field5 - 2.371094), 90.0, arg0, $00, $00, $00, "", $00)
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            arg0\Field29[$00] = local0
            arg0\Field25[$03] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$03], (arg0\Field3 + 3.25), (arg0\Field4 + (1.0 / 1.542169)), (arg0\Field5 + 3.0625), $01)
            arg0\Field25[$04] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$04], (arg0\Field3 - 2.53125), (arg0\Field4 + 2.3125), (arg0\Field5 + 2.703125), $01)
            arg0\Field25[$05] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$05], (arg0\Field3 + 3.234375), (arg0\Field4 + 2.3125), (arg0\Field5 + 2.3125), $01)
            arg0\Field25[$06] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$06], (arg0\Field3 - 0.296875), (arg0\Field4 + 2.421875), (arg0\Field5 + 2.90625), $01)
            arg0\Field25[$07] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$07], (arg0\Field3 - 2.5), (arg0\Field4 + 2.421875), (arg0\Field5 - 3.375), $01)
            arg0\Field25[$08] = loadmesh_strict("GFX\map\forest\door_frame.b3d", $00, $00)
            positionentity(arg0\Field25[$08], (arg0\Field3 - 1.0625), 2.0, (arg0\Field5 + 1.125), $01)
            rotateentity(arg0\Field25[$08], 0.0, 90.0, 0.0, $01)
            scaleentity(arg0\Field25[$08], (1.0 / 5.688889), (1.0 / 5.688889), (1.0 / 3.2), $01)
            entityparent(arg0\Field25[$08], arg0\Field2, $01)
            arg0\Field25[$09] = loadmesh_strict("GFX\map\forest\door.b3d", $00, $00)
            positionentity(arg0\Field25[$09], (arg0\Field3 - 1.0625), 2.0, (arg0\Field5 + (1.0 / 1.174312)), $01)
            rotateentity(arg0\Field25[$09], 0.0, 10.0, 0.0, $01)
            entitytype(arg0\Field25[$09], $01, $00)
            scaleentity(arg0\Field25[$09], (1.0 / 5.565217), (1.0 / 5.688889), (1.0 / 5.565217), $01)
            entityparent(arg0\Field25[$09], arg0\Field2, $01)
            arg0\Field25[$0A] = copyentity(arg0\Field25[$08], $00)
            positionentity(arg0\Field25[$0A], (arg0\Field3 - 1.0625), 2.0, (arg0\Field5 + 2.875), $01)
            rotateentity(arg0\Field25[$0A], 0.0, 90.0, 0.0, $01)
            scaleentity(arg0\Field25[$0A], (1.0 / 5.688889), (1.0 / 5.688889), (1.0 / 3.2), $01)
            entityparent(arg0\Field25[$0A], arg0\Field2, $01)
            arg0\Field25[$0B] = copyentity(arg0\Field25[$09], $00)
            positionentity(arg0\Field25[$0B], (arg0\Field3 - 1.0625), 2.0, (arg0\Field5 + 2.601562), $01)
            rotateentity(arg0\Field25[$0B], 0.0, 90.0, 0.0, $01)
            entitytype(arg0\Field25[$0B], $01, $00)
            scaleentity(arg0\Field25[$0B], (1.0 / 5.565217), (1.0 / 5.688889), (1.0 / 5.565217), $01)
            entityparent(arg0\Field25[$0B], arg0\Field2, $01)
            arg0\Field25[$0C] = copyentity(arg0\Field25[$08], $00)
            positionentity(arg0\Field25[$0C], (arg0\Field3 - 2.3125), 2.0, (arg0\Field5 - 2.75), $01)
            rotateentity(arg0\Field25[$0C], 0.0, 0.0, 0.0, $01)
            scaleentity(arg0\Field25[$0C], (1.0 / 5.688889), (1.0 / 5.688889), (1.0 / 3.2), $01)
            entityparent(arg0\Field25[$0C], arg0\Field2, $01)
            arg0\Field25[$0D] = copyentity(arg0\Field25[$09], $00)
            positionentity(arg0\Field25[$0D], (arg0\Field3 - 2.585938), 2.0, (arg0\Field5 - 2.75), $01)
            rotateentity(arg0\Field25[$0D], 0.0, 0.0, 0.0, $01)
            entitytype(arg0\Field25[$0D], $01, $00)
            scaleentity(arg0\Field25[$0D], (1.0 / 5.565217), (1.0 / 5.688889), (1.0 / 5.565217), $01)
            entityparent(arg0\Field25[$0D], arg0\Field2, $01)
            arg0\Field25[$0E] = loadmesh_strict("GFX\map\1123_hb.b3d", arg0\Field2, $00)
            entitypickmode(arg0\Field25[$0E], $02, $01)
            entitytype(arg0\Field25[$0E], $01, $00)
            entityalpha(arg0\Field25[$0E], 0.0)
        Case "pocketdimension"
            local53 = loadmesh_strict("GFX\map\pocketdimension2.b3d", $00, $00)
            arg0\Field25[$08] = loadmesh_strict("GFX\map\pocketdimension3.b3d", $00, $00)
            arg0\Field25[$09] = loadmesh_strict("GFX\map\pocketdimension4.b3d", $00, $00)
            arg0\Field25[$0A] = copyentity(arg0\Field25[$09], $00)
            arg0\Field25[$0B] = loadmesh_strict("GFX\map\pocketdimension5.b3d", $00, $00)
            local54 = loadmesh_strict("GFX\map\pocketdimensionterrain.b3d", $00, $00)
            scaleentity(local54, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $01)
            positionentity(local54, 0.0, 2944.0, 0.0, $01)
            createitem("Burnt Note", "paper", entityx(arg0\Field2, $00), 0.5, (entityz(arg0\Field2, $00) + 3.5), $00, $00, $00, 1.0, $00, $01)
            For local18 = $00 To $FFFFFFFF Step $01
                Select local18
                    Case $00
                        local56 = local53
                    Case $01
                        local56 = arg0\Field25[$08]
                    Case $02
                        local56 = arg0\Field25[$09]
                    Case $03
                        local56 = arg0\Field25[$0A]
                    Case $04
                        local56 = arg0\Field25[$0B]
                End Select
            Next
            For local7 = $08 To $0B Step $01
                scaleentity(arg0\Field25[local7], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                entitytype(arg0\Field25[local7], $01, $00)
                entitypickmode(arg0\Field25[local7], $02, $01)
                positionentity(arg0\Field25[local7], arg0\Field3, arg0\Field4, (arg0\Field5 + 32.0), $01)
            Next
            scaleentity(local54, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            entitytype(local54, $01, $00)
            entitypickmode(local54, $03, $01)
            positionentity(local54, arg0\Field3, (arg0\Field4 + 11.5), (arg0\Field5 + 32.0), $01)
            arg0\Field29[$00] = createdoor($00, arg0\Field3, 8.0, ((arg0\Field5 + 32.0) - 4.0), 0.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$01] = createdoor($00, arg0\Field3, 8.0, ((arg0\Field5 + 32.0) + 4.0), 180.0, arg0, $00, $00, $00, "", $00)
            local3 = createdecal($12, (arg0\Field3 - 6.0), 0.02, ((arg0\Field5 + 2.375) + 32.0), 90.0, 0.0, 0.0)
            entityparent(local3\Field0, arg0\Field2, $01)
            local3\Field2 = rnd(0.8, 0.8)
            local3\Field6 = $02
            local3\Field7 = $09
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityfx(local3\Field0, $09)
            entityblend(local3\Field0, $02)
            scaleentity(arg0\Field25[$0A], (1.0 / 170.6667), (1.0 / 128.0), (1.0 / 170.6667), $01)
            positionentity(arg0\Field25[$0B], arg0\Field3, arg0\Field4, (arg0\Field5 + 64.0), $01)
            For local7 = $01 To $08 Step $01
                arg0\Field25[(local7 - $01)] = copyentity(local53, $00)
                scaleentity(arg0\Field25[(local7 - $01)], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                local57 = ((Float (local7 - $01)) * 45.0)
                entitytype(arg0\Field25[(local7 - $01)], $01, $00)
                entitypickmode(arg0\Field25[(local7 - $01)], $02, $01)
                rotateentity(arg0\Field25[(local7 - $01)], 0.0, (local57 - 90.0), 0.0, $00)
                positionentity(arg0\Field25[(local7 - $01)], (arg0\Field3 + (cos(local57) * 2.0)), 0.0, (arg0\Field5 + (sin(local57) * 2.0)), $00)
                entityparent(arg0\Field25[(local7 - $01)], arg0\Field2, $01)
                If (local7 < $06) Then
                    local3 = createdecal((local7 + $07), (arg0\Field3 + ((cos(local57) * 2.0) * 3.0)), 0.02, (arg0\Field5 + ((sin(local57) * 2.0) * 3.0)), 90.0, (local57 - 90.0), 0.0)
                    local3\Field2 = rnd(0.5, 0.5)
                    local3\Field6 = $02
                    local3\Field7 = $09
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                    entityfx(local3\Field0, $09)
                    entityblend(local3\Field0, $02)
                EndIf
            Next
            For local7 = $0C To $10 Step $01
                arg0\Field25[local7] = createpivot(arg0\Field25[$0B])
                Select local7
                    Case $0C
                        positionentity(arg0\Field25[local7], arg0\Field3, (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 + 64.0), $01)
                    Case $0D
                        positionentity(arg0\Field25[local7], (arg0\Field3 + 1.523438), (arg0\Field4 + (1.0 / 1.28)), ((arg0\Field5 + 64.0) + 1.0625), $01)
                    Case $0E
                        positionentity(arg0\Field25[local7], (arg0\Field3 + 3.273438), (arg0\Field4 + (1.0 / 1.28)), ((arg0\Field5 + 64.0) - 2.152344), $01)
                    Case $0F
                        positionentity(arg0\Field25[local7], (arg0\Field3 - (1.0 / 1.841727)), (arg0\Field4 + (1.0 / 1.28)), ((arg0\Field5 + 64.0) + 4.691406), $01)
                    Case $10
                        positionentity(arg0\Field25[local7], (arg0\Field3 - 4.835938), (arg0\Field4 - 6.5), ((arg0\Field5 + 64.0) + 1.488281), $01)
                End Select
            Next
            local59 = loadtexture_strict("GFX\npcs\oldmaneyes.jpg", $01, $00)
            arg0\Field25[$11] = createsprite($00)
            scalesprite(arg0\Field25[$11], 0.03, 0.03)
            entitytexture(arg0\Field25[$11], local59, $00, $00)
            entityblend(arg0\Field25[$11], $03)
            entityfx(arg0\Field25[$11], $09)
            spriteviewmode(arg0\Field25[$11], $02)
            arg0\Field27[$12] = loadtexture_strict("GFX\npcs\pdplane.png", $03, $00)
            arg0\Field27[$13] = loadtexture_strict("GFX\npcs\pdplaneeye.png", $03, $00)
            arg0\Field25[$14] = createsprite($00)
            scalesprite(arg0\Field25[$14], 8.0, 8.0)
            entitytexture(arg0\Field25[$14], arg0\Field27[$12], $00, $00)
            entityorder(arg0\Field25[$14], $64)
            entityblend(arg0\Field25[$14], $02)
            entityfx(arg0\Field25[$14], $09)
            spriteviewmode(arg0\Field25[$14], $02)
            freetexture(local51)
            freeentity(local53)
            freetexture(local59)
        Case "room3z3"
            local2 = createsecuritycam((arg0\Field3 - 1.25), (arg0\Field4 + 1.5), (arg0\Field5 + 2.000977), arg0, $00)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room2_3","room3_3"
            local26 = createwaypoint(arg0\Field3, (arg0\Field4 + (1.0 / 3.878788)), arg0\Field5, Null, arg0)
        Case "room1lifts"
            arg0\Field25[$00] = createbutton((arg0\Field3 + 0.375), (arg0\Field4 + 0.625), (arg0\Field5 + 0.25), 0.0, 0.0, 0.0)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            arg0\Field25[$01] = createbutton((arg0\Field3 - 0.375), (arg0\Field4 + 0.625), (arg0\Field5 + 0.25), 0.0, 0.0, 0.0)
            entityparent(arg0\Field25[$01], arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 + 1.5), (arg0\Field4 + 1.5), (arg0\Field5 - 3.75), arg0, $00)
            local2\Field11 = 45.0
            local2\Field12 = 45.0
            local2\Field19 = arg0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            local26 = createwaypoint(arg0\Field3, (arg0\Field4 + (1.0 / 3.878788)), arg0\Field5, Null, arg0)
        Case "room2servers2"
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 + 1.03125), 0.0, (arg0\Field5 + 2.625), 270.0, arg0, $00, $00, $03, "", $00)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + 0.875), entityy(arg0\Field29[$00]\Field3[$00], $01), (arg0\Field5 + 1.992188), $01)
            positionentity(arg0\Field29[$00]\Field3[$01], (arg0\Field3 + 1.1875), entityy(arg0\Field29[$00]\Field3[$01], $01), (arg0\Field5 + 3.28125), $01)
            turnentity(arg0\Field29[$00]\Field3[$01], 0.0, 0.0, 0.0, $01)
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 - 2.0), -3.0, (arg0\Field5 - 1.3125), 0.0, arg0, $00, $00, $03, "", $00)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - 1.988281), -3.0, (arg0\Field5 - 4.050781), 0.0, arg0, $00, $00, $03, "", $00)
            local0\Field4 = $01
            local0\Field14 = $01
            local6 = createitem("Night Vision Goggles", "nvgoggles", (arg0\Field3 + (1.0 / 4.570172)), (arg0\Field4 - 2.53125), (arg0\Field5 + 2.928273), $00, $00, $00, 1.0, $00, $01)
            local6\Field13 = 200.0
            rotateentity(local6\Field1, 0.0, (Float (arg0\Field6 + rand($F5, $01))), 0.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room2gw","room2gw_b"
            If (arg0\Field7\Field10 = "room2gw_b") Then
                arg0\Field25[$02] = createpivot(arg0\Field2)
                positionentity(arg0\Field25[$02], (arg0\Field3 - (1.0 / 1.632393)), -0.145882, (arg0\Field5 + (1.0 / 2.109357)), $01)
                local3 = createdecal($03, (arg0\Field3 - (1.0 / 1.632393)), -0.145882, (arg0\Field5 + (1.0 / 2.109357)), 90.0, rnd(360.0, 0.0), 0.0)
                local3\Field2 = 0.5
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                entityparent(local3\Field0, arg0\Field2, $01)
                arg0\Field25[$00] = createpivot($00)
                positionentity(arg0\Field25[$00], (arg0\Field3 + 1.09375), (arg0\Field4 + 1.347656), (arg0\Field5 - 1.328125), $01)
                entityparent(arg0\Field25[$00], arg0\Field2, $01)
            EndIf
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 + 1.3125), 0.0, (arg0\Field5 - 1.492188), 0.0, arg0, $00, $00, $00, "", $00)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + 2.268836), entityy(arg0\Field29[$00]\Field3[$00], $01), (arg0\Field5 - 2.36984), $01)
            positionentity(arg0\Field29[$00]\Field3[$01], (arg0\Field3 + 2.268836), entityy(arg0\Field29[$00]\Field3[$01], $01), (arg0\Field5 - 2.36984), $01)
            arg0\Field29[$00]\Field9 = $00
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $01
            arg0\Field29[$00]\Field4 = $01
            arg0\Field29[$00]\Field24 = $00
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 + 1.3125), 0.0, (arg0\Field5 + 1.804688), 180.0, arg0, $00, $00, $00, "", $00)
            positionentity(arg0\Field29[$01]\Field3[$00], (arg0\Field3 + 2.268836), entityy(arg0\Field29[$01]\Field3[$00], $01), (arg0\Field5 - 2.36984), $01)
            positionentity(arg0\Field29[$01]\Field3[$01], (arg0\Field3 + 2.268836), entityy(arg0\Field29[$01]\Field3[$01], $01), (arg0\Field5 - 2.36984), $01)
            arg0\Field29[$01]\Field9 = $00
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field5 = $01
            arg0\Field29[$01]\Field4 = $01
            arg0\Field29[$01]\Field24 = $00
            For local4 = Each rooms
                If (local4 <> arg0) Then
                    If (((local4\Field7\Field10 = "room2gw") Or (local4\Field7\Field10 = "room2gw_b")) <> 0) Then
                        arg0\Field25[$03] = copyentity(local4\Field25[$03], arg0\Field2)
                        Exit
                    EndIf
                EndIf
            Next
            If (arg0\Field25[$03] = $00) Then
                arg0\Field25[$03] = createpivot(arg0\Field2)
            EndIf
            entitypickmode(arg0\Field25[$03], $02, $01)
            If (arg0\Field7\Field10 = "room2gw") Then
                arg0\Field25[$00] = createpivot($00)
                positionentity(arg0\Field25[$00], (arg0\Field3 + 1.34375), 0.5, arg0\Field5, $00)
                entityparent(arg0\Field25[$00], arg0\Field2, $01)
                local60 = $00
                If (room2gw_brokendoor <> 0) Then
                    If (room2gw_x = arg0\Field3) Then
                        If (room2gw_z = arg0\Field5) Then
                            local60 = $01
                        EndIf
                    EndIf
                EndIf
                If ((((room2gw_brokendoor = $00) And (rand($01, $02) = $01)) Or local60) <> 0) Then
                    arg0\Field25[$01] = copyentity(doorobj, $00)
                    scaleentity(arg0\Field25[$01], (0.796875 / meshwidth(arg0\Field25[$01])), (1.21875 / meshheight(arg0\Field25[$01])), ((1.0 / 16.0) / meshdepth(arg0\Field25[$01])), $00)
                    entitytype(arg0\Field25[$01], $01, $00)
                    positionentity(arg0\Field25[$01], (arg0\Field3 + 1.3125), 0.0, (arg0\Field5 + 1.804688), $00)
                    rotateentity(arg0\Field25[$01], 0.0, 360.0, 0.0, $00)
                    entityparent(arg0\Field25[$01], arg0\Field2, $01)
                    moveentity(arg0\Field25[$01], 120.0, 0.0, 5.0)
                    room2gw_brokendoor = $01
                    room2gw_x = arg0\Field3
                    room2gw_z = arg0\Field5
                    freeentity(arg0\Field29[$01]\Field1)
                    arg0\Field29[$01]\Field1 = $00
                EndIf
            EndIf
        Case "room3gw"
            local0 = createdoor(arg0\Field0, (arg0\Field3 - 2.84375), 0.0, (arg0\Field5 - 1.789062), 0.0, arg0, $00, $00, $03, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            local0\Field4 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (1.0 / 1.147982)), 0.0, (arg0\Field5 - 2.875), -90.0, arg0, $00, $00, $03, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            local0\Field4 = $00
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 - 1.792969), 0.0, (arg0\Field5 + 1.324219), 90.0, arg0, $00, $00, $00, "", $00)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + 2.268836), entityy(arg0\Field29[$00]\Field3[$00], $01), (arg0\Field5 - 2.36984), $01)
            positionentity(arg0\Field29[$00]\Field3[$01], (arg0\Field3 + 2.268836), entityy(arg0\Field29[$00]\Field3[$01], $01), (arg0\Field5 - 2.36984), $01)
            arg0\Field29[$00]\Field9 = $00
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $01
            arg0\Field29[$00]\Field4 = $01
            arg0\Field29[$00]\Field24 = $00
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 + 1.503906), 0.0, (arg0\Field5 + 1.324219), 270.0, arg0, $00, $00, $00, "", $00)
            positionentity(arg0\Field29[$01]\Field3[$00], (arg0\Field3 + 2.268836), entityy(arg0\Field29[$01]\Field3[$00], $01), (arg0\Field5 - 2.36984), $01)
            positionentity(arg0\Field29[$01]\Field3[$01], (arg0\Field3 + 2.268836), entityy(arg0\Field29[$01]\Field3[$01], $01), (arg0\Field5 - 2.36984), $01)
            arg0\Field29[$01]\Field9 = $00
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field5 = $01
            arg0\Field29[$01]\Field4 = $01
            arg0\Field29[$01]\Field24 = $00
            freeentity(arg0\Field29[$01]\Field1)
            arg0\Field29[$01]\Field1 = $00
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (arg0\Field3 - 0.1875), 0.5, (arg0\Field5 + 1.25), $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            local61 = createbutton((arg0\Field3 + (1.0 / 2.56)), (arg0\Field4 + (1.0 / 1.446328)), (arg0\Field5 - 1.863281), 359.0, -1.0, 379.0)
            entityparent(local61, arg0\Field2, $01)
            local61 = createbutton((arg0\Field3 + (1.0 / 3.084337)), (arg0\Field4 + 0.6875), (arg0\Field5 - 1.703125), 360.0, 180.0, 360.0)
            entityparent(local61, arg0\Field2, $01)
            For local4 = Each rooms
                If (local4 <> arg0) Then
                    If (local4\Field7\Field10 = "room3gw") Then
                        arg0\Field25[$03] = copyentity(local4\Field25[$03], arg0\Field2)
                        Exit
                    EndIf
                EndIf
            Next
            If (arg0\Field25[$03] = $00) Then
                arg0\Field25[$03] = createpivot(arg0\Field2)
            EndIf
            entitypickmode(arg0\Field25[$03], $02, $01)
        Case "room1162"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + 0.96875), 0.0, (arg0\Field5 - 2.875), 90.0, arg0, $00, $00, ($02 - server\Field21), "", $00)
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (arg0\Field3 + 3.953125), (arg0\Field4 + 0.5), (arg0\Field5 - 2.5), $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            entitypickmode(arg0\Field25[$00], $01, $01)
            If (server\Field21 = $00) Then
                local6 = createitem("Document SCP-1162", "paper", (arg0\Field3 + 3.37198), (arg0\Field4 + 0.59375), (arg0\Field5 - 3.723559), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (arg0\Field3 + 3.37198), (arg0\Field4 + 0.59375), (arg0\Field5 - 3.723559), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
                local6 = createitem("Level 2 Key Card", "key2", (arg0\Field3 + 3.383699), (arg0\Field4 + 0.59375), (arg0\Field5 - 3.723559), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local2 = createsecuritycam((arg0\Field3 - 0.75), (arg0\Field4 + 2.75), (arg0\Field5 + 0.75), arg0, $00)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room2scps2"
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 + 1.125), arg0\Field4, (arg0\Field5 + 2.25), 90.0, arg0, $00, $00, $03, "", $00)
            arg0\Field29[$00]\Field5 = $00
            arg0\Field29[$00]\Field4 = $01
            local0 = createdoor(arg0\Field0, (arg0\Field3 + 3.035156), arg0\Field4, (arg0\Field5 + 2.621094), 90.0, arg0, $00, $00, $04, "", $00)
            local0 = createdoor(arg0\Field0, (arg0\Field3 + 2.171875), arg0\Field4, (arg0\Field5 + 1.15625), 0.0, arg0, $00, $00, $03, "", $00)
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (arg0\Field3 + 2.25), (arg0\Field4 + 0.625), (arg0\Field5 + 2.46875), $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            If (server\Field21 = $00) Then
                local6 = createitem("SCP-1499", "scp1499", (arg0\Field3 + 2.34375), (arg0\Field4 + 0.6875), (arg0\Field5 - 0.890625), $00, $00, $00, 1.0, $00, $01)
                rotateentity(local6\Field1, 0.0, (Float arg0\Field6), 0.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("Document SCP-1499", "paper", (arg0\Field3 + 3.28125), (arg0\Field4 + 1.015625), (arg0\Field5 + 0.875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            If (server\Field21 = $00) Then
                local6 = createitem("Document SCP-500", "paper", (arg0\Field3 + 4.5), (arg0\Field4 + 0.875), (arg0\Field5 + 1.3125), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("FN P90", "p90", (arg0\Field3 + 4.5), (arg0\Field4 + 0.875), (arg0\Field5 + 1.3125), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("Emily Ross' Badge", "badge", (arg0\Field3 + 1.421875), (arg0\Field4 + (1.0 / 51.2)), (arg0\Field5 + 2.796875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 + 3.320312), (arg0\Field4 + 1.367188), (arg0\Field5 + 3.421875), arg0, $00)
            local2\Field11 = 220.0
            local2\Field12 = 30.0
            turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 + 2.34375), (arg0\Field4 + 2.007812), (arg0\Field5 + (1.0 / 1.706667)), arg0, $00)
            local2\Field11 = 180.0
            local2\Field12 = 30.0
            turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
        Case "room3offices"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + 2.875), 0.0, (arg0\Field5 + 0.9375), 0.0, arg0, $00, $00, $03, "", $00)
            positionentity(local0\Field3[$00], (arg0\Field3 + 3.484375), entityy(local0\Field3[$00], $01), (arg0\Field5 + 0.875), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 + 3.484375), entityy(local0\Field3[$01], $01), (arg0\Field5 + (1.0 / 1.003922)), $01)
            freeentity(local0\Field1)
            local0\Field1 = $00
            arg0\Field25[$00] = loadmesh_strict("GFX\map\room3offices_hb.b3d", arg0\Field2, $00)
            entitypickmode(arg0\Field25[$00], $02, $01)
            entitytype(arg0\Field25[$00], $01, $00)
            entityalpha(arg0\Field25[$00], 0.0)
        Case "room2offices4"
            local0 = createdoor($00, (arg0\Field3 - 0.9375), 0.0, arg0\Field5, 90.0, arg0, $00, $00, $00, "", $00)
            positionentity(local0\Field3[$00], (arg0\Field3 - (1.0 / 1.113043)), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 - (1.0 / 1.024)), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0\Field5 = $00
            local0\Field21 = $00
            local6 = createitem("Sticky Note", "paper", (arg0\Field3 - 3.871094), (arg0\Field4 - (1.0 / 1.057851)), (arg0\Field5 + 3.53125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room2sl"
            local62 = (1.0 / 142.2222)
            arg0\Field35[$00] = loadanimtexture("GFX\SL_monitors_checkpoint.jpg", $01, $200, $200, $00, $04)
            arg0\Field35[$01] = loadanimtexture("GFX\Sl_monitors.jpg", $01, $100, $100, $00, $08)
            For local7 = $00 To $0E Step $01
                If (local7 <> $07) Then
                    arg0\Field25[local7] = copyentity(monitor, $00)
                    scaleentity(arg0\Field25[local7], local62, local62, local62, $00)
                    If (((local7 <> $04) And (local7 <> $0D)) <> 0) Then
                        local63 = createsprite($00)
                        entityfx(local63, $11)
                        spriteviewmode(local63, $02)
                        scalesprite(local63, (((meshwidth(monitor) * local62) * 0.95) * 0.5), (((meshheight(monitor) * local62) * 0.95) * 0.5))
                        Select local7
                            Case $00
                                entitytexture(local63, arg0\Field35[$01], $00, $00)
                            Case $02
                                entitytexture(local63, arg0\Field35[$01], $02, $00)
                            Case $03
                                entitytexture(local63, arg0\Field35[$01], $01, $00)
                            Case $08
                                entitytexture(local63, arg0\Field35[$01], $04, $00)
                            Case $09
                                entitytexture(local63, arg0\Field35[$01], $05, $00)
                            Case $0A
                                entitytexture(local63, arg0\Field35[$01], $03, $00)
                            Case $0B
                                entitytexture(local63, arg0\Field35[$01], $07, $00)
                            Default
                                entitytexture(local63, arg0\Field35[$00], $03, $00)
                        End Select
                        entityparent(local63, arg0\Field25[local7], $01)
                    ElseIf (local7 = $04) Then
                        arg0\Field25[$14] = createsprite($00)
                        entityfx(arg0\Field25[$14], $11)
                        spriteviewmode(arg0\Field25[$14], $02)
                        scalesprite(arg0\Field25[$14], (((meshwidth(monitor) * local62) * 0.95) * 0.5), (((meshheight(monitor) * local62) * 0.95) * 0.5))
                        entitytexture(arg0\Field25[$14], arg0\Field35[$00], $02, $00)
                        entityparent(arg0\Field25[$14], arg0\Field25[local7], $01)
                    Else
                        arg0\Field25[$15] = createsprite($00)
                        entityfx(arg0\Field25[$15], $11)
                        spriteviewmode(arg0\Field25[$15], $02)
                        scalesprite(arg0\Field25[$15], (((meshwidth(monitor) * local62) * 0.95) * 0.5), (((meshheight(monitor) * local62) * 0.95) * 0.5))
                        entitytexture(arg0\Field25[$15], arg0\Field35[$01], $06, $00)
                        entityparent(arg0\Field25[$15], arg0\Field25[local7], $01)
                    EndIf
                EndIf
            Next
            For local7 = $00 To $02 Step $01
                positionentity(arg0\Field25[local7], (arg0\Field3 - (1.0 / 1.231124)), (arg0\Field4 + ((648.0 + (Float ($70 * local7))) * (1.0 / 256.0))), (arg0\Field5 - 0.234643), $00)
                rotateentity(arg0\Field25[local7], 0.0, (Float (arg0\Field6 + $69)), 0.0, $00)
                entityparent(arg0\Field25[local7], arg0\Field2, $01)
            Next
            For local7 = $03 To $05 Step $01
                positionentity(arg0\Field25[local7], (arg0\Field3 - (1.0 / 1.105884)), (arg0\Field4 + ((648.0 + (Float ((local7 - $03) * $70))) * (1.0 / 256.0))), (arg0\Field5 + (1.0 / 2.673788)), $00)
                rotateentity(arg0\Field25[local7], 0.0, (Float (arg0\Field6 + $5A)), 0.0, $00)
                entityparent(arg0\Field25[local7], arg0\Field2, $01)
            Next
            For local7 = $06 To $08 Step $02
                positionentity(arg0\Field25[local7], (arg0\Field3 - (1.0 / 1.105884)), (arg0\Field4 + ((648.0 + (Float ((local7 - $06) * $70))) * (1.0 / 256.0))), (arg0\Field5 + 0.999), $00)
                rotateentity(arg0\Field25[local7], 0.0, (Float (arg0\Field6 + $5A)), 0.0, $00)
                entityparent(arg0\Field25[local7], arg0\Field2, $01)
            Next
            For local7 = $09 To $0B Step $01
                positionentity(arg0\Field25[local7], (arg0\Field3 - (1.0 / 1.105884)), (arg0\Field4 + ((648.0 + (Float ((local7 - $09) * $70))) * (1.0 / 256.0))), (arg0\Field5 + 1.624), $00)
                rotateentity(arg0\Field25[local7], 0.0, (Float (arg0\Field6 + $5A)), 0.0, $00)
                entityparent(arg0\Field25[local7], arg0\Field2, $01)
            Next
            For local7 = $0C To $0E Step $01
                positionentity(arg0\Field25[local7], (arg0\Field3 - (1.0 / 1.229953)), (arg0\Field4 + ((648.0 + (Float ((local7 - $0C) * $70))) * (1.0 / 256.0))), (arg0\Field5 + 2.232746), $00)
                rotateentity(arg0\Field25[local7], 0.0, (Float (arg0\Field6 + $4B)), 0.0, $00)
                entityparent(arg0\Field25[local7], arg0\Field2, $01)
            Next
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 + 1.875), arg0\Field4, (arg0\Field5 - 2.5), 90.0, arg0, $00, $00, $03, "", $00)
            arg0\Field29[$00]\Field21 = $00
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + 2.25), entityy(arg0\Field29[$00]\Field3[$00], $01), (arg0\Field5 - 1.875), $01)
            rotateentity(arg0\Field29[$00]\Field3[$00], 0.0, 270.0, 0.0, $00)
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 + 2.125), (arg0\Field4 + 1.875), (arg0\Field5 + 1.0), 270.0, arg0, $00, $00, $03, "", $00)
            arg0\Field29[$01]\Field21 = $00
            freeentity(arg0\Field29[$01]\Field1)
            arg0\Field29[$01]\Field1 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + 5.875), (arg0\Field4 + 1.875), (arg0\Field5 + 3.75), 0.0, arg0, $00, $00, $00, "", $00)
            local0\Field21 = $00
            local0\Field4 = $01
            arg0\Field25[$07] = createpivot($00)
            positionentity(arg0\Field25[$07], arg0\Field3, (arg0\Field4 + (1.0 / 2.56)), (arg0\Field5 - 3.125), $01)
            entityparent(arg0\Field25[$07], arg0\Field2, $01)
            arg0\Field25[$0F] = createpivot($00)
            positionentity(arg0\Field25[$0F], (arg0\Field3 + 2.734375), (arg0\Field4 + 2.734375), (arg0\Field5 + 1.0), $01)
            entityparent(arg0\Field25[$0F], arg0\Field2, $01)
            arg0\Field25[$10] = createpivot($00)
            positionentity(arg0\Field25[$10], (arg0\Field3 - 0.234375), (arg0\Field4 + 2.734375), (arg0\Field5 + (1.0 / 1.28)), $01)
            entityparent(arg0\Field25[$10], arg0\Field2, $01)
            arg0\Field25[$11] = createpivot($00)
            positionentity(arg0\Field25[$11], (arg0\Field3 - 0.1875), (arg0\Field4 + 2.109375), (arg0\Field5 + 2.5625), $01)
            entityparent(arg0\Field25[$11], arg0\Field2, $01)
            arg0\Field25[$12] = copyentity(leverbaseobj, $00)
            arg0\Field25[$13] = copyentity(leverobj, $00)
            arg0\Field28[$00] = arg0\Field25[$13]
            For local7 = $00 To $01 Step $01
                scaleentity(arg0\Field25[($12 + local7)], 0.04, 0.04, 0.04, $00)
                positionentity(arg0\Field25[($12 + local7)], (arg0\Field3 - (1.0 / 5.22449)), (arg0\Field4 + 2.691406), (arg0\Field5 + 3.5625), $01)
                entityparent(arg0\Field25[($12 + local7)], arg0\Field2, $01)
            Next
            rotateentity(arg0\Field25[$12], 0.0, 0.0, 0.0, $00)
            rotateentity(arg0\Field25[$13], 10.0, -180.0, 0.0, $00)
            entitypickmode(arg0\Field25[$13], $01, $00)
            entityradius(arg0\Field25[$13], 0.1, 0.0)
            local2 = createsecuritycam((arg0\Field3 - (1.0 / 1.610063)), (arg0\Field4 + 1.5), (arg0\Field5 - 3.628906), arg0, $01)
            local2\Field11 = 315.0
            local2\Field19 = arg0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, (arg0\Field3 - (1.0 / 1.105884)), (arg0\Field4 + 2.96875), (arg0\Field5 + 0.999), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field2, $01)
        Case "room2_4"
            arg0\Field25[$06] = createpivot($00)
            positionentity(arg0\Field25[$06], (arg0\Field3 + 2.5), (1.0 / 32.0), (arg0\Field5 - 3.5), $00)
            entityparent(arg0\Field25[$06], arg0\Field2, $01)
        Case "room3z2"
            For local4 = Each rooms
                If (((local4\Field7\Field10 = arg0\Field7\Field10) And (local4 <> arg0)) <> 0) Then
                    arg0\Field25[$00] = copyentity(local4\Field25[$00], arg0\Field2)
                    Exit
                EndIf
            Next
            If (arg0\Field25[$00] = $00) Then
                arg0\Field25[$00] = loadmesh_strict("GFX\map\room3z2_hb.b3d", arg0\Field2, $00)
            EndIf
            entitypickmode(arg0\Field25[$00], $02, $01)
            entitytype(arg0\Field25[$00], $01, $00)
            entityalpha(arg0\Field25[$00], 0.0)
        Case "lockroom3"
            local0 = createdoor(arg0\Field0, (arg0\Field3 - 2.875), 0.0, (arg0\Field5 - 0.40625), 0.0, arg0, $01, $00, $00, "", $00)
            local0\Field10 = (((server\Field21 * $05) + $05) * $46)
            local0\Field21 = $00
            local0\Field5 = $00
            local0\Field4 = $01
            entityparent(local0\Field3[$00], $00, $01)
            positionentity(local0\Field3[$00], (arg0\Field3 - 1.125), 0.7, (arg0\Field5 - 2.5), $00)
            entityparent(local0\Field3[$00], arg0\Field2, $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local1 = createdoor(arg0\Field0, (arg0\Field3 + 0.40625), 0.0, (arg0\Field5 + 2.875), 270.0, arg0, $01, $00, $00, "", $00)
            local1\Field10 = (((server\Field21 * $05) + $05) * $46)
            local1\Field21 = $00
            local1\Field5 = $00
            local1\Field4 = $01
            entityparent(local1\Field3[$00], $00, $01)
            positionentity(local1\Field3[$00], (arg0\Field3 + 2.5), 0.7, (arg0\Field5 + 1.125), $00)
            rotateentity(local1\Field3[$00], 0.0, 90.0, 0.0, $00)
            entityparent(local1\Field3[$00], arg0\Field2, $01)
            freeentity(local1\Field3[$01])
            local1\Field3[$01] = $00
            local0\Field22 = local1
            local1\Field22 = local0
            local62 = (1.0 / 142.2222)
            arg0\Field25[$00] = copyentity(monitor, $00)
            scaleentity(arg0\Field25[$00], local62, local62, local62, $00)
            positionentity(arg0\Field25[$00], (arg0\Field3 + 2.609375), 1.1, (arg0\Field5 - 0.375), $01)
            rotateentity(arg0\Field25[$00], 0.0, 90.0, 0.0, $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            arg0\Field25[$01] = copyentity(monitor, $00)
            scaleentity(arg0\Field25[$01], local62, local62, local62, $00)
            positionentity(arg0\Field25[$01], (arg0\Field3 + 0.375), 1.1, (arg0\Field5 - 2.609375), $01)
            entityparent(arg0\Field25[$01], arg0\Field2, $01)
        Case "medibay"
            arg0\Field25[$00] = loadmesh_strict("GFX\map\medibay_props.b3d", arg0\Field2, $00)
            entitytype(arg0\Field25[$00], $01, $00)
            entitypickmode(arg0\Field25[$00], $02, $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 - 2.976562), (arg0\Field4 + 0.0), (arg0\Field5 - 1.351562), $01)
            arg0\Field25[$02] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$02], (entityx(arg0\Field25[$01], $01) + (1.0 / 2.031746)), entityy(arg0\Field25[$01], $01), entityz(arg0\Field25[$01], $01), $01)
            local6 = createitem("First Aid Kit", "firstaid", (arg0\Field3 - 1.976562), (arg0\Field4 + 0.75), (arg0\Field5 - 1.257812), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Syringe", "syringe", (arg0\Field3 - 1.300781), (arg0\Field4 + (1.0 / 2.56)), (arg0\Field5 + (1.0 / 2.631038)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Syringe", "syringe", (arg0\Field3 - 1.328125), (arg0\Field4 + (1.0 / 2.56)), (arg0\Field5 + (1.0 / 4.894837)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 - 1.03125), (arg0\Field4 - 0.0), (arg0\Field5 + 2.5), 90.0, arg0, $00, $00, $03, "", $00)
            arg0\Field25[$03] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$03], (arg0\Field3 - 3.203125), arg0\Field4, (arg0\Field5 - 1.243746), $01)
        Case "room2cpit"
            local14 = createemitter((arg0\Field3 + 2.0), -0.296875, (arg0\Field5 - 2.6875), $00, 0.0)
            turnentity(local14\Field0, -90.0, 0.0, 0.0, $00)
            entityparent(local14\Field0, arg0\Field2, $01)
            local14\Field10 = 55.0
            local14\Field9 = 0.0005
            local14\Field12 = -0.015
            local14\Field11 = 0.007
            local0 = createdoor(arg0\Field0, (arg0\Field3 - 1.0), 0.0, (arg0\Field5 - 2.9375), 90.0, arg0, $00, $02, $03, "", $00)
            local0\Field4 = $01
            local0\Field5 = $00
            local0\Field21 = $00
            local0\Field24 = $00
            local0\Field14 = $01
            positionentity(local0\Field3[$00], (arg0\Field3 - 0.9375), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            local6 = createitem("Dr L's Note", "paper", (arg0\Field3 - 0.625), 0.125, (arg0\Field5 - 1.378906), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "dimension1499"
            arg0\Field28[$01] = loadmesh_strict("GFX\map\dimension1499\1499object0_cull.b3d", arg0\Field2, $00)
            entitytype(arg0\Field28[$01], $01, $00)
            entityalpha(arg0\Field28[$01], 0.0)
            arg0\Field28[$00] = createpivot($00)
            positionentity(arg0\Field28[$00], (arg0\Field3 + (1.0 / 1.24878)), (arg0\Field4 + (1.0 / 1.28)), (arg0\Field5 + 8.933594), $00)
            entityparent(arg0\Field28[$00], arg0\Field2, $01)
    End Select
    For local65 = Each lighttemplates
        If (local65\Field0 = arg0\Field7) Then
            local66 = addlight(arg0, (arg0\Field3 + local65\Field2), (arg0\Field4 + local65\Field3), (arg0\Field5 + local65\Field4), local65\Field1, local65\Field5, local65\Field6, local65\Field7, local65\Field8)
            If (local66 <> $00) Then
                If (local65\Field1 = $03) Then
                    lightconeangles(local66, (Float local65\Field11), local65\Field12)
                    rotateentity(local66, local65\Field9, local65\Field10, 0.0, $00)
                EndIf
            EndIf
        EndIf
    Next
    For local67 = Each tempscreens
        If (local67\Field4 = arg0\Field7) Then
            createscreen((arg0\Field3 + local67\Field1), (arg0\Field4 + local67\Field2), (arg0\Field5 + local67\Field3), local67\Field0, arg0)
        EndIf
    Next
    For local68 = Each tempwaypoints
        If (local68\Field3 = arg0\Field7) Then
            createwaypoint((arg0\Field3 + local68\Field0), (arg0\Field4 + local68\Field1), (arg0\Field5 + local68\Field2), Null, arg0)
        EndIf
    Next
    If (arg0\Field7\Field14 > $00) Then
        arg0\Field38 = arg0\Field7\Field14
        For local7 = $00 To (arg0\Field38 - $01) Step $01
            arg0\Field39[local7] = copyentity(arg0\Field7\Field15[local7], arg0\Field2)
            arg0\Field40[local7] = arg0\Field7\Field16[local7]
            hideentity(arg0\Field39[local7])
        Next
    EndIf
    For local7 = $00 To $07 Step $01
        If (arg0\Field7\Field4[local7] <> $00) Then
            arg0\Field13[local7] = createpivot(arg0\Field2)
            positionentity(arg0\Field13[local7], (arg0\Field3 + arg0\Field7\Field5[local7]), (arg0\Field4 + arg0\Field7\Field6[local7]), (arg0\Field5 + arg0\Field7\Field7[local7]), $01)
            entityparent(arg0\Field13[local7], arg0\Field2, $01)
            arg0\Field12[local7] = arg0\Field7\Field4[local7]
            arg0\Field14[local7] = arg0\Field7\Field8[local7]
        EndIf
    Next
    allowroomdoorsinit = Null
    Return $00
End Function
