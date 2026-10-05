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
    Local local9#
    Local local10#
    Local local11#
    Local local12#
    Local local13#
    Local local14#
    Local local15%
    Local local17%
    Local local18.forest
    Local local19.emitters
    Local local20%
    Local local21%
    Local local22%
    Local local23%
    Local local24%
    Local local26#
    Local local27#
    Local local29%
    Local local31.waypoints
    Local local32.waypoints
    Local local33#
    Local local34%
    Local local36#
    Local local37$
    Local local38$
    Local local39%
    Local local42%
    Local local44#
    Local local52%
    Local local53%
    Local local54%
    Local local55%
    Local local56%
    Local local57$
    Local local58%
    Local local59%
    Local local61%
    Local local62#
    Local local64%
    Local local65%
    Local local66%
    Local local67#
    Local local68%
    Local local70.lighttemplates
    Local local71%
    Local local72.tempscreens
    Local local73.tempwaypoints
    local9 = arg0\Field4
    local10 = arg0\Field5
    local11 = arg0\Field6
    allowroomsdoorsinit = $01
    Select arg0\Field8\Field11
        Case "room860"
            arg0\Field25[$02] = loadmesh_strict("GFX\map\forest\door_frame.b3d", $00)
            positionentity(arg0\Field25[$02], (local9 + 0.71875), 0.0, local11, $01)
            scaleentity(arg0\Field25[$02], (1.0 / 5.688889), (1.0 / 5.688889), (1.0 / 3.2), $01)
            entityparent(arg0\Field25[$02], arg0\Field3, $01)
            arg0\Field25[$03] = loadmesh_strict("GFX\map\forest\door.b3d", $00)
            positionentity(arg0\Field25[$03], (local9 + 0.4375), 0.0, (local11 + 0.05), $01)
            entitytype(arg0\Field25[$03], $01, $00)
            scaleentity(arg0\Field25[$03], (1.0 / 5.565217), (1.0 / 5.688889), (1.0 / 5.565217), $01)
            entityparent(arg0\Field25[$03], arg0\Field3, $01)
            arg0\Field25[$04] = copyentity(arg0\Field25[$03], $00)
            positionentity(arg0\Field25[$04], (local9 + 1.0), 0.0, (local11 - 0.05), $01)
            rotateentity(arg0\Field25[$04], 0.0, 180.0, 0.0, $00)
            scaleentity(arg0\Field25[$04], (1.0 / 5.565217), (1.0 / 5.688889), (1.0 / 5.565217), $01)
            entityparent(arg0\Field25[$04], arg0\Field3, $01)
            addentitytoroomprops(arg0, arg0\Field25[$02])
            addentitytoroomprops(arg0, arg0\Field25[$03])
            addentitytoroomprops(arg0, arg0\Field25[$04])
            local0 = createdoor(local17, (local9 + 3.625), 0.0, (local11 + 2.5), 0.0, arg0, networkserver\Field12, $00, $00, "ABCD")
            local0\Field20 = (networkserver\Field12 = $00)
            local0 = createdoor(local17, (local9 + 3.625), 0.0, (local11 - 2.5), 0.0, arg0, $01, $00, $00, "ABCD")
            local0\Field20 = $00
            local0 = createdoor(local17, (local9 + 1.625), 0.0, (local11 - 2.5), 0.0, arg0, $00, $00, $01, "")
            local0 = createdoor(local17, (local9 + 1.625), 0.0, (local11 + 2.5), 0.0, arg0, $00, $00, $01, "")
            If (i_zone\Field1 = $00) Then
                local18 = (New forest)
                arg0\Field11 = local18
                genforestgrid(local18)
                placeforest(local18, local9, (local10 + 100.0), local11, arg0)
            EndIf
            If (networkserver\Field12 = $00) Then
                local6 = createitem("Document SCP-860-1", "paper", (local9 + 2.625), (local10 + 0.6875), (local11 + 1.308594), $00, $00, $00, 1.0, $00, $01)
                rotateentity(local6\Field2, 0.0, (Float (arg0\Field7 + $0A)), 0.0, $00)
                entityparent(local6\Field2, arg0\Field3, $01)
                local6 = createitem("Document SCP-860", "paper", (local9 + 4.5), (local10 + 0.6875), (local11 - 1.5), $00, $00, $00, 1.0, $00, $01)
                rotateentity(local6\Field2, 0.0, (Float (arg0\Field7 + $AA)), 0.0, $00)
                entityparent(local6\Field2, arg0\Field3, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (local9 + 2.625), (local10 + 0.6875), (local11 + 1.308594), $00, $00, $00, 1.0, $00, $01)
                rotateentity(local6\Field2, 0.0, (Float (arg0\Field7 + $0A)), 0.0, $00)
                entityparent(local6\Field2, arg0\Field3, $01)
                local6 = createitem("Rocket Launcher", "rpg", (local9 + 4.5), (local10 + 0.6875), (local11 - 1.5), $00, $00, $00, 1.0, $00, $01)
                rotateentity(local6\Field2, 0.0, (Float (arg0\Field7 + $AA)), 0.0, $00)
                entityparent(local6\Field2, arg0\Field3, $01)
            EndIf
        Case "lockroom"
            local0 = createdoor(local17, (local9 - 2.875), 0.0, (local11 - 0.40625), 0.0, arg0, $01, $00, $00, "")
            local0\Field10 = (((networkserver\Field12 * $05) + $05) * $46)
            local0\Field20 = $00
            local0\Field5 = $00
            entityparent(local0\Field3[$00], $00, $01)
            positionentity(local0\Field3[$00], (local9 - 1.125), 0.7, (local11 - 2.5), $00)
            entityparent(local0\Field3[$00], arg0\Field3, $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local1 = createdoor(local17, (local9 + 0.40625), 0.0, (local11 + 2.875), 270.0, arg0, $01, $00, $00, "")
            local1\Field10 = (((networkserver\Field12 * $05) + $05) * $46)
            local1\Field20 = $00
            local1\Field5 = $00
            entityparent(local1\Field3[$00], $00, $01)
            positionentity(local1\Field3[$00], (local9 + 2.5), 0.7, (local11 + 1.125), $00)
            rotateentity(local1\Field3[$00], 0.0, 90.0, 0.0, $00)
            entityparent(local1\Field3[$00], arg0\Field3, $01)
            freeentity(local1\Field3[$01])
            local1\Field3[$01] = $00
            local0\Field21 = local1
            local1\Field21 = local0
            local2 = createsecuritycam((local9 - 2.6875), (local10 + 1.5), (local11 + 2.6875), arg0, $01)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            local2\Field9 = $01
            entitytexture(local2\Field4, screentexs[local2\Field9], $00, $00)
            turnentity(local2\Field3, 40.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field3, $01)
            positionentity(local2\Field4, (local9 + 2.609375), 1.1, (local11 - 0.375), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field3, $01)
            local2 = createsecuritycam((local9 - 0.4375), (local10 + 1.5), (local11 + 0.4375), arg0, $01)
            local2\Field11 = 45.0
            local2\Field12 = 45.0
            local2\Field9 = $01
            entitytexture(local2\Field4, screentexs[local2\Field9], $00, $00)
            turnentity(local2\Field3, 40.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field3, $01)
            positionentity(local2\Field4, (local9 + 0.375), 1.1, (local11 - 2.609375), $00)
            entityparent(local2\Field4, arg0\Field3, $01)
            local19 = createemitter((local9 - (1.0 / 1.462857)), 1.445312, (local11 + 2.5625), $00, 0.0, 0.0, 0.0, 0.0)
            turnentity(local19\Field0, 90.0, 0.0, 0.0, $01)
            entityparent(local19\Field0, arg0\Field3, $01)
            local19\Field14 = 20.0
            local19\Field13 = 0.05
            local19\Field15 = 0.007
            local19\Field16 = -0.006
            local19\Field4 = -0.24
            local19 = createemitter((local9 - 2.558594), 1.445312, (local11 + 0.9375), $00, 0.0, 0.0, 0.0, 0.0)
            turnentity(local19\Field0, 90.0, 0.0, 0.0, $01)
            entityparent(local19\Field0, arg0\Field3, $01)
            local19\Field14 = 20.0
            local19\Field13 = 0.05
            local19\Field15 = 0.007
            local19\Field16 = -0.006
            local19\Field4 = -0.24
        Case "lockroom2"
            For local7 = $00 To $05 Step $01
                local3 = createdecal(rand($02, $03), ((rnd(-392.0, 520.0) * (1.0 / 256.0)) + local9), (rnd(0.0, 0.001) + (1.0 / 85.33334)), ((rnd(-392.0, 520.0) * (1.0 / 256.0)) + local11), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
                local3\Field2 = rnd(0.3, 0.6)
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                createdecal(rand($0F, $10), ((rnd(-392.0, 520.0) * (1.0 / 256.0)) + local9), (rnd(0.0, 0.001) + (1.0 / 85.33334)), ((rnd(-392.0, 520.0) * (1.0 / 256.0)) + local11), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
                local3\Field2 = rnd(0.1, 0.6)
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                createdecal(rand($0F, $10), (rnd(-0.5, 0.5) + local9), (rnd(0.0, 0.001) + (1.0 / 85.33334)), (rnd(-0.5, 0.5) + local11), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
                local3\Field2 = rnd(0.1, 0.6)
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
            Next
            local2 = createsecuritycam((local9 + 2.0), (local10 + 1.5), (local11 + 1.5), arg0, $01)
            local2\Field11 = 135.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 40.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field3, $01)
            positionentity(local2\Field4, (local9 + 2.609375), 1.1, (local11 - 0.375), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field3, $01)
            local2 = createsecuritycam((local9 - 1.5), (local10 + 1.5), (local11 - 2.0), arg0, $01)
            local2\Field11 = 315.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 40.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field3, $01)
            positionentity(local2\Field4, (local9 + 0.375), 1.1, (local11 - 2.609375), $00)
            entityparent(local2\Field4, arg0\Field3, $01)
        Case "gatea"
            arg0\Field29[$02] = createdoor(local17, (local9 - 15.875), (local10 - 5.0), (local11 + 15.4375), 0.0, arg0, $00, $00, $00, "")
            arg0\Field29[$02]\Field20 = $00
            arg0\Field29[$02]\Field5 = $00
            local1 = createdoor(local17, local9, local10, (local11 - 4.0), 0.0, arg0, $00, $00, $00, "")
            local1\Field20 = $00
            local1\Field5 = $00
            local1\Field4 = $01
            local1 = createdoor(local17, (local9 - 5.625), (local10 - 1.875), (local11 + 9.09375), 0.0, arg0, $00, $00, $02, "")
            If (selectedending = "A2") Then
                local1\Field20 = $00
                local1\Field5 = $01
                local1\Field4 = $01
            Else
                local1\Field20 = $00
                local1\Field5 = $00
                local1\Field4 = $00
            EndIf
            positionentity(local1\Field3[$00], (local9 - 5.15625), entityy(local1\Field3[$00], $01), (local11 + 8.9375), $01)
            positionentity(local1\Field3[$01], (local9 - 6.1875), entityy(local1\Field3[$00], $01), (local11 + 9.71875), $01)
            rotateentity(local1\Field3[$01], 0.0, 90.0, 0.0, $01)
            local1 = createdoor(local17, (local9 - 5.625), (local10 - 1.875), (local11 + 17.0), 0.0, arg0, $00, $00, $02, "")
            If (selectedending = "A2") Then
                local1\Field20 = $00
                local1\Field5 = $01
                local1\Field4 = $01
            Else
                local1\Field20 = $00
                local1\Field5 = $00
                local1\Field4 = $00
            EndIf
            positionentity(local1\Field3[$00], (local9 - 5.15625), entityy(local1\Field3[$00], $01), (local11 + 17.125), $01)
            rotateentity(local1\Field3[$00], 0.0, 180.0, 0.0, $01)
            positionentity(local1\Field3[$01], (local9 - 6.1875), entityy(local1\Field3[$00], $01), (local11 + 16.53125), $01)
            rotateentity(local1\Field3[$01], 0.0, 90.0, 0.0, $01)
            For local4 = Each rooms
                If (local4\Field8\Field11 = "exit1") Then
                    arg0\Field25[$01] = local4\Field25[$01]
                    arg0\Field25[$02] = local4\Field25[$02]
                ElseIf (local4\Field8\Field11 = "gateaentrance") Then
                    arg0\Field29[$01] = createdoor($00, (local9 + 6.03125), local10, (local11 - 0.25), 90.0, arg0, $00, $03, $00, "")
                    arg0\Field29[$01]\Field20 = $00
                    arg0\Field29[$01]\Field5 = $00
                    positionentity(arg0\Field29[$01]\Field3[$00], (local9 + 6.1875), entityy(arg0\Field29[$01]\Field3[$00], $01), (local11 + (1.0 / 3.2)), $01)
                    positionentity(arg0\Field29[$01]\Field3[$01], (local9 + 5.6875), entityy(arg0\Field29[$01]\Field3[$01], $01), (local11 - 0.8125), $01)
                    local4\Field25[$01] = createpivot($00)
                    positionentity(local4\Field25[$01], (local9 + 7.21875), (local10 + 0.9375), (local11 - 0.25), $01)
                    entityparent(local4\Field25[$01], arg0\Field3, $01)
                EndIf
            Next
            arg0\Field25[$03] = createpivot($00)
            positionentity(arg0\Field25[$03], (local9 + 4.75), local10, (local11 + 8.25), $01)
            entityparent(arg0\Field25[$03], arg0\Field3, $01)
            arg0\Field25[$04] = createpivot($00)
            positionentity(arg0\Field25[$04], local9, (local10 + 0.375), (local11 + 25.0), $01)
            entityparent(arg0\Field25[$04], arg0\Field3, $01)
            arg0\Field25[$05] = createpivot($00)
            positionentity(arg0\Field25[$05], (local9 + 6.96875), (local10 + 8.296875), (local11 + 17.625), $01)
            entityparent(arg0\Field25[$05], arg0\Field3, $01)
            arg0\Field25[$06] = createpivot($00)
            positionentity(arg0\Field25[$06], (local9 - 19.71875), (local10 + 7.46875), (local11 + 18.1875), $01)
            entityparent(arg0\Field25[$06], arg0\Field3, $01)
            arg0\Field25[$07] = createpivot($00)
            positionentity(arg0\Field25[$07], (local9 + 7.125), (local10 + 0.875), (local11 + 27.5625), $01)
            entityparent(arg0\Field25[$07], arg0\Field3, $01)
            arg0\Field25[$08] = createpivot($00)
            positionentity(arg0\Field25[$08], (local9 - 7.125), (local10 + 0.875), (local11 + 27.5625), $01)
            entityparent(arg0\Field25[$08], arg0\Field3, $01)
            arg0\Field25[$09] = createpivot($00)
            positionentity(arg0\Field25[$09], (local9 + 10.25), (local10 + 3.875), (local11 + 24.05078), $01)
            entityparent(arg0\Field25[$09], arg0\Field3, $01)
            arg0\Field25[$0B] = createpivot($00)
            positionentity(arg0\Field25[$0B], (local9 - 15.875), (local10 - 4.875), (local11 - 6.625), $01)
            entityparent(arg0\Field25[$0B], arg0\Field3, $01)
            local20 = createcube($00)
            entityalpha(local20, 0.0)
            positionentity(local20, (local9 - 16.25), (local10 - 4.082031), (local11 - 7.5), $00)
            moveentity(local20, 0.3, 0.0, -0.3)
            scaleentity(local20, 0.55, 0.55, 0.55, $00)
            entitytype(local20, $01, $00)
            entityparent(local20, arg0\Field3, $01)
            arg0\Field25[$1B] = createpivot($00)
            positionentity(arg0\Field25[$1B], (local9 - 16.25), (local10 - 4.082031), (local11 - 7.5), $00)
            moveentity(arg0\Field25[$1B], 0.3, 0.1, 30.0)
            entityparent(arg0\Field25[$1B], arg0\Field3, $01)
            arg0\Field25[$0D] = loadmesh_strict("GFX\map\gateawall1.b3d", arg0\Field3)
            positionentity(arg0\Field25[$0D], (local9 - 16.82812), (local10 - 4.082031), (local11 + 2.125), $01)
            entitycolor(arg0\Field25[$0D], 25.0, 25.0, 25.0)
            entitytype(arg0\Field25[$0D], $01, $00)
            addentitytoroomprops(arg0, arg0\Field25[$0D])
            arg0\Field25[$0E] = loadmesh_strict("GFX\map\gateawall2.b3d", arg0\Field3)
            positionentity(arg0\Field25[$0E], (local9 - 14.92188), (local10 - 4.082031), (local11 + 2.125), $01)
            entitycolor(arg0\Field25[$0E], 25.0, 25.0, 25.0)
            entitytype(arg0\Field25[$0E], $01, $00)
            addentitytoroomprops(arg0, arg0\Field25[$0E])
            arg0\Field25[$0F] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$0F], (local9 - 13.9375), (local10 - 4.253906), (local11 + 19.3125), $01)
            arg0\Field25[$10] = loadmesh_strict("GFX\map\gatea_hitbox1.b3d", arg0\Field3)
            entitypickmode(arg0\Field25[$10], $02, $01)
            entitytype(arg0\Field25[$10], $01, $00)
            entityalpha(arg0\Field25[$10], 0.0)
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (local9 - 5.33914), (local10 + 0.302002), (local11 - 1.065562), -45.0)
            local21 = createcube($00)
            scaleentity(local21, 2.12, 6.0, 2.59, $00)
            positionentity(local21, (local9 + 3.560786), (local10 - 2.996094), (local11 + 4.148674), $00)
            moveentity(local21, 0.5, 0.0, 0.1)
            entitytype(local21, $09, $00)
            entityalpha(local21, 0.0)
            entityparent(local21, arg0\Field3, $01)
            local21 = createcube($00)
            scaleentity(local21, 2.12, 6.0, 2.59, $00)
            positionentity(local21, (local9 - 3.538257), (local10 - 2.996094), (local11 + 4.225296), $00)
            moveentity(local21, -0.5, 0.0, 0.0)
            entitytype(local21, $09, $00)
            entityalpha(local21, 0.0)
            entityparent(local21, arg0\Field3, $01)
        Case "gateaentrance"
            arg0\Field29[$00] = createdoor($00, (local9 + 2.90625), 0.0, (local11 + 2.0), 90.0, arg0, $01, $03, $00, "")
            arg0\Field29[$00]\Field20 = $00
            arg0\Field29[$00]\Field5 = $01
            positionentity(arg0\Field29[$00]\Field3[$01], (local9 + 2.6875), entityy(arg0\Field29[$00]\Field3[$01], $01), (local11 + 1.4375), $01)
            positionentity(arg0\Field29[$00]\Field3[$00], (local9 + 3.0625), entityy(arg0\Field29[$00]\Field3[$00], $01), (local11 + 2.5625), $01)
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (local9 + 4.09375), 0.0, (local11 + 2.0), $01)
            entityparent(arg0\Field25[$00], arg0\Field3, $01)
            arg0\Field29[$01] = createdoor(local17, local9, 0.0, (local11 - 1.40625), 0.0, arg0, $00, $01, $05, "")
            arg0\Field29[$01]\Field9 = $01
            arg0\Field29[$01]\Field20 = $00
            arg0\Field29[$01]\Field5 = $00
            positionentity(arg0\Field29[$01]\Field3[$01], (local9 + 1.648438), entityy(arg0\Field29[$00]\Field3[$01], $01), (local11 - 2.25), $01)
            rotateentity(arg0\Field29[$01]\Field3[$01], 0.0, ((Float arg0\Field7) - 90.0), 0.0, $01)
            positionentity(arg0\Field29[$01]\Field3[$00], (local9 - 2.039062), entityy(arg0\Field29[$01]\Field3[$00], $01), entityz(arg0\Field29[$01]\Field3[$00], $01), $01)
            rotateentity(arg0\Field29[$01]\Field3[$00], 0.0, ((Float arg0\Field7) - 225.0), 0.0, $01)
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (local9 + 1.613648), (local10 + 0.302), (local11 + 3.142031), -179.0)
        Case "exit1"
            arg0\Field25[$00] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$00], (local9 + 17.01562), 38.15234, (local11 + 10.10938), $01)
            arg0\Field29[$04] = createdoor(local17, local9, 0.0, (local11 - 1.25), 0.0, arg0, $00, $01, $05, "")
            arg0\Field29[$04]\Field9 = $01
            arg0\Field29[$04]\Field20 = $00
            arg0\Field29[$04]\Field5 = $00
            positionentity(arg0\Field29[$04]\Field3[$01], (local9 + 1.398438), entityy(arg0\Field29[$04]\Field3[$01], $01), (local11 - 2.0625), $01)
            rotateentity(arg0\Field29[$04]\Field3[$01], 0.0, ((Float arg0\Field7) - 90.0), 0.0, $01)
            positionentity(arg0\Field29[$04]\Field3[$00], entityx(arg0\Field29[$04]\Field3[$00], $01), entityy(arg0\Field29[$04]\Field3[$00], $01), (local11 - (1.0 / 1.292929)), $01)
            rotateentity(arg0\Field29[$04]\Field3[$00], 0.0, ((Float arg0\Field7) - 180.0), 0.0, $01)
            arg0\Field25[$03] = createpivot($00)
            positionentity(arg0\Field25[$03], (local9 - 30.0), 42.9375, (local11 - 105.6562), $01)
            entityparent(arg0\Field25[$03], arg0\Field3, $01)
            arg0\Field25[$04] = createpivot($00)
            positionentity(arg0\Field25[$04], (local9 + 20.32562), 47.375, (local11 - 6.793711), $01)
            entityparent(arg0\Field25[$04], arg0\Field3, $01)
            arg0\Field25[$05] = createpivot($00)
            positionentity(arg0\Field25[$05], (local9 + 17.04305), 41.15625, (local11 + 10.80531), $01)
            entityparent(arg0\Field25[$05], arg0\Field3, $01)
            arg0\Field25[$06] = createpivot($00)
            positionentity(arg0\Field25[$06], (local9 + 20.28125), 47.625, (local11 - 6.875), $01)
            entityparent(arg0\Field25[$06], arg0\Field3, $01)
            arg0\Field25[$07] = createpivot($00)
            positionentity(arg0\Field25[$07], (local9 + 20.28125), 47.625, (local11 - 17.0), $01)
            entityparent(arg0\Field25[$07], arg0\Field3, $01)
            arg0\Field29[$00] = createdoor($00, (local9 + 2.8125), 0.0, (local11 + 5.59375), 0.0, arg0, $01, $03, $00, "")
            arg0\Field29[$00]\Field20 = $00
            arg0\Field29[$00]\Field5 = $01
            moveentity(arg0\Field29[$00]\Field3[$00], 0.0, 0.0, (1.0 / 11.63636))
            moveentity(arg0\Field29[$00]\Field3[$01], 0.0, 0.0, (1.0 / 11.63636))
            arg0\Field25[$08] = createpivot($00)
            positionentity(arg0\Field25[$08], (local9 + 2.8125), 0.0, (local11 + 6.8125), $01)
            entityparent(arg0\Field25[$08], arg0\Field3, $01)
            arg0\Field29[$01] = createdoor($00, (local9 - 21.1875), 42.125, (local11 - 5.390625), 0.0, arg0, $00, $03, $00, "")
            arg0\Field29[$01]\Field20 = $00
            arg0\Field29[$01]\Field5 = $00
            moveentity(arg0\Field29[$01]\Field3[$00], 0.0, 0.0, (1.0 / 11.63636))
            moveentity(arg0\Field29[$01]\Field3[$01], 0.0, 0.0, (1.0 / 11.63636))
            arg0\Field25[$09] = createpivot($00)
            positionentity(arg0\Field25[$09], (local9 - 21.1875), 42.125, (local11 - 4.171875), $01)
            entityparent(arg0\Field25[$09], arg0\Field3, $01)
            arg0\Field29[$02] = createdoor($00, (local9 + 17.0), 42.125, (local11 - 1.921875), 0.0, arg0, $00, $00, $00, "")
            arg0\Field29[$02]\Field20 = $00
            arg0\Field29[$02]\Field5 = $00
            arg0\Field29[$03] = createdoor($00, (local9 + 17.0), 42.125, (local11 + (1.0 / 0.512)), 0.0, arg0, $00, $00, $00, "")
            arg0\Field29[$03]\Field20 = $00
            arg0\Field29[$03]\Field5 = $00
            arg0\Field25[$0A] = createpivot($00)
            positionentity(arg0\Field25[$0A], (local9 + 17.0), 42.10156, (local11 + 5.25), $01)
            entityparent(arg0\Field25[$0A], arg0\Field3, $01)
            arg0\Field25[$0B] = createpivot($00)
            positionentity(arg0\Field25[$0B], (local9 + 11.0), 43.0625, (local11 - 11.0), $01)
            entityparent(arg0\Field25[$0B], arg0\Field3, $01)
            arg0\Field29[$05] = createdoor($00, (local9 + 12.6875), 38.5, (local11 + 25.0), 0.0, arg0, $00, $00, $00, "28084020")
            arg0\Field29[$05]\Field20 = $00
            arg0\Field29[$05]\Field5 = $00
            local0 = createdoor($00, (local9 + 12.0), 38.5, (local11 + 22.65625), 90.0, arg0, $00, $00, $03, "")
            local0\Field20 = $00
            local0\Field5 = $00
            arg0\Field25[$0E] = createpivot($00)
            positionentity(arg0\Field25[$0E], (local9 + 13.8125), 40.0625, (local11 + 21.53125), $01)
            entityparent(arg0\Field25[$0E], arg0\Field3, $01)
            arg0\Field25[$0F] = createpivot($00)
            positionentity(arg0\Field25[$0F], (local9 + 13.8125), 40.0625, (local11 + 22.75), $01)
            entityparent(arg0\Field25[$0F], arg0\Field3, $01)
            arg0\Field25[$10] = createpivot($00)
            positionentity(arg0\Field25[$10], (local9 + 15.0625), 40.0625, (local11 + 21.53125), $01)
            entityparent(arg0\Field25[$10], arg0\Field3, $01)
            arg0\Field25[$11] = createpivot($00)
            positionentity(arg0\Field25[$11], (local9 + 15.0625), 40.0625, (local11 + 22.75), $01)
            entityparent(arg0\Field25[$11], arg0\Field3, $01)
            arg0\Field25[$12] = createpivot($00)
            positionentity(arg0\Field25[$12], (local9 + 12.69531), 38.65625, (local11 + 25.87109), $01)
            entityparent(arg0\Field25[$12], arg0\Field3, $01)
            arg0\Field25[$13] = createpivot($00)
            positionentity(arg0\Field25[$13], (local9 + 14.875), 48.125, (local11 - 53.0), $01)
            entityparent(arg0\Field25[$13], arg0\Field3, $01)
            arg0\Field25[$1A] = createpivot($00)
            positionentity(arg0\Field25[$1A], (local9 + 17.0), 42.125, (local11 + (1.0 / 0.512)), $00)
            moveentity(arg0\Field25[$1A], 0.0, 0.3, -8.0)
            entityparent(arg0\Field25[$1A], arg0\Field3, $01)
            arg0\Field25[$1B] = createpivot($00)
            positionentity(arg0\Field25[$1B], (local9 + 12.0), 38.5, (local11 + 22.65625), $00)
            entityparent(arg0\Field25[$1B], arg0\Field3, $01)
            If (networkserver\Field12 <> 0) Then
                arg0\Field25[$16] = createbutton((local9 + 15.50659), (local10 + 38.96456), (local11 + 22.76515), 80.0, -90.0, 0.0, $00)
                entityparent(arg0\Field25[$16], arg0\Field3, $01)
            EndIf
            arg0\Field25[$1C] = createpivot($00)
            positionentity(arg0\Field25[$1C], (local9 + 2.25), 42.84375, (local11 - 10.25), $00)
            entityparent(arg0\Field25[$1C], arg0\Field3, $01)
            arg0\Field25[$1D] = createpivot($00)
            positionentity(arg0\Field25[$1D], (local9 + 11.75), 40.5, (local11 + 15.25), $00)
            entityparent(arg0\Field25[$1D], arg0\Field3, $01)
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (local9 + 3.409651), 0.0, (local11 - (1.0 / 3.898312)), 115.0)
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (local9 + -21.4809), (local10 + 40.05485), (local11 - 14.81771), 0.0)
        Case "roompj"
            If (networkserver\Field12 = $00) Then
                local6 = createitem("Document SCP-372", "paper", (local9 + 3.125), (local10 + 0.6875), (local11 + 4.328125), $00, $00, $00, 1.0, $00, $01)
                rotateentity(local6\Field2, 0.0, (Float arg0\Field7), 0.0, $00)
                entityparent(local6\Field2, arg0\Field3, $01)
            Else
                local6 = createitem("Strange Bottle", "veryfinefirstaid", (local9 + 3.125), (local10 + 0.6875), (local11 + 4.328125), $00, $00, $00, 1.0, $00, $01)
                rotateentity(local6\Field2, 0.0, (Float arg0\Field7), 0.0, $00)
                entityparent(local6\Field2, arg0\Field3, $01)
            EndIf
            local6 = createitem("Radio Transceiver", "radio", (local9 + 3.125), (local10 + 0.4375), (local11 + 3.6875), $00, $00, $00, 1.0, $00, $01)
            local6\Field13 = 80.0
            entityparent(local6\Field2, arg0\Field3, $01)
            arg0\Field25[$03] = loadmesh_strict("GFX\map\372_hb.b3d", arg0\Field3)
            entitypickmode(arg0\Field25[$03], $02, $01)
            entitytype(arg0\Field25[$03], $01, $00)
            entityalpha(arg0\Field25[$03], 0.0)
            local0 = createdoor(local17, local9, local10, (local11 - 1.4375), 0.0, arg0, $01, $01, $02, "")
            local0\Field20 = $00
            positionentity(local0\Field3[$00], (local9 - 1.9375), 0.7, (local11 - 1.0625), $01)
            turnentity(local0\Field3[$00], 0.0, 90.0, 0.0, $00)
        Case "room079"
            local0 = createdoor(local17, local9, -1.75, (local11 + 4.4375), 0.0, arg0, $00, $01, $04, "")
            local0\Field9 = $01
            local0\Field20 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$01], (local9 + 0.875), (1.0 / -1.024), (local11 + 3.585938), $01)
            positionentity(local0\Field3[$00], (local9 - 0.9375), (1.0 / -1.024), (local11 + 5.335938), $01)
            arg0\Field29[$00] = createdoor(local17, (local9 + 5.6875), -1.75, (local11 + 3.8125), 0.0, arg0, $00, $01, $03, "")
            arg0\Field29[$00]\Field9 = $01
            arg0\Field29[$00]\Field20 = $00
            arg0\Field29[$00]\Field5 = $00
            positionentity(arg0\Field29[$00]\Field3[$01], (local9 + 6.875), (1.0 / -1.024), (local11 + 4.828125), $01)
            turnentity(arg0\Field29[$00]\Field3[$00], 0.0, -180.0, 0.0, $01)
            positionentity(arg0\Field29[$00]\Field3[$00], (local9 + 6.875), -0.9375, (local11 + 2.890625), $01)
            turnentity(arg0\Field29[$00]\Field3[$01], 0.0, 0.0, 0.0, $01)
            createdoor($00, (local9 + 4.46875), -1.75, (local11 + 2.75), 90.0, arg0, $00, $00, $FFFFFFFF, "")
            arg0\Field25[$00] = loadanimmesh_strict("GFX\map\079.b3d", $00)
            scaleentity(arg0\Field25[$00], 1.3, 1.3, 1.3, $01)
            positionentity(arg0\Field25[$00], (local9 + 7.25), -2.1875, (local11 - 2.625), $01)
            entityparent(arg0\Field25[$00], arg0\Field3, $01)
            turnentity(arg0\Field25[$00], 0.0, 180.0, 0.0, $01)
            addentitytoroomprops(arg0, arg0\Field25[$00])
            arg0\Field25[$01] = createsprite(arg0\Field25[$00])
            spriteviewmode(arg0\Field25[$01], $02)
            positionentity(arg0\Field25[$01], 0.082, 0.119, 0.01, $00)
            scalesprite(arg0\Field25[$01], 0.09, 0.0725)
            turnentity(arg0\Field25[$01], 0.0, 13.0, 0.0, $00)
            moveentity(arg0\Field25[$01], 0.0, 0.0, -0.022)
            entitytexture(arg0\Field25[$01], oldaipics($00), $00, $00)
            hideentity(arg0\Field25[$01])
            arg0\Field25[$02] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$02], (local9 + 4.625), -1.75, (local11 + 7.0), $01)
            local3 = createdecal($03, (local9 + 4.625), -1.74, (local11 + 7.0), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
            local3\Field2 = 0.5
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityparent(local3\Field0, arg0\Field3, $01)
        Case "checkpoint1"
            arg0\Field29[$00] = createdoor($00, (local9 + 0.1875), 0.0, (local11 - 0.5), 0.0, arg0, $00, $00, ($03 - networkserver\Field12), "")
            positionentity(arg0\Field29[$00]\Field3[$00], (local9 - 0.59375), entityy(arg0\Field29[$00]\Field3[$00], $01), (local11 - 1.375), $01)
            positionentity(arg0\Field29[$00]\Field3[$01], (local9 - 0.59375), entityy(arg0\Field29[$00]\Field3[$01], $01), (local11 + 0.375), $01)
            arg0\Field29[$01] = createdoor($00, (local9 - 1.375), 0.0, (local11 - 0.5), 0.0, arg0, $00, $00, ($03 - networkserver\Field12), "")
            arg0\Field29[$01]\Field21 = arg0\Field29[$00]
            arg0\Field29[$00]\Field21 = arg0\Field29[$01]
            arg0\Field25[$00] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$00], (local9 + 2.8125), 0.46875, (local11 + 1.300781), $01)
            arg0\Field29[$00]\Field10 = $15E
            arg0\Field29[$01]\Field10 = $15E
            local2 = createsecuritycam((local9 + 0.75), (local10 + 2.75), (local11 - 3.75), arg0, $00)
            local2\Field11 = 45.0
            local2\Field12 = 0.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            arg0\Field25[$02] = copyentity(monitor2, arg0\Field3)
            scaleentity(arg0\Field25[$02], 2.0, 2.0, 2.0, $00)
            positionentity(arg0\Field25[$02], (local9 - 0.59375), 1.5, (local11 + 0.484375), $01)
            rotateentity(arg0\Field25[$02], 0.0, 180.0, 0.0, $00)
            entityfx(arg0\Field25[$02], $01)
            addentitytoroomprops(arg0, arg0\Field25[$02])
            arg0\Field25[$03] = copyentity(monitor2, arg0\Field3)
            scaleentity(arg0\Field25[$03], 2.0, 2.0, 2.0, $00)
            positionentity(arg0\Field25[$03], (local9 - 0.59375), 1.5, (local11 - 1.484375), $01)
            rotateentity(arg0\Field25[$03], 0.0, 0.0, 0.0, $00)
            entityfx(arg0\Field25[$03], $01)
            addentitytoroomprops(arg0, arg0\Field25[$03])
            If (maptemp((Int floor((local9 / 8.0))), (Int (floor((local11 / 8.0)) - 1.0))) = $00) Then
                createdoor(local17, local9, 0.0, (local11 - 4.0), 0.0, arg0, $00, $02, $00, "GEAR")
            EndIf
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (local9 - 3.145789), (local10 + 0.302), (local11 + 1.321121), -80.0)
        Case "checkpoint2"
            arg0\Field29[$00] = createdoor($00, (local9 - 0.1875), 0.0, (local11 + 0.5), 0.0, arg0, $00, $00, ($05 - (networkserver\Field12 Shl $01)), "")
            positionentity(arg0\Field29[$00]\Field3[$00], (local9 + 0.59375), entityy(arg0\Field29[$00]\Field3[$00], $01), (local11 - 0.375), $01)
            positionentity(arg0\Field29[$00]\Field3[$01], (local9 + 0.59375), entityy(arg0\Field29[$00]\Field3[$01], $01), (local11 + 1.375), $01)
            arg0\Field29[$01] = createdoor($00, (local9 + 1.375), 0.0, (local11 + 0.5), 0.0, arg0, $00, $00, ($05 - (networkserver\Field12 Shl $01)), "")
            arg0\Field29[$01]\Field21 = arg0\Field29[$00]
            arg0\Field29[$00]\Field21 = arg0\Field29[$01]
            arg0\Field25[$00] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$00], (local9 - 2.8125), 0.46875, (local11 + 1.8125), $01)
            arg0\Field25[$02] = copyentity(monitor3, arg0\Field3)
            scaleentity(arg0\Field25[$02], 2.0, 2.0, 2.0, $00)
            positionentity(arg0\Field25[$02], (local9 + 0.59375), 1.5, (local11 + 1.484375), $01)
            rotateentity(arg0\Field25[$02], 0.0, 180.0, 0.0, $00)
            entityfx(arg0\Field25[$02], $01)
            addentitytoroomprops(arg0, arg0\Field25[$02])
            arg0\Field25[$03] = copyentity(monitor3, arg0\Field3)
            scaleentity(arg0\Field25[$03], 2.0, 2.0, 2.0, $00)
            positionentity(arg0\Field25[$03], (local9 + 0.59375), 1.5, (local11 - 0.484375), $01)
            rotateentity(arg0\Field25[$03], 0.0, 0.0, 0.0, $00)
            entityfx(arg0\Field25[$03], $01)
            addentitytoroomprops(arg0, arg0\Field25[$03])
            arg0\Field29[$00]\Field10 = $15E
            arg0\Field29[$01]\Field10 = $15E
            If (maptemp((Int floor((local9 / 8.0))), (Int (floor((local11 / 8.0)) - 1.0))) = $00) Then
                createdoor(local17, local9, 0.0, (local11 - 4.0), 0.0, arg0, $00, $00, $00, "GEAR")
            EndIf
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (local9 + 2.951149), (local10 + 0.302), (local11 - 1.745691), 72.0)
        Case "room2pit"
            local7 = $00
            For local12 = -1.0 To 1.0 Step 2.0
                For local14 = -1.0 To 1.0 Step 1.0
                    local19 = createemitter((((1.0 / 1.267327) * local12) + local9), (1.0 / 32.0), ((1.0 * local14) + local11), $00, 0.0, 0.0, 0.0, 0.0)
                    local19\Field14 = 30.0
                    local19\Field13 = 0.0045
                    local19\Field15 = 0.007
                    local19\Field16 = -0.016
                    arg0\Field25[local7] = local19\Field0
                    If (local7 < $03) Then
                        turnentity(local19\Field0, 0.0, -90.0, 0.0, $01)
                    Else
                        turnentity(local19\Field0, 0.0, 90.0, 0.0, $01)
                    EndIf
                    turnentity(local19\Field0, -45.0, 0.0, 0.0, $01)
                    entityparent(local19\Field0, arg0\Field3, $01)
                    local7 = (local7 + $01)
                Next
            Next
            arg0\Field25[$06] = createpivot($00)
            positionentity(arg0\Field25[$06], (local9 + 2.5), (1.0 / 32.0), (local11 - 3.5), $00)
            entityparent(arg0\Field25[$06], arg0\Field3, $01)
            arg0\Field25[$07] = createpivot($00)
            positionentity(arg0\Field25[$07], (local9 - 3.375), (1.0 / -0.64), (local11 - 2.46875), $00)
            entityparent(arg0\Field25[$07], arg0\Field3, $01)
        Case "room2testroom2"
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (local9 - 2.5), 0.5, (local11 - 3.5625), $00)
            entityparent(arg0\Field25[$00], arg0\Field3, $01)
            arg0\Field25[$01] = createpivot($00)
            positionentity(arg0\Field25[$01], (local9 - 2.613281), 0.5, (local11 - (1.0 / 16.0)), $00)
            entityparent(arg0\Field25[$01], arg0\Field3, $01)
            local22 = loadtexture_strict("GFX\map\glass.png", $03)
            arg0\Field25[$02] = createsprite($00)
            entitytexture(arg0\Field25[$02], local22, $00, $00)
            spriteviewmode(arg0\Field25[$02], $02)
            scalesprite(arg0\Field25[$02], (1.0 / 2.813187), 0.375)
            positionentity(arg0\Field25[$02], (local9 - 2.46875), 0.875, (local11 - 0.8125), $00)
            turnentity(arg0\Field25[$02], 0.0, 180.0, 0.0, $00)
            entityparent(arg0\Field25[$02], arg0\Field3, $01)
            hideentity(arg0\Field25[$02])
            freetexture(local22)
            arg0\Field29[$00] = createdoor(local17, (local9 - 0.9375), 0.0, (local11 + 2.5), 90.0, arg0, $00, $00, $01, "")
            arg0\Field29[$00]\Field20 = $00
            arg0\Field29[$00]\Field5 = $00
            local0 = createdoor(local17, (local9 - 2.0), 0.0, (local11 + 1.5), 0.0, arg0, $00, $00, $00, "")
            local0\Field20 = $00
            local0\Field5 = $00
            local6 = createitem("Level 2 Key Card", "key2", (local9 - 3.570312), (local10 + (1.0 / 1.868613)), (local11 + (1.0 / 4.196721)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            If (networkserver\Field12 = $00) Then
                local6 = createitem("S-NAV 300 Navigator", "nav", (local9 - 1.21875), (local10 + 1.03125), (local11 + 0.6875), $00, $00, $00, 1.0, $00, $01)
                local6\Field13 = 20.0
                entityparent(local6\Field2, arg0\Field3, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (local9 - 1.21875), (local10 + 1.03125), (local11 + 0.6875), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
                local6 = createitem("Level 2 Key Card", "key2", (local9 - 3.554688), (local10 + (1.0 / 1.868613)), (local11 + (1.0 / 4.196721)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            EndIf
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (local9 - 3.417507), 0.0, (local11 + 2.496274), -90.0)
        Case "room3tunnel"
            arg0\Field25[$00] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$00], (local9 - (1.0 / 1.347368)), (1.0 / 64.0), (local11 + (1.0 / 1.347368)), $01)
        Case "room2toilets"
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (local9 + 4.0625), 0.75, local11, $00)
            entityparent(arg0\Field25[$00], arg0\Field3, $01)
            arg0\Field25[$01] = createpivot($00)
            positionentity(arg0\Field25[$01], (local9 + 5.976562), 0.5, (local11 + 2.0), $00)
            entityparent(arg0\Field25[$01], arg0\Field3, $01)
            arg0\Field25[$02] = createpivot($00)
            positionentity(arg0\Field25[$02], (local9 + 5.996094), (local10 + (1.0 / 1.706667)), (local11 + 2.0), $00)
            entityparent(arg0\Field25[$02], arg0\Field3, $01)
        Case "room2storage"
            arg0\Field29[$00] = createdoor(local17, (local9 - 5.03125), 0.0, local11, 270.0, arg0, $00, $00, $00, "")
            arg0\Field29[$01] = createdoor(local17, (local9 - 2.96875), 0.0, local11, 270.0, arg0, $00, $00, $00, "")
            arg0\Field29[$02] = createdoor(local17, (local9 - 1.03125), 0.0, local11, 270.0, arg0, $00, $00, $00, "")
            arg0\Field29[$03] = createdoor(local17, (local9 + 1.03125), 0.0, local11, 270.0, arg0, $00, $00, $00, "")
            arg0\Field29[$04] = createdoor(local17, (local9 + 2.96875), 0.0, local11, 270.0, arg0, $00, $00, $00, "")
            arg0\Field29[$05] = createdoor(local17, (local9 + 5.03125), 0.0, local11, 270.0, arg0, $00, $00, $00, "")
            For local7 = $00 To $05 Step $01
                moveentity(arg0\Field29[local7]\Field3[$00], 0.0, 0.0, -8.0)
                moveentity(arg0\Field29[local7]\Field3[$01], 0.0, 0.0, -8.0)
                arg0\Field29[local7]\Field20 = $00
                arg0\Field29[local7]\Field5 = $00
            Next
            local6 = createitem("Document SCP-939", "paper", (local9 + 1.375), (local10 + 0.6875), (local11 + 1.0), $00, $00, $00, 1.0, $00, $01)
            rotateentity(local6\Field2, 0.0, (Float (arg0\Field7 + $04)), 0.0, $00)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Gas Mask", "gasmask", (local9 + 1.375), (local10 + 0.4375), (local11 + 1.75), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            If (networkserver\Field12 = $00) Then
                local6 = createitem("Empty Cup", "emptycup", (local9 - 2.625), 0.9375, (local11 + 1.125), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (local9 - 2.625), 0.9375, (local11 + 1.125), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            EndIf
            local6 = createitem((("Level " + (Str (networkserver\Field12 + $01))) + " Key Card"), ("key" + (Str (networkserver\Field12 + $01))), (local9 - 2.625), (local10 + 0.9375), (local11 + 0.875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
        Case "room2sroom"
            local0 = createdoor(local17, (local9 + 5.625), 0.875, (local11 + 0.125), 90.0, arg0, $00, $00, $04, "")
            local0\Field20 = $00
            local0\Field5 = $00
            local6 = createitem("Some SCP-420-J", "420", (local9 + 6.9375), (local10 + (1.0 / 0.64)), (local11 + 1.667969), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Some SCP-420-J", "420", (local9 + 7.0625), (local10 + (1.0 / 0.64)), (local11 + 1.699219), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Level 5 Key Card", "key5", (local9 + 8.71875), (local10 + 1.53125), (local11 + 1.511719), $00, $00, $00, 1.0, $00, $01)
            rotateentity(local6\Field2, 0.0, (Float arg0\Field7), 0.0, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Nuclear Device Document", "paper", (local9 + 8.78125), (local10 + 1.71875), (local11 + 1.453125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Radio Transceiver", "radio", (local9 + 8.75), (local10 + 1.25), (local11 + 0.5), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
        Case "room2shaft"
            local0 = createdoor(local17, (local9 + 6.0625), local10, (local11 + 2.15625), 0.0, arg0, $00, $00, $00, "")
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (local11 + 2.023438), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (local11 + 2.246094), $01)
            local0\Field20 = $00
            local0\Field5 = $00
            local0 = createdoor(local17, (local9 + 1.0), local10, (local11 + 2.90625), 90.0, arg0, $00, $00, $02, "")
            local0\Field20 = $00
            local0\Field5 = $00
            local6 = createitem("Level 3 Key Card", "key3", (local9 + 4.371094), (local10 + (1.0 / 1.098712)), (local11 + 1.929688), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("First Aid Kit", "firstaid", (local9 + 4.042969), (local10 + (1.0 / 1.765517)), (local11 + 0.21875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            rotateentity(local6\Field2, 0.0, 90.0, 0.0, $00)
            local6 = createitem("9V Battery", "bat", (local9 + 7.539062), (local10 + (1.0 / 2.639175)), (local11 + 1.0), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("9V Battery", "bat", (local9 + 4.144531), (local10 + (1.0 / 1.590062)), (local11 + 1.929688), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("ReVision Eyedrops", "eyedrops", (local9 + 7.539062), (local10 + (1.0 / 1.137778)), (local11 + 0.5), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            arg0\Field25[$00] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$00], (local9 + 6.09375), local10, (local11 + (1.0 / 1.024)), $01)
            arg0\Field25[$01] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$01], (local9 + 5.25), -2.9375, (local11 - 1.5), $01)
            local3 = createdecal($03, (local9 + 5.210938), -3.099375, (local11 - 0.859375), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
            local3\Field2 = 0.25
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityparent(local3\Field0, arg0\Field3, $01)
            arg0\Field25[$02] = createbutton((local9 + 4.613281), (local10 + 0.703125), (local11 - 2.0), 0.0, 270.0, 0.0, $00)
            entityparent(arg0\Field25[$02], arg0\Field3, $01)
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (local9 + 3.235352), (local10 + 0.302), (local11 - 2.375324), 90.0)
        Case "room2poffices"
            local0 = createdoor(local17, (local9 + 0.9375), 0.0, (local11 + 1.75), 90.0, arg0, $00, $00, $00, (Str accesscode))
            positionentity(local0\Field3[$00], (local9 + 0.96875), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (local9 + 0.90625), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0\Field20 = $00
            local0\Field5 = $00
            local0 = createdoor(local17, (local9 - 1.9375), 0.0, local11, 90.0, arg0, $00, $00, $00, "ABCD")
            positionentity(local0\Field3[$00], (local9 - 1.90625), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (local9 - 1.96875), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0\Field20 = $00
            local0\Field5 = $00
            local0\Field4 = $01
            local0 = createdoor(local17, (local9 + 0.9375), 0.0, (local11 - 2.25), 90.0, arg0, $00, $00, $00, "7816")
            positionentity(local0\Field3[$00], (local9 + 0.96875), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (local9 + 0.90625), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0\Field20 = $00
            local0\Field5 = $00
            local6 = createitem("Mysterious Note", "paper", (local9 + 2.875), (local10 + 0.875), (local11 + 2.125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Ballistic Vest", "vest", (local9 + 2.375), (local10 + 0.4375), (local11 + 0.125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            rotateentity(local6\Field2, 0.0, 90.0, 0.0, $00)
            If (networkserver\Field12 = $00) Then
                local6 = createitem("Incident Report SCP-106-0204", "paper", (local9 + 2.75), (local10 + (1.0 / 1.398907)), (local11 - 2.25), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
                local6 = createitem("Journal Page", "paper", (local9 + 3.5625), (local10 + 0.6875), (local11 - 0.625), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            Else
                local6 = createitem("FN P90", "p90", (local9 + 2.75), (local10 + (1.0 / 1.398907)), (local11 - 2.25), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
                local6 = createitem("Rocket Launcher", "rpg", (local9 + 3.5625), (local10 + 0.6875), (local11 - 0.625), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            EndIf
            local6 = createitem("First Aid Kit", "firstaid", (local9 + 3.5625), (local10 + 0.4375), (local11 - 1.3125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            rotateentity(local6\Field2, 0.0, 90.0, 0.0, $00)
        Case "room2poffices2"
            local0 = createdoor(local17, (local9 + 0.9375), 0.0, (local11 + 0.1875), 270.0, arg0, $00, $00, $03, "")
            positionentity(local0\Field3[$00], (local9 + 0.875), entityy(local0\Field3[$00], $01), (local11 + 0.6875), $01)
            positionentity(local0\Field3[$01], (local9 + 1.0), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0\Field20 = $00
            local0\Field5 = $00
            arg0\Field29[$00] = createdoor(local17, (local9 - 1.6875), 0.0, local11, 90.0, arg0, $00, $00, $00, "1234")
            positionentity(arg0\Field29[$00]\Field3[$00], (local9 - 1.625), entityy(arg0\Field29[$00]\Field3[$00], $01), (local11 + 0.6875), $01)
            freeentity(arg0\Field29[$00]\Field3[$01])
            arg0\Field29[$00]\Field3[$01] = $00
            arg0\Field29[$00]\Field20 = $00
            arg0\Field29[$00]\Field5 = $00
            arg0\Field29[$00]\Field4 = $01
            local3 = createdecal($00, (local9 - 3.15625), 0.005, (local11 - 0.28125), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
            entityparent(local3\Field0, arg0\Field3, $01)
            local3 = createdecal($02, (local9 - 3.15625), 0.01, (local11 - 0.28125), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
            local3\Field2 = 0.3
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityparent(local3\Field0, arg0\Field3, $01)
            local3 = createdecal($00, (local9 - 1.6875), 0.01, local11, 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
            entityparent(local3\Field0, arg0\Field3, $01)
            arg0\Field25[$00] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$00], (local9 - 3.15625), 1.0, (local11 - 0.28125), $01)
            If (networkserver\Field12 = $00) Then
                local6 = createitem("Dr. L's Burnt Note", "paper", (local9 - 2.6875), 1.0, (local11 - (1.0 / 16.0)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
                local6 = createitem("Dr L's Burnt Note", "paper", (local9 - 3.15625), 1.0, (local11 - 0.28125), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            Else
                local6 = createitem("FN P90", "p90", (local9 - 2.6875), 1.0, (local11 - (1.0 / 16.0)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
                local6 = createitem("Rocket Launcher", "rpg", (local9 - 3.15625), 1.0, (local11 - 0.28125), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            EndIf
            local6 = createitem("The Modular Site Project", "paper", (local9 + 2.429688), (local10 + (1.0 / 2.048)), (local11 - (1.0 / 3.506849)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
        Case "room2elevator"
            arg0\Field25[$00] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$00], (local9 + 3.46875), 0.9375, local11, $01)
            arg0\Field25[$01] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$01], ((local9 + 4.0) - 0.01), 0.46875, local11, $01)
            arg0\Field29[$00] = createdoor(local17, (local9 + 1.75), 0.0, local11, 90.0, arg0, $00, $03, $00, "")
            positionentity(arg0\Field29[$00]\Field3[$01], (local9 + 1.625), entityy(arg0\Field29[$00]\Field3[$01], $01), (local11 - 0.8125), $01)
            positionentity(arg0\Field29[$00]\Field3[$00], (local9 + 1.875), entityy(arg0\Field29[$00]\Field3[$00], $01), (local11 + 0.71875), $01)
            arg0\Field29[$00]\Field20 = $00
            arg0\Field29[$00]\Field5 = $01
            arg0\Field29[$00]\Field4 = $01
        Case "room2cafeteria"
            arg0\Field25[$00] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$00], (local9 + 7.214844), -0.9375, (local11 - 1.253906), $01)
            arg0\Field25[$01] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$01], (local9 + 6.953125), -0.96875, (local11 - 1.078125), $01)
            local6 = createitem("cup", "cup", (local9 - 1.984375), (1.0 / -1.368984), (local11 + 1.109375), $F0, $AF, $46, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6\Field0 = "Cup of Orange Juice"
            local6 = createitem("cup", "cup", (local9 + 5.515625), (1.0 / -1.368984), (local11 - 2.796875), $57, $3E, $2D, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6\Field0 = "Cup of Coffee"
            If (networkserver\Field12 = $00) Then
                local6 = createitem("Empty Cup", "emptycup", (local9 - 2.109375), (1.0 / -1.368984), (local11 + 0.484375), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (local9 - 2.109375), (1.0 / -1.368984), (local11 + 0.484375), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            EndIf
            local6 = createitem("Quarter", "25ct", (local9 - 1.746094), (local10 - 1.304688), (local11 + 0.140625), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Quarter", "25ct", (local9 + 5.503906), (local10 - 1.304688), (local11 - 2.859375), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (local9 - 2.255336), (local10 - 1.5), (local11 - 3.152867), -25.0)
        Case "room2nuke"
            local0 = createdoor(local17, (local9 + 2.25), 0.0, (local11 + 0.59375), 90.0, arg0, $00, $00, $05, "")
            local0\Field20 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], (local9 + 2.351562), entityy(local0\Field3[$00], $01), (local11 + (1.0 / 12.8)), $01)
            positionentity(local0\Field3[$01], (local9 + 2.148438), entityy(local0\Field3[$01], $01), (local11 + (1.0 / 12.8)), $01)
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(local17, (local9 - 2.125), 5.875, (local11 + 2.882812), 90.0, arg0, $00, $00, $05, "")
            local0\Field20 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (local11 + 2.375), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (local11 + 2.375), $01)
            arg0\Field29[$00] = createdoor(local17, (local9 + 4.65625), 0.0, local11, 90.0, arg0, $01, $03, $00, "")
            arg0\Field29[$00]\Field20 = $00
            arg0\Field29[$00]\Field5 = $01
            arg0\Field25[$04] = createpivot($00)
            positionentity(arg0\Field25[$04], (local9 + 5.84375), 0.9375, local11, $00)
            entityparent(arg0\Field25[$04], arg0\Field3, $01)
            arg0\Field29[$01] = createdoor(local17, (local9 + 2.65625), 5.875, local11, 90.0, arg0, $00, $03, $00, "")
            arg0\Field29[$01]\Field20 = $00
            arg0\Field29[$01]\Field5 = $00
            arg0\Field25[$05] = createpivot($00)
            positionentity(arg0\Field25[$05], (local9 + 3.84375), 6.8125, local11, $00)
            entityparent(arg0\Field25[$05], arg0\Field3, $01)
            For local23 = $00 To $01 Step $01
                arg0\Field25[(local23 Shl $01)] = copyentity(leverbaseobj, $00)
                arg0\Field25[((local23 Shl $01) + $01)] = copyentity(leverobj, $00)
                arg0\Field28[local23] = arg0\Field25[((local23 Shl $01) + $01)]
                For local7 = $00 To $01 Step $01
                    scaleentity(arg0\Field25[((local23 Shl $01) + local7)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field25[((local23 Shl $01) + local7)], (local9 - 3.808594), (local10 + 6.6875), (local11 - ((502.0 - (132.0 * (Float local23))) * (1.0 / 256.0))), $01)
                    entityparent(arg0\Field25[((local23 Shl $01) + local7)], arg0\Field3, $01)
                Next
                rotateentity(arg0\Field25[(local23 Shl $01)], 0.0, -270.0, 0.0, $00)
                rotateentity(arg0\Field25[((local23 Shl $01) + $01)], 10.0, -450.0, 0.0, $00)
                entityradius(arg0\Field25[((local23 Shl $01) + $01)], 0.1, 0.0)
                addentitytoroomprops(arg0, arg0\Field25[(local23 Shl $01)])
                addentitytoroomprops(arg0, arg0\Field25[((local23 Shl $01) + $01)])
            Next
            local6 = createitem("Nuclear Device Document", "paper", (local9 - 3.0), (local10 + 6.578125), (local11 - 3.0), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Ballistic Vest", "vest", (local9 - 3.6875), (local10 + 6.453125), (local11 - 2.5625), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            rotateentity(local6\Field2, 0.0, -90.0, 0.0, $00)
            local2 = createsecuritycam((local9 + 2.4375), (local10 + 7.375), (local11 - 1.21875), arg0, $00)
            local2\Field11 = 90.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            arg0\Field25[$06] = createpivot($00)
            positionentity(arg0\Field25[$06], (local9 + 4.335938), (local10 + 0.140625), (local11 - 0.8125), $00)
            entityparent(arg0\Field25[$06], arg0\Field3, $01)
        Case "room2tunnel"
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (local9 + 10.3125), -9.75, (local11 + (1.0 / 0.64)), $00)
            entityparent(arg0\Field25[$00], arg0\Field3, $01)
            arg0\Field25[$01] = createpivot($00)
            positionentity(arg0\Field25[$01], (local9 - 16.9375), -9.75, (local11 - 9.8125), $00)
            entityparent(arg0\Field25[$01], arg0\Field3, $01)
            arg0\Field25[$02] = createpivot($00)
            rotateentity(arg0\Field25[$02], 0.0, 180.0, 0.0, $01)
            positionentity(arg0\Field25[$02], (local9 + 2.15625), 0.9375, (local11 + 2.5625), $00)
            entityparent(arg0\Field25[$02], arg0\Field3, $01)
            arg0\Field25[$04] = createpivot($00)
            positionentity(arg0\Field25[$04], (local9 - 2.15625), 0.9375, (local11 - 2.5625), $00)
            entityparent(arg0\Field25[$04], arg0\Field3, $01)
            arg0\Field29[$00] = createdoor(local17, (local9 + 1.03125), 0.0, (local11 + 2.5625), 90.0, arg0, $01, $03, $00, "")
            arg0\Field29[$00]\Field20 = $00
            arg0\Field29[$00]\Field5 = $01
            positionentity(arg0\Field29[$00]\Field3[$01], (local9 + 0.875), 0.7, (local11 + 1.875), $01)
            positionentity(arg0\Field29[$00]\Field3[$00], (local9 + 1.1875), 0.7, (local11 + 3.25), $01)
            arg0\Field29[$02] = createdoor(local17, (local9 - 1.03125), 0.0, (local11 - 2.5625), 90.0, arg0, $01, $03, $00, "")
            arg0\Field29[$02]\Field20 = $00
            arg0\Field29[$02]\Field5 = $01
            positionentity(arg0\Field29[$02]\Field3[$00], (local9 - 0.875), 0.7, (local11 - 1.875), $01)
            positionentity(arg0\Field29[$02]\Field3[$01], (local9 - 1.1875), 0.7, (local11 - 3.25), $01)
            local24 = ((accesscode * $03) Mod $2710)
            If (local24 < $3E8) Then
                local24 = (local24 + $3E8)
            EndIf
            local0 = createdoor($00, local9, local10, local11, 0.0, arg0, $00, $01, $00, (Str local24))
            positionentity(local0\Field3[$00], (local9 + 0.875), (local10 + 0.7), (local11 - 1.5), $01)
            rotateentity(local0\Field3[$00], 0.0, -90.0, 0.0, $01)
            positionentity(local0\Field3[$01], (local9 - 0.875), (local10 + 0.7), (local11 + 1.5), $01)
            rotateentity(local0\Field3[$01], 0.0, 90.0, 0.0, $01)
            local3 = createdecal($00, (local9 + 0.25), 0.005, (local11 + 0.5625), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
            entityparent(local3\Field0, arg0\Field3, $01)
            local6 = createitem("Gas Mask", "gasmask", (local9 + 0.25), (local10 + 0.5625), (local11 + 0.5), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Scorched Note", "paper", (local9 + 0.25), (local10 + 0.5625), (local11 - 1.5), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
        Case "008"
            arg0\Field25[$00] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$00], (local9 + 1.140625), (1.0 / 1.969231), (local11 + 2.015625), $01)
            arg0\Field25[$01] = loadmesh_strict("GFX\map\008_2.b3d", $00)
            scaleentity(arg0\Field25[$01], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field25[$01], (local9 + 1.140625), (1.0 / 1.695364), (local11 + 2.25), $00)
            entityparent(arg0\Field25[$01], arg0\Field3, $01)
            addentitytoroomprops(arg0, arg0\Field25[$01])
            rotateentity(arg0\Field25[$01], 89.0, 0.0, 0.0, $01)
            arg0\Field28[$00] = arg0\Field25[$01]
            local22 = loadtexture_strict("GFX\map\glass.png", $03)
            arg0\Field25[$02] = createsprite($00)
            entitytexture(arg0\Field25[$02], local22, $00, $00)
            spriteviewmode(arg0\Field25[$02], $02)
            scalesprite(arg0\Field25[$02], 0.5, (1.0 / 2.639175))
            positionentity(arg0\Field25[$02], (local9 - 0.6875), 0.875, (local11 + 1.75), $00)
            turnentity(arg0\Field25[$02], 0.0, 90.0, 0.0, $00)
            entityparent(arg0\Field25[$02], arg0\Field3, $01)
            freetexture(local22)
            arg0\Field25[$03] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$03], (local9 - 1.738281), 0.46875, (local11 + 2.125), $01)
            arg0\Field25[$04] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$04], (local9 + (1.0 / 3.820895)), 0.46875, (local11 + 1.8125), $01)
            arg0\Field25[$05] = createsprite($00)
            positionentity(arg0\Field25[$05], (local9 - (1.0 / 1.620253)), 1.4375, (local11 + 1.164062), $00)
            scalesprite(arg0\Field25[$05], 0.02, 0.02)
            entitytexture(arg0\Field25[$05], lightspritetex($01), $00, $00)
            entityblend(arg0\Field25[$05], $03)
            entityparent(arg0\Field25[$05], arg0\Field3, $01)
            hideentity(arg0\Field25[$05])
            local0 = createdoor(local17, (local9 + 1.15625), 0.0, (local11 - 2.625), 180.0, arg0, $01, $00, $04, "")
            local0\Field20 = $00
            positionentity(local0\Field3[$01], (local9 + 0.640625), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            arg0\Field29[$00] = local0
            local1 = createdoor(local17, (local9 + 1.15625), 0.0, (local11 - 0.5625), 0.0, arg0, $00, $00, $00, "")
            local1\Field20 = $00
            positionentity(local1\Field3[$00], (local9 + 1.6875), entityy(local1\Field3[$00], $01), (local11 - 1.875), $01)
            rotateentity(local1\Field3[$00], 0.0, -90.0, 0.0, $01)
            positionentity(local1\Field3[$01], (local9 + 0.640625), entityy(local1\Field3[$00], $01), (local11 - 0.5), $01)
            freeentity(local1\Field1)
            local1\Field1 = $00
            arg0\Field29[$01] = local1
            local0\Field21 = local1
            local1\Field21 = local0
            local0 = createdoor(local17, (local9 - 1.5), 0.0, (local11 - 2.625), 0.0, arg0, $00, $00, $04, "")
            local0\Field20 = $00
            local0\Field4 = $01
            arg0\Field29[$02] = local0
            local6 = createitem("Hazmat Suit", "hazmatsuit", (local9 - 0.296875), 0.5, (local11 - 1.546875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            rotateentity(local6\Field2, 0.0, 90.0, 0.0, $00)
            If (networkserver\Field12 = $00) Then
                local6 = createitem("Document SCP-008", "paper", (local9 - (1.0 / 1.044898)), (local10 + 0.75), (local11 + 1.4375), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (local9 - (1.0 / 1.044898)), (local10 + 0.75), (local11 + 1.4375), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            EndIf
            arg0\Field25[$06] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$06], (local9 + 0.625), 2.625, (local11 - 1.5), $01)
            arg0\Field25[$07] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$07], local9, 2.625, (local11 + 1.375), $01)
            local2 = createsecuritycam((local9 + 2.261547), (local10 + 1.738109), (local11 + 3.015625), arg0, $00)
            local2\Field11 = 135.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room035"
            local0 = createdoor(local17, (local9 - 1.15625), 0.0, (local11 - 2.625), 180.0, arg0, $01, $00, $05, "")
            local0\Field20 = $00
            local0\Field4 = $01
            arg0\Field29[$00] = local0
            positionentity(local0\Field3[$01], (local9 - 0.640625), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local1 = createdoor(local17, (local9 - 1.15625), 0.0, (local11 - 0.5625), 0.0, arg0, $00, $00, $00, "")
            local1\Field20 = $00
            local1\Field4 = $01
            arg0\Field29[$01] = local1
            positionentity(local1\Field3[$00], (local9 - 1.6875), entityy(local1\Field3[$00], $01), (local11 - 1.875), $01)
            rotateentity(local1\Field3[$00], 0.0, 90.0, 0.0, $01)
            freeentity(local1\Field3[$01])
            local1\Field3[$01] = $00
            freeentity(local1\Field1)
            local1\Field1 = $00
            arg0\Field29[$02] = createdoor(local17, (local9 + 1.5), 0.0, (local11 - 2.625), 180.0, arg0, $00, $00, $05, "")
            arg0\Field29[$02]\Field20 = $00
            arg0\Field29[$03] = createdoor($00, (local9 + 3.0), 0.0, (local11 + 2.0), 90.0, arg0, $00, $00, $00, "5731")
            arg0\Field29[$03]\Field20 = $00
            local0\Field21 = local1
            local1\Field21 = local0
            For local7 = $00 To $01 Step $01
                arg0\Field25[(local7 Shl $01)] = copyentity(leverbaseobj, $00)
                arg0\Field25[((local7 Shl $01) + $01)] = copyentity(leverobj, $00)
                arg0\Field28[local7] = arg0\Field25[((local7 Shl $01) + $01)]
                For local23 = $00 To $01 Step $01
                    scaleentity(arg0\Field25[((local7 Shl $01) + local23)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field25[((local7 Shl $01) + local23)], (local9 + (1.0 / 1.219048)), (local10 + 0.875), (local11 - ((Float ($D0 - (local7 * $4C))) * (1.0 / 256.0))), $01)
                    entityparent(arg0\Field25[((local7 Shl $01) + local23)], arg0\Field3, $01)
                Next
                rotateentity(arg0\Field25[(local7 Shl $01)], 0.0, -270.0, 0.0, $00)
                rotateentity(arg0\Field25[((local7 Shl $01) + $01)], -80.0, -90.0, 0.0, $00)
                entityradius(arg0\Field25[((local7 Shl $01) + $01)], 0.1, 0.0)
                addentitytoroomprops(arg0, arg0\Field25[(local7 Shl $01)])
                addentitytoroomprops(arg0, arg0\Field25[((local7 Shl $01) + $01)])
            Next
            arg0\Field25[$03] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$03], (local9 + 1.78125), 0.5, (local11 + (1.0 / 0.64)), $01)
            arg0\Field25[$04] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$04], (local9 - 2.25), 0.5, (local11 + 2.5), $01)
            For local7 = $00 To $01 Step $01
                local19 = createemitter((local9 - 1.0625), 10.0, (((624.0 - (Float (local7 Shl $09))) * (1.0 / 256.0)) + local11), $00, 0.0, 0.0, 0.0, 0.0)
                turnentity(local19\Field0, 90.0, 0.0, 0.0, $01)
                entityparent(local19\Field0, arg0\Field3, $01)
                local19\Field14 = 15.0
                local19\Field13 = 0.05
                local19\Field15 = 0.007
                local19\Field16 = -0.006
                local19\Field4 = -0.24
                arg0\Field25[($05 + local7)] = local19\Field0
            Next
            arg0\Field25[$07] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$07], (local9 - 2.8125), 0.5, (local11 + 3.4375), $01)
            arg0\Field25[$08] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$08], (local9 + 0.6875), 0.5, (local11 - 0.5625), $01)
            local6 = createitem("SCP-035 Addendum", "paper", (local9 + 0.96875), (local10 + 0.859375), (local11 + 2.25), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            If (networkserver\Field12 = $00) Then
                local6 = createitem("Radio Transceiver", "radio", (local9 - 2.125), 0.5, (local11 + 2.75), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (local9 - 2.125), 0.5, (local11 + 2.75), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            EndIf
            local6 = createitem("SCP-500-01", "scp500", (local9 + 4.5625), 0.875, (local11 + 2.25), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Metal Panel", "scp148", (local9 - 1.40625), 0.5, (local11 + 2.515625), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Document SCP-035", "paper", (local9 + 4.5625), 0.40625, (local11 + 2.375), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
        Case "room513"
            local0 = createdoor(local17, (local9 - 2.75), 0.0, (local11 + 1.1875), 0.0, arg0, $00, $00, $02, "")
            local0\Field20 = $00
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (local11 + 1.125), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (local11 + 1.25), $01)
            local2 = createsecuritycam((local9 - 1.21875), (local10 + 1.617188), (local11 + 2.5625), arg0, $00)
            local2\Field21 = $01
            local6 = createitem("SCP-513", "scp513", (local9 - 0.234375), (local10 + 0.765625), (local11 + 2.6875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Blood-stained Note", "paper", (local9 + 2.875), 1.0, (local11 + 0.1875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Document SCP-513", "paper", (local9 - 1.875), 0.40625, (local11 - 0.6875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            If ((rand($00, $01) And networkserver\Field12) <> 0) Then
                local6 = createitem("SCP-035", "scp035", (local9 - 2.34375), (local10 + 0.765625), (local11 + 2.6875), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            EndIf
        Case "room966"
            local0 = createdoor(local17, (local9 - (1.0 / 0.64)), 0.0, local11, -90.0, arg0, $00, $00, $03, "")
            local0 = createdoor(local17, local9, 0.0, (local11 - 1.875), 180.0, arg0, $00, $00, $03, "")
            local2 = createsecuritycam((local9 - 1.21875), (local10 + 1.757812), (local11 + 2.5625), arg0, $01)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            positionentity(local2\Field4, (local9 - 1.375), (local10 + 0.6875), (local11 - 1.4375), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field3, $01)
            arg0\Field25[$00] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$00], local9, 0.5, (local11 + 2.0), $01)
            arg0\Field25[$01] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$01], (local9 + 0.25), 0.5, (local11 - 2.5), $01)
            arg0\Field25[$02] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$02], local9, 0.5, local11, $01)
            arg0\Field25[$03] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$03], (local9 + 1.25), 0.5, (local11 + 2.75), $01)
            local6 = createitem("Night Vision Goggles", "nvgoggles", (local9 + 1.25), 0.5, (local11 + 2.75), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6\Field13 = 300.0
        Case "room3storage"
            arg0\Field25[$00] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$00], local9, 0.9375, (local11 + 2.9375), $01)
            arg0\Field25[$01] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$01], (local9 + 22.8125), -21.0625, (local11 + 5.3125), $01)
            arg0\Field25[$02] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$02], (local9 + 2.375), 0.9375, (local11 - 2.4375), $01)
            arg0\Field25[$03] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$03], (local9 - 1.78125), -21.0625, (local11 - 4.4375), $01)
            arg0\Field25[$04] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$04], (local9 + 8.3125), -21.67969, (local11 + 8.0), $01)
            arg0\Field25[$05] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$05], (local9 + 8.3125), -21.67969, (local11 - 4.4375), $01)
            arg0\Field25[$06] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$06], (local9 + 14.9375), -21.67969, (local11 - 4.5625), $01)
            arg0\Field25[$07] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$07], (local9 + 14.6875), -21.67969, (local11 + 8.0), $01)
            arg0\Field25[$08] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$08], (local9 + 18.9375), -21.67969, (local11 + 0.4375), $01)
            arg0\Field25[$09] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$09], (local9 + 2.3125), -21.67969, (local11 + 24.8125), $01)
            arg0\Field25[$0A] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$0A], (local9 + 11.4375), -21.67969, (local11 + 24.8125), $01)
            arg0\Field25[$0B] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$0B], (local9 + 11.4375), -21.67969, (local11 + 20.3125), $01)
            arg0\Field25[$0C] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$0C], (local9 + 2.3125), -21.67969, (local11 + 20.3125), $01)
            arg0\Field25[$0D] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$0D], (local9 + 4.4375), -21.67969, (local11 + 11.5), $01)
            arg0\Field25[$0E] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$0E], (local9 + 4.3125), -21.67969, (local11 + 4.625), $01)
            arg0\Field25[$0F] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$0F], (local9 - 1.8125), -21.67969, (local11 + 4.75), $01)
            arg0\Field25[$10] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$10], (local9 - 1.6875), -21.67969, (local11 + 11.625), $01)
            arg0\Field25[$14] = loadmesh_strict("GFX\map\room3storage_hb.b3d", arg0\Field3)
            entitypickmode(arg0\Field25[$14], $02, $01)
            entitytype(arg0\Field25[$14], $01, $00)
            entityalpha(arg0\Field25[$14], 0.0)
            arg0\Field29[$00] = createdoor(local17, local9, 0.0, (local11 + 1.75), 0.0, arg0, $01, $03, $00, "")
            arg0\Field29[$00]\Field20 = $00
            arg0\Field29[$00]\Field5 = $01
            positionentity(arg0\Field29[$00]\Field3[$01], (local9 - 0.625), 0.7, (local11 + 1.875), $01)
            positionentity(arg0\Field29[$00]\Field3[$00], (local9 + 0.625), 0.7, (local11 + 1.625), $01)
            arg0\Field29[$01] = createdoor(local17, (local9 + 22.8125), -22.0, (local11 + 4.09375), 0.0, arg0, $00, $03, $00, "")
            arg0\Field29[$01]\Field20 = $00
            arg0\Field29[$01]\Field5 = $00
            positionentity(arg0\Field29[$01]\Field3[$00], (local9 + 23.4375), entityy(arg0\Field29[$01]\Field3[$00], $01), (local11 + 3.9375), $01)
            positionentity(arg0\Field29[$01]\Field3[$01], (local9 + 22.1875), entityy(arg0\Field29[$01]\Field3[$01], $01), (local11 + 4.25), $01)
            arg0\Field29[$02] = createdoor(local17, (local9 + 2.375), 0.0, (local11 - 1.21875), 0.0, arg0, $01, $03, $00, "")
            arg0\Field29[$02]\Field20 = $00
            arg0\Field29[$02]\Field5 = $01
            positionentity(arg0\Field29[$02]\Field3[$01], (local9 + 1.75), 0.7, (local11 - 1.0625), $01)
            positionentity(arg0\Field29[$02]\Field3[$00], (local9 + 3.0), 0.7, (local11 - 1.375), $01)
            arg0\Field29[$03] = createdoor(local17, (local9 - 1.78125), -22.0, (local11 - 3.21875), 0.0, arg0, $00, $03, $00, "")
            arg0\Field29[$03]\Field20 = $00
            arg0\Field29[$03]\Field5 = $00
            positionentity(arg0\Field29[$03]\Field3[$00], (local9 - 1.09375), entityy(arg0\Field29[$03]\Field3[$00], $01), (local11 - 3.375), $01)
            positionentity(arg0\Field29[$03]\Field3[$01], (local9 - 2.46875), entityy(arg0\Field29[$03]\Field3[$01], $01), (local11 - 3.0625), $01)
            local19 = createemitter((local9 + 20.38281), -21.8125, (local11 - 2.34375), $00, 0.0, 0.0, 0.0, 0.0)
            turnentity(local19\Field0, 20.0, -100.0, 0.0, $01)
            entityparent(local19\Field0, arg0\Field3, $01)
            local19\Field8 = arg0
            local19\Field14 = 15.0
            local19\Field13 = 0.03
            local19\Field15 = 0.01
            local19\Field16 = -0.006
            local19\Field4 = -0.2
            Select rand($03, $01)
                Case $01
                    local26 = 2312.0
                    local27 = -952.0
                Case $02
                    local26 = 3032.0
                    local27 = 1288.0
                Case $03
                    local26 = 2824.0
                    local27 = 2808.0
            End Select
            local6 = createitem("Black Severed Hand", "hand2", ((local26 * (1.0 / 256.0)) + local9), -20.85938, ((local27 * (1.0 / 256.0)) + local11), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Night Vision Goggles", "nvgoggles", (local9 + 7.5625), (local10 - 21.46875), (local11 - 3.6875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6\Field13 = 450.0
            local3 = createdecal($03, ((local26 * (1.0 / 256.0)) + local9), -21.99, ((local27 * (1.0 / 256.0)) + local11), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
            local3\Field2 = 0.5
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityparent(local3\Field0, arg0\Field3, $01)
            For local23 = $0A To $0B Step $01
                arg0\Field25[(local23 Shl $01)] = copyentity(leverbaseobj, $00)
                arg0\Field25[((local23 Shl $01) + $01)] = copyentity(leverobj, $00)
                arg0\Field28[(local23 - $0A)] = arg0\Field25[((local23 Shl $01) + $01)]
                For local7 = $00 To $01 Step $01
                    scaleentity(arg0\Field25[((local23 Shl $01) + local7)], 0.04, 0.04, 0.04, $00)
                    If (local23 = $0A) Then
                        positionentity(arg0\Field25[((local23 Shl $01) + local7)], (local9 + 12.11328), (local10 - 21.33203), (local11 + 25.65625), $01)
                    Else
                        positionentity(arg0\Field25[((local23 Shl $01) + local7)], (local9 + 4.722656), (local10 - 21.33203), (local11 + 12.35938), $01)
                    EndIf
                    entityparent(arg0\Field25[((local23 Shl $01) + local7)], arg0\Field3, $01)
                Next
                rotateentity(arg0\Field25[(local23 Shl $01)], 0.0, 0.0, 0.0, $00)
                rotateentity(arg0\Field25[((local23 Shl $01) + $01)], -10.0, -180.0, 0.0, $00)
                entityradius(arg0\Field25[((local23 Shl $01) + $01)], 0.1, 0.0)
                addentitytoroomprops(arg0, arg0\Field25[(local23 Shl $01)])
                addentitytoroomprops(arg0, arg0\Field25[((local23 Shl $01) + $01)])
            Next
            arg0\Field29[$04] = createdoor(local17, (local9 + 0.21875), (local10 - 22.0), (local11 + 24.78125), 90.0, arg0, $00, $02, $00, "")
            arg0\Field29[$04]\Field20 = $00
            arg0\Field29[$04]\Field5 = $00
            For local7 = $00 To $01 Step $01
                freeentity(arg0\Field29[$04]\Field3[local7])
                arg0\Field29[$04]\Field3[local7] = $00
            Next
            local0 = createdoor(local17, (local9 + 4.519531), (local10 - 22.0), (local11 + 2.578125), 0.0, arg0, $00, $02, $00, "")
            local0\Field4 = $01
            local0\Field5 = $00
            local0\Field20 = $00
            For local7 = $00 To $01 Step $01
                freeentity(local0\Field3[local7])
                local0\Field3[local7] = $00
            Next
            local0 = createdoor(local17, (local9 + (1.0 / 1.094017)), (local10 - 22.0), (local11 + 20.46484), 90.0, arg0, $00, $02, $00, "")
            local0\Field4 = $01
            local0\Field5 = $00
            local0\Field20 = $00
            For local7 = $00 To $01 Step $01
                freeentity(local0\Field3[local7])
                local0\Field3[local7] = $00
            Next
            local0 = createdoor(local17, (local9 + 13.46094), (local10 - 22.0), (local11 + 24.87891), 90.0, arg0, $00, $02, $00, "")
            local0\Field4 = $01
            local0\Field5 = $00
            local0\Field20 = $00
            For local7 = $00 To $01 Step $01
                freeentity(local0\Field3[local7])
                local0\Field3[local7] = $00
            Next
        Case "room049"
            arg0\Field25[$00] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$00], (local9 + 2.5), 0.9375, (local11 + 2.5625), $01)
            arg0\Field25[$01] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$01], (local9 + 12.54297), -12.8125, (local11 + 7.125), $01)
            arg0\Field25[$02] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$02], (local9 - 2.625), 0.9375, (local11 - (1.0 / 2.752688)), $01)
            arg0\Field25[$03] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$03], (local9 - 10.80469), -12.8125, (local11 - 4.988281), $01)
            arg0\Field25[$04] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$04], (local9 + 2.0625), -13.4375, (local11 + 0.375), $01)
            arg0\Field25[$05] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$05], (local9 + 0.25), -13.4375, (local11 - (1.0 / 0.256)), $01)
            For local23 = $00 To $01 Step $01
                arg0\Field25[((local23 Shl $01) + $06)] = copyentity(leverbaseobj, $00)
                arg0\Field25[((local23 Shl $01) + $07)] = copyentity(leverobj, $00)
                arg0\Field28[local23] = arg0\Field25[((local23 Shl $01) + $07)]
                For local7 = $00 To $01 Step $01
                    scaleentity(arg0\Field25[(((local23 Shl $01) + $06) + local7)], 0.03, 0.03, 0.03, $00)
                    Select local23
                        Case $00
                            positionentity(arg0\Field25[(((local23 Shl $01) + $06) + local7)], (local9 + 3.328125), (local10 - 13.17969), (local11 - 3.335938), $01)
                        Case $01
                            positionentity(arg0\Field25[(((local23 Shl $01) + $06) + local7)], (local9 - 3.257812), (local10 - 13.28125), (local11 + 4.269531), $01)
                    End Select
                    entityparent(arg0\Field25[(((local23 Shl $01) + $06) + local7)], arg0\Field3, $01)
                Next
                rotateentity(arg0\Field25[((local23 Shl $01) + $06)], 0.0, (Float (((local23 = $00) * $5A) + $B4)), 0.0, $00)
                rotateentity(arg0\Field25[((local23 Shl $01) + $07)], (Float ($51 - ($5C * local23))), (Float ((local23 = $00) * $5A)), 0.0, $00)
                entityradius(arg0\Field25[((local23 Shl $01) + $07)], 0.1, 0.0)
                addentitytoroomprops(arg0, arg0\Field25[((local23 Shl $01) + $06)])
                addentitytoroomprops(arg0, arg0\Field25[((local23 Shl $01) + $07)])
            Next
            arg0\Field29[$00] = createdoor(local17, (local9 + 1.289062), 0.0, (local11 + 2.5625), 90.0, arg0, $01, $03, $00, "")
            arg0\Field29[$00]\Field20 = $00
            arg0\Field29[$00]\Field5 = $01
            positionentity(arg0\Field29[$00]\Field3[$01], (local9 + 1.125), 0.7, (local11 + 2.0), $01)
            positionentity(arg0\Field29[$00]\Field3[$00], (local9 + 1.4375), 0.7, (local11 + 3.28125), $01)
            arg0\Field29[$01] = createdoor(local17, (local9 + 11.32031), -13.75, (local11 + 7.125), 90.0, arg0, $00, $03, $00, "")
            arg0\Field29[$01]\Field20 = $00
            arg0\Field29[$01]\Field5 = $00
            positionentity(arg0\Field29[$01]\Field3[$01], (local9 + 11.25391), entityy(arg0\Field29[$01]\Field3[$01], $01), (local11 + 6.496094), $01)
            positionentity(arg0\Field29[$01]\Field3[$00], (local9 + 11.46875), entityy(arg0\Field29[$01]\Field3[$00], $01), (local11 + 7.847656), $01)
            arg0\Field29[$02] = createdoor(local17, (local9 - 2.625), 0.0, (local11 - 1.59375), 0.0, arg0, $01, $03, $00, "")
            arg0\Field29[$02]\Field20 = $00
            arg0\Field29[$02]\Field5 = $01
            positionentity(arg0\Field29[$02]\Field3[$00], (local9 - 1.902344), 0.7, (local11 - 1.746094), $01)
            positionentity(arg0\Field29[$02]\Field3[$01], (local9 - 3.347656), 0.7, (local11 - 1.441406), $01)
            arg0\Field29[$03] = createdoor(local17, (local9 - 10.80469), -13.75, (local11 - 6.21875), 0.0, arg0, $00, $03, $00, "")
            arg0\Field29[$03]\Field20 = $00
            arg0\Field29[$03]\Field5 = $00
            positionentity(arg0\Field29[$03]\Field3[$00], (local9 - 10.08203), entityy(arg0\Field29[$03]\Field3[$00], $01), (local11 - 6.371094), $01)
            positionentity(arg0\Field29[$03]\Field3[$01], (local9 - 11.52734), entityy(arg0\Field29[$03]\Field3[$01], $01), (local11 - 6.066406), $01)
            arg0\Field29[$04] = createdoor(local17, (local9 + 1.0625), -13.875, (local11 + 0.40625), 90.0, arg0, $00, $00, $00, "")
            arg0\Field29[$04]\Field20 = $00
            arg0\Field29[$04]\Field5 = $01
            arg0\Field29[$04]\Field4 = $01
            arg0\Field29[$05] = createdoor(local17, (local9 + 1.03125), -13.75, (local11 - 7.125), 90.0, arg0, $00, $00, $00, "")
            arg0\Field29[$05]\Field20 = $00
            arg0\Field29[$05]\Field5 = $01
            arg0\Field29[$05]\Field4 = $01
            arg0\Field29[$06] = createdoor(local17, (local9 - 1.03125), -13.75, (local11 + 7.125), 90.0, arg0, $00, $00, $00, "")
            arg0\Field29[$06]\Field20 = $00
            arg0\Field29[$06]\Field5 = $01
            arg0\Field29[$06]\Field4 = $01
            local0 = createdoor($00, local9, 0.0, local11, 0.0, arg0, $00, $02, $FFFFFFFE, "")
            local6 = createitem("Document SCP-049", "paper", (local9 - 2.375), (local10 - 13.01562), (local11 + 3.421875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Level 4 Key Card", "key4", (local9 - 2.0), (local10 - 13.32812), (local11 + 3.375), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("First Aid Kit", "firstaid", (local9 + 1.503906), (local10 - 13.32812), (local11 + 1.058594), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local0 = createdoor(local17, (local9 - 1.0625), (local10 - 13.875), (local11 + (1.0 / 2.612245)), 90.0, arg0, $01, $01, $00, "")
            local0\Field20 = $00
            local0\Field5 = $01
            local0\Field23 = $00
            local0\Field4 = $01
            For local7 = $00 To $01 Step $01
                freeentity(local0\Field3[local7])
                local0\Field3[local7] = $00
            Next
            local0 = createdoor(local17, (local9 - 11.67969), (local10 - 13.75), (local11 - 7.125), 90.0, arg0, $00, $02, $00, "")
            local0\Field4 = $01
            local0\Field14 = $01
            local0 = createdoor(local17, (local9 - 3.5), local10, (local11 - 2.5), 90.0, arg0, $00, $02, $00, "")
            local0\Field4 = $01
            local0\Field14 = $01
            arg0\Field25[$0A] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$0A], (local9 - 3.25), (local10 - 13.60938), (local11 + 6.140625), $01)
            arg0\Field25[$0B] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$0B], (local9 + 10.32031), (local10 - 13.73438), (local11 + 7.117188), $01)
            arg0\Field25[$0C] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$0C], (local9 - 10.41406), (local10 - 13.73438), (local11 - 7.0), $01)
        Case "room2_2"
            For local4 = Each rooms
                If (local4 <> arg0) Then
                    If (local4\Field8\Field11 = "room2_2") Then
                        arg0\Field25[$00] = copyentity(local4\Field25[$00], $00)
                        Exit
                    EndIf
                EndIf
            Next
            If (arg0\Field25[$00] = $00) Then
                arg0\Field25[$00] = loadmesh_strict("GFX\map\fan.b3d", $00)
            EndIf
            scaleentity(arg0\Field25[$00], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field25[$00], (local9 - 0.96875), 2.0625, local11, $00)
            entityparent(arg0\Field25[$00], arg0\Field3, $01)
            addentitytoroomprops(arg0, arg0\Field25[$00])
        Case "room012"
            local0 = createdoor(local17, (local9 + 1.03125), 0.0, (local11 + 2.625), 270.0, arg0, $00, $00, $03, "")
            positionentity(local0\Field3[$00], (local9 + 0.875), entityy(local0\Field3[$00], $01), (local11 + 2.109375), $01)
            positionentity(local0\Field3[$01], (local9 + 1.1875), entityy(local0\Field3[$01], $01), (local11 + 3.28125), $01)
            turnentity(local0\Field3[$01], 0.0, 0.0, 0.0, $01)
            arg0\Field29[$00] = createdoor(local17, (local9 - 2.0), -3.0, (local11 - 1.3125), 0.0, arg0, $00, $00, $00, "")
            arg0\Field29[$00]\Field20 = $00
            arg0\Field29[$00]\Field5 = $00
            arg0\Field29[$00]\Field4 = $01
            positionentity(arg0\Field29[$00]\Field3[$00], (local9 + 0.6875), -2.0, (local11 - 1.421875), $01)
            freeentity(arg0\Field29[$00]\Field3[$01])
            arg0\Field29[$00]\Field3[$01] = $00
            arg0\Field25[$00] = copyentity(leverbaseobj, $00)
            arg0\Field25[$01] = copyentity(leverobj, $00)
            addentitytoroomprops(arg0, arg0\Field25[$00])
            addentitytoroomprops(arg0, arg0\Field25[$01])
            arg0\Field28[$00] = arg0\Field25[$01]
            For local7 = $00 To $01 Step $01
                scaleentity(arg0\Field25[local7], 0.04, 0.04, 0.04, $00)
                positionentity(arg0\Field25[local7], (local9 + 0.9375), (local10 - 2.0), (local11 - 1.421875), $01)
                entityparent(arg0\Field25[local7], arg0\Field3, $01)
            Next
            rotateentity(arg0\Field25[$01], 10.0, -180.0, 0.0, $00)
            entitypickmode(arg0\Field25[$01], $01, $00)
            entityradius(arg0\Field25[$01], 0.1, 0.0)
            arg0\Field25[$02] = loadmesh_strict("GFX\map\room012_2.b3d", $00)
            scaleentity(arg0\Field25[$02], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field25[$02], (local9 - 1.40625), (1.0 / -1.969231), (local11 + 1.78125), $00)
            entityparent(arg0\Field25[$02], arg0\Field3, $01)
            addentitytoroomprops(arg0, arg0\Field25[$02])
            arg0\Field25[$03] = createsprite($00)
            positionentity(arg0\Field25[$03], (local9 - (1.0 / 5.885057)), -2.242188, (local11 - 1.414062), $00)
            scalesprite(arg0\Field25[$03], 0.015, 0.015)
            entitytexture(arg0\Field25[$03], lightspritetex($01), $00, $00)
            entityblend(arg0\Field25[$03], $03)
            entityparent(arg0\Field25[$03], arg0\Field3, $01)
            hideentity(arg0\Field25[$03])
            arg0\Field25[$04] = loadmesh_strict("GFX\map\room012_3.b3d", $00)
            local29 = loadtexture_strict("GFX\map\scp-012_0.jpg", $01)
            entitytexture(arg0\Field25[$04], local29, $00, $01)
            scaleentity(arg0\Field25[$04], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field25[$04], (local9 - 1.40625), (1.0 / -1.969231), (local11 + 1.78125), $00)
            entityparent(arg0\Field25[$04], arg0\Field25[$02], $01)
            freetexture(local29)
            addentitytoroomprops(arg0, arg0\Field25[$04])
            local6 = createitem("Document SCP-012", "paper", (local9 - 0.21875), (local10 - 2.25), (local11 - 1.59375), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Severed Hand", "hand", (local9 - 3.0625), -1.95, (local11 + 2.5), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local3 = createdecal($03, (local9 - 3.0625), -2.99, (local11 + 2.5), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
            local3\Field2 = 0.5
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityparent(local3\Field0, arg0\Field3, $01)
        Case "tunnel2"
            arg0\Field25[$00] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$00], local9, 2.125, (local11 + 2.0), $01)
            arg0\Field25[$01] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$01], local9, 2.125, (local11 - 2.0), $01)
        Case "room2pipes"
            arg0\Field25[$00] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$00], (local9 + 1.4375), 0.0, local11, $01)
            arg0\Field25[$01] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$01], (local9 - 1.4375), 0.0, local11, $01)
            arg0\Field25[$02] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$02], ((local9 + 0.875) - 0.005), 0.75, local11, $01)
            arg0\Field25[$03] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$03], ((local9 - 0.875) + 0.005), 0.75, local11, $01)
        Case "room3pit"
            local19 = createemitter((local9 + 2.0), -0.296875, (local11 - 2.6875), $00, 0.0, 0.0, 0.0, 0.0)
            turnentity(local19\Field0, -90.0, 0.0, 0.0, $00)
            entityparent(local19\Field0, arg0\Field3, $01)
            local19\Field14 = 55.0
            local19\Field13 = 0.0005
            local19\Field16 = -0.015
            local19\Field15 = 0.007
            local19 = createemitter((local9 - 2.0), -0.296875, (local11 - 2.6875), $00, 0.0, 0.0, 0.0, 0.0)
            turnentity(local19\Field0, -90.0, 0.0, 0.0, $00)
            entityparent(local19\Field0, arg0\Field3, $01)
            local19\Field14 = 55.0
            local19\Field13 = 0.0005
            local19\Field16 = -0.015
            local19\Field15 = 0.007
            arg0\Field25[$00] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$00], (local9 + 2.75), 0.4375, (local11 - 1.625), $01)
        Case "room2servers"
            local0 = createdoor($00, local9, 0.0, local11, 0.0, arg0, $00, $02, $00, "")
            local0\Field4 = $01
            arg0\Field29[$00] = createdoor(local17, (local9 - 0.8125), 0.0, (local11 - 2.875), 90.0, arg0, $01, $00, $00, "")
            arg0\Field29[$00]\Field20 = $00
            arg0\Field29[$01] = createdoor(local17, (local9 - 0.8125), 0.0, (local11 + 2.875), 90.0, arg0, $01, $00, $00, "")
            arg0\Field29[$01]\Field20 = $00
            arg0\Field29[$02] = createdoor(local17, (local9 - 2.625), 0.0, (local11 - 4.0), 0.0, arg0, $00, $00, $00, "GEAR")
            arg0\Field29[$02]\Field20 = $00
            arg0\Field29[$02]\Field14 = $01
            freeentity(arg0\Field29[$02]\Field3[$00])
            arg0\Field29[$02]\Field3[$00] = $00
            freeentity(arg0\Field29[$02]\Field3[$01])
            arg0\Field29[$02]\Field3[$01] = $00
            For local23 = $00 To $02 Step $01
                arg0\Field25[(local23 Shl $01)] = copyentity(leverbaseobj, $00)
                arg0\Field25[((local23 Shl $01) + $01)] = copyentity(leverobj, $00)
                arg0\Field28[local23] = arg0\Field25[((local23 Shl $01) + $01)]
                For local7 = $00 To $01 Step $01
                    scaleentity(arg0\Field25[((local23 Shl $01) + local7)], 0.03, 0.03, 0.03, $00)
                    Select local23
                        Case $00
                            positionentity(arg0\Field25[((local23 Shl $01) + local7)], (local9 - 4.921875), (local10 + (1.0 / 1.094017)), (local11 + 2.929688), $01)
                        Case $01
                            positionentity(arg0\Field25[((local23 Shl $01) + local7)], (local9 - 3.59375), (local10 + 0.640625), (local11 + 3.507812), $01)
                        Case $02
                            positionentity(arg0\Field25[((local23 Shl $01) + local7)], (local9 - 3.269531), (local10 + 0.59375), (local11 + 3.460938), $01)
                    End Select
                    entityparent(arg0\Field25[((local23 Shl $01) + local7)], arg0\Field3, $01)
                Next
                rotateentity(arg0\Field25[((local23 Shl $01) + $01)], 81.0, -180.0, 0.0, $00)
                entitypickmode(arg0\Field25[((local23 Shl $01) + $01)], $01, $00)
                entityradius(arg0\Field25[((local23 Shl $01) + $01)], 0.1, 0.0)
            Next
            rotateentity(arg0\Field25[$03], -81.0, -180.0, 0.0, $00)
            rotateentity(arg0\Field25[$05], -81.0, -180.0, 0.0, $00)
            arg0\Field25[$06] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$06], (local9 - 1.640625), 0.5, local11, $01)
            arg0\Field25[$07] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$07], (local9 - 5.1875), 0.5, (local11 + 2.0625), $01)
            arg0\Field25[$08] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$08], (local9 - 5.375), 0.5, (local11 + 0.125), $01)
            arg0\Field25[$09] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$09], (local9 - 3.3125), 0.5, (local11 + 2.25), $01)
        Case "room3servers"
            local6 = createitem("9V Battery", "bat", (local9 - 0.515625), (local10 - 1.4375), (local11 - 2.53125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("9V Battery", "bat", (local9 - 0.296875), (local10 - 1.4375), (local11 - 2.53125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("S-NAV 300 Navigator", "nav", (local9 + 0.484375), (local10 - 1.4375), (local11 - 2.53125), $00, $00, $00, 1.0, $00, $01)
            local6\Field13 = 20.0
            entityparent(local6\Field2, arg0\Field3, $01)
            arg0\Field25[$00] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$00], (local9 + 2.875), -2.0, (local11 - (1.0 / 0.64)), $01)
            arg0\Field25[$01] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$01], (local9 - 2.15625), -2.0, (local11 - 2.0625), $01)
            arg0\Field25[$02] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$02], (local9 + 2.875), -2.0, (local11 + 1.0625), $01)
            arg0\Field25[$03] = loadmesh_strict("GFX\npcs\duck_low_res.b3d", $00)
            scaleentity(arg0\Field25[$03], 0.07, 0.07, 0.07, $00)
            local29 = loadtexture_strict("GFX\npcs\duck2.png", $01)
            entitytexture(arg0\Field25[$03], local29, $00, $00)
            positionentity(arg0\Field25[$03], (local9 + 3.625), -2.5, (local11 + 2.75), $00)
            freetexture(local29)
            entityparent(arg0\Field25[$03], arg0\Field3, $01)
            addentitytoroomprops(arg0, arg0\Field25[$03])
        Case "room3servers2"
            arg0\Field25[$00] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$00], (local9 - 1.96875), -2.0, (local11 + 1.058594), $01)
            arg0\Field25[$01] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$01], (local9 + 2.453125), -2.0, (local11 + 1.058594), $01)
            arg0\Field25[$02] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$02], (local9 - 2.078125), -2.0, (local11 - 3.425781), $01)
            local6 = createitem("Document SCP-970", "paper", (local9 + 3.75), (local10 - 1.75), (local11 + (1.0 / 1.01992)), $00, $00, $00, 1.0, $00, $01)
            rotateentity(local6\Field2, 0.0, (Float arg0\Field7), 0.0, $00)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Gas Mask", "gasmask", (local9 + 3.726562), (local10 - 1.96875), (local11 + (1.0 / 1.089362)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
        Case "testroom"
            For local12 = 0.0 To 1.0 Step 1.0
                For local14 = -1.0 To 1.0 Step 1.0
                    arg0\Field25[(Int ((local12 * 3.0) + (local14 + 1.0)))] = createpivot($00)
                    positionentity(arg0\Field25[(Int ((local12 * 3.0) + (local14 + 1.0)))], ((((280.0 * local12) + -236.0) * (1.0 / 256.0)) + local9), -2.734375, (((384.0 * local14) * (1.0 / 256.0)) + local11), $00)
                    entityparent(arg0\Field25[(Int ((local12 * 3.0) + (local14 + 1.0)))], arg0\Field3, $01)
                Next
            Next
            arg0\Field25[$06] = createpivot($00)
            positionentity(arg0\Field25[$06], (local9 + 2.945312), (local10 - 4.875), local11, $00)
            entityparent(arg0\Field25[$06], arg0\Field3, $01)
            local2 = createsecuritycam((local9 + 2.90625), (local10 - 3.34375), (local11 + 0.921875), arg0, $00)
            local2\Field21 = $01
            createdoor($00, (local9 + 2.8125), 0.0, local11, 0.0, arg0, $00, $02, $FFFFFFFF, "")
            createdoor($00, (local9 - 2.4375), -5.0, local11, 90.0, arg0, $01, $00, $00, "")
            local6 = createitem("Document SCP-682", "paper", (local9 + 2.5625), (local10 - 4.6875), (local11 - (1.0 / 16.0)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
        Case "room2closets"
            If (networkserver\Field12 = $00) Then
                local6 = createitem("Document SCP-1048", "paper", (local9 + 2.875), (local10 + 0.6875), (local11 + 2.875), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (local9 + 2.875), (local10 + 0.6875), (local11 + 2.875), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            EndIf
            local6 = createitem("Gas Mask", "gasmask", (local9 + 2.875), (local10 + 0.6875), (local11 + 2.125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            If (networkserver\Field12 = $00) Then
                local6 = createitem("9V Battery", "bat", (local9 + 2.875), (local10 + 0.6875), (local11 - 1.75), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
                local6 = createitem("9V Battery", "bat", (local9 + 2.851562), (local10 + 0.6875), (local11 - 1.9375), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            Else
                local6 = createitem("Strange Bottle", "veryfinefirstaid", (local9 + 2.875), (local10 + 0.6875), (local11 - 1.75), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
                local6 = createitem("Strange Bottle", "veryfinefirstaid", (local9 + 2.851562), (local10 + 0.6875), (local11 - 1.9375), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            EndIf
            local6 = createitem("Level 1 Key Card", "key1", (local9 + 2.875), (local10 + 0.9375), (local11 + 2.9375), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Clipboard", "clipboard", (local9 + 2.875), (local10 + 0.875), (local11 - 1.875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Incident Report SCP-1048-A", "paper", (local9 + 2.875), (local10 + 0.875), (local11 - 1.875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            arg0\Field25[$00] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$00], (local9 - 4.375), -1.0, (local11 + 3.5), $01)
            arg0\Field25[$01] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$01], (local9 - 4.8125), -1.0, (local11 - 0.625), $01)
            local0 = createdoor($00, (local9 - 0.9375), 0.0, local11, 90.0, arg0, $00, $00, $00, "")
            positionentity(local0\Field3[$00], (local9 - (1.0 / 1.113043)), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (local9 - (1.0 / 1.024)), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0\Field5 = $00
            local0\Field20 = $00
            local2 = createsecuritycam(local9, (local10 + 2.75), (local11 + 3.371094), arg0, $00)
            local2\Field11 = 180.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room2offices"
            If (networkserver\Field12 = $00) Then
                local6 = createitem("Document SCP-106", "paper", (local9 + 1.578125), (local10 + (1.0 / 1.765517)), (local11 + 2.183594), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (local9 + 1.578125), (local10 + (1.0 / 1.765517)), (local11 + 2.183594), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            EndIf
            local6 = createitem("Level 2 Key Card", "key2", (local9 - 0.609375), (local10 + (1.0 / 1.695364)), (local11 + 0.28125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("S-NAV 300 Navigator", "nav", (local9 + 1.191406), (local10 + (1.0 / 1.673203)), (local11 + 3.6875), $00, $00, $00, 1.0, $00, $01)
            local6\Field13 = 20.0
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Notification", "paper", (local9 - (1.0 / 1.868613)), (local10 + (1.0 / 1.673203)), (local11 + 1.8125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local31 = createwaypoint((local9 - 0.125), (local10 + (1.0 / 3.878788)), (local11 + 1.125), Null, arg0)
            local32 = createwaypoint(local9, (local10 + (1.0 / 3.878788)), (local11 - 1.75), Null, arg0)
            local31\Field4[$00] = local32
            local31\Field5[$00] = entitydistance(local31\Field0, local32\Field0)
            local32\Field4[$00] = local31
            local32\Field5[$00] = local31\Field5[$00]
        Case "room2offices2"
            local6 = createitem("Level 1 Key Card", "key1", (local9 - 1.4375), (local10 - 0.1875), (local11 + (1.0 / 3.2)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Document SCP-895", "paper", (local9 - 3.125), (local10 - 0.1875), (local11 + 1.4375), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Document SCP-860", "paper", (local9 - 3.125), (local10 - 0.1875), (local11 - 1.8125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("S-NAV 300 Navigator", "nav", (local9 - 1.3125), (local10 - 0.1875), (local11 - 1.875), $00, $00, $00, 1.0, $00, $01)
            local6\Field13 = 28.0
            entityparent(local6\Field2, arg0\Field3, $01)
            arg0\Field25[$00] = loadmesh_strict("GFX\npcs\duck_low_res.b3d", $00)
            scaleentity(arg0\Field25[$00], 0.07, 0.07, 0.07, $00)
            entityparent(arg0\Field25[$00], arg0\Field3, $01)
            addentitytoroomprops(arg0, arg0\Field25[$00])
            arg0\Field25[$01] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$01], (local9 - 3.15625), -0.28125, (local11 - (1.0 / 6.4)), $01)
            arg0\Field25[$02] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$02], (local9 - 1.90625), 0.625, (local11 + 2.734375), $01)
            arg0\Field25[$03] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$03], (local9 - 1.90625), 0.625, (local11 - 2.609375), $01)
            arg0\Field25[$04] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$04], (local9 - 2.234375), 1.367188, (local11 - (1.0 / 64.0)), $01)
            local24 = rand($01, $04)
            positionentity(arg0\Field25[$00], entityx(arg0\Field25[local24], $01), entityy(arg0\Field25[local24], $01), entityz(arg0\Field25[local24], $01), $01)
        Case "room2offices3"
            local6 = createitem("Mobile Task Forces", "paper", (local9 + 2.90625), (local10 + 0.9375), (local11 + 3.6875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Object Classes", "paper", (local9 + 0.625), (local10 + 0.9375), (local11 + 2.21875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Document", "paper", (local9 - 5.625), (local10 + 2.4375), (local11 + 0.59375), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Radio Transceiver", "radio", (local9 - 4.625), (local10 + 1.875), (local11 - 3.125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("ReVision Eyedrops", "eyedrops", (local9 - 5.972656), (local10 + 2.199219), ((local11 - 2.234375) + 0.0), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("9V Battery", "bat", (local9 - 6.035156), (local10 + 2.355469), (local11 - 1.453125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("9V Battery", "bat", (local9 - 6.015625), (local10 + 2.355469), (local11 - 1.328125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            arg0\Field29[$00] = createdoor(local17, (local9 - 4.125), 1.5, (local11 + 1.132812), 90.0, arg0, $01, $00, $00, "")
            arg0\Field29[$00]\Field20 = $00
            arg0\Field29[$00]\Field5 = $01
            positionentity(arg0\Field29[$00]\Field3[$00], entityx(arg0\Field29[$00]\Field3[$00], $01), entityy(arg0\Field29[$00]\Field3[$00], $01), (local11 + (1.0 / 1.590062)), $01)
            positionentity(arg0\Field29[$00]\Field3[$01], entityx(arg0\Field29[$00]\Field3[$01], $01), entityy(arg0\Field29[$00]\Field3[$01], $01), (local11 + (1.0 / 1.590062)), $01)
        Case "room3"
            If (rand($00, $01) = $01) Then
                placehalloweenscene(arg0, $17, rand($00, ($03 - newyearindex)), (local9 - (1.0 / 20.70979)), (local10 + 0.302), (local11 + 1.692062), -180.0)
            EndIf
        Case "start"
            arg0\Field29[$01] = createdoor(local17, (local9 + 15.625), 1.5, (local11 + 6.625), 90.0, arg0, $01, $01, $00, "")
            arg0\Field29[$01]\Field4 = $00
            arg0\Field29[$01]\Field20 = $00
            arg0\Field29[$01]\Field9 = $01
            arg0\Field29[$01]\Field5 = $01
            freeentity(arg0\Field29[$01]\Field3[$00])
            arg0\Field29[$01]\Field3[$00] = $00
            freeentity(arg0\Field29[$01]\Field3[$01])
            arg0\Field29[$01]\Field3[$01] = $00
            arg0\Field29[$01]\Field23 = $00
            arg0\Field29[$02] = createdoor(local17, (local9 + 10.5625), 1.5, (local11 + 2.4375), 90.0, arg0, $00, $00, $00, "")
            arg0\Field29[$02]\Field20 = $00
            arg0\Field29[$02]\Field5 = $00
            freeentity(arg0\Field29[$02]\Field3[$00])
            arg0\Field29[$02]\Field3[$00] = $00
            freeentity(arg0\Field29[$02]\Field3[$01])
            arg0\Field29[$02]\Field3[$01] = $00
            arg0\Field29[$02]\Field23 = $00
            local0 = createdoor(local17, (local9 + 5.4375), 1.5, (local11 + 0.25), 90.0, arg0, $01, $00, $00, "")
            local0\Field20 = $00
            local0\Field23 = $00
            local0\Field4 = $01
            local0 = createdoor(local17, (local9 - 2.5), 1.5, (local11 + 0.25), 90.0, arg0, $00, $00, $00, "")
            local0\Field4 = $01
            local0\Field20 = $00
            local0 = createdoor(local17, (local9 + 5.0), 1.5, (local11 + 1.21875), 180.0, arg0, $01, $00, $00, "")
            local0\Field4 = $01
            local0\Field20 = $00
            positionentity(local0\Field3[$00], (local9 + 4.375), entityy(local0\Field3[$00], $01), (local11 + 1.28125), $01)
            positionentity(local0\Field3[$01], (local9 + 4.375), entityy(local0\Field3[$01], $01), (local11 + 1.15625), $01)
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0\Field23 = $00
            local0 = createdoor(local17, local9, 0.0, (local11 + 4.625), 0.0, arg0, $00, $00, $00, "")
            local0\Field4 = $01
            arg0\Field25[$00] = loadmesh_strict("GFX\map\IntroDesk.b3d", $00)
            scaleentity(arg0\Field25[$00], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field25[$00], (local9 + 1.0625), 0.0, (local11 + (1.0 / 0.64)), $00)
            entityparent(arg0\Field25[$00], arg0\Field3, $01)
            addentitytoroomprops(arg0, arg0\Field25[$00])
            local3 = createdecal($00, (local9 + 1.0625), 0.005, (local11 + 1.023438), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
            entityparent(local3\Field0, arg0\Field3, $01)
            arg0\Field25[$01] = loadmesh_strict("GFX\map\IntroDrawer.b3d", $00)
            scaleentity(arg0\Field25[$01], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            positionentity(arg0\Field25[$01], (local9 + 1.75), 0.0, (local11 + 0.75), $00)
            entityparent(arg0\Field25[$01], arg0\Field3, $01)
            addentitytoroomprops(arg0, arg0\Field25[$01])
            local3 = createdecal($00, (local9 + 1.78125), 0.005, (local11 + (1.0 / 1.896296)), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
            entityparent(local3\Field0, arg0\Field3, $01)
            local2 = createsecuritycam((local9 - 1.3125), (local10 + 1.375), (local11 + 0.1875), arg0, $01)
            local2\Field11 = 270.0
            local2\Field12 = 45.0
            local2\Field20 = arg0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field3, $01)
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (local9 + 6.599336), (local10 + 1.505125), (local11 - 1.068605), 0.0)
            placehalloweenscene(arg0, $17, rand($00, ($03 - newyearindex)), (local9 - 1.748793), (local10 + 0.302), (local11 + 3.804094), -115.0)
            positionentity(local2\Field4, (local9 + 5.6875), 2.375, (local11 + 1.375), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field3, $01)
            arg0\Field25[$02] = createpivot($00)
            positionentity(arg0\Field25[$02], (entityx(arg0\Field3, $00) + (1.0 / 6.4)), 1.796875, (entityz(arg0\Field3, $00) + 4.1875), $00)
            arg0\Field25[$03] = createpivot($00)
            positionentity(arg0\Field25[$03], (entityx(arg0\Field3, $00) - (1.0 / 3.2)), (1.0 / 2.56), (entityz(arg0\Field3, $00) + 2.054688), $00)
            arg0\Field25[$04] = createpivot($00)
            positionentity(arg0\Field25[$04], (entityx(arg0\Field3, $00) - 0.5), (1.0 / 2.56), (entityz(arg0\Field3, $00) + 1.25), $00)
            arg0\Field25[$05] = createpivot($00)
            positionentity(arg0\Field25[$05], (entityx(arg0\Field3, $00) + 2.578125), (1.0 / 2.56), (entityz(arg0\Field3, $00) + 2.054688), $00)
            arg0\Field25[$06] = createpivot($00)
            positionentity(arg0\Field25[$06], (entityx(arg0\Field3, $00) + 2.734375), (1.0 / 2.56), (entityz(arg0\Field3, $00) + 1.25), $00)
            arg0\Field25[$07] = createpivot($00)
            positionentity(arg0\Field25[$07], (entityx(arg0\Field3, $00) + 5.75), (1.0 / 2.56), (entityz(arg0\Field3, $00) + 3.5625), $00)
            For local7 = $02 To $07 Step $01
                entityparent(arg0\Field25[local7], arg0\Field3, $01)
            Next
        Case "room2scps"
            local0 = createdoor(local17, (local9 + 1.03125), 0.0, local11, 90.0, arg0, $01, $00, $03, "")
            local0\Field20 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], (local9 + 1.25), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (local9 + 0.875), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(local17, (local9 - 1.03125), 0.0, (local11 + 0.125), 270.0, arg0, $01, $00, $03, "")
            local0\Field20 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], (local9 - 1.25), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (local9 - 0.875), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            arg0\Field29[$01] = createdoor(local17, (local9 - 2.1875), 0.0, (local11 - (1.0 / 1.057851)), 0.0, arg0, $01, $00, $03, "")
            arg0\Field29[$01]\Field20 = $00
            arg0\Field29[$01]\Field5 = $00
            arg0\Field29[$02] = createdoor(local17, (local9 + 2.1875), 0.0, (local11 - 0.984375), 180.0, arg0, $01, $00, $03, "")
            arg0\Field29[$02]\Field20 = $00
            arg0\Field29[$02]\Field5 = $00
            arg0\Field29[$03] = createdoor(local17, (local9 + 2.1875), 0.0, (local11 + 1.0625), 180.0, arg0, $01, $00, $03, "")
            arg0\Field29[$03]\Field20 = $00
            arg0\Field29[$03]\Field5 = $00
            arg0\Field29[$04] = createdoor(local17, (local9 - 2.1875), 0.0, (local11 + 1.0625), 0.0, arg0, $01, $00, $03, "")
            arg0\Field29[$04]\Field20 = $00
            arg0\Field29[$04]\Field5 = $00
            local6 = createitem("SCP-714", "scp714", (local9 - 2.15625), (local10 + 0.859375), (local11 - 2.96875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("SCP-1025", "scp1025", (local9 + 2.15625), (local10 + 0.875), (local11 - 2.960938), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            If (networkserver\Field12 = $00) Then
                local6 = createitem("SCP-860", "scp860", (local9 + 2.21875), (local10 + (1.0 / 1.438202)), (local11 + 2.96875), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            EndIf
            local2 = createsecuritycam((local9 + 2.1875), (local10 + 1.507812), (local11 - 1.625), arg0, $00)
            local2\Field11 = 180.0
            local2\Field12 = 30.0
            turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field3, $01)
            local2 = createsecuritycam((local9 - 2.1875), (local10 + 1.507812), (local11 - 1.625), arg0, $00)
            local2\Field11 = 180.0
            local2\Field12 = 30.0
            turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field3, $01)
            local2 = createsecuritycam((local9 + 2.1875), (local10 + 1.507812), (local11 + 1.875), arg0, $00)
            local2\Field11 = 0.0
            local2\Field12 = 30.0
            turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field3, $01)
            local2 = createsecuritycam((local9 - 2.1875), (local10 + 1.507812), (local11 + 1.875), arg0, $00)
            local2\Field11 = 0.0
            local2\Field12 = 30.0
            turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field3, $01)
            local6 = createitem("Document SCP-714", "paper", (local9 - 2.84375), (local10 + 1.125), (local11 - 1.40625), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Document SCP-427", "paper", (local9 - 2.375), (local10 + (1.0 / 3.878788)), (local11 + 2.484375), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            For local7 = $00 To $0E Step $01
                Select local7
                    Case $00
                        local33 = -64.0
                        local36 = -516.0
                    Case $01
                        local33 = -96.0
                        local36 = -388.0
                    Case $02
                        local33 = -128.0
                        local36 = -292.0
                    Case $03
                        local33 = -128.0
                        local36 = -132.0
                    Case $04
                        local33 = -160.0
                        local36 = -36.0
                    Case $05
                        local33 = -192.0
                        local36 = 28.0
                    Case $06
                        local33 = -384.0
                        local36 = 28.0
                    Case $07
                        local33 = -448.0
                        local36 = 92.0
                    Case $08
                        local33 = -480.0
                        local36 = 124.0
                    Case $09
                        local33 = -512.0
                        local36 = 156.0
                    Case $0A
                        local33 = -544.0
                        local36 = 220.0
                    Case $0B
                        local33 = -544.0
                        local36 = 380.0
                    Case $0C
                        local33 = -544.0
                        local36 = 476.0
                    Case $0D
                        local33 = -544.0
                        local36 = 572.0
                    Case $0E
                        local33 = -544.0
                        local36 = 636.0
                End Select
                local3 = createdecal(rand($0F, $10), ((local33 * (1.0 / 256.0)) + local9), 0.005, ((local36 * (1.0 / 256.0)) + local11), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                If (local7 > $0A) Then
                    local3\Field2 = rnd(0.2, 0.25)
                Else
                    local3\Field2 = rnd(0.1, 0.17)
                EndIf
                entityalpha(local3\Field0, 1.0)
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                entityparent(local3\Field0, arg0\Field3, $01)
            Next
        Case "room205"
            arg0\Field29[$01] = createdoor(local17, (local9 + 0.5), 0.0, (local11 + 2.5), 90.0, arg0, $01, $00, $03, "")
            arg0\Field29[$01]\Field20 = $00
            arg0\Field29[$01]\Field5 = $00
            arg0\Field29[$00] = createdoor(local17, (local9 - 5.4375), -0.5, (local11 - 1.5), 0.0, arg0, $01, $00, $03, "")
            arg0\Field29[$00]\Field20 = $00
            arg0\Field29[$00]\Field5 = $00
            freeentity(arg0\Field29[$00]\Field3[$00])
            arg0\Field29[$00]\Field3[$00] = $00
            freeentity(arg0\Field29[$00]\Field3[$01])
            arg0\Field29[$00]\Field3[$01] = $00
            local2 = createsecuritycam((local9 - 4.5), (local10 + 3.515625), (local11 + 0.6875), arg0, $01)
            local2\Field11 = 90.0
            local2\Field12 = 0.0
            entityparent(local2\Field0, arg0\Field3, $01)
            local2\Field23 = $00
            local2\Field19 = 0.0
            entityparent(local2\Field4, $00, $01)
            positionentity(local2\Field4, (local9 - 6.703125), (local10 + 0.625), (local11 + 0.6875), $01)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            scalesprite(local2\Field4, 1.75, 1.75)
            entityparent(local2\Field4, arg0\Field3, $01)
            camerazoom(local2\Field8, 1.5)
            hideentity(local2\Field10)
            hideentity(local2\Field1)
            arg0\Field25[$00] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$00], (local9 - 6.0), (local10 + 2.851562), (local11 + 0.75), $01)
            rotateentity(arg0\Field25[$00], 0.0, -90.0, 0.0, $01)
            arg0\Field25[$01] = local2\Field4
        Case "endroom"
            arg0\Field29[$00] = createdoor(local17, local9, 0.0, (local11 + 4.4375), 0.0, arg0, $00, $01, $06, "")
            arg0\Field29[$00]\Field20 = $00
            arg0\Field29[$00]\Field5 = $00
            arg0\Field29[$00]\Field4 = $01
            freeentity(arg0\Field29[$00]\Field3[$00])
            arg0\Field29[$00]\Field3[$00] = $00
            freeentity(arg0\Field29[$00]\Field3[$01])
            arg0\Field29[$00]\Field3[$01] = $00
        Case "endroomc"
            local0 = createdoor(local17, (local9 + 4.0), 0.0, local11, 0.0, arg0, $00, $02, $00, "")
            local0\Field5 = $00
            local0\Field20 = $00
            local0\Field4 = $01
        Case "coffin"
            local0 = createdoor(local17, local9, 0.0, (local11 - 1.75), 0.0, arg0, $00, $01, $02, "")
            local0\Field20 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], (local9 - 1.5), 0.7, (local11 - 1.09375), $01)
            local2 = createsecuritycam((local9 - 1.25), (local10 + 2.75), (local11 + 1.125), arg0, $01)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            local2\Field22 = $01
            turnentity(local2\Field3, 120.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field3, $01)
            coffincam = local2
            positionentity(local2\Field4, (local9 - 3.125), 1.125, (local11 - 1.328125), $00)
            entityparent(local2\Field4, arg0\Field3, $01)
            turnentity(local2\Field4, 0.0, 180.0, 0.0, $00)
            arg0\Field25[$02] = copyentity(leverbaseobj, $00)
            arg0\Field25[$03] = copyentity(leverobj, $00)
            addentitytoroomprops(arg0, arg0\Field25[$02])
            addentitytoroomprops(arg0, arg0\Field25[$03])
            arg0\Field28[$00] = arg0\Field25[$03]
            For local7 = $00 To $01 Step $01
                scaleentity(arg0\Field25[($02 + local7)], 0.04, 0.04, 0.04, $00)
                positionentity(arg0\Field25[($02 + local7)], (local9 - 3.125), (local10 + 0.703125), (local11 - 1.3125), $01)
                entityparent(arg0\Field25[($02 + local7)], arg0\Field3, $01)
            Next
            rotateentity(arg0\Field25[$02], 0.0, 180.0, 0.0, $00)
            rotateentity(arg0\Field25[$03], 10.0, 0.0, 0.0, $00)
            entityradius(arg0\Field25[$03], 0.1, 0.0)
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], local9, -5.15625, (local11 + 9.0), $00)
            entityparent(arg0\Field25[$00], arg0\Field3, $01)
            local6 = createitem("Document SCP-895", "paper", (local9 - 2.6875), (local10 + (1.0 / 1.924812)), (local11 - 1.1875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Level 3 Key Card", "key3", (local9 + 0.9375), (local10 - 5.6875), (local11 + 8.0625), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Night Vision Goggles", "nvgoggles", (local9 + 1.09375), (local10 - 5.6875), (local11 + 8.453125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6\Field13 = 400.0
            arg0\Field25[$01] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$01], (local9 + 0.375), -5.984375, (local11 + 7.875), $01)
        Case "room2tesla","room2tesla_lcz","room2tesla_hcz"
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (local9 - (1.0 / 2.245614)), 0.0, local11, $00)
            entityparent(arg0\Field25[$00], arg0\Field3, $01)
            arg0\Field25[$01] = createpivot($00)
            positionentity(arg0\Field25[$01], (local9 + (1.0 / 2.245614)), 0.0, local11, $00)
            entityparent(arg0\Field25[$01], arg0\Field3, $01)
            arg0\Field25[$02] = createpivot($00)
            positionentity(arg0\Field25[$02], local9, 0.0, local11, $00)
            entityparent(arg0\Field25[$02], arg0\Field3, $01)
            arg0\Field25[$03] = createsprite($00)
            entitytexture(arg0\Field25[$03], teslatexture, $00, $00)
            spriteviewmode(arg0\Field25[$03], $02)
            entityblend(arg0\Field25[$03], $03)
            entityfx(arg0\Field25[$03], $19)
            positionentity(arg0\Field25[$03], local9, 0.8, local11, $00)
            hideentity(arg0\Field25[$03])
            entityparent(arg0\Field25[$03], arg0\Field3, $01)
            local31 = createwaypoint(local9, (local10 + (1.0 / 3.878788)), (local11 + 1.140625), Null, arg0)
            local32 = createwaypoint(local9, (local10 + (1.0 / 3.878788)), (local11 - 1.109375), Null, arg0)
            local31\Field4[$00] = local32
            local31\Field5[$00] = entitydistance(local31\Field0, local32\Field0)
            local32\Field4[$00] = local31
            local32\Field5[$00] = local31\Field5[$00]
            arg0\Field25[$04] = createsprite($00)
            positionentity(arg0\Field25[$04], (local9 - 0.125), 2.21875, local11, $00)
            scalesprite(arg0\Field25[$04], 0.03, 0.03)
            entitytexture(arg0\Field25[$04], lightspritetex($01), $00, $00)
            entityblend(arg0\Field25[$04], $03)
            entityparent(arg0\Field25[$04], arg0\Field3, $01)
            hideentity(arg0\Field25[$04])
            arg0\Field25[$05] = createpivot($00)
            positionentity(arg0\Field25[$05], local9, 0.0, (local11 - 3.125), $00)
            entityparent(arg0\Field25[$05], arg0\Field3, $01)
            arg0\Field25[$06] = createpivot($00)
            positionentity(arg0\Field25[$06], local9, 0.0, (local11 + 3.125), $00)
            entityparent(arg0\Field25[$06], arg0\Field3, $01)
            For local4 = Each rooms
                If (local4 <> arg0) Then
                    If ((((local4\Field8\Field11 = "room2tesla") Or (local4\Field8\Field11 = "room2tesla_lcz")) Or (local4\Field8\Field11 = "room2tesla_hcz")) <> 0) Then
                        arg0\Field25[$07] = copyentity(local4\Field25[$07], arg0\Field3)
                        entitytype(arg0\Field25[$07], $00, $00)
                        Exit
                    EndIf
                EndIf
            Next
            If (arg0\Field25[$07] = $00) Then
                arg0\Field25[$07] = loadmesh_strict("GFX\map\room2tesla_caution.b3d", arg0\Field3)
            EndIf
            entitytype(arg0\Field25[$07], $00, $00)
        Case "room2doors"
            local0 = createdoor(local17, local9, 0.0, (local11 + 2.0625), 0.0, arg0, $01, $00, $00, "")
            local0\Field20 = $00
            positionentity(local0\Field3[$00], (local9 - 3.25), 0.7, (local11 + 0.625), $01)
            positionentity(local0\Field3[$01], (local9 + 0.625), 0.7, (local11 + 2.09375), $01)
            local1 = createdoor(local17, local9, 0.0, (local11 - 2.0625), 180.0, arg0, $01, $00, $00, "")
            local1\Field20 = $00
            freeentity(local1\Field3[$00])
            local1\Field3[$00] = $00
            positionentity(local1\Field3[$01], (local9 + 0.625), 0.7, (local11 - 2.09375), $01)
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (local9 - 3.25), 0.5, local11, $00)
            entityparent(arg0\Field25[$00], arg0\Field3, $01)
            local1\Field21 = local0
            local0\Field21 = local1
            local0\Field5 = $00
            local1\Field5 = $01
        Case "room4"
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (local9 + 1.427953), (local10 + 1.625), (local11 + (1.0 / 13.26732)), 90.0)
        Case "914"
            arg0\Field29[$02] = createdoor(local17, local9, 0.0, (local11 - 1.4375), 0.0, arg0, $00, $01, $02, "")
            arg0\Field29[$02]\Field9 = $01
            arg0\Field29[$02]\Field20 = $00
            arg0\Field29[$02]\Field5 = $00
            positionentity(arg0\Field29[$02]\Field3[$00], (local9 - 1.9375), 0.7, (local11 - 1.0625), $01)
            turnentity(arg0\Field29[$02]\Field3[$00], 0.0, 90.0, 0.0, $00)
            arg0\Field25[$00] = loadmesh_strict("GFX\map\914key.x", $00)
            arg0\Field25[$01] = loadmesh_strict("GFX\map\914knob.x", $00)
            addentitytoroomprops(arg0, arg0\Field25[$00])
            addentitytoroomprops(arg0, arg0\Field25[$01])
            For local7 = $00 To $01 Step $01
                scaleentity(arg0\Field25[local7], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                entitypickmode(arg0\Field25[local7], $02, $01)
            Next
            positionentity(arg0\Field25[$00], local9, (local10 + (1.0 / 1.347368)), (local11 + 1.460938), $00)
            positionentity(arg0\Field25[$01], local9, (local10 + (1.0 / 1.113043)), (local11 + 1.460938), $00)
            entityparent(arg0\Field25[$00], arg0\Field3, $01)
            entityparent(arg0\Field25[$01], arg0\Field3, $01)
            local0 = createdoor(local17, (local9 - 2.4375), 0.0, (local11 + 2.0625), 180.0, arg0, $01, $00, $00, "")
            freeentity(local0\Field1)
            local0\Field1 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local0\Field9 = $04
            arg0\Field29[$00] = local0
            local0\Field20 = $00
            local0 = createdoor(local17, (local9 + 3.1875), 0.0, (local11 + 2.0625), 180.0, arg0, $01, $00, $00, "")
            freeentity(local0\Field1)
            local0\Field1 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local0\Field9 = $04
            arg0\Field29[$01] = local0
            local0\Field20 = $00
            arg0\Field25[$02] = createpivot($00)
            arg0\Field25[$03] = createpivot($00)
            positionentity(arg0\Field25[$02], (local9 - 2.78125), 0.5, (local11 + 2.5), $00)
            positionentity(arg0\Field25[$03], (local9 + 2.84375), 0.5, (local11 + 2.5), $00)
            entityparent(arg0\Field25[$02], arg0\Field3, $01)
            entityparent(arg0\Field25[$03], arg0\Field3, $01)
            local6 = createitem("Addendum: 5/14 Test Log", "paper", (local9 + 3.726562), (local10 + 0.890625), (local11 + (1.0 / 2.015748)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("First Aid Kit", "firstaid", (local9 + 3.75), (local10 + 0.4375), (local11 - (1.0 / 6.4)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            rotateentity(local6\Field2, 0.0, 90.0, 0.0, $00)
            local6 = createitem("Dr. L's Note", "paper", (local9 - 3.625), 0.625, (local11 - 0.625), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (local9 - 3.385273), 0.0, (local11 + (1.0 / 1.728305)), -90.0)
            local20 = createcube($00)
            entityalpha(local20, 0.0)
            positionentity(local20, local9, local10, (local11 + 1.460938), $00)
            moveentity(local20, 0.0, 2.5, 0.0)
            scaleentity(local20, 2.92, 1.0, 3.39, $00)
            entitytype(local20, $09, $00)
            entityparent(local20, arg0\Field3, $01)
        Case "173"
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (entityx(arg0\Field3, $00) + (1.0 / 6.4)), 1.796875, (entityz(arg0\Field3, $00) + 4.1875), $00)
            arg0\Field25[$01] = createpivot($00)
            positionentity(arg0\Field25[$01], (entityx(arg0\Field3, $00) - (1.0 / 3.2)), (1.0 / 2.56), (entityz(arg0\Field3, $00) + 2.054688), $00)
            arg0\Field25[$02] = createpivot($00)
            positionentity(arg0\Field25[$02], (entityx(arg0\Field3, $00) - 0.5), (1.0 / 2.56), (entityz(arg0\Field3, $00) + 1.25), $00)
            arg0\Field25[$03] = createpivot($00)
            positionentity(arg0\Field25[$03], (entityx(arg0\Field3, $00) + 2.578125), (1.0 / 2.56), (entityz(arg0\Field3, $00) + 2.054688), $00)
            arg0\Field25[$04] = createpivot($00)
            positionentity(arg0\Field25[$04], (entityx(arg0\Field3, $00) + 2.734375), (1.0 / 2.56), (entityz(arg0\Field3, $00) + 1.25), $00)
            arg0\Field25[$05] = createpivot($00)
            positionentity(arg0\Field25[$05], (entityx(arg0\Field3, $00) + 5.75), (1.0 / 2.56), (entityz(arg0\Field3, $00) + 3.5625), $00)
            For local7 = $00 To $05 Step $01
                entityparent(arg0\Field25[local7], arg0\Field3, $01)
            Next
            arg0\Field29[$01] = createdoor(local17, (entityx(arg0\Field3, $00) + 1.125), 0.0, (entityz(arg0\Field3, $00) + 1.5), 90.0, arg0, $00, $01, $00, "")
            arg0\Field29[$01]\Field20 = $00
            arg0\Field29[$01]\Field9 = $01
            arg0\Field29[$01]\Field5 = $00
            freeentity(arg0\Field29[$01]\Field3[$00])
            arg0\Field29[$01]\Field3[$00] = $00
            freeentity(arg0\Field29[$01]\Field3[$01])
            arg0\Field29[$01]\Field3[$01] = $00
            local3 = createdecal(rand($04, $05), entityx(arg0\Field25[$05], $01), 0.002, entityz(arg0\Field25[$05], $01), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
            local3\Field2 = 1.2
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            For local12 = 0.0 To 1.0 Step 1.0
                For local14 = 0.0 To 1.0 Step 1.0
                    local3 = createdecal(rand($04, $06), (((local9 + 2.734375) + ((local12 * 700.0) * (1.0 / 256.0))) + rnd(-0.5, 0.5)), rnd(0.001, 0.0018), ((((600.0 * local14) * (1.0 / 256.0)) + local11) + rnd(-0.5, 0.5)), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
                    local3\Field2 = rnd(0.5, 0.8)
                    local3\Field5 = rnd(0.8, 1.0)
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Next
            Next
            arg0\Field29[$02] = createdoor(local17, (local9 - 3.9375), 0.0, (local11 - 2.6875), 90.0, arg0, $01, $00, $00, "")
            arg0\Field29[$02]\Field20 = $00
            arg0\Field29[$02]\Field5 = $00
            arg0\Field29[$02]\Field4 = $01
            freeentity(arg0\Field29[$02]\Field3[$00])
            arg0\Field29[$02]\Field3[$00] = $00
            freeentity(arg0\Field29[$02]\Field3[$01])
            arg0\Field29[$02]\Field3[$01] = $00
            arg0\Field29[$03] = createdoor(local17, (local9 - 9.0625), 0.0, (local11 - 4.875), 90.0, arg0, $01, $00, $00, "")
            arg0\Field29[$03]\Field20 = $00
            arg0\Field29[$03]\Field5 = $01
            arg0\Field29[$03]\Field4 = $01
            arg0\Field29[$04] = createdoor(local17, (local9 - 17.0), 0.0, (local11 - 4.875), 90.0, arg0, $01, $00, $00, "")
            arg0\Field29[$04]\Field20 = $00
            arg0\Field29[$04]\Field5 = $01
            arg0\Field29[$04]\Field4 = $01
            arg0\Field29[$07] = createdoor(local17, (local9 - 14.5), -1.503906, (local11 - 0.5), 0.0, arg0, $01, $00, $00, "")
            arg0\Field29[$07]\Field20 = $00
            arg0\Field29[$07]\Field5 = $01
            local0 = createdoor(local17, (local9 - 14.5), -1.503906, (local11 - 9.125), 0.0, arg0, $00, $00, $00, "")
            local0\Field4 = $01
            local0\Field14 = $01
            local0 = createdoor(local17, (local9 - 26.8125), 0.0, (local11 - 4.875), 90.0, arg0, $01, $00, $00, "")
            local0\Field20 = $00
            local0\Field4 = $01
            local0 = createdoor(local17, (local9 - 22.875), 0.0, (local11 - 5.875), 0.0, arg0, $00, $00, $00, "")
            local0\Field4 = $01
            local0\Field14 = $01
            local0 = createdoor(local17, (local9 - 9.5), 0.0, (local11 - (1.0 / 0.256)), 0.0, arg0, $00, $00, $00, "")
            positionentity(local0\Field3[$00], (local9 - 10.125), entityy(local0\Field3[$00], $01), (local11 - 3.96875), $01)
            positionentity(local0\Field3[$01], (local9 - 10.125), entityy(local0\Field3[$00], $01), (local11 - 3.84375), $01)
            local0\Field4 = $01
            local0\Field14 = $01
            local29 = loadtexture_strict("GFX\map\Door02.jpg", $01)
            For local14 = 0.0 To 1.0 Step 1.0
                local0 = createdoor(local17, (local9 - 22.5), 0.0, ((((896.0 * local14) + 320.0) * (1.0 / 256.0)) + local11), 0.0, arg0, $00, $00, $00, "")
                local0\Field4 = $01
                local0\Field14 = $01
                local0 = createdoor(local17, (local9 - 32.375), 0.0, ((((896.0 * local14) + 320.0) * (1.0 / 256.0)) + local11), 0.0, arg0, $00, $00, $00, "")
                local0\Field4 = $01
                If (0.0 = local14) Then
                    local0\Field5 = $01
                Else
                    local0\Field14 = $01
                EndIf
                For local12 = 0.0 To 2.0 Step 1.0
                    local0 = createdoor(local17, (local9 - ((7424.0 - (512.0 * local12)) * (1.0 / 256.0))), 0.0, (((1008.0 - (480.0 * local14)) * (1.0 / 256.0)) + local11), (Float ((0.0 = local14) * $B4)), arg0, $00, $00, $00, "")
                    entitytexture(local0\Field0, local29, $00, $00)
                    local0\Field4 = $01
                    freeentity(local0\Field1)
                    local0\Field1 = $00
                    freeentity(local0\Field3[$00])
                    local0\Field3[$00] = $00
                    freeentity(local0\Field3[$01])
                    local0\Field3[$01] = $00
                    local0\Field14 = $01
                Next
                For local12 = 0.0 To 4.0 Step 1.0
                    local0 = createdoor(local17, (local9 - ((5120.0 - (512.0 * local12)) * (1.0 / 256.0))), 0.0, (((1008.0 - (480.0 * local14)) * (1.0 / 256.0)) + local11), (Float ((0.0 = local14) * $B4)), arg0, $00, $00, $00, "")
                    entitytexture(local0\Field0, local29, $00, $00)
                    local0\Field4 = $01
                    freeentity(local0\Field1)
                    local0\Field1 = $00
                    freeentity(local0\Field3[$00])
                    local0\Field3[$00] = $00
                    freeentity(local0\Field3[$01])
                    local0\Field3[$01] = $00
                    local0\Field14 = $01
                    If (((2.0 = local12) And (1.0 = local14)) <> 0) Then
                        arg0\Field29[$06] = local0
                    EndIf
                Next
            Next
            createitem("Class D Orientation Leaflet", "paper", (local9 - 15.38281), (1.0 / 1.505882), (local11 + (1.0 / 6.4)), $00, $00, $00, 1.0, $00, $01)
            local2 = createsecuritycam((local9 - 15.8125), (local10 - 0.125), (local11 - 4.8125), arg0, $01)
            local2\Field11 = 270.0
            local2\Field12 = 45.0
            local2\Field20 = arg0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field3, $01)
            positionentity(local2\Field4, (local9 - 8.8125), 0.875, (local11 - 3.625), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field3, $01)
        Case "room2ccont"
            local0 = createdoor(local17, (local9 + 0.25), 0.0, (local11 + 1.4375), 180.0, arg0, $00, $00, $02, "")
            local0\Field20 = $00
            local0\Field5 = $00
            If (networkserver\Field12 = $00) Then
                local6 = createitem("Note from Daniel", "paper", (local9 - (1.0 / 0.64)), 4.0625, (local11 + (1.0 / 2.226087)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            Else
                local6 = createitem("FN P90", "p90", (local9 - (1.0 / 0.64)), 4.0625, (local11 + (1.0 / 2.226087)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            EndIf
            For local23 = $00 To $02 Step $01
                arg0\Field25[(local23 Shl $01)] = copyentity(leverbaseobj, $00)
                arg0\Field25[((local23 Shl $01) + $01)] = copyentity(leverobj, $00)
                arg0\Field28[local23] = arg0\Field25[((local23 Shl $01) + $01)]
                For local7 = $00 To $01 Step $01
                    scaleentity(arg0\Field25[((local23 Shl $01) + local7)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field25[((local23 Shl $01) + local7)], (local9 - 0.9375), (local10 + 4.3125), (((632.0 - (64.0 * (Float local23))) * (1.0 / 256.0)) + local11), $01)
                    entityparent(arg0\Field25[((local23 Shl $01) + local7)], arg0\Field3, $01)
                Next
                rotateentity(arg0\Field25[(local23 Shl $01)], 0.0, -90.0, 0.0, $00)
                rotateentity(arg0\Field25[((local23 Shl $01) + $01)], 10.0, -270.0, 0.0, $00)
                entityradius(arg0\Field25[((local23 Shl $01) + $01)], 0.1, 0.0)
                addentitytoroomprops(arg0, arg0\Field25[(local23 Shl $01)])
                addentitytoroomprops(arg0, arg0\Field25[((local23 Shl $01) + $01)])
            Next
            local2 = createsecuritycam((local9 - 1.035156), (local10 + 5.0), (local11 + (1.0 / 2.438095)), arg0, $00)
            local2\Field11 = 45.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room106"
            local6 = createitem("Level 5 Key Card", "key5", (local9 - 2.9375), (local10 - 2.3125), (local11 + 11.82031), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Dr. Allok's Note", "paper", (local9 - 1.625), (local10 - 2.25), (local11 + 9.734375), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Recall Protocol RP-106-N", "paper", (local9 + 1.046875), (local10 - 2.25), (local11 + 10.12891), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local0 = createdoor(local17, (local9 - 3.78125), -2.984375, (local11 + 5.4375), 0.0, arg0, $00, $00, $04, "")
            local0\Field20 = $00
            local0\Field5 = $00
            local0 = createdoor(local17, local9, 0.0, (local11 - 1.8125), 0.0, arg0, $00, $00, $04, "")
            local0\Field20 = $00
            local0\Field5 = $00
            local0 = createdoor(local17, (local9 - 2.4375), -5.0, local11, 90.0, arg0, $00, $00, $04, "")
            local0\Field20 = $00
            local0\Field5 = $00
            If (networkserver\Field12 <> 0) Then
                local6 = createitem("Micro-HID", "microhid", (local9 - (1.0 / 1.078485)), (local10 - 2.25), (local11 + 9.701817), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            EndIf
            arg0\Field25[$06] = loadmesh_strict("GFX\map\room1062.b3d", $00)
            scaleentity(arg0\Field25[$06], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            entitytype(arg0\Field25[$06], $01, $00)
            entitypickmode(arg0\Field25[$06], $03, $01)
            positionentity(arg0\Field25[$06], (local9 + 3.0625), -3.828125, (local11 + 2.8125), $01)
            entityparent(arg0\Field25[$06], arg0\Field3, $01)
            addentitytoroomprops(arg0, arg0\Field25[$06])
            For local23 = $00 To $02 Step $02
                arg0\Field25[local23] = copyentity(leverbaseobj, $00)
                arg0\Field25[(local23 + $01)] = copyentity(leverobj, $00)
                arg0\Field28[(local23 Sar $01)] = arg0\Field25[(local23 + $01)]
                For local7 = $00 To $01 Step $01
                    scaleentity(arg0\Field25[(local23 + local7)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field25[(local23 + local7)], (local9 - ((555.0 - (81.0 * (Float (local23 Sar $01)))) * (1.0 / 256.0))), (local10 - 2.25), (local11 + 11.875), $01)
                    entityparent(arg0\Field25[(local23 + local7)], arg0\Field3, $01)
                Next
                rotateentity(arg0\Field25[local23], 0.0, 0.0, 0.0, $00)
                rotateentity(arg0\Field25[(local23 + $01)], 10.0, -180.0, 0.0, $00)
                entitypickmode(arg0\Field25[(local23 + $01)], $01, $00)
                entityradius(arg0\Field25[(local23 + $01)], 0.1, 0.0)
                addentitytoroomprops(arg0, arg0\Field25[local23])
                addentitytoroomprops(arg0, arg0\Field25[(local23 + $01)])
            Next
            rotateentity(arg0\Field25[$01], 81.0, -180.0, 0.0, $00)
            rotateentity(arg0\Field25[$03], -81.0, -180.0, 0.0, $00)
            arg0\Field25[$04] = createbutton((local9 - (1.0 / 1.753425)), (local10 - 2.25), (local11 + 11.89453), 0.0, 0.0, 0.0, $00)
            entityparent(arg0\Field25[$04], arg0\Field3, $01)
            local2 = createsecuritycam((local9 + 3.0), (local10 + 5.4375), (local11 + 6.625), arg0, $01)
            local2\Field11 = 315.0
            turnentity(local2\Field3, 45.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field3, $01)
            arg0\Field25[$07] = local2\Field3
            arg0\Field25[$08] = local2\Field0
            positionentity(local2\Field4, (local9 - 1.0625), -2.125, (local11 + 11.79688), $00)
            turnentity(local2\Field4, 0.0, -10.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field3, $01)
            local2\Field22 = $00
            arg0\Field25[$05] = createpivot($00)
            turnentity(arg0\Field25[$05], 0.0, 180.0, 0.0, $00)
            positionentity(arg0\Field25[$05], (local9 + 4.25), 4.3125, (local11 + 7.375), $00)
            entityparent(arg0\Field25[$05], arg0\Field3, $01)
            arg0\Field25[$09] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$09], (local9 - 1.0625), (local10 - 2.625), (local11 + 10.6875), $01)
            arg0\Field25[$0A] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$0A], local9, local10, (local11 - 2.8125), $01)
        Case "room1archive"
            If (networkserver\Field12 = $00) Then
                For local12 = 0.0 To 1.0 Step 1.0
                    For local13 = 0.0 To 2.0 Step 1.0
                        For local14 = 0.0 To 2.0 Step 1.0
                            local37 = "9V Battery"
                            local38 = "bat"
                            local39 = rand($FFFFFFF6, $64)
                            Select $01
                                Case (local39 < $00)
                                    Exit
                                Case (local39 < $28)
                                    local37 = "Document SCP-"
                                    Select rand($01, $06)
                                        Case $01
                                            local37 = (local37 + "1123")
                                        Case $02
                                            local37 = (local37 + "1048")
                                        Case $03
                                            local37 = (local37 + "939")
                                        Case $04
                                            local37 = (local37 + "682")
                                        Case $05
                                            local37 = (local37 + "079")
                                        Case $06
                                            local37 = (local37 + "096")
                                        Case $06
                                            local37 = (local37 + "966")
                                    End Select
                                    local38 = "paper"
                                Case ((local39 >= $28) And (local39 < $2D))
                                    local42 = rand($01, $02)
                                    local37 = (("Level " + (Str local42)) + " Key Card")
                                    local38 = ("key" + (Str local42))
                                Case ((local39 >= $2D) And (local39 < $32))
                                    local37 = "First Aid Kit"
                                    local38 = "firstaid"
                                Case ((local39 >= $32) And (local39 < $3C))
                                    local37 = "9V Battery"
                                    local38 = "bat"
                                Case ((local39 >= $3C) And (local39 < $46))
                                    local37 = "S-NAV 300 Navigator"
                                    local38 = "nav"
                                Case ((local39 >= $46) And (local39 < $55))
                                    local37 = "Radio Transceiver"
                                    local38 = "radio"
                                Case ((local39 >= $55) And (local39 < $5F))
                                    local37 = "Clipboard"
                                    local38 = "clipboard"
                                Case ((local39 >= $5F) And (local39 <= $64))
                                    local42 = rand($01, $03)
                                    Select local42
                                        Case $01
                                            local37 = "Playing Card"
                                        Case $02
                                            local37 = "Mastercard"
                                        Case $03
                                            local37 = "Origami"
                                    End Select
                                    local38 = "misc"
                            End Select
                            local26 = (((864.0 * local12) + -672.0) * (1.0 / 256.0))
                            local44 = (((96.0 * local13) + 96.0) * (1.0 / 256.0))
                            local27 = (((480.0 - (352.0 * local14)) + rnd(-96.0, 96.0)) * (1.0 / 256.0))
                            local6 = createitem(local37, local38, (local9 + local26), local44, (local11 + local27), $00, $00, $00, 1.0, $00, $01)
                            If (local6 <> Null) Then
                                entityparent(local6\Field2, arg0\Field3, $01)
                            EndIf
                        Next
                    Next
                Next
            Else
                For local12 = 0.0 To 1.0 Step 1.0
                    For local13 = 0.0 To 2.0 Step 1.0
                        For local14 = 0.0 To 2.0 Step 1.0
                            local37 = "9V Battery"
                            local38 = "bat"
                            local39 = rand($FFFFFFF6, $64)
                            Select $01
                                Case (local39 < $00)
                                    Exit
                                Case (local39 < $28)
                                    local42 = rand($01, $06)
                                    Select local42
                                        Case $01
                                            local37 = "MP5-SD"
                                            local38 = "mp5sd"
                                        Case $02
                                            local37 = "Small First Aid Kit"
                                            local38 = "finefirstaid"
                                        Case $03
                                            local37 = "Box of ammo"
                                            local38 = "boxofammo"
                                        Case $04
                                            local37 = "FN P90"
                                            local38 = "p90"
                                        Case $05
                                            local37 = "USP Tactical"
                                            local38 = "usp"
                                        Case $06
                                            local37 = "Gas Mask"
                                            local38 = "gasmask"
                                    End Select
                                Case ((local39 >= $28) And (local39 < $2D))
                                    local42 = rand($01, $03)
                                    local37 = (("Level " + (Str local42)) + " Key Card")
                                    local38 = ("key" + (Str local42))
                                Case ((local39 >= $2D) And (local39 < $32))
                                    local37 = "First Aid Kit"
                                    local38 = "firstaid"
                                Case ((local39 >= $32) And (local39 < $3C))
                                    local42 = rand($01, $06)
                                    Select local42
                                        Case $01
                                            local37 = "MP5-SD"
                                            local38 = "mp5sd"
                                        Case $02
                                            local37 = "Rocket Launcher"
                                            local38 = "rpg"
                                        Case $03
                                            local37 = "Small First Aid Kit"
                                            local38 = "finefirstaid"
                                        Case $04
                                            local37 = "FN P90"
                                            local38 = "p90"
                                        Case $05
                                            local37 = "USP Tactical"
                                            local38 = "usp"
                                        Case $06
                                            local37 = "Gas Mask"
                                            local38 = "gasmask"
                                    End Select
                                Case ((local39 >= $3C) And (local39 < $46))
                                    local42 = rand($01, $06)
                                    Select local42
                                        Case $01
                                            local37 = "MP5-SD"
                                            local38 = "mp5sd"
                                        Case $02
                                            local37 = "Small First Aid Kit"
                                            local38 = "finefirstaid"
                                        Case $03
                                            local37 = "Minigun"
                                            local38 = "minigun"
                                        Case $04
                                            local37 = "FN P90"
                                            local38 = "p90"
                                        Case $05
                                            local37 = "USP Tactical"
                                            local38 = "usp"
                                        Case $06
                                            local37 = "Gas Mask"
                                            local38 = "gasmask"
                                    End Select
                                Case ((local39 >= $46) And (local39 < $55))
                                    local42 = rand($01, $06)
                                    Select local42
                                        Case $01
                                            local37 = "MP5-SD"
                                            local38 = "mp5sd"
                                        Case $02
                                            local37 = "Rocket Launcher"
                                            local38 = "rpg"
                                        Case $03
                                            local37 = "Small First Aid Kit"
                                            local38 = "finefirstaid"
                                        Case $04
                                            local37 = "FN P90"
                                            local38 = "p90"
                                        Case $05
                                            local37 = "USP Tactical"
                                            local38 = "usp"
                                        Case $06
                                            local37 = "Gas Mask"
                                            local38 = "gasmask"
                                    End Select
                                Case ((local39 >= $55) And (local39 < $5F))
                                    local42 = rand($01, $06)
                                    Select local42
                                        Case $01
                                            local37 = "Small First Aid Kit"
                                            local38 = "finefirstaid"
                                        Case $02
                                            local37 = "Rocket Launcher"
                                            local38 = "rpg"
                                        Case $03
                                            local37 = "Box of ammo"
                                            local38 = "boxofammo"
                                        Case $04
                                            local37 = "FN P90"
                                            local38 = "p90"
                                        Case $05
                                            local37 = "USP Tactical"
                                            local38 = "usp"
                                        Case $06
                                            local37 = "Gas Mask"
                                            local38 = "gasmask"
                                    End Select
                                Case ((local39 >= $5F) And (local39 <= $64))
                                    local42 = rand($01, $06)
                                    Select local42
                                        Case $01
                                            local37 = "MP5-SD"
                                            local38 = "mp5sd"
                                        Case $02
                                            local37 = "Small First Aid Kit"
                                            local38 = "finefirstaid"
                                        Case $03
                                            local37 = "Minigun"
                                            local38 = "minigun"
                                        Case $04
                                            local37 = "FN P90"
                                            local38 = "p90"
                                        Case $05
                                            local37 = "USP Tactical"
                                            local38 = "usp"
                                        Case $06
                                            local37 = "Gas Mask"
                                            local38 = "gasmask"
                                    End Select
                            End Select
                            local26 = (((864.0 * local12) + -672.0) * (1.0 / 256.0))
                            local44 = (((96.0 * local13) + 96.0) * (1.0 / 256.0))
                            local27 = (((480.0 - (352.0 * local14)) + rnd(-96.0, 96.0)) * (1.0 / 256.0))
                            local6 = createitem(local37, local38, (local9 + local26), local44, (local11 + local27), $00, $00, $00, 1.0, $00, $01)
                            entityparent(local6\Field2, arg0\Field3, $01)
                        Next
                    Next
                Next
            EndIf
            arg0\Field29[$00] = createdoor(local17, local9, local10, (local11 - 2.0625), 0.0, arg0, $00, $00, $06, "")
            local2 = createsecuritycam((local9 - 1.0), (local10 + 1.5), (local11 + 2.5), arg0, $00)
            local2\Field11 = 180.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room2test1074"
            arg0\Field29[$00] = createdoor(local17, local9, local10, local11, 0.0, arg0, $00, $00, $00, "")
            arg0\Field29[$00]\Field4 = $01
            arg0\Field29[$01] = createdoor(local17, (local9 + 1.3125), local10, (local11 + 2.621094), 90.0, arg0, $01, $00, $03, "")
            arg0\Field29[$01]\Field20 = $00
            arg0\Field29[$02] = createdoor(local17, (local9 + 1.3125), local10, (local11 - 3.125), 90.0, arg0, $01, $00, $03, "")
            arg0\Field29[$02]\Field20 = $00
            arg0\Field29[$03] = createdoor(local17, (local9 + 2.625), local10, local11, 0.0, arg0, $00, $00, $00, "")
            arg0\Field37[$00] = loadtexture("GFX\map\1074tex0.jpg", $01)
            arg0\Field37[$01] = loadtexture("GFX\map\1074tex1.jpg", $01)
            textureblend(arg0\Field37[$00], $05)
            textureblend(arg0\Field37[$01], $05)
            local6 = createitem("Document SCP-1074", "paper", (local9 + 1.171875), (local10 + (1.0 / 12.8)), (local11 + 2.621094), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (local9 + 3.261719), (local10 + (1.0 / 1.551515)), (local11 + 2.109375), $01)
            entityparent(arg0\Field25[$00], arg0\Field3, $01)
            arg0\Field25[$01] = createpivot($00)
            positionentity(arg0\Field25[$01], (local9 + 3.261719), (local10 + (1.0 / 25.6)), (local11 + 1.171875), $01)
            entityparent(arg0\Field25[$01], arg0\Field3, $01)
            local52 = getchild(arg0\Field3, $02)
            arg0\Field36[$00] = getsurface(local52, $01)
            For local53 = $01 To countsurfaces(local52) Step $01
                local54 = getsurface(local52, local53)
                local55 = getsurfacebrush(local54)
                local56 = getbrushtexture(local55, $01)
                local57 = strippath(texturename(local56))
                If (lower(local57) = "1074tex1.jpg") Then
                    arg0\Field36[$00] = local54
                    freetexture(local56)
                    freebrush(local55)
                    Exit
                EndIf
                If (local57 <> "") Then
                    freetexture(local56)
                EndIf
                freebrush(local55)
            Next
        Case "room1123"
            If (networkserver\Field12 = $00) Then
                local6 = createitem("Document SCP-1123", "paper", (local9 + 1.996094), (local10 + (1.0 / 2.048)), (local11 - 3.65625), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (local9 + 1.996094), (local10 + (1.0 / 2.048)), (local11 - 3.65625), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            EndIf
            local6 = createitem("SCP-1123", "1123", (local9 + 3.25), (local10 + (1.0 / 1.542169)), (local11 + 3.0625), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Leaflet", "paper", (local9 - 3.1875), (local10 + 2.75), (local11 + 3.46875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Gas Mask", "gasmask", (local9 + 1.785156), (local10 + (1.0 / 1.706667)), (local11 + 3.75), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local0 = createdoor(local17, (local9 + 3.25), 0.0, (local11 + 1.433594), 0.0, arg0, $00, $00, $03, "")
            positionentity(local0\Field3[$00], (local9 + 3.734375), entityy(local0\Field3[$00], $01), (local11 + 1.375), $01)
            positionentity(local0\Field3[$01], (local9 + 2.785156), entityy(local0\Field3[$01], $01), (local11 + 1.5), $01)
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(local17, (local9 + 1.09375), 0.0, (local11 - 2.371094), 90.0, arg0, $00, $00, $00, "")
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(local17, (local9 + 1.09375), 2.0, (local11 - 2.371094), 90.0, arg0, $00, $00, $00, "")
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            arg0\Field29[$00] = local0
            arg0\Field25[$03] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$03], (local9 + 3.25), (local10 + (1.0 / 1.542169)), (local11 + 3.0625), $01)
            arg0\Field25[$04] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$04], (local9 - 2.53125), (local10 + 2.3125), (local11 + 2.703125), $01)
            arg0\Field25[$05] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$05], (local9 + 3.234375), (local10 + 2.3125), (local11 + 2.3125), $01)
            arg0\Field25[$06] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$06], (local9 - 0.296875), (local10 + 2.421875), (local11 + 2.90625), $01)
            arg0\Field25[$07] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$07], (local9 - 2.5), (local10 + 2.421875), (local11 - 3.375), $01)
            arg0\Field25[$08] = loadmesh_strict("GFX\map\forest\door_frame.b3d", $00)
            entitypickmode(arg0\Field25[$08], $02, $01)
            entitytype(arg0\Field25[$08], $01, $00)
            positionentity(arg0\Field25[$08], (local9 - 1.0625), 2.0, (local11 + 1.125), $01)
            rotateentity(arg0\Field25[$08], 0.0, 90.0, 0.0, $01)
            scaleentity(arg0\Field25[$08], (1.0 / 5.688889), (1.0 / 5.688889), (1.0 / 3.2), $01)
            entityparent(arg0\Field25[$08], arg0\Field3, $01)
            addentitytoroomprops(arg0, arg0\Field25[$08])
            arg0\Field25[$09] = loadmesh_strict("GFX\map\forest\door.b3d", $00)
            positionentity(arg0\Field25[$09], (local9 - 1.0625), 2.0, (local11 + (1.0 / 1.174312)), $01)
            rotateentity(arg0\Field25[$09], 0.0, 10.0, 0.0, $01)
            entitypickmode(arg0\Field25[$09], $02, $01)
            entitytype(arg0\Field25[$09], $01, $00)
            scaleentity(arg0\Field25[$09], (1.0 / 5.565217), (1.0 / 5.688889), (1.0 / 5.565217), $01)
            entityparent(arg0\Field25[$09], arg0\Field3, $01)
            addentitytoroomprops(arg0, arg0\Field25[$09])
            arg0\Field25[$0A] = copyentity(arg0\Field25[$08], $00)
            positionentity(arg0\Field25[$0A], (local9 - 1.0625), 2.0, (local11 + 2.875), $01)
            rotateentity(arg0\Field25[$0A], 0.0, 90.0, 0.0, $01)
            scaleentity(arg0\Field25[$0A], (1.0 / 5.688889), (1.0 / 5.688889), (1.0 / 3.2), $01)
            entityparent(arg0\Field25[$0A], arg0\Field3, $01)
            addentitytoroomprops(arg0, arg0\Field25[$0A])
            arg0\Field25[$0B] = copyentity(arg0\Field25[$09], $00)
            positionentity(arg0\Field25[$0B], (local9 - 1.0625), 2.0, (local11 + 2.601562), $01)
            rotateentity(arg0\Field25[$0B], 0.0, 90.0, 0.0, $01)
            entitytype(arg0\Field25[$0B], $01, $00)
            scaleentity(arg0\Field25[$0B], (1.0 / 5.565217), (1.0 / 5.688889), (1.0 / 5.565217), $01)
            entityparent(arg0\Field25[$0B], arg0\Field3, $01)
            addentitytoroomprops(arg0, arg0\Field25[$0B])
            arg0\Field25[$0C] = copyentity(arg0\Field25[$08], $00)
            positionentity(arg0\Field25[$0C], (local9 - 2.3125), 2.0, (local11 - 2.75), $01)
            rotateentity(arg0\Field25[$0C], 0.0, 0.0, 0.0, $01)
            scaleentity(arg0\Field25[$0C], (1.0 / 5.688889), (1.0 / 5.688889), (1.0 / 3.2), $01)
            entityparent(arg0\Field25[$0C], arg0\Field3, $01)
            addentitytoroomprops(arg0, arg0\Field25[$0C])
            arg0\Field25[$0D] = copyentity(arg0\Field25[$09], $00)
            positionentity(arg0\Field25[$0D], (local9 - 2.585938), 2.0, (local11 - 2.75), $01)
            rotateentity(arg0\Field25[$0D], 0.0, 0.0, 0.0, $01)
            entitytype(arg0\Field25[$0D], $01, $00)
            scaleentity(arg0\Field25[$0D], (1.0 / 5.565217), (1.0 / 5.688889), (1.0 / 5.565217), $01)
            entityparent(arg0\Field25[$0D], arg0\Field3, $01)
            addentitytoroomprops(arg0, arg0\Field25[$0D])
            arg0\Field25[$0E] = loadmesh_strict("GFX\map\1123_hb.b3d", arg0\Field3)
            entitypickmode(arg0\Field25[$0E], $02, $01)
            entitytype(arg0\Field25[$0E], $01, $00)
            entityalpha(arg0\Field25[$0E], 0.0)
        Case "pocketdimension"
            local58 = loadmesh_strict("GFX\map\pocketdimension2.b3d", $00)
            arg0\Field25[$08] = loadmesh_strict("GFX\map\pocketdimension3.b3d", $00)
            arg0\Field25[$09] = loadmesh_strict("GFX\map\pocketdimension4.b3d", $00)
            arg0\Field25[$0A] = copyentity(arg0\Field25[$09], $00)
            arg0\Field25[$0B] = loadmesh_strict("GFX\map\pocketdimension5.b3d", $00)
            addentitytoroomprops(arg0, arg0\Field25[$08])
            addentitytoroomprops(arg0, arg0\Field25[$09])
            addentitytoroomprops(arg0, arg0\Field25[$0A])
            addentitytoroomprops(arg0, arg0\Field25[$0B])
            local59 = loadmesh_strict("GFX\map\pocketdimensionterrain.b3d", $00)
            scaleentity(local59, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $01)
            positionentity(local59, 0.0, 2944.0, 0.0, $01)
            createitem("Burnt Note", "paper", entityx(arg0\Field3, $00), 0.5, (entityz(arg0\Field3, $00) + 3.5), $00, $00, $00, 1.0, $00, $01)
            For local23 = $00 To $FFFFFFFF Step $01
                Select local23
                    Case $00
                        local61 = local58
                    Case $01
                        local61 = arg0\Field25[$08]
                    Case $02
                        local61 = arg0\Field25[$09]
                    Case $03
                        local61 = arg0\Field25[$0A]
                    Case $04
                        local61 = arg0\Field25[$0B]
                End Select
            Next
            For local7 = $08 To $0B Step $01
                scaleentity(arg0\Field25[local7], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                entitytype(arg0\Field25[local7], $01, $00)
                entitypickmode(arg0\Field25[local7], $02, $01)
                positionentity(arg0\Field25[local7], local9, local10, (local11 + 32.0), $01)
            Next
            scaleentity(local59, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            entitytype(local59, $01, $00)
            entitypickmode(local59, $03, $01)
            positionentity(local59, local9, (local10 + 11.5), (local11 + 32.0), $01)
            arg0\Field29[$00] = createdoor($00, local9, 8.0, ((local11 + 32.0) - 4.0), 0.0, arg0, $00, $00, $00, "")
            arg0\Field29[$01] = createdoor($00, local9, 8.0, ((local11 + 32.0) + 4.0), 180.0, arg0, $00, $00, $00, "")
            local3 = createdecal($12, (local9 - 6.0), 0.02, ((local11 + 2.375) + 32.0), 90.0, 0.0, 0.0, 1.0, 1.0)
            entityparent(local3\Field0, arg0\Field3, $01)
            local3\Field2 = rnd(0.8, 0.8)
            local3\Field6 = $02
            local3\Field7 = $09
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityfx(local3\Field0, $09)
            entityblend(local3\Field0, $02)
            scaleentity(arg0\Field25[$0A], (1.0 / 170.6667), (1.0 / 128.0), (1.0 / 170.6667), $01)
            positionentity(arg0\Field25[$0B], local9, local10, (local11 + 64.0), $01)
            For local7 = $01 To $08 Step $01
                arg0\Field25[(local7 - $01)] = copyentity(local58, $00)
                scaleentity(arg0\Field25[(local7 - $01)], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                local62 = ((Float (local7 - $01)) * 45.0)
                entitytype(arg0\Field25[(local7 - $01)], $01, $00)
                entitypickmode(arg0\Field25[(local7 - $01)], $02, $01)
                rotateentity(arg0\Field25[(local7 - $01)], 0.0, (local62 - 90.0), 0.0, $00)
                positionentity(arg0\Field25[(local7 - $01)], ((cos(local62) * 2.0) + local9), 0.0, ((sin(local62) * 2.0) + local11), $00)
                entityparent(arg0\Field25[(local7 - $01)], arg0\Field3, $01)
                If (local7 < $06) Then
                    local3 = createdecal((local7 + $07), (((cos(local62) * 2.0) * 3.0) + local9), 0.02, (((sin(local62) * 2.0) * 3.0) + local11), 90.0, (local62 - 90.0), 0.0, 1.0, 1.0)
                    local3\Field2 = rnd(0.5, 0.5)
                    local3\Field6 = $02
                    local3\Field7 = $09
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                    entityfx(local3\Field0, $09)
                    entityblend(local3\Field0, $02)
                EndIf
                addentitytoroomprops(arg0, arg0\Field25[(local7 - $01)])
            Next
            For local7 = $0C To $10 Step $01
                arg0\Field25[local7] = createpivot(arg0\Field25[$0B])
                Select local7
                    Case $0C
                        positionentity(arg0\Field25[local7], local9, (local10 + (1.0 / 1.28)), (local11 + 64.0), $01)
                    Case $0D
                        positionentity(arg0\Field25[local7], (local9 + 1.523438), (local10 + (1.0 / 1.28)), ((local11 + 64.0) + 1.0625), $01)
                    Case $0E
                        positionentity(arg0\Field25[local7], (local9 + 3.273438), (local10 + (1.0 / 1.28)), ((local11 + 64.0) - 2.152344), $01)
                    Case $0F
                        positionentity(arg0\Field25[local7], (local9 - (1.0 / 1.841727)), (local10 + (1.0 / 1.28)), ((local11 + 64.0) + 4.691406), $01)
                    Case $10
                        positionentity(arg0\Field25[local7], (local9 - 4.835938), (local10 - 6.5), ((local11 + 64.0) + 1.488281), $01)
                End Select
            Next
            local64 = loadtexture_strict("GFX\npcs\oldmaneyes.jpg", $01)
            arg0\Field25[$11] = createsprite($00)
            scalesprite(arg0\Field25[$11], 0.03, 0.03)
            entitytexture(arg0\Field25[$11], local64, $00, $00)
            entityblend(arg0\Field25[$11], $03)
            entityfx(arg0\Field25[$11], $09)
            spriteviewmode(arg0\Field25[$11], $02)
            arg0\Field27[$12] = loadtexture_strict("GFX\npcs\pdplane.png", $03)
            arg0\Field27[$13] = loadtexture_strict("GFX\npcs\pdplaneeye.png", $03)
            arg0\Field25[$14] = createsprite($00)
            scalesprite(arg0\Field25[$14], 8.0, 8.0)
            entitytexture(arg0\Field25[$14], arg0\Field27[$12], $00, $00)
            entityorder(arg0\Field25[$14], $64)
            entityblend(arg0\Field25[$14], $02)
            entityfx(arg0\Field25[$14], $09)
            spriteviewmode(arg0\Field25[$14], $02)
            freetexture(local56)
            freeentity(local58)
            freetexture(local64)
        Case "room3z3"
            local2 = createsecuritycam((local9 - 1.25), (local10 + 1.5), (local11 + 2.000977), arg0, $00)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room2_3","room3_3"
            local31 = createwaypoint(local9, (local10 + (1.0 / 3.878788)), local11, Null, arg0)
        Case "room1lifts"
            arg0\Field25[$00] = createbutton((local9 + 0.375), (local10 + 0.625), (local11 + 0.25), 0.0, 0.0, 0.0, $00)
            entityparent(arg0\Field25[$00], arg0\Field3, $01)
            arg0\Field25[$01] = createbutton((local9 - 0.375), (local10 + 0.625), (local11 + 0.25), 0.0, 0.0, 0.0, $00)
            entityparent(arg0\Field25[$01], arg0\Field3, $01)
            local2 = createsecuritycam((local9 + 1.5), (local10 + 1.5), (local11 - 3.75), arg0, $00)
            local2\Field11 = 45.0
            local2\Field12 = 45.0
            local2\Field20 = arg0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field3, $01)
            local31 = createwaypoint(local9, (local10 + (1.0 / 3.878788)), local11, Null, arg0)
        Case "room2servers2"
            local0 = createdoor(local17, (local9 + 1.03125), 0.0, (local11 + 2.625), 270.0, arg0, $00, $00, $03, "")
            positionentity(local0\Field3[$00], (local9 + 0.875), entityy(local0\Field3[$00], $01), (local11 + 1.992188), $01)
            positionentity(local0\Field3[$01], (local9 + 1.1875), entityy(local0\Field3[$01], $01), (local11 + 3.28125), $01)
            turnentity(local0\Field3[$01], 0.0, 0.0, 0.0, $01)
            local0 = createdoor(local17, (local9 - 2.0), -3.0, (local11 - 1.3125), 0.0, arg0, $00, $00, $03, "")
            local0 = createdoor(local17, (local9 - 1.988281), -3.0, (local11 - 4.050781), 0.0, arg0, $00, $00, $03, "")
            local0\Field4 = $01
            local0\Field14 = $01
            local6 = createitem("Night Vision Goggles", "nvgoggles", (local9 + (1.0 / 4.570172)), (local10 - 2.53125), (local11 + 2.928273), $00, $00, $00, 1.0, $00, $01)
            local6\Field13 = 200.0
            rotateentity(local6\Field2, 0.0, (Float (arg0\Field7 + rand($F5, $01))), 0.0, $00)
            entityparent(local6\Field2, arg0\Field3, $01)
        Case "room2gw","room2gw_b"
            If (arg0\Field8\Field11 = "room2gw_b") Then
                arg0\Field25[$02] = createpivot(arg0\Field3)
                positionentity(arg0\Field25[$02], (local9 - (1.0 / 1.632393)), -0.145882, (local11 + (1.0 / 2.109357)), $01)
                local3 = createdecal($03, (local9 - (1.0 / 1.632393)), -0.145882, (local11 + (1.0 / 2.109357)), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
                local3\Field2 = 0.5
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                entityparent(local3\Field0, arg0\Field3, $01)
                arg0\Field25[$00] = createpivot($00)
                positionentity(arg0\Field25[$00], (local9 + 1.09375), (local10 + 1.347656), (local11 - 1.328125), $01)
                entityparent(arg0\Field25[$00], arg0\Field3, $01)
            EndIf
            arg0\Field25[$03] = createpivot($00)
            entityparent(arg0\Field25[$03], arg0\Field3, $01)
            arg0\Field29[$00] = createdoor(local17, (local9 + 1.3125), 0.0, (local11 - 1.492188), 0.0, arg0, $00, $00, $00, "")
            positionentity(arg0\Field29[$00]\Field3[$00], (local9 + 2.268836), entityy(arg0\Field29[$00]\Field3[$00], $01), (local11 - 2.36984), $01)
            positionentity(arg0\Field29[$00]\Field3[$01], (local9 + 2.268836), entityy(arg0\Field29[$00]\Field3[$01], $01), (local11 - 2.36984), $01)
            arg0\Field29[$00]\Field9 = $00
            arg0\Field29[$00]\Field20 = $00
            arg0\Field29[$00]\Field5 = $01
            arg0\Field29[$00]\Field4 = $01
            arg0\Field29[$00]\Field23 = $00
            arg0\Field29[$01] = createdoor(local17, (local9 + 1.3125), 0.0, (local11 + 1.804688), 180.0, arg0, $00, $00, $00, "")
            positionentity(arg0\Field29[$01]\Field3[$00], (local9 + 2.268836), entityy(arg0\Field29[$01]\Field3[$00], $01), (local11 - 2.36984), $01)
            positionentity(arg0\Field29[$01]\Field3[$01], (local9 + 2.268836), entityy(arg0\Field29[$01]\Field3[$01], $01), (local11 - 2.36984), $01)
            arg0\Field29[$01]\Field9 = $00
            arg0\Field29[$01]\Field20 = $00
            arg0\Field29[$01]\Field5 = $01
            arg0\Field29[$01]\Field4 = $01
            arg0\Field29[$01]\Field23 = $00
            If (arg0\Field25[$03] = $00) Then
                arg0\Field25[$03] = createpivot($00)
            EndIf
            entitypickmode(arg0\Field25[$03], $02, $01)
            addentitytoroomprops(arg0, arg0\Field25[$03])
            If (arg0\Field8\Field11 = "room2gw") Then
                arg0\Field25[$00] = createpivot($00)
                positionentity(arg0\Field25[$00], (local9 + 1.34375), 0.5, local11, $00)
                entityparent(arg0\Field25[$00], arg0\Field3, $01)
                local65 = $00
                If (room2gw_brokendoor <> 0) Then
                    If (local9 = room2gw_x) Then
                        If (local11 = room2gw_z) Then
                            local65 = $01
                        EndIf
                    EndIf
                EndIf
                If ((((room2gw_brokendoor = $00) And (rand($01, $02) = $01)) Or local65) <> 0) Then
                    arg0\Field25[$01] = copyentity(doorobj, $00)
                    scaleentity(arg0\Field25[$01], (0.796875 / meshwidth(arg0\Field25[$01])), (1.21875 / meshheight(arg0\Field25[$01])), ((1.0 / 16.0) / meshdepth(arg0\Field25[$01])), $00)
                    entitytype(arg0\Field25[$01], $01, $00)
                    positionentity(arg0\Field25[$01], (local9 + 1.3125), 0.0, (local11 + 1.804688), $00)
                    rotateentity(arg0\Field25[$01], 0.0, 360.0, 0.0, $00)
                    entityparent(arg0\Field25[$01], arg0\Field3, $01)
                    moveentity(arg0\Field25[$01], 120.0, 0.0, 5.0)
                    room2gw_brokendoor = $01
                    room2gw_x = local9
                    room2gw_z = local11
                    freeentity(arg0\Field29[$01]\Field1)
                    arg0\Field29[$01]\Field1 = $00
                    addentitytoroomprops(arg0, arg0\Field25[$01])
                EndIf
            EndIf
        Case "room3gw"
            local0 = createdoor(local17, (local9 - 2.84375), 0.0, (local11 - 1.789062), 0.0, arg0, $00, $00, $03, "")
            local0\Field20 = $00
            local0\Field5 = $00
            local0\Field4 = $00
            local0 = createdoor(local17, (local9 - (1.0 / 1.147982)), 0.0, (local11 - 2.875), -90.0, arg0, $00, $00, $03, "")
            local0\Field20 = $00
            local0\Field5 = $00
            local0\Field4 = $00
            arg0\Field29[$00] = createdoor(local17, (local9 - 1.792969), 0.0, (local11 + 1.324219), 90.0, arg0, $00, $00, $00, "")
            positionentity(arg0\Field29[$00]\Field3[$00], (local9 + 2.268836), entityy(arg0\Field29[$00]\Field3[$00], $01), (local11 - 2.36984), $01)
            positionentity(arg0\Field29[$00]\Field3[$01], (local9 + 2.268836), entityy(arg0\Field29[$00]\Field3[$01], $01), (local11 - 2.36984), $01)
            arg0\Field29[$00]\Field9 = $00
            arg0\Field29[$00]\Field20 = $00
            arg0\Field29[$00]\Field5 = $01
            arg0\Field29[$00]\Field4 = $01
            arg0\Field29[$00]\Field23 = $00
            arg0\Field29[$01] = createdoor(local17, (local9 + 1.503906), 0.0, (local11 + 1.324219), 270.0, arg0, $00, $00, $00, "")
            positionentity(arg0\Field29[$01]\Field3[$00], (local9 + 2.268836), entityy(arg0\Field29[$01]\Field3[$00], $01), (local11 - 2.36984), $01)
            positionentity(arg0\Field29[$01]\Field3[$01], (local9 + 2.268836), entityy(arg0\Field29[$01]\Field3[$01], $01), (local11 - 2.36984), $01)
            arg0\Field29[$01]\Field9 = $00
            arg0\Field29[$01]\Field20 = $00
            arg0\Field29[$01]\Field5 = $01
            arg0\Field29[$01]\Field4 = $01
            arg0\Field29[$01]\Field23 = $00
            freeentity(arg0\Field29[$01]\Field1)
            arg0\Field29[$01]\Field1 = $00
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (local9 - 0.1875), 0.5, (local11 + 1.25), $00)
            entityparent(arg0\Field25[$00], arg0\Field3, $01)
            local66 = createbutton((arg0\Field4 + (1.0 / 2.56)), (arg0\Field5 + (1.0 / 1.446328)), (arg0\Field6 - 1.863281), 359.0, -1.0, 379.0, $01)
            entityparent(local66, arg0\Field3, $01)
            local66 = createbutton((arg0\Field4 + (1.0 / 3.084337)), (arg0\Field5 + 0.6875), (arg0\Field6 - 1.703125), 360.0, 180.0, 360.0, $01)
            entityparent(local66, arg0\Field3, $01)
            local66 = createbutton((arg0\Field4 - 0.375), (arg0\Field5 + 0.453125), (arg0\Field6 + (1.0 / 2.438095)), 79.0, -1.0, 3.0, $00)
            entityparent(local66, arg0\Field3, $01)
            local66 = createbutton((arg0\Field4 + (1.0 / 2.485437)), (arg0\Field5 + 0.453125), (arg0\Field6 + (1.0 / 2.438095)), 79.0, -1.0, 3.0, $00)
            entityparent(local66, arg0\Field3, $01)
            For local4 = Each rooms
                If (local4 <> arg0) Then
                    If (local4\Field8\Field11 = "room3gw") Then
                        arg0\Field25[$03] = copyentity(local4\Field25[$03], arg0\Field3)
                        Exit
                    EndIf
                EndIf
            Next
        Case "room1162"
            local0 = createdoor(local17, (local9 + 0.96875), 0.0, (local11 - 2.875), 90.0, arg0, $00, $00, ($02 - networkserver\Field12), "")
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (local9 + 3.953125), (local10 + 0.5), (local11 - 2.5), $00)
            entityparent(arg0\Field25[$00], arg0\Field3, $01)
            If (networkserver\Field12 = $00) Then
                local6 = createitem("Document SCP-1162", "paper", (local9 + 3.37198), (local10 + 0.59375), (local11 - 3.723559), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (local9 + 3.37198), (local10 + 0.59375), (local11 - 3.723559), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
                local6 = createitem("Level 2 Key Card", "key2", (local9 + 3.383699), (local10 + 0.59375), (local11 - 3.723559), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            EndIf
            local2 = createsecuritycam((local9 - 0.75), (local10 + 2.75), (local11 + 0.75), arg0, $00)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room2scps2"
            arg0\Field29[$00] = createdoor(local17, (local9 + 1.125), local10, (local11 + 2.25), 90.0, arg0, $00, $00, $03, "")
            arg0\Field29[$00]\Field5 = $00
            arg0\Field29[$00]\Field4 = $01
            local0 = createdoor(local17, (local9 + 3.035156), local10, (local11 + 2.621094), 90.0, arg0, $00, $00, $04, "")
            local0 = createdoor(local17, (local9 + 2.171875), local10, (local11 + 1.15625), 0.0, arg0, $00, $00, $03, "")
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (local9 + 2.25), (local10 + 0.625), (local11 + 2.46875), $00)
            entityparent(arg0\Field25[$00], arg0\Field3, $01)
            If (networkserver\Field12 = $00) Then
                local6 = createitem("SCP-1499", "scp1499", (local9 + 2.34375), (local10 + 0.6875), (local11 - 0.890625), $00, $00, $00, 1.0, $00, $01)
                rotateentity(local6\Field2, 0.0, (Float arg0\Field7), 0.0, $00)
                entityparent(local6\Field2, arg0\Field3, $01)
            EndIf
            local6 = createitem("Document SCP-1499", "paper", (local9 + 3.28125), (local10 + 1.015625), (local11 + 0.875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            If (networkserver\Field12 = $00) Then
                local6 = createitem("Document SCP-500", "paper", (local9 + 4.5), (local10 + 0.875), (local11 + 1.3125), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            Else
                local6 = createitem("FN P90", "p90", (local9 + 4.5), (local10 + 0.875), (local11 + 1.3125), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field2, arg0\Field3, $01)
            EndIf
            local6 = createitem("Emily Ross' Badge", "badge", (local9 + 1.421875), (local10 + (1.0 / 51.2)), (local11 + 2.796875), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local2 = createsecuritycam((local9 + 3.320312), (local10 + 1.367188), (local11 + 3.421875), arg0, $00)
            local2\Field11 = 220.0
            local2\Field12 = 30.0
            turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field3, $01)
            local2 = createsecuritycam((local9 + 2.34375), (local10 + 2.007812), (local11 + (1.0 / 1.706667)), arg0, $00)
            local2\Field11 = 180.0
            local2\Field12 = 30.0
            turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field3, $01)
        Case "room3offices"
            local0 = createdoor(local17, (local9 + 2.875), 0.0, (local11 + 0.9375), 0.0, arg0, $00, $00, $03, "")
            positionentity(local0\Field3[$00], (local9 + 3.484375), entityy(local0\Field3[$00], $01), (local11 + 0.875), $01)
            positionentity(local0\Field3[$01], (local9 + 3.484375), entityy(local0\Field3[$01], $01), (local11 + (1.0 / 1.003922)), $01)
            freeentity(local0\Field1)
            local0\Field1 = $00
            arg0\Field25[$00] = loadmesh_strict("GFX\map\room3offices_hb.b3d", arg0\Field3)
            entitypickmode(arg0\Field25[$00], $02, $01)
            entitytype(arg0\Field25[$00], $01, $00)
            entityalpha(arg0\Field25[$00], 0.0)
        Case "room2offices4"
            local0 = createdoor($00, (local9 - 0.9375), 0.0, local11, 90.0, arg0, $00, $00, $00, "")
            positionentity(local0\Field3[$00], (local9 - (1.0 / 1.113043)), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (local9 - (1.0 / 1.024)), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0\Field5 = $00
            local0\Field20 = $00
            local6 = createitem("Sticky Note", "paper", (local9 - 3.871094), (local10 - (1.0 / 1.057851)), (local11 + 3.53125), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
        Case "room2sl"
            local67 = (1.0 / 142.2222)
            arg0\Field37[$00] = loadanimtexture("GFX\SL_monitors_checkpoint.jpg", $01, $200, $200, $00, $04)
            arg0\Field37[$01] = loadanimtexture("GFX\Sl_monitors.jpg", $01, $100, $100, $00, $08)
            For local7 = $00 To $0E Step $01
                If (local7 <> $07) Then
                    arg0\Field25[local7] = copyentity(monitor, $00)
                    scaleentity(arg0\Field25[local7], local67, local67, local67, $00)
                    If (((local7 <> $04) And (local7 <> $0D)) <> 0) Then
                        local68 = createsprite($00)
                        entityfx(local68, $11)
                        spriteviewmode(local68, $02)
                        scalesprite(local68, (((meshwidth(monitor) * local67) * 0.95) * 0.5), (((meshheight(monitor) * local67) * 0.95) * 0.5))
                        Select local7
                            Case $00
                                entitytexture(local68, arg0\Field37[$01], $00, $00)
                            Case $02
                                entitytexture(local68, arg0\Field37[$01], $02, $00)
                            Case $03
                                entitytexture(local68, arg0\Field37[$01], $01, $00)
                            Case $08
                                entitytexture(local68, arg0\Field37[$01], $04, $00)
                            Case $09
                                entitytexture(local68, arg0\Field37[$01], $05, $00)
                            Case $0A
                                entitytexture(local68, arg0\Field37[$01], $03, $00)
                            Case $0B
                                entitytexture(local68, arg0\Field37[$01], $07, $00)
                            Default
                                entitytexture(local68, arg0\Field37[$00], $03, $00)
                        End Select
                        entityparent(local68, arg0\Field25[local7], $01)
                    ElseIf (local7 = $04) Then
                        arg0\Field25[$14] = createsprite($00)
                        entityfx(arg0\Field25[$14], $11)
                        spriteviewmode(arg0\Field25[$14], $02)
                        scalesprite(arg0\Field25[$14], (((meshwidth(monitor) * local67) * 0.95) * 0.5), (((meshheight(monitor) * local67) * 0.95) * 0.5))
                        entitytexture(arg0\Field25[$14], arg0\Field37[$00], $02, $00)
                        entityparent(arg0\Field25[$14], arg0\Field25[local7], $01)
                    Else
                        arg0\Field25[$15] = createsprite($00)
                        entityfx(arg0\Field25[$15], $11)
                        spriteviewmode(arg0\Field25[$15], $02)
                        scalesprite(arg0\Field25[$15], (((meshwidth(monitor) * local67) * 0.95) * 0.5), (((meshheight(monitor) * local67) * 0.95) * 0.5))
                        entitytexture(arg0\Field25[$15], arg0\Field37[$01], $06, $00)
                        entityparent(arg0\Field25[$15], arg0\Field25[local7], $01)
                    EndIf
                    addentitytoroomprops(arg0, arg0\Field25[local7])
                EndIf
            Next
            For local7 = $00 To $02 Step $01
                positionentity(arg0\Field25[local7], (local9 - (1.0 / 1.231124)), (((648.0 + (Float ($70 * local7))) * (1.0 / 256.0)) + local10), (local11 - 0.234643), $00)
                rotateentity(arg0\Field25[local7], 0.0, (Float (arg0\Field7 + $69)), 0.0, $00)
                entityparent(arg0\Field25[local7], arg0\Field3, $01)
            Next
            For local7 = $03 To $05 Step $01
                positionentity(arg0\Field25[local7], (local9 - (1.0 / 1.105884)), (((648.0 + (Float ((local7 - $03) * $70))) * (1.0 / 256.0)) + local10), (local11 + (1.0 / 2.673788)), $00)
                rotateentity(arg0\Field25[local7], 0.0, (Float (arg0\Field7 + $5A)), 0.0, $00)
                entityparent(arg0\Field25[local7], arg0\Field3, $01)
            Next
            For local7 = $06 To $08 Step $02
                positionentity(arg0\Field25[local7], (local9 - (1.0 / 1.105884)), (((648.0 + (Float ((local7 - $06) * $70))) * (1.0 / 256.0)) + local10), (local11 + 0.999), $00)
                rotateentity(arg0\Field25[local7], 0.0, (Float (arg0\Field7 + $5A)), 0.0, $00)
                entityparent(arg0\Field25[local7], arg0\Field3, $01)
            Next
            For local7 = $09 To $0B Step $01
                positionentity(arg0\Field25[local7], (local9 - (1.0 / 1.105884)), (((648.0 + (Float ((local7 - $09) * $70))) * (1.0 / 256.0)) + local10), (local11 + 1.624), $00)
                rotateentity(arg0\Field25[local7], 0.0, (Float (arg0\Field7 + $5A)), 0.0, $00)
                entityparent(arg0\Field25[local7], arg0\Field3, $01)
            Next
            For local7 = $0C To $0E Step $01
                positionentity(arg0\Field25[local7], (local9 - (1.0 / 1.229953)), (((648.0 + (Float ((local7 - $0C) * $70))) * (1.0 / 256.0)) + local10), (local11 + 2.232746), $00)
                rotateentity(arg0\Field25[local7], 0.0, (Float (arg0\Field7 + $4B)), 0.0, $00)
                entityparent(arg0\Field25[local7], arg0\Field3, $01)
            Next
            arg0\Field29[$00] = createdoor(local17, (local9 + 1.875), local10, (local11 - 2.5), 90.0, arg0, $00, $00, $03, "")
            arg0\Field29[$00]\Field20 = $00
            positionentity(arg0\Field29[$00]\Field3[$00], (local9 + 2.25), entityy(arg0\Field29[$00]\Field3[$00], $01), (local11 - 1.875), $01)
            rotateentity(arg0\Field29[$00]\Field3[$00], 0.0, 270.0, 0.0, $00)
            arg0\Field29[$01] = createdoor(local17, (local9 + 2.125), (local10 + 1.875), (local11 + 1.0), 270.0, arg0, $00, $00, $03, "")
            arg0\Field29[$01]\Field20 = $00
            freeentity(arg0\Field29[$01]\Field1)
            arg0\Field29[$01]\Field1 = $00
            local0 = createdoor(local17, (local9 + 5.875), (local10 + 1.875), (local11 + 3.75), 0.0, arg0, $00, $00, $00, "")
            local0\Field20 = $00
            local0\Field4 = $01
            arg0\Field25[$07] = createpivot($00)
            positionentity(arg0\Field25[$07], local9, (local10 + (1.0 / 2.56)), (local11 - 3.125), $01)
            entityparent(arg0\Field25[$07], arg0\Field3, $01)
            arg0\Field25[$0F] = createpivot($00)
            positionentity(arg0\Field25[$0F], (local9 + 2.734375), (local10 + 2.734375), (local11 + 1.0), $01)
            entityparent(arg0\Field25[$0F], arg0\Field3, $01)
            arg0\Field25[$10] = createpivot($00)
            positionentity(arg0\Field25[$10], (local9 - 0.234375), (local10 + 2.734375), (local11 + (1.0 / 1.28)), $01)
            entityparent(arg0\Field25[$10], arg0\Field3, $01)
            arg0\Field25[$11] = createpivot($00)
            positionentity(arg0\Field25[$11], (local9 - 0.1875), (local10 + 2.109375), (local11 + 2.5625), $01)
            entityparent(arg0\Field25[$11], arg0\Field3, $01)
            arg0\Field25[$12] = copyentity(leverbaseobj, $00)
            arg0\Field25[$13] = copyentity(leverobj, $00)
            addentitytoroomprops(arg0, arg0\Field25[$12])
            addentitytoroomprops(arg0, arg0\Field25[$13])
            arg0\Field28[$00] = arg0\Field25[$13]
            For local7 = $00 To $01 Step $01
                scaleentity(arg0\Field25[($12 + local7)], 0.04, 0.04, 0.04, $00)
                positionentity(arg0\Field25[($12 + local7)], (local9 - (1.0 / 5.22449)), (local10 + 2.691406), (local11 + 3.5625), $01)
                entityparent(arg0\Field25[($12 + local7)], arg0\Field3, $01)
            Next
            rotateentity(arg0\Field25[$12], 0.0, 0.0, 0.0, $00)
            rotateentity(arg0\Field25[$13], 10.0, -180.0, 0.0, $00)
            entityradius(arg0\Field25[$13], 0.1, 0.0)
            local2 = createsecuritycam((local9 - (1.0 / 1.610063)), (local10 + 1.5), (local11 - 3.628906), arg0, $01)
            local2\Field11 = 315.0
            local2\Field20 = arg0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field3, $01)
            positionentity(local2\Field4, (local9 - (1.0 / 1.105884)), (local10 + 2.96875), (local11 + 0.999), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field3, $01)
        Case "room2_4"
            arg0\Field25[$06] = createpivot($00)
            positionentity(arg0\Field25[$06], (local9 + 2.5), (1.0 / 32.0), (local11 - 3.5), $00)
            entityparent(arg0\Field25[$06], arg0\Field3, $01)
        Case "room3z2"
            For local4 = Each rooms
                If (((local4\Field8\Field11 = arg0\Field8\Field11) And (local4 <> arg0)) <> 0) Then
                    arg0\Field25[$00] = copyentity(local4\Field25[$00], arg0\Field3)
                    Exit
                EndIf
            Next
            If (arg0\Field25[$00] = $00) Then
                arg0\Field25[$00] = loadmesh_strict("GFX\map\room3z2_hb.b3d", arg0\Field3)
            EndIf
            entitypickmode(arg0\Field25[$00], $02, $01)
            entitytype(arg0\Field25[$00], $01, $00)
            entityalpha(arg0\Field25[$00], 0.0)
        Case "lockroom3"
            local0 = createdoor(local17, (local9 - 2.875), 0.0, (local11 - 0.40625), 0.0, arg0, $01, $00, $00, "")
            local0\Field10 = (((networkserver\Field12 * $05) + $05) * $46)
            local0\Field20 = $00
            local0\Field5 = $00
            local0\Field4 = $01
            entityparent(local0\Field3[$00], $00, $01)
            positionentity(local0\Field3[$00], (local9 - 1.125), 0.7, (local11 - 2.5), $00)
            entityparent(local0\Field3[$00], arg0\Field3, $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local1 = createdoor(local17, (local9 + 0.40625), 0.0, (local11 + 2.875), 270.0, arg0, $01, $00, $00, "")
            local1\Field10 = (((networkserver\Field12 * $05) + $05) * $46)
            local1\Field20 = $00
            local1\Field5 = $00
            local1\Field4 = $01
            entityparent(local1\Field3[$00], $00, $01)
            positionentity(local1\Field3[$00], (local9 + 2.5), 0.7, (local11 + 1.125), $00)
            rotateentity(local1\Field3[$00], 0.0, 90.0, 0.0, $00)
            entityparent(local1\Field3[$00], arg0\Field3, $01)
            freeentity(local1\Field3[$01])
            local1\Field3[$01] = $00
            local0\Field21 = local1
            local1\Field21 = local0
            local67 = (1.0 / 142.2222)
            arg0\Field25[$00] = copyentity(monitor, $00)
            scaleentity(arg0\Field25[$00], local67, local67, local67, $00)
            positionentity(arg0\Field25[$00], (local9 + 2.609375), 1.1, (local11 - 0.375), $01)
            rotateentity(arg0\Field25[$00], 0.0, 90.0, 0.0, $00)
            entityparent(arg0\Field25[$00], arg0\Field3, $01)
            arg0\Field25[$01] = copyentity(monitor, $00)
            scaleentity(arg0\Field25[$01], local67, local67, local67, $00)
            positionentity(arg0\Field25[$01], (local9 + 0.375), 1.1, (local11 - 2.609375), $01)
            entityparent(arg0\Field25[$01], arg0\Field3, $01)
            addentitytoroomprops(arg0, arg0\Field25[$00])
            addentitytoroomprops(arg0, arg0\Field25[$01])
        Case "medibay"
            arg0\Field25[$00] = loadmesh_strict("GFX\map\medibay_props.b3d", arg0\Field3)
            entitytype(arg0\Field25[$00], $01, $00)
            entitypickmode(arg0\Field25[$00], $02, $01)
            addentitytoroomprops(arg0, arg0\Field25[$00])
            arg0\Field25[$01] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$01], (local9 - 2.976562), (local10 + 0.0), (local11 - 1.351562), $01)
            arg0\Field25[$02] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$02], (entityx(arg0\Field25[$01], $01) + (1.0 / 2.031746)), entityy(arg0\Field25[$01], $01), entityz(arg0\Field25[$01], $01), $01)
            local6 = createitem("First Aid Kit", "firstaid", (local9 - 1.976562), (local10 + 0.75), (local11 - 1.257812), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Syringe", "syringe", (local9 - 1.300781), (local10 + (1.0 / 2.56)), (local11 + (1.0 / 2.631038)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            local6 = createitem("Syringe", "syringe", (local9 - 1.328125), (local10 + (1.0 / 2.56)), (local11 + (1.0 / 4.894837)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
            arg0\Field29[$00] = createdoor(local17, (local9 - 1.03125), (local10 - 0.0), (local11 + 2.5), 90.0, arg0, $00, $00, $03, "")
            arg0\Field25[$03] = createpivot(arg0\Field3)
            positionentity(arg0\Field25[$03], (local9 - 3.203125), local10, (local11 - 1.243746), $01)
        Case "room2cpit"
            local19 = createemitter((local9 + 2.0), -0.296875, (local11 - 2.6875), $00, 0.0, 0.0, 0.0, 0.0)
            turnentity(local19\Field0, -90.0, 0.0, 0.0, $00)
            entityparent(local19\Field0, arg0\Field3, $01)
            local19\Field14 = 55.0
            local19\Field13 = 0.0005
            local19\Field16 = -0.015
            local19\Field15 = 0.007
            local0 = createdoor(local17, (local9 - 1.0), 0.0, (local11 - 2.9375), 90.0, arg0, $00, $02, $03, "")
            local0\Field4 = $01
            local0\Field5 = $00
            local0\Field20 = $00
            local0\Field23 = $00
            local0\Field14 = $01
            positionentity(local0\Field3[$00], (local9 - 0.9375), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            local6 = createitem("Dr L's Note", "paper", (local9 - 0.625), 0.125, (local11 - 1.378906), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field2, arg0\Field3, $01)
        Case "dimension1499"
            arg0\Field28[$01] = loadmesh_strict("GFX\map\dimension1499\1499object0_cull.b3d", arg0\Field3)
            entitytype(arg0\Field28[$01], $01, $00)
            entityalpha(arg0\Field28[$01], 0.0)
            arg0\Field28[$00] = createpivot($00)
            positionentity(arg0\Field28[$00], (local9 + (1.0 / 1.24878)), (local10 + (1.0 / 1.28)), (local11 + 8.933594), $00)
            entityparent(arg0\Field28[$00], arg0\Field3, $01)
    End Select
    For local70 = Each lighttemplates
        If (local70\Field0 = arg0\Field8) Then
            local71 = addlight(arg0, (local70\Field2 + local9), (local70\Field3 + local10), (local70\Field4 + local11), local70\Field1, local70\Field5, local70\Field6, local70\Field7, local70\Field8, $00)
            If (local71 <> $00) Then
                If (local70\Field1 = $03) Then
                    lightconeangles(local71, (Float local70\Field11), local70\Field12)
                    rotateentity(local71, local70\Field9, local70\Field10, 0.0, $00)
                EndIf
            EndIf
        EndIf
    Next
    For local72 = Each tempscreens
        If (local72\Field4 = arg0\Field8) Then
            createscreen((local72\Field1 + local9), (local72\Field2 + local10), (local72\Field3 + local11), local72\Field0, arg0)
        EndIf
    Next
    For local73 = Each tempwaypoints
        If (local73\Field3 = arg0\Field8) Then
            createwaypoint((local73\Field0 + local9), (local73\Field1 + local10), (local73\Field2 + local11), Null, arg0)
        EndIf
    Next
    If (arg0\Field8\Field15 > $00) Then
        arg0\Field40 = arg0\Field8\Field15
        For local7 = $00 To (arg0\Field40 - $01) Step $01
            arg0\Field41[local7] = copyentity(arg0\Field8\Field16[local7], arg0\Field3)
            arg0\Field42[local7] = arg0\Field8\Field17[local7]
        Next
    EndIf
    For local7 = $00 To $0F Step $01
        If (arg0\Field8\Field5[local7] <> $00) Then
            arg0\Field13[local7] = createpivot(arg0\Field3)
            positionentity(arg0\Field13[local7], (arg0\Field8\Field6[local7] + local9), (arg0\Field8\Field7[local7] + local10), (arg0\Field8\Field8[local7] + local11), $01)
            entityparent(arg0\Field13[local7], arg0\Field3, $01)
            arg0\Field12[local7] = arg0\Field8\Field5[local7]
            arg0\Field14[local7] = arg0\Field8\Field9[local7]
        EndIf
    Next
    initroomdoors(arg0, $00)
    allowroomsdoorsinit = $00
    Return $00
End Function
