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
    Local local61#
    Local local62%
    Local local64.lighttemplates
    Local local65%
    Local local66.tempscreens
    Local local67.tempwaypoints
    allowroomsdoorsinit = $01
    Select arg0\Field7\Field11
        Case "room860"
            arg0\Field25[$02] = loadmesh_strict("GFX\map\forest\door_frame.b3d", $00)
            positionentity(arg0\Field25[$02], (arg0\Field3 + (184.0 * roomscale)), 0.0, arg0\Field5, $01)
            scaleentity(arg0\Field25[$02], (45.0 * roomscale), (45.0 * roomscale), (80.0 * roomscale), $01)
            entityparent(arg0\Field25[$02], arg0\Field2, $01)
            arg0\Field25[$03] = loadmesh_strict("GFX\map\forest\door.b3d", $00)
            positionentity(arg0\Field25[$03], (arg0\Field3 + (112.0 * roomscale)), 0.0, (arg0\Field5 + 0.05), $01)
            entitytype(arg0\Field25[$03], $01, $00)
            scaleentity(arg0\Field25[$03], (46.0 * roomscale), (45.0 * roomscale), (46.0 * roomscale), $01)
            entityparent(arg0\Field25[$03], arg0\Field2, $01)
            arg0\Field25[$04] = copyentity(arg0\Field25[$03], $00)
            positionentity(arg0\Field25[$04], (arg0\Field3 + (256.0 * roomscale)), 0.0, (arg0\Field5 - 0.05), $01)
            rotateentity(arg0\Field25[$04], 0.0, 180.0, 0.0, $00)
            scaleentity(arg0\Field25[$04], (46.0 * roomscale), (45.0 * roomscale), (46.0 * roomscale), $01)
            entityparent(arg0\Field25[$04], arg0\Field2, $01)
            addentitytoroomprops(arg0, arg0\Field25[$02])
            addentitytoroomprops(arg0, arg0\Field25[$03])
            addentitytoroomprops(arg0, arg0\Field25[$04])
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (928.0 * roomscale)), 0.0, (arg0\Field5 + (640.0 * roomscale)), 0.0, arg0, networkserver\Field15, $00, $00, "ABCD", $00)
            local0\Field21 = (networkserver\Field15 = $00)
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (928.0 * roomscale)), 0.0, (arg0\Field5 - (640.0 * roomscale)), 0.0, arg0, $01, $00, $00, "ABCD", $00)
            local0\Field21 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (416.0 * roomscale)), 0.0, (arg0\Field5 - (640.0 * roomscale)), 0.0, arg0, $00, $00, $01, "", $00)
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (416.0 * roomscale)), 0.0, (arg0\Field5 + (640.0 * roomscale)), 0.0, arg0, $00, $00, $01, "", $00)
            If (i_zone\Field1 = $00) Then
                local13 = (New forest)
                arg0\Field11 = local13
                genforestgrid(local13)
                placeforest(local13, arg0\Field3, (arg0\Field4 + 30.0), arg0\Field5, arg0)
            EndIf
            If (networkserver\Field15 = $00) Then
                local6 = createitem("Document SCP-860-1", "paper", (arg0\Field3 + (672.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 + (335.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                rotateentity(local6\Field1, 0.0, (Float (arg0\Field6 + $0A)), 0.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
                local6 = createitem("Document SCP-860", "paper", (arg0\Field3 + (1152.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 - (384.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                rotateentity(local6\Field1, 0.0, (Float (arg0\Field6 + $AA)), 0.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (arg0\Field3 + (672.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 + (335.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                rotateentity(local6\Field1, 0.0, (Float (arg0\Field6 + $0A)), 0.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
                local6 = createitem("Rocket Launcher", "rpg", (arg0\Field3 + (1152.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 - (384.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                rotateentity(local6\Field1, 0.0, (Float (arg0\Field6 + $AA)), 0.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
        Case "lockroom"
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (736.0 * roomscale)), 0.0, (arg0\Field5 - (104.0 * roomscale)), 0.0, arg0, $01, $00, $00, "", $00)
            local0\Field10 = (((networkserver\Field15 * $05) + $05) * $46)
            local0\Field21 = $00
            local0\Field5 = $00
            entityparent(local0\Field3[$00], $00, $01)
            positionentity(local0\Field3[$00], (arg0\Field3 - (288.0 * roomscale)), 0.7, (arg0\Field5 - (640.0 * roomscale)), $00)
            entityparent(local0\Field3[$00], arg0\Field2, $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local1 = createdoor(arg0\Field0, (arg0\Field3 + (104.0 * roomscale)), 0.0, (arg0\Field5 + (736.0 * roomscale)), 270.0, arg0, $01, $00, $00, "", $00)
            local1\Field10 = (((networkserver\Field15 * $05) + $05) * $46)
            local1\Field21 = $00
            local1\Field5 = $00
            entityparent(local1\Field3[$00], $00, $01)
            positionentity(local1\Field3[$00], (arg0\Field3 + (640.0 * roomscale)), 0.7, (arg0\Field5 + (288.0 * roomscale)), $00)
            rotateentity(local1\Field3[$00], 0.0, 90.0, 0.0, $00)
            entityparent(local1\Field3[$00], arg0\Field2, $01)
            freeentity(local1\Field3[$01])
            local1\Field3[$01] = $00
            local0\Field22 = local1
            local1\Field22 = local0
            local2 = createsecuritycam((arg0\Field3 - (688.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 + (688.0 * roomscale)), arg0, $01)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            local2\Field9 = $01
            entitytexture(local2\Field4, screentexs[local2\Field9], $00, $00)
            turnentity(local2\Field3, 40.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, (arg0\Field3 + (668.0 * roomscale)), 1.1, (arg0\Field5 - (96.0 * roomscale)), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 - (112.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 + (112.0 * roomscale)), arg0, $01)
            local2\Field11 = 45.0
            local2\Field12 = 45.0
            local2\Field9 = $01
            entitytexture(local2\Field4, screentexs[local2\Field9], $00, $00)
            turnentity(local2\Field3, 40.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, (arg0\Field3 + (96.0 * roomscale)), 1.1, (arg0\Field5 - (668.0 * roomscale)), $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            local14 = createemitter((arg0\Field3 - (175.0 * roomscale)), (370.0 * roomscale), (arg0\Field5 + (656.0 * roomscale)), $00, 0.0)
            turnentity(local14\Field0, 90.0, 0.0, 0.0, $01)
            entityparent(local14\Field0, arg0\Field2, $01)
            local14\Field10 = 20.0
            local14\Field9 = 0.05
            local14\Field11 = 0.007
            local14\Field12 = -0.006
            local14\Field4 = -0.24
            local14 = createemitter((arg0\Field3 - (655.0 * roomscale)), (370.0 * roomscale), (arg0\Field5 + (240.0 * roomscale)), $00, 0.0)
            turnentity(local14\Field0, 90.0, 0.0, 0.0, $01)
            entityparent(local14\Field0, arg0\Field2, $01)
            local14\Field10 = 20.0
            local14\Field9 = 0.05
            local14\Field11 = 0.007
            local14\Field12 = -0.006
            local14\Field4 = -0.24
        Case "lockroom2"
            For local7 = $00 To $05 Step $01
                local3 = createdecal(rand($02, $03), (arg0\Field3 + (rnd(-392.0, 520.0) * roomscale)), ((3.0 * roomscale) + rnd(0.0, 0.001)), (arg0\Field5 + (rnd(-392.0, 520.0) * roomscale)), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
                local3\Field2 = rnd(0.3, 0.6)
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                createdecal(rand($0F, $10), (arg0\Field3 + (rnd(-392.0, 520.0) * roomscale)), ((3.0 * roomscale) + rnd(0.0, 0.001)), (arg0\Field5 + (rnd(-392.0, 520.0) * roomscale)), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
                local3\Field2 = rnd(0.1, 0.6)
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                createdecal(rand($0F, $10), (arg0\Field3 + rnd(-0.5, 0.5)), ((3.0 * roomscale) + rnd(0.0, 0.001)), (arg0\Field5 + rnd(-0.5, 0.5)), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
                local3\Field2 = rnd(0.1, 0.6)
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
            Next
            local2 = createsecuritycam((arg0\Field3 + (512.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 + (384.0 * roomscale)), arg0, $01)
            local2\Field11 = 135.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 40.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, (arg0\Field3 + (668.0 * roomscale)), 1.1, (arg0\Field5 - (96.0 * roomscale)), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 - (384.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 - (512.0 * roomscale)), arg0, $01)
            local2\Field11 = 315.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 40.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, (arg0\Field3 + (96.0 * roomscale)), 1.1, (arg0\Field5 - (668.0 * roomscale)), $00)
            entityparent(local2\Field4, arg0\Field2, $01)
        Case "gatea"
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 - (4064.0 * roomscale)), (arg0\Field4 - (1280.0 * roomscale)), (arg0\Field5 + (3952.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$02]\Field5 = $00
            local1 = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, (arg0\Field5 - (1024.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            local1\Field21 = $00
            local1\Field5 = $00
            local1\Field4 = $01
            local1 = createdoor(arg0\Field0, (arg0\Field3 - (1440.0 * roomscale)), (arg0\Field4 - (480.0 * roomscale)), (arg0\Field5 + (2328.0 * roomscale)), 0.0, arg0, $00, $00, $02, "", $00)
            If (selectedending = "A2") Then
                local1\Field21 = $00
                local1\Field5 = $01
                local1\Field4 = $01
            Else
                local1\Field21 = $00
                local1\Field5 = $00
                local1\Field4 = $00
            EndIf
            positionentity(local1\Field3[$00], (arg0\Field3 - (1320.0 * roomscale)), entityy(local1\Field3[$00], $01), (arg0\Field5 + (2288.0 * roomscale)), $01)
            positionentity(local1\Field3[$01], (arg0\Field3 - (1584.0 * roomscale)), entityy(local1\Field3[$00], $01), (arg0\Field5 + (2488.0 * roomscale)), $01)
            rotateentity(local1\Field3[$01], 0.0, 90.0, 0.0, $01)
            local1 = createdoor(arg0\Field0, (arg0\Field3 - (1440.0 * roomscale)), (arg0\Field4 - (480.0 * roomscale)), (arg0\Field5 + (4352.0 * roomscale)), 0.0, arg0, $00, $00, $02, "", $00)
            If (selectedending = "A2") Then
                local1\Field21 = $00
                local1\Field5 = $01
                local1\Field4 = $01
            Else
                local1\Field21 = $00
                local1\Field5 = $00
                local1\Field4 = $00
            EndIf
            positionentity(local1\Field3[$00], (arg0\Field3 - (1320.0 * roomscale)), entityy(local1\Field3[$00], $01), (arg0\Field5 + (4384.0 * roomscale)), $01)
            rotateentity(local1\Field3[$00], 0.0, 180.0, 0.0, $01)
            positionentity(local1\Field3[$01], (arg0\Field3 - (1584.0 * roomscale)), entityy(local1\Field3[$00], $01), (arg0\Field5 + (4232.0 * roomscale)), $01)
            rotateentity(local1\Field3[$01], 0.0, 90.0, 0.0, $01)
            For local4 = Each rooms
                If (local4\Field7\Field11 = "exit1") Then
                    arg0\Field25[$01] = local4\Field25[$01]
                    arg0\Field25[$02] = local4\Field25[$02]
                ElseIf (local4\Field7\Field11 = "gateaentrance") Then
                    arg0\Field29[$01] = createdoor($00, (arg0\Field3 + (1544.0 * roomscale)), arg0\Field4, (arg0\Field5 - (64.0 * roomscale)), 90.0, arg0, $00, $03, $00, "", $00)
                    arg0\Field29[$01]\Field21 = $00
                    arg0\Field29[$01]\Field5 = $00
                    positionentity(arg0\Field29[$01]\Field3[$00], (arg0\Field3 + (1584.0 * roomscale)), entityy(arg0\Field29[$01]\Field3[$00], $01), (arg0\Field5 + (80.0 * roomscale)), $01)
                    positionentity(arg0\Field29[$01]\Field3[$01], (arg0\Field3 + (1456.0 * roomscale)), entityy(arg0\Field29[$01]\Field3[$01], $01), (arg0\Field5 - (208.0 * roomscale)), $01)
                    local4\Field25[$01] = createpivot($00)
                    positionentity(local4\Field25[$01], (arg0\Field3 + (1848.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 - (64.0 * roomscale)), $01)
                    entityparent(local4\Field25[$01], arg0\Field2, $01)
                EndIf
            Next
            arg0\Field25[$03] = createpivot($00)
            positionentity(arg0\Field25[$03], (arg0\Field3 + (1216.0 * roomscale)), arg0\Field4, (arg0\Field5 + (2112.0 * roomscale)), $01)
            entityparent(arg0\Field25[$03], arg0\Field2, $01)
            arg0\Field25[$04] = createpivot($00)
            positionentity(arg0\Field25[$04], arg0\Field3, (arg0\Field4 + (96.0 * roomscale)), (arg0\Field5 + (6400.0 * roomscale)), $01)
            entityparent(arg0\Field25[$04], arg0\Field2, $01)
            arg0\Field25[$05] = createpivot($00)
            positionentity(arg0\Field25[$05], (arg0\Field3 + (1784.0 * roomscale)), (arg0\Field4 + (2124.0 * roomscale)), (arg0\Field5 + (4512.0 * roomscale)), $01)
            entityparent(arg0\Field25[$05], arg0\Field2, $01)
            arg0\Field25[$06] = createpivot($00)
            positionentity(arg0\Field25[$06], (arg0\Field3 - (5048.0 * roomscale)), (arg0\Field4 + (1912.0 * roomscale)), (arg0\Field5 + (4656.0 * roomscale)), $01)
            entityparent(arg0\Field25[$06], arg0\Field2, $01)
            arg0\Field25[$07] = createpivot($00)
            positionentity(arg0\Field25[$07], (arg0\Field3 + (1824.0 * roomscale)), (arg0\Field4 + (224.0 * roomscale)), (arg0\Field5 + (7056.0 * roomscale)), $01)
            entityparent(arg0\Field25[$07], arg0\Field2, $01)
            arg0\Field25[$08] = createpivot($00)
            positionentity(arg0\Field25[$08], (arg0\Field3 - (1824.0 * roomscale)), (arg0\Field4 + (224.0 * roomscale)), (arg0\Field5 + (7056.0 * roomscale)), $01)
            entityparent(arg0\Field25[$08], arg0\Field2, $01)
            arg0\Field25[$09] = createpivot($00)
            positionentity(arg0\Field25[$09], (arg0\Field3 + (2624.0 * roomscale)), (arg0\Field4 + (992.0 * roomscale)), (arg0\Field5 + (6157.0 * roomscale)), $01)
            entityparent(arg0\Field25[$09], arg0\Field2, $01)
            arg0\Field25[$0B] = createpivot($00)
            positionentity(arg0\Field25[$0B], (arg0\Field3 - (4064.0 * roomscale)), (arg0\Field4 - (1248.0 * roomscale)), (arg0\Field5 - (1696.0 * roomscale)), $01)
            entityparent(arg0\Field25[$0B], arg0\Field2, $01)
            local15 = createcube($00)
            entityalpha(local15, 0.0)
            positionentity(local15, (arg0\Field3 - (4160.0 * roomscale)), (arg0\Field4 - (1045.0 * roomscale)), (arg0\Field5 - (1920.0 * roomscale)), $00)
            moveentity(local15, 0.3, 0.0, -0.3)
            scaleentity(local15, 0.55, 0.55, 0.55, $00)
            entitytype(local15, $01, $00)
            entityparent(local15, arg0\Field2, $01)
            arg0\Field25[$1B] = createpivot($00)
            positionentity(arg0\Field25[$1B], (arg0\Field3 - (4160.0 * roomscale)), (arg0\Field4 - (1045.0 * roomscale)), (arg0\Field5 - (1920.0 * roomscale)), $00)
            moveentity(arg0\Field25[$1B], 0.3, 0.1, 30.0)
            entityparent(arg0\Field25[$1B], arg0\Field2, $01)
            arg0\Field25[$0D] = loadmesh_strict("GFX\map\gateawall1.b3d", arg0\Field2)
            positionentity(arg0\Field25[$0D], (arg0\Field3 - (4308.0 * roomscale)), (arg0\Field4 - (1045.0 * roomscale)), (arg0\Field5 + (544.0 * roomscale)), $01)
            entitycolor(arg0\Field25[$0D], 25.0, 25.0, 25.0)
            entitytype(arg0\Field25[$0D], $01, $00)
            addentitytoroomprops(arg0, arg0\Field25[$0D])
            arg0\Field25[$0E] = loadmesh_strict("GFX\map\gateawall2.b3d", arg0\Field2)
            positionentity(arg0\Field25[$0E], (arg0\Field3 - (3820.0 * roomscale)), (arg0\Field4 - (1045.0 * roomscale)), (arg0\Field5 + (544.0 * roomscale)), $01)
            entitycolor(arg0\Field25[$0E], 25.0, 25.0, 25.0)
            entitytype(arg0\Field25[$0E], $01, $00)
            addentitytoroomprops(arg0, arg0\Field25[$0E])
            arg0\Field25[$0F] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$0F], (arg0\Field3 - (3568.0 * roomscale)), (arg0\Field4 - (1089.0 * roomscale)), (arg0\Field5 + (4944.0 * roomscale)), $01)
            arg0\Field25[$10] = loadmesh_strict("GFX\map\gatea_hitbox1.b3d", arg0\Field2)
            entitypickmode(arg0\Field25[$10], $02, $01)
            entitytype(arg0\Field25[$10], $01, $00)
            entityalpha(arg0\Field25[$10], 0.0)
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 - (1366.82 * roomscale)), (arg0\Field4 + (77.3125 * roomscale)), (arg0\Field5 - (272.784 * roomscale)), -45.0)
            local16 = createcube($00)
            scaleentity(local16, 2.12, 6.0, 2.59, $00)
            positionentity(local16, (arg0\Field3 + (911.5613 * roomscale)), (arg0\Field4 - (767.0 * roomscale)), (arg0\Field5 + (1062.061 * roomscale)), $00)
            moveentity(local16, 0.5, 0.0, 0.1)
            entitytype(local16, $09, $00)
            entityalpha(local16, 0.0)
            entityparent(local16, arg0\Field2, $01)
            local16 = createcube($00)
            scaleentity(local16, 2.12, 6.0, 2.59, $00)
            positionentity(local16, (arg0\Field3 - (905.7939 * roomscale)), (arg0\Field4 - (767.0 * roomscale)), (arg0\Field5 + (1081.676 * roomscale)), $00)
            moveentity(local16, -0.5, 0.0, 0.0)
            entitytype(local16, $09, $00)
            entityalpha(local16, 0.0)
            entityparent(local16, arg0\Field2, $01)
        Case "gateaentrance"
            arg0\Field29[$00] = createdoor($00, (arg0\Field3 + (744.0 * roomscale)), 0.0, (arg0\Field5 + (512.0 * roomscale)), 90.0, arg0, $01, $03, $00, "", $00)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $01
            positionentity(arg0\Field29[$00]\Field3[$01], (arg0\Field3 + (688.0 * roomscale)), entityy(arg0\Field29[$00]\Field3[$01], $01), (arg0\Field5 + (368.0 * roomscale)), $01)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + (784.0 * roomscale)), entityy(arg0\Field29[$00]\Field3[$00], $01), (arg0\Field5 + (656.0 * roomscale)), $01)
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (arg0\Field3 + (1048.0 * roomscale)), 0.0, (arg0\Field5 + (512.0 * roomscale)), $01)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            arg0\Field29[$01] = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - (360.0 * roomscale)), 0.0, arg0, $00, $01, $05, "", $00)
            arg0\Field29[$01]\Field9 = $01
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field5 = $00
            positionentity(arg0\Field29[$01]\Field3[$01], (arg0\Field3 + (422.0 * roomscale)), entityy(arg0\Field29[$00]\Field3[$01], $01), (arg0\Field5 - (576.0 * roomscale)), $01)
            rotateentity(arg0\Field29[$01]\Field3[$01], 0.0, ((Float arg0\Field6) - 90.0), 0.0, $01)
            positionentity(arg0\Field29[$01]\Field3[$00], (arg0\Field3 - (522.0 * roomscale)), entityy(arg0\Field29[$01]\Field3[$00], $01), entityz(arg0\Field29[$01]\Field3[$00], $01), $01)
            rotateentity(arg0\Field29[$01]\Field3[$00], 0.0, ((Float arg0\Field6) - 225.0), 0.0, $01)
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 + (413.094 * roomscale)), (arg0\Field4 + (77.312 * roomscale)), (arg0\Field5 + (804.36 * roomscale)), -179.0)
        Case "exit1"
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 + (4356.0 * roomscale)), (9767.0 * roomscale), (arg0\Field5 + (2588.0 * roomscale)), $01)
            arg0\Field29[$04] = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - (320.0 * roomscale)), 0.0, arg0, $00, $01, $05, "", $00)
            arg0\Field29[$04]\Field9 = $01
            arg0\Field29[$04]\Field21 = $00
            arg0\Field29[$04]\Field5 = $00
            positionentity(arg0\Field29[$04]\Field3[$01], (arg0\Field3 + (358.0 * roomscale)), entityy(arg0\Field29[$04]\Field3[$01], $01), (arg0\Field5 - (528.0 * roomscale)), $01)
            rotateentity(arg0\Field29[$04]\Field3[$01], 0.0, ((Float arg0\Field6) - 90.0), 0.0, $01)
            positionentity(arg0\Field29[$04]\Field3[$00], entityx(arg0\Field29[$04]\Field3[$00], $01), entityy(arg0\Field29[$04]\Field3[$00], $01), (arg0\Field5 - (198.0 * roomscale)), $01)
            rotateentity(arg0\Field29[$04]\Field3[$00], 0.0, ((Float arg0\Field6) - 180.0), 0.0, $01)
            arg0\Field25[$03] = createpivot($00)
            positionentity(arg0\Field25[$03], (arg0\Field3 - (7680.0 * roomscale)), (10992.0 * roomscale), (arg0\Field5 - (27048.0 * roomscale)), $01)
            entityparent(arg0\Field25[$03], arg0\Field2, $01)
            arg0\Field25[$04] = createpivot($00)
            positionentity(arg0\Field25[$04], (arg0\Field3 + (5203.36 * roomscale)), (12128.0 * roomscale), (arg0\Field5 - (1739.19 * roomscale)), $01)
            entityparent(arg0\Field25[$04], arg0\Field2, $01)
            arg0\Field25[$05] = createpivot($00)
            positionentity(arg0\Field25[$05], (arg0\Field3 + (4363.02 * roomscale)), (10536.0 * roomscale), (arg0\Field5 + (2766.16 * roomscale)), $01)
            entityparent(arg0\Field25[$05], arg0\Field2, $01)
            arg0\Field25[$06] = createpivot($00)
            positionentity(arg0\Field25[$06], (arg0\Field3 + (5192.0 * roomscale)), (12192.0 * roomscale), (arg0\Field5 - (1760.0 * roomscale)), $01)
            entityparent(arg0\Field25[$06], arg0\Field2, $01)
            arg0\Field25[$07] = createpivot($00)
            positionentity(arg0\Field25[$07], (arg0\Field3 + (5192.0 * roomscale)), (12192.0 * roomscale), (arg0\Field5 - (4352.0 * roomscale)), $01)
            entityparent(arg0\Field25[$07], arg0\Field2, $01)
            arg0\Field29[$00] = createdoor($00, (arg0\Field3 + (720.0 * roomscale)), 0.0, (arg0\Field5 + (1432.0 * roomscale)), 0.0, arg0, $01, $03, $00, "", $00)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $01
            moveentity(arg0\Field29[$00]\Field3[$00], 0.0, 0.0, (22.0 * roomscale))
            moveentity(arg0\Field29[$00]\Field3[$01], 0.0, 0.0, (22.0 * roomscale))
            arg0\Field25[$08] = createpivot($00)
            positionentity(arg0\Field25[$08], (arg0\Field3 + (720.0 * roomscale)), 0.0, (arg0\Field5 + (1744.0 * roomscale)), $01)
            entityparent(arg0\Field25[$08], arg0\Field2, $01)
            arg0\Field29[$01] = createdoor($00, (arg0\Field3 - (5424.0 * roomscale)), (10784.0 * roomscale), (arg0\Field5 - (1380.0 * roomscale)), 0.0, arg0, $00, $03, $00, "", $00)
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field5 = $00
            moveentity(arg0\Field29[$01]\Field3[$00], 0.0, 0.0, (22.0 * roomscale))
            moveentity(arg0\Field29[$01]\Field3[$01], 0.0, 0.0, (22.0 * roomscale))
            arg0\Field25[$09] = createpivot($00)
            positionentity(arg0\Field25[$09], (arg0\Field3 - (5424.0 * roomscale)), (10784.0 * roomscale), (arg0\Field5 - (1068.0 * roomscale)), $01)
            entityparent(arg0\Field25[$09], arg0\Field2, $01)
            arg0\Field29[$02] = createdoor($00, (arg0\Field3 + (4352.0 * roomscale)), (10784.0 * roomscale), (arg0\Field5 - (492.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$02]\Field5 = $00
            arg0\Field29[$03] = createdoor($00, (arg0\Field3 + (4352.0 * roomscale)), (10784.0 * roomscale), (arg0\Field5 + (500.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$03]\Field21 = $00
            arg0\Field29[$03]\Field5 = $00
            arg0\Field25[$0A] = createpivot($00)
            positionentity(arg0\Field25[$0A], (arg0\Field3 + (4352.0 * roomscale)), (10778.0 * roomscale), (arg0\Field5 + (1344.0 * roomscale)), $01)
            entityparent(arg0\Field25[$0A], arg0\Field2, $01)
            arg0\Field25[$0B] = createpivot($00)
            positionentity(arg0\Field25[$0B], (arg0\Field3 + (2816.0 * roomscale)), (11024.0 * roomscale), (arg0\Field5 - (2816.0 * roomscale)), $01)
            entityparent(arg0\Field25[$0B], arg0\Field2, $01)
            arg0\Field29[$05] = createdoor($00, (arg0\Field3 + (3248.0 * roomscale)), (9856.0 * roomscale), (arg0\Field5 + (6400.0 * roomscale)), 0.0, arg0, $00, $00, $00, "28084020", $00)
            arg0\Field29[$05]\Field21 = $00
            arg0\Field29[$05]\Field5 = $00
            local0 = createdoor($00, (arg0\Field3 + (3072.0 * roomscale)), (9856.0 * roomscale), (arg0\Field5 + (5800.0 * roomscale)), 90.0, arg0, $00, $00, $03, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            arg0\Field25[$0E] = createpivot($00)
            positionentity(arg0\Field25[$0E], (arg0\Field3 + (3536.0 * roomscale)), (10256.0 * roomscale), (arg0\Field5 + (5512.0 * roomscale)), $01)
            entityparent(arg0\Field25[$0E], arg0\Field2, $01)
            arg0\Field25[$0F] = createpivot($00)
            positionentity(arg0\Field25[$0F], (arg0\Field3 + (3536.0 * roomscale)), (10256.0 * roomscale), (arg0\Field5 + (5824.0 * roomscale)), $01)
            entityparent(arg0\Field25[$0F], arg0\Field2, $01)
            arg0\Field25[$10] = createpivot($00)
            positionentity(arg0\Field25[$10], (arg0\Field3 + (3856.0 * roomscale)), (10256.0 * roomscale), (arg0\Field5 + (5512.0 * roomscale)), $01)
            entityparent(arg0\Field25[$10], arg0\Field2, $01)
            arg0\Field25[$11] = createpivot($00)
            positionentity(arg0\Field25[$11], (arg0\Field3 + (3856.0 * roomscale)), (10256.0 * roomscale), (arg0\Field5 + (5824.0 * roomscale)), $01)
            entityparent(arg0\Field25[$11], arg0\Field2, $01)
            arg0\Field25[$12] = createpivot($00)
            positionentity(arg0\Field25[$12], (arg0\Field3 + (3250.0 * roomscale)), (9896.0 * roomscale), (arg0\Field5 + (6623.0 * roomscale)), $01)
            entityparent(arg0\Field25[$12], arg0\Field2, $01)
            arg0\Field25[$13] = createpivot($00)
            positionentity(arg0\Field25[$13], (arg0\Field3 + (3808.0 * roomscale)), (12320.0 * roomscale), (arg0\Field5 - (13568.0 * roomscale)), $01)
            entityparent(arg0\Field25[$13], arg0\Field2, $01)
            arg0\Field25[$1A] = createpivot($00)
            positionentity(arg0\Field25[$1A], (arg0\Field3 + (4352.0 * roomscale)), (10784.0 * roomscale), (arg0\Field5 + (500.0 * roomscale)), $00)
            moveentity(arg0\Field25[$1A], 0.0, 0.3, -8.0)
            entityparent(arg0\Field25[$1A], arg0\Field2, $01)
            arg0\Field25[$1B] = createpivot($00)
            positionentity(arg0\Field25[$1B], (arg0\Field3 + (3072.0 * roomscale)), (9856.0 * roomscale), (arg0\Field5 + (5800.0 * roomscale)), $00)
            entityparent(arg0\Field25[$1B], arg0\Field2, $01)
            If (networkserver\Field15 <> 0) Then
                arg0\Field25[$16] = createbutton((arg0\Field3 + (3969.687 * roomscale)), (arg0\Field4 + (9974.927 * roomscale)), (arg0\Field5 + (5827.879 * roomscale)), 80.0, -90.0, 0.0)
                entityparent(arg0\Field25[$16], arg0\Field2, $01)
            EndIf
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 + (872.8707 * roomscale)), 0.0, (arg0\Field5 - (65.66945 * roomscale)), 115.0)
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 + (-5499.11 * roomscale)), (arg0\Field4 + (10254.04 * roomscale)), (arg0\Field5 - (3793.333 * roomscale)), 0.0)
        Case "roompj"
            If (networkserver\Field15 = $00) Then
                local6 = createitem("Document SCP-372", "paper", (arg0\Field3 + (800.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 + (1108.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                rotateentity(local6\Field1, 0.0, (Float arg0\Field6), 0.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("Strange Bottle", "veryfinefirstaid", (arg0\Field3 + (800.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 + (1108.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                rotateentity(local6\Field1, 0.0, (Float arg0\Field6), 0.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("Radio Transceiver", "radio", (arg0\Field3 + (800.0 * roomscale)), (arg0\Field4 + (112.0 * roomscale)), (arg0\Field5 + (944.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            local6\Field13 = 80.0
            entityparent(local6\Field1, arg0\Field2, $01)
            arg0\Field25[$03] = loadmesh_strict("GFX\map\372_hb.b3d", arg0\Field2)
            entitypickmode(arg0\Field25[$03], $02, $01)
            entitytype(arg0\Field25[$03], $01, $00)
            entityalpha(arg0\Field25[$03], 0.0)
            local0 = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, (arg0\Field5 - (368.0 * roomscale)), 0.0, arg0, $01, $01, $02, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$00], (arg0\Field3 - (496.0 * roomscale)), 0.7, (arg0\Field5 - (272.0 * roomscale)), $01)
            turnentity(local0\Field3[$00], 0.0, 90.0, 0.0, $00)
        Case "room079"
            local0 = createdoor(arg0\Field0, arg0\Field3, (-448.0 * roomscale), (arg0\Field5 + (1136.0 * roomscale)), 0.0, arg0, $00, $01, $04, "", $00)
            local0\Field9 = $01
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$01], (arg0\Field3 + (224.0 * roomscale)), (-250.0 * roomscale), (arg0\Field5 + (918.0 * roomscale)), $01)
            positionentity(local0\Field3[$00], (arg0\Field3 - (240.0 * roomscale)), (-250.0 * roomscale), (arg0\Field5 + (1366.0 * roomscale)), $01)
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 + (1456.0 * roomscale)), (-448.0 * roomscale), (arg0\Field5 + (976.0 * roomscale)), 0.0, arg0, $00, $01, $03, "", $00)
            arg0\Field29[$00]\Field9 = $01
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $00
            positionentity(arg0\Field29[$00]\Field3[$01], (arg0\Field3 + (1760.0 * roomscale)), (-250.0 * roomscale), (arg0\Field5 + (1236.0 * roomscale)), $01)
            turnentity(arg0\Field29[$00]\Field3[$00], 0.0, -180.0, 0.0, $01)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + (1760.0 * roomscale)), (-240.0 * roomscale), (arg0\Field5 + (740.0 * roomscale)), $01)
            turnentity(arg0\Field29[$00]\Field3[$01], 0.0, 0.0, 0.0, $01)
            createdoor($00, (arg0\Field3 + (1144.0 * roomscale)), (-448.0 * roomscale), (arg0\Field5 + (704.0 * roomscale)), 90.0, arg0, $00, $00, $FFFFFFFF, "", $00)
            arg0\Field25[$00] = loadanimmesh_strict("GFX\map\079.b3d", $00)
            scaleentity(arg0\Field25[$00], 1.3, 1.3, 1.3, $01)
            positionentity(arg0\Field25[$00], (arg0\Field3 + (1856.0 * roomscale)), (-560.0 * roomscale), (arg0\Field5 - (672.0 * roomscale)), $01)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
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
            arg0\Field25[$02] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$02], (arg0\Field3 + (1184.0 * roomscale)), (-448.0 * roomscale), (arg0\Field5 + (1792.0 * roomscale)), $01)
            local3 = createdecal($03, (arg0\Field3 + (1184.0 * roomscale)), ((-448.0 * roomscale) + 0.01), (arg0\Field5 + (1792.0 * roomscale)), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
            local3\Field2 = 0.5
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityparent(local3\Field0, arg0\Field2, $01)
        Case "checkpoint1"
            arg0\Field29[$00] = createdoor($00, (arg0\Field3 + (48.0 * roomscale)), 0.0, (arg0\Field5 - (128.0 * roomscale)), 0.0, arg0, $00, $00, ($03 - networkserver\Field15), "", $00)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 - (152.0 * roomscale)), entityy(arg0\Field29[$00]\Field3[$00], $01), (arg0\Field5 - (352.0 * roomscale)), $01)
            positionentity(arg0\Field29[$00]\Field3[$01], (arg0\Field3 - (152.0 * roomscale)), entityy(arg0\Field29[$00]\Field3[$01], $01), (arg0\Field5 + (96.0 * roomscale)), $01)
            arg0\Field29[$01] = createdoor($00, (arg0\Field3 - (352.0 * roomscale)), 0.0, (arg0\Field5 - (128.0 * roomscale)), 0.0, arg0, $00, $00, ($03 - networkserver\Field15), "", $00)
            arg0\Field29[$01]\Field22 = arg0\Field29[$00]
            arg0\Field29[$00]\Field22 = arg0\Field29[$01]
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 + (720.0 * roomscale)), (120.0 * roomscale), (arg0\Field5 + (333.0 * roomscale)), $01)
            arg0\Field29[$00]\Field10 = $15E
            arg0\Field29[$01]\Field10 = $15E
            local2 = createsecuritycam((arg0\Field3 + (192.0 * roomscale)), (arg0\Field4 + (704.0 * roomscale)), (arg0\Field5 - (960.0 * roomscale)), arg0, $00)
            local2\Field11 = 45.0
            local2\Field12 = 0.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            arg0\Field25[$02] = copyentity(monitor2, arg0\Field2)
            scaleentity(arg0\Field25[$02], 2.0, 2.0, 2.0, $00)
            positionentity(arg0\Field25[$02], (arg0\Field3 - (152.0 * roomscale)), (384.0 * roomscale), (arg0\Field5 + (124.0 * roomscale)), $01)
            rotateentity(arg0\Field25[$02], 0.0, 180.0, 0.0, $00)
            entityfx(arg0\Field25[$02], $01)
            addentitytoroomprops(arg0, arg0\Field25[$02])
            arg0\Field25[$03] = copyentity(monitor2, arg0\Field2)
            scaleentity(arg0\Field25[$03], 2.0, 2.0, 2.0, $00)
            positionentity(arg0\Field25[$03], (arg0\Field3 - (152.0 * roomscale)), (384.0 * roomscale), (arg0\Field5 - (380.0 * roomscale)), $01)
            rotateentity(arg0\Field25[$03], 0.0, 0.0, 0.0, $00)
            entityfx(arg0\Field25[$03], $01)
            addentitytoroomprops(arg0, arg0\Field25[$03])
            If (maptemp((Int floor((arg0\Field3 / 8.0))), (Int (floor((arg0\Field5 / 8.0)) - 1.0))) = $00) Then
                createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - 4.0), 0.0, arg0, $00, $02, $00, "GEAR", $00)
            EndIf
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 - (805.322 * roomscale)), (arg0\Field4 + (77.312 * roomscale)), (arg0\Field5 + (338.207 * roomscale)), -80.0)
        Case "checkpoint2"
            arg0\Field29[$00] = createdoor($00, (arg0\Field3 - (48.0 * roomscale)), 0.0, (arg0\Field5 + (128.0 * roomscale)), 0.0, arg0, $00, $00, ($05 - (networkserver\Field15 Shl $01)), "", $00)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + (152.0 * roomscale)), entityy(arg0\Field29[$00]\Field3[$00], $01), (arg0\Field5 - (96.0 * roomscale)), $01)
            positionentity(arg0\Field29[$00]\Field3[$01], (arg0\Field3 + (152.0 * roomscale)), entityy(arg0\Field29[$00]\Field3[$01], $01), (arg0\Field5 + (352.0 * roomscale)), $01)
            arg0\Field29[$01] = createdoor($00, (arg0\Field3 + (352.0 * roomscale)), 0.0, (arg0\Field5 + (128.0 * roomscale)), 0.0, arg0, $00, $00, ($05 - (networkserver\Field15 Shl $01)), "", $00)
            arg0\Field29[$01]\Field22 = arg0\Field29[$00]
            arg0\Field29[$00]\Field22 = arg0\Field29[$01]
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 - (720.0 * roomscale)), (120.0 * roomscale), (arg0\Field5 + (464.0 * roomscale)), $01)
            arg0\Field25[$02] = copyentity(monitor3, arg0\Field2)
            scaleentity(arg0\Field25[$02], 2.0, 2.0, 2.0, $00)
            positionentity(arg0\Field25[$02], (arg0\Field3 + (152.0 * roomscale)), (384.0 * roomscale), (arg0\Field5 + (380.0 * roomscale)), $01)
            rotateentity(arg0\Field25[$02], 0.0, 180.0, 0.0, $00)
            entityfx(arg0\Field25[$02], $01)
            addentitytoroomprops(arg0, arg0\Field25[$02])
            arg0\Field25[$03] = copyentity(monitor3, arg0\Field2)
            scaleentity(arg0\Field25[$03], 2.0, 2.0, 2.0, $00)
            positionentity(arg0\Field25[$03], (arg0\Field3 + (152.0 * roomscale)), (384.0 * roomscale), (arg0\Field5 - (124.0 * roomscale)), $01)
            rotateentity(arg0\Field25[$03], 0.0, 0.0, 0.0, $00)
            entityfx(arg0\Field25[$03], $01)
            addentitytoroomprops(arg0, arg0\Field25[$03])
            arg0\Field29[$00]\Field10 = $15E
            arg0\Field29[$01]\Field10 = $15E
            If (maptemp((Int floor((arg0\Field3 / 8.0))), (Int (floor((arg0\Field5 / 8.0)) - 1.0))) = $00) Then
                createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - 4.0), 0.0, arg0, $00, $00, $00, "GEAR", $00)
            EndIf
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 + (755.494 * roomscale)), (arg0\Field4 + (77.312 * roomscale)), (arg0\Field5 - (446.897 * roomscale)), 72.0)
        Case "room2pit"
            local7 = $00
            For local8 = $FFFFFFFF To $01 Step $02
                For local10 = $FFFFFFFF To $01 Step $01
                    local14 = createemitter((arg0\Field3 + ((202.0 * roomscale) * (Float local8))), (8.0 * roomscale), (arg0\Field5 + ((256.0 * roomscale) * (Float local10))), $00, 0.0)
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
            positionentity(arg0\Field25[$06], (arg0\Field3 + (640.0 * roomscale)), (8.0 * roomscale), (arg0\Field5 - (896.0 * roomscale)), $00)
            entityparent(arg0\Field25[$06], arg0\Field2, $01)
            arg0\Field25[$07] = createpivot($00)
            positionentity(arg0\Field25[$07], (arg0\Field3 - (864.0 * roomscale)), (-400.0 * roomscale), (arg0\Field5 - (632.0 * roomscale)), $00)
            entityparent(arg0\Field25[$07], arg0\Field2, $01)
        Case "room2testroom2"
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (arg0\Field3 - (640.0 * roomscale)), 0.5, (arg0\Field5 - (912.0 * roomscale)), $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            arg0\Field25[$01] = createpivot($00)
            positionentity(arg0\Field25[$01], (arg0\Field3 - (669.0 * roomscale)), 0.5, (arg0\Field5 - (16.0 * roomscale)), $00)
            entityparent(arg0\Field25[$01], arg0\Field2, $01)
            local17 = loadtexture_strict("GFX\map\glass.png", $03)
            arg0\Field25[$02] = createsprite($00)
            entitytexture(arg0\Field25[$02], local17, $00, $00)
            spriteviewmode(arg0\Field25[$02], $02)
            scalesprite(arg0\Field25[$02], ((182.0 * roomscale) * 0.5), ((192.0 * roomscale) * 0.5))
            positionentity(arg0\Field25[$02], (arg0\Field3 - (632.0 * roomscale)), (224.0 * roomscale), (arg0\Field5 - (208.0 * roomscale)), $00)
            turnentity(arg0\Field25[$02], 0.0, 180.0, 0.0, $00)
            entityparent(arg0\Field25[$02], arg0\Field2, $01)
            hideentity(arg0\Field25[$02])
            freetexture(local17)
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 - (240.0 * roomscale)), 0.0, (arg0\Field5 + (640.0 * roomscale)), 90.0, arg0, $00, $00, $01, "", $00)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (512.0 * roomscale)), 0.0, (arg0\Field5 + (384.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            local6 = createitem("Level 2 Key Card", "key2", (arg0\Field3 - (914.0 * roomscale)), (arg0\Field4 + (137.0 * roomscale)), (arg0\Field5 + (61.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            If (networkserver\Field15 = $00) Then
                local6 = createitem("S-NAV 300 Navigator", "nav", (arg0\Field3 - (312.0 * roomscale)), (arg0\Field4 + (264.0 * roomscale)), (arg0\Field5 + (176.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                local6\Field13 = 20.0
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (arg0\Field3 - (312.0 * roomscale)), (arg0\Field4 + (264.0 * roomscale)), (arg0\Field5 + (176.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
                local6 = createitem("Level 2 Key Card", "key2", (arg0\Field3 - (910.0 * roomscale)), (arg0\Field4 + (137.0 * roomscale)), (arg0\Field5 + (61.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 - (874.8817 * roomscale)), 0.0, (arg0\Field5 + (639.0461 * roomscale)), -90.0)
        Case "room3tunnel"
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 - (190.0 * roomscale)), (4.0 * roomscale), (arg0\Field5 + (190.0 * roomscale)), $01)
        Case "room2toilets"
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (arg0\Field3 + (1040.0 * roomscale)), (192.0 * roomscale), arg0\Field5, $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            arg0\Field25[$01] = createpivot($00)
            positionentity(arg0\Field25[$01], (arg0\Field3 + (1530.0 * roomscale)), 0.5, (arg0\Field5 + (512.0 * roomscale)), $00)
            entityparent(arg0\Field25[$01], arg0\Field2, $01)
            arg0\Field25[$02] = createpivot($00)
            positionentity(arg0\Field25[$02], (arg0\Field3 + (1535.0 * roomscale)), (arg0\Field4 + (150.0 * roomscale)), (arg0\Field5 + (512.0 * roomscale)), $00)
            entityparent(arg0\Field25[$02], arg0\Field2, $01)
        Case "room2storage"
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 - (1288.0 * roomscale)), 0.0, arg0\Field5, 270.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 - (760.0 * roomscale)), 0.0, arg0\Field5, 270.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 - (264.0 * roomscale)), 0.0, arg0\Field5, 270.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$03] = createdoor(arg0\Field0, (arg0\Field3 + (264.0 * roomscale)), 0.0, arg0\Field5, 270.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$04] = createdoor(arg0\Field0, (arg0\Field3 + (760.0 * roomscale)), 0.0, arg0\Field5, 270.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$05] = createdoor(arg0\Field0, (arg0\Field3 + (1288.0 * roomscale)), 0.0, arg0\Field5, 270.0, arg0, $00, $00, $00, "", $00)
            For local7 = $00 To $05 Step $01
                moveentity(arg0\Field29[local7]\Field3[$00], 0.0, 0.0, -8.0)
                moveentity(arg0\Field29[local7]\Field3[$01], 0.0, 0.0, -8.0)
                arg0\Field29[local7]\Field21 = $00
                arg0\Field29[local7]\Field5 = $00
            Next
            local6 = createitem("Document SCP-939", "paper", (arg0\Field3 + (352.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 + (256.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            rotateentity(local6\Field1, 0.0, (Float (arg0\Field6 + $04)), 0.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("9V Battery", "bat", (arg0\Field3 + (352.0 * roomscale)), (arg0\Field4 + (112.0 * roomscale)), (arg0\Field5 + (448.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            If (networkserver\Field15 = $00) Then
                local6 = createitem("Empty Cup", "emptycup", (arg0\Field3 - (672.0 * roomscale)), (240.0 * roomscale), (arg0\Field5 + (288.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (arg0\Field3 - (672.0 * roomscale)), (240.0 * roomscale), (arg0\Field5 + (288.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem((("Level " + (Str (networkserver\Field15 + $01))) + " Key Card"), ("key" + (Str (networkserver\Field15 + $01))), (arg0\Field3 - (672.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 + (224.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room2sroom"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (1440.0 * roomscale)), (224.0 * roomscale), (arg0\Field5 + (32.0 * roomscale)), 90.0, arg0, $00, $00, $04, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            local6 = createitem("Some SCP-420-J", "420", (arg0\Field3 + (1776.0 * roomscale)), (arg0\Field4 + (400.0 * roomscale)), (arg0\Field5 + (427.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Some SCP-420-J", "420", (arg0\Field3 + (1808.0 * roomscale)), (arg0\Field4 + (400.0 * roomscale)), (arg0\Field5 + (435.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Level 5 Key Card", "key5", (arg0\Field3 + (2232.0 * roomscale)), (arg0\Field4 + (392.0 * roomscale)), (arg0\Field5 + (387.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            rotateentity(local6\Field1, 0.0, (Float arg0\Field6), 0.0, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Nuclear Device Document", "paper", (arg0\Field3 + (2248.0 * roomscale)), (arg0\Field4 + (440.0 * roomscale)), (arg0\Field5 + (372.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Radio Transceiver", "radio", (arg0\Field3 + (2240.0 * roomscale)), (arg0\Field4 + (320.0 * roomscale)), (arg0\Field5 + (128.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room2shaft"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (1552.0 * roomscale)), arg0\Field4, (arg0\Field5 + (552.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (arg0\Field5 + (518.0 * roomscale)), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (arg0\Field5 + (575.0 * roomscale)), $01)
            local0\Field21 = $00
            local0\Field5 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (256.0 * roomscale)), arg0\Field4, (arg0\Field5 + (744.0 * roomscale)), 90.0, arg0, $00, $00, $02, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            local6 = createitem("Level 3 Key Card", "key3", (arg0\Field3 + (1119.0 * roomscale)), (arg0\Field4 + (233.0 * roomscale)), (arg0\Field5 + (494.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("First Aid Kit", "firstaid", (arg0\Field3 + (1035.0 * roomscale)), (arg0\Field4 + (145.0 * roomscale)), (arg0\Field5 + (56.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
            local6 = createitem("9V Battery", "bat", (arg0\Field3 + (1930.0 * roomscale)), (arg0\Field4 + (97.0 * roomscale)), (arg0\Field5 + (256.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("9V Battery", "bat", (arg0\Field3 + (1061.0 * roomscale)), (arg0\Field4 + (161.0 * roomscale)), (arg0\Field5 + (494.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("ReVision Eyedrops", "eyedrops", (arg0\Field3 + (1930.0 * roomscale)), (arg0\Field4 + (225.0 * roomscale)), (arg0\Field5 + (128.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 + (1560.0 * roomscale)), arg0\Field4, (arg0\Field5 + (250.0 * roomscale)), $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 + (1344.0 * roomscale)), (-752.0 * roomscale), (arg0\Field5 - (384.0 * roomscale)), $01)
            local3 = createdecal($03, (arg0\Field3 + (1334.0 * roomscale)), ((-796.0 * roomscale) + 0.01), (arg0\Field5 - (220.0 * roomscale)), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
            local3\Field2 = 0.25
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityparent(local3\Field0, arg0\Field2, $01)
            arg0\Field25[$02] = createbutton((arg0\Field3 + (1181.0 * roomscale)), (arg0\Field4 + (180.0 * roomscale)), (arg0\Field5 - (512.0 * roomscale)), 0.0, 270.0, 0.0)
            entityparent(arg0\Field25[$02], arg0\Field2, $01)
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 + (828.25 * roomscale)), (arg0\Field4 + (77.312 * roomscale)), (arg0\Field5 - (608.083 * roomscale)), 90.0)
        Case "room2poffices"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (240.0 * roomscale)), 0.0, (arg0\Field5 + (448.0 * roomscale)), 90.0, arg0, $00, $00, $00, (Str accesscode), $00)
            positionentity(local0\Field3[$00], (arg0\Field3 + (248.0 * roomscale)), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 + (232.0 * roomscale)), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0\Field21 = $00
            local0\Field5 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (496.0 * roomscale)), 0.0, arg0\Field5, 90.0, arg0, $00, $00, $00, "ABCD", $00)
            positionentity(local0\Field3[$00], (arg0\Field3 - (488.0 * roomscale)), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 - (504.0 * roomscale)), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0\Field21 = $00
            local0\Field5 = $00
            local0\Field4 = $01
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (240.0 * roomscale)), 0.0, (arg0\Field5 - (576.0 * roomscale)), 90.0, arg0, $00, $00, $00, "7816", $00)
            positionentity(local0\Field3[$00], (arg0\Field3 + (248.0 * roomscale)), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 + (232.0 * roomscale)), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0\Field21 = $00
            local0\Field5 = $00
            local6 = createitem("Mysterious Note", "paper", (arg0\Field3 + (736.0 * roomscale)), (arg0\Field4 + (224.0 * roomscale)), (arg0\Field5 + (544.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Ballistic Vest", "vest", (arg0\Field3 + (608.0 * roomscale)), (arg0\Field4 + (112.0 * roomscale)), (arg0\Field5 + (32.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
            If (networkserver\Field15 = $00) Then
                local6 = createitem("Incident Report SCP-106-0204", "paper", (arg0\Field3 + (704.0 * roomscale)), (arg0\Field4 + (183.0 * roomscale)), (arg0\Field5 - (576.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
                local6 = createitem("Journal Page", "paper", (arg0\Field3 + (912.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 - (160.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("FN P90", "p90", (arg0\Field3 + (704.0 * roomscale)), (arg0\Field4 + (183.0 * roomscale)), (arg0\Field5 - (576.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
                local6 = createitem("Rocket Launcher", "rpg", (arg0\Field3 + (912.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 - (160.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("First Aid Kit", "firstaid", (arg0\Field3 + (912.0 * roomscale)), (arg0\Field4 + (112.0 * roomscale)), (arg0\Field5 - (336.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
        Case "room2poffices2"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (240.0 * roomscale)), 0.0, (arg0\Field5 + (48.0 * roomscale)), 270.0, arg0, $00, $00, $03, "", $00)
            positionentity(local0\Field3[$00], (arg0\Field3 + (224.0 * roomscale)), entityy(local0\Field3[$00], $01), (arg0\Field5 + (176.0 * roomscale)), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 + (256.0 * roomscale)), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0\Field21 = $00
            local0\Field5 = $00
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 - (432.0 * roomscale)), 0.0, arg0\Field5, 90.0, arg0, $00, $00, $00, "1234", $00)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 - (416.0 * roomscale)), entityy(arg0\Field29[$00]\Field3[$00], $01), (arg0\Field5 + (176.0 * roomscale)), $01)
            freeentity(arg0\Field29[$00]\Field3[$01])
            arg0\Field29[$00]\Field3[$01] = $00
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $00
            arg0\Field29[$00]\Field4 = $01
            local3 = createdecal($00, (arg0\Field3 - (808.0 * roomscale)), 0.005, (arg0\Field5 - (72.0 * roomscale)), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createdecal($02, (arg0\Field3 - (808.0 * roomscale)), 0.01, (arg0\Field5 - (72.0 * roomscale)), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
            local3\Field2 = 0.3
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createdecal($00, (arg0\Field3 - (432.0 * roomscale)), 0.01, arg0\Field5, 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
            entityparent(local3\Field0, arg0\Field2, $01)
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 - (808.0 * roomscale)), 1.0, (arg0\Field5 - (72.0 * roomscale)), $01)
            If (networkserver\Field15 = $00) Then
                local6 = createitem("Dr. L's Burnt Note", "paper", (arg0\Field3 - (688.0 * roomscale)), 1.0, (arg0\Field5 - (16.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
                local6 = createitem("Dr L's Burnt Note", "paper", (arg0\Field3 - (808.0 * roomscale)), 1.0, (arg0\Field5 - (72.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("FN P90", "p90", (arg0\Field3 - (688.0 * roomscale)), 1.0, (arg0\Field5 - (16.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
                local6 = createitem("Rocket Launcher", "rpg", (arg0\Field3 - (808.0 * roomscale)), 1.0, (arg0\Field5 - (72.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("The Modular Site Project", "paper", (arg0\Field3 + (622.0 * roomscale)), (arg0\Field4 + (125.0 * roomscale)), (arg0\Field5 - (73.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room2elevator"
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 + (888.0 * roomscale)), (240.0 * roomscale), arg0\Field5, $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], ((arg0\Field3 + (1024.0 * roomscale)) - 0.01), (120.0 * roomscale), arg0\Field5, $01)
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 + (448.0 * roomscale)), 0.0, arg0\Field5, 90.0, arg0, $00, $03, $00, "", $00)
            positionentity(arg0\Field29[$00]\Field3[$01], (arg0\Field3 + (416.0 * roomscale)), entityy(arg0\Field29[$00]\Field3[$01], $01), (arg0\Field5 - (208.0 * roomscale)), $01)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + (480.0 * roomscale)), entityy(arg0\Field29[$00]\Field3[$00], $01), (arg0\Field5 + (184.0 * roomscale)), $01)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $01
            arg0\Field29[$00]\Field4 = $01
        Case "room2cafeteria"
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 + (1847.0 * roomscale)), (-240.0 * roomscale), (arg0\Field5 - (321.0 * roomscale)), $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 + (1780.0 * roomscale)), (-248.0 * roomscale), (arg0\Field5 - (276.0 * roomscale)), $01)
            local6 = createitem("cup", "cup", (arg0\Field3 - (508.0 * roomscale)), (-187.0 * roomscale), (arg0\Field5 + (284.0 * roomscale)), $F0, $AF, $46, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6\Field0 = "Cup of Orange Juice"
            local6 = createitem("cup", "cup", (arg0\Field3 + (1412.0 * roomscale)), (-187.0 * roomscale), (arg0\Field5 - (716.0 * roomscale)), $57, $3E, $2D, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6\Field0 = "Cup of Coffee"
            If (networkserver\Field15 = $00) Then
                local6 = createitem("Empty Cup", "emptycup", (arg0\Field3 - (540.0 * roomscale)), (-187.0 * roomscale), (arg0\Field5 + (124.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (arg0\Field3 - (540.0 * roomscale)), (-187.0 * roomscale), (arg0\Field5 + (124.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("Quarter", "25ct", (arg0\Field3 - (447.0 * roomscale)), (arg0\Field4 - (334.0 * roomscale)), (arg0\Field5 + (36.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Quarter", "25ct", (arg0\Field3 + (1409.0 * roomscale)), (arg0\Field4 - (334.0 * roomscale)), (arg0\Field5 - (732.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 - (577.366 * roomscale)), (arg0\Field4 - (384.0 * roomscale)), (arg0\Field5 - (807.134 * roomscale)), -25.0)
        Case "room2nuke"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (576.0 * roomscale)), 0.0, (arg0\Field5 + (152.0 * roomscale)), 90.0, arg0, $00, $00, $05, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], (arg0\Field3 + (602.0 * roomscale)), entityy(local0\Field3[$00], $01), (arg0\Field5 + (20.0 * roomscale)), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 + (550.0 * roomscale)), entityy(local0\Field3[$01], $01), (arg0\Field5 + (20.0 * roomscale)), $01)
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (544.0 * roomscale)), (1504.0 * roomscale), (arg0\Field5 + (738.0 * roomscale)), 90.0, arg0, $00, $00, $05, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (arg0\Field5 + (608.0 * roomscale)), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (arg0\Field5 + (608.0 * roomscale)), $01)
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 + (1192.0 * roomscale)), 0.0, arg0\Field5, 90.0, arg0, $01, $03, $00, "", $00)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $01
            arg0\Field25[$04] = createpivot($00)
            positionentity(arg0\Field25[$04], (arg0\Field3 + (1496.0 * roomscale)), (240.0 * roomscale), arg0\Field5, $00)
            entityparent(arg0\Field25[$04], arg0\Field2, $01)
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 + (680.0 * roomscale)), (1504.0 * roomscale), arg0\Field5, 90.0, arg0, $00, $03, $00, "", $00)
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field5 = $00
            arg0\Field25[$05] = createpivot($00)
            positionentity(arg0\Field25[$05], (arg0\Field3 + (984.0 * roomscale)), (1744.0 * roomscale), arg0\Field5, $00)
            entityparent(arg0\Field25[$05], arg0\Field2, $01)
            For local18 = $00 To $01 Step $01
                arg0\Field25[(local18 Shl $01)] = copyentity(leverbaseobj, $00)
                arg0\Field25[((local18 Shl $01) + $01)] = copyentity(leverobj, $00)
                arg0\Field28[local18] = arg0\Field25[((local18 Shl $01) + $01)]
                For local7 = $00 To $01 Step $01
                    scaleentity(arg0\Field25[((local18 Shl $01) + local7)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field25[((local18 Shl $01) + local7)], (arg0\Field3 - (975.0 * roomscale)), (arg0\Field4 + (1712.0 * roomscale)), (arg0\Field5 - ((502.0 - (132.0 * (Float local18))) * roomscale)), $01)
                    entityparent(arg0\Field25[((local18 Shl $01) + local7)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field25[(local18 Shl $01)], 0.0, -270.0, 0.0, $00)
                rotateentity(arg0\Field25[((local18 Shl $01) + $01)], 10.0, -450.0, 0.0, $00)
                entityradius(arg0\Field25[((local18 Shl $01) + $01)], 0.1, 0.0)
                addentitytoroomprops(arg0, arg0\Field25[(local18 Shl $01)])
                addentitytoroomprops(arg0, arg0\Field25[((local18 Shl $01) + $01)])
            Next
            local6 = createitem("Nuclear Device Document", "paper", (arg0\Field3 - (768.0 * roomscale)), (arg0\Field4 + (1684.0 * roomscale)), (arg0\Field5 - (768.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Ballistic Vest", "vest", (arg0\Field3 - (944.0 * roomscale)), (arg0\Field4 + (1652.0 * roomscale)), (arg0\Field5 - (656.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, -90.0, 0.0, $00)
            local2 = createsecuritycam((arg0\Field3 + (624.0 * roomscale)), (arg0\Field4 + (1888.0 * roomscale)), (arg0\Field5 - (312.0 * roomscale)), arg0, $00)
            local2\Field11 = 90.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            arg0\Field25[$06] = createpivot($00)
            positionentity(arg0\Field25[$06], (arg0\Field3 + (1110.0 * roomscale)), (arg0\Field4 + (36.0 * roomscale)), (arg0\Field5 - (208.0 * roomscale)), $00)
            entityparent(arg0\Field25[$06], arg0\Field2, $01)
        Case "room2tunnel"
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (arg0\Field3 + (2640.0 * roomscale)), (-2496.0 * roomscale), (arg0\Field5 + (400.0 * roomscale)), $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            arg0\Field25[$01] = createpivot($00)
            positionentity(arg0\Field25[$01], (arg0\Field3 - (4336.0 * roomscale)), (-2496.0 * roomscale), (arg0\Field5 - (2512.0 * roomscale)), $00)
            entityparent(arg0\Field25[$01], arg0\Field2, $01)
            arg0\Field25[$02] = createpivot($00)
            rotateentity(arg0\Field25[$02], 0.0, 180.0, 0.0, $01)
            positionentity(arg0\Field25[$02], (arg0\Field3 + (552.0 * roomscale)), (240.0 * roomscale), (arg0\Field5 + (656.0 * roomscale)), $00)
            entityparent(arg0\Field25[$02], arg0\Field2, $01)
            arg0\Field25[$04] = createpivot($00)
            positionentity(arg0\Field25[$04], (arg0\Field3 - (552.0 * roomscale)), (240.0 * roomscale), (arg0\Field5 - (656.0 * roomscale)), $00)
            entityparent(arg0\Field25[$04], arg0\Field2, $01)
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 + (264.0 * roomscale)), 0.0, (arg0\Field5 + (656.0 * roomscale)), 90.0, arg0, $01, $03, $00, "", $00)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $01
            positionentity(arg0\Field29[$00]\Field3[$01], (arg0\Field3 + (224.0 * roomscale)), 0.7, (arg0\Field5 + (480.0 * roomscale)), $01)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + (304.0 * roomscale)), 0.7, (arg0\Field5 + (832.0 * roomscale)), $01)
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 - (264.0 * roomscale)), 0.0, (arg0\Field5 - (656.0 * roomscale)), 90.0, arg0, $01, $03, $00, "", $00)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$02]\Field5 = $01
            positionentity(arg0\Field29[$02]\Field3[$00], (arg0\Field3 - (224.0 * roomscale)), 0.7, (arg0\Field5 - (480.0 * roomscale)), $01)
            positionentity(arg0\Field29[$02]\Field3[$01], (arg0\Field3 - (304.0 * roomscale)), 0.7, (arg0\Field5 - (832.0 * roomscale)), $01)
            local19 = ((accesscode * $03) Mod $2710)
            If (local19 < $3E8) Then
                local19 = (local19 + $3E8)
            EndIf
            local0 = createdoor($00, arg0\Field3, arg0\Field4, arg0\Field5, 0.0, arg0, $00, $01, $00, (Str local19), $00)
            positionentity(local0\Field3[$00], (arg0\Field3 + (224.0 * roomscale)), (arg0\Field4 + 0.7), (arg0\Field5 - (384.0 * roomscale)), $01)
            rotateentity(local0\Field3[$00], 0.0, -90.0, 0.0, $01)
            positionentity(local0\Field3[$01], (arg0\Field3 - (224.0 * roomscale)), (arg0\Field4 + 0.7), (arg0\Field5 + (384.0 * roomscale)), $01)
            rotateentity(local0\Field3[$01], 0.0, 90.0, 0.0, $01)
            local3 = createdecal($00, (arg0\Field3 + (64.0 * roomscale)), 0.005, (arg0\Field5 + (144.0 * roomscale)), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
            entityparent(local3\Field0, arg0\Field2, $01)
            local6 = createitem("Scorched Note", "paper", (arg0\Field3 + (64.0 * roomscale)), (arg0\Field4 + (144.0 * roomscale)), (arg0\Field5 - (384.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "008"
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 + (292.0 * roomscale)), (130.0 * roomscale), (arg0\Field5 + (516.0 * roomscale)), $01)
            arg0\Field25[$01] = loadmesh_strict("GFX\map\008_2.b3d", $00)
            scaleentity(arg0\Field25[$01], roomscale, roomscale, roomscale, $00)
            positionentity(arg0\Field25[$01], (arg0\Field3 + (292.0 * roomscale)), (151.0 * roomscale), (arg0\Field5 + (576.0 * roomscale)), $00)
            entityparent(arg0\Field25[$01], arg0\Field2, $01)
            addentitytoroomprops(arg0, arg0\Field25[$01])
            rotateentity(arg0\Field25[$01], 89.0, 0.0, 0.0, $01)
            arg0\Field28[$00] = arg0\Field25[$01]
            local17 = loadtexture_strict("GFX\map\glass.png", $03)
            arg0\Field25[$02] = createsprite($00)
            entitytexture(arg0\Field25[$02], local17, $00, $00)
            spriteviewmode(arg0\Field25[$02], $02)
            scalesprite(arg0\Field25[$02], ((256.0 * roomscale) * 0.5), ((194.0 * roomscale) * 0.5))
            positionentity(arg0\Field25[$02], (arg0\Field3 - (176.0 * roomscale)), (224.0 * roomscale), (arg0\Field5 + (448.0 * roomscale)), $00)
            turnentity(arg0\Field25[$02], 0.0, 90.0, 0.0, $00)
            entityparent(arg0\Field25[$02], arg0\Field2, $01)
            freetexture(local17)
            arg0\Field25[$03] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$03], (arg0\Field3 - (445.0 * roomscale)), (120.0 * roomscale), (arg0\Field5 + (544.0 * roomscale)), $01)
            arg0\Field25[$04] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$04], (arg0\Field3 + (67.0 * roomscale)), (120.0 * roomscale), (arg0\Field5 + (464.0 * roomscale)), $01)
            arg0\Field25[$05] = createsprite($00)
            positionentity(arg0\Field25[$05], (arg0\Field3 - (158.0 * roomscale)), (368.0 * roomscale), (arg0\Field5 + (298.0 * roomscale)), $00)
            scalesprite(arg0\Field25[$05], 0.02, 0.02)
            entitytexture(arg0\Field25[$05], lightspritetex($01), $00, $00)
            entityblend(arg0\Field25[$05], $03)
            entityparent(arg0\Field25[$05], arg0\Field2, $01)
            hideentity(arg0\Field25[$05])
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (296.0 * roomscale)), 0.0, (arg0\Field5 - (672.0 * roomscale)), 180.0, arg0, $01, $00, $04, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$01], (arg0\Field3 + (164.0 * roomscale)), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            arg0\Field29[$00] = local0
            local1 = createdoor(arg0\Field0, (arg0\Field3 + (296.0 * roomscale)), 0.0, (arg0\Field5 - (144.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            local1\Field21 = $00
            positionentity(local1\Field3[$00], (arg0\Field3 + (432.0 * roomscale)), entityy(local1\Field3[$00], $01), (arg0\Field5 - (480.0 * roomscale)), $01)
            rotateentity(local1\Field3[$00], 0.0, -90.0, 0.0, $01)
            positionentity(local1\Field3[$01], (arg0\Field3 + (164.0 * roomscale)), entityy(local1\Field3[$00], $01), (arg0\Field5 - (128.0 * roomscale)), $01)
            freeentity(local1\Field1)
            local1\Field1 = $00
            arg0\Field29[$01] = local1
            local0\Field22 = local1
            local1\Field22 = local0
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (384.0 * roomscale)), 0.0, (arg0\Field5 - (672.0 * roomscale)), 0.0, arg0, $00, $00, $04, "", $00)
            local0\Field21 = $00
            local0\Field4 = $01
            arg0\Field29[$02] = local0
            local6 = createitem("Hazmat Suit", "hazmatsuit", (arg0\Field3 - (76.0 * roomscale)), 0.5, (arg0\Field5 - (396.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
            If (networkserver\Field15 = $00) Then
                local6 = createitem("Document SCP-008", "paper", (arg0\Field3 - (245.0 * roomscale)), (arg0\Field4 + (192.0 * roomscale)), (arg0\Field5 + (368.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (arg0\Field3 - (245.0 * roomscale)), (arg0\Field4 + (192.0 * roomscale)), (arg0\Field5 + (368.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            arg0\Field25[$06] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$06], (arg0\Field3 + (160.0 * roomscale)), (672.0 * roomscale), (arg0\Field5 - (384.0 * roomscale)), $01)
            arg0\Field25[$07] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$07], arg0\Field3, (672.0 * roomscale), (arg0\Field5 + (352.0 * roomscale)), $01)
            local2 = createsecuritycam((arg0\Field3 + (578.956 * roomscale)), (arg0\Field4 + (444.956 * roomscale)), (arg0\Field5 + (772.0 * roomscale)), arg0, $00)
            local2\Field11 = 135.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room035"
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (296.0 * roomscale)), 0.0, (arg0\Field5 - (672.0 * roomscale)), 180.0, arg0, $01, $00, $05, "", $00)
            local0\Field21 = $00
            local0\Field4 = $01
            arg0\Field29[$00] = local0
            positionentity(local0\Field3[$01], (arg0\Field3 - (164.0 * roomscale)), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field1)
            local0\Field1 = $00
            local1 = createdoor(arg0\Field0, (arg0\Field3 - (296.0 * roomscale)), 0.0, (arg0\Field5 - (144.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            local1\Field21 = $00
            local1\Field4 = $01
            arg0\Field29[$01] = local1
            positionentity(local1\Field3[$00], (arg0\Field3 - (432.0 * roomscale)), entityy(local1\Field3[$00], $01), (arg0\Field5 - (480.0 * roomscale)), $01)
            rotateentity(local1\Field3[$00], 0.0, 90.0, 0.0, $01)
            freeentity(local1\Field3[$01])
            local1\Field3[$01] = $00
            freeentity(local1\Field1)
            local1\Field1 = $00
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 + (384.0 * roomscale)), 0.0, (arg0\Field5 - (672.0 * roomscale)), 180.0, arg0, $00, $00, $05, "", $00)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$03] = createdoor($00, (arg0\Field3 + (768.0 * roomscale)), 0.0, (arg0\Field5 + (512.0 * roomscale)), 90.0, arg0, $00, $00, $00, "5731", $00)
            arg0\Field29[$03]\Field21 = $00
            local0\Field22 = local1
            local1\Field22 = local0
            For local7 = $00 To $01 Step $01
                arg0\Field25[(local7 Shl $01)] = copyentity(leverbaseobj, $00)
                arg0\Field25[((local7 Shl $01) + $01)] = copyentity(leverobj, $00)
                arg0\Field28[local7] = arg0\Field25[((local7 Shl $01) + $01)]
                For local18 = $00 To $01 Step $01
                    scaleentity(arg0\Field25[((local7 Shl $01) + local18)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field25[((local7 Shl $01) + local18)], (arg0\Field3 + (210.0 * roomscale)), (arg0\Field4 + (224.0 * roomscale)), (arg0\Field5 - ((Float ($D0 - (local7 * $4C))) * roomscale)), $01)
                    entityparent(arg0\Field25[((local7 Shl $01) + local18)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field25[(local7 Shl $01)], 0.0, -270.0, 0.0, $00)
                rotateentity(arg0\Field25[((local7 Shl $01) + $01)], -80.0, -90.0, 0.0, $00)
                entityradius(arg0\Field25[((local7 Shl $01) + $01)], 0.1, 0.0)
                addentitytoroomprops(arg0, arg0\Field25[(local7 Shl $01)])
                addentitytoroomprops(arg0, arg0\Field25[((local7 Shl $01) + $01)])
            Next
            arg0\Field25[$03] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$03], (arg0\Field3 + (456.0 * roomscale)), 0.5, (arg0\Field5 + (400.0 * roomscale)), $01)
            arg0\Field25[$04] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$04], (arg0\Field3 - (576.0 * roomscale)), 0.5, (arg0\Field5 + (640.0 * roomscale)), $01)
            For local7 = $00 To $01 Step $01
                local14 = createemitter((arg0\Field3 - (272.0 * roomscale)), 10.0, (arg0\Field5 + ((624.0 - (Float (local7 Shl $09))) * roomscale)), $00, 0.0)
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
            positionentity(arg0\Field25[$07], (arg0\Field3 - (720.0 * roomscale)), 0.5, (arg0\Field5 + (880.0 * roomscale)), $01)
            arg0\Field25[$08] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$08], (arg0\Field3 + (176.0 * roomscale)), 0.5, (arg0\Field5 - (144.0 * roomscale)), $01)
            local6 = createitem("SCP-035 Addendum", "paper", (arg0\Field3 + (248.0 * roomscale)), (arg0\Field4 + (220.0 * roomscale)), (arg0\Field5 + (576.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            If (networkserver\Field15 = $00) Then
                local6 = createitem("Radio Transceiver", "radio", (arg0\Field3 - (544.0 * roomscale)), 0.5, (arg0\Field5 + (704.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (arg0\Field3 - (544.0 * roomscale)), 0.5, (arg0\Field5 + (704.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("SCP-500-01", "scp500", (arg0\Field3 + (1168.0 * roomscale)), (224.0 * roomscale), (arg0\Field5 + (576.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Metal Panel", "scp148", (arg0\Field3 - (360.0 * roomscale)), 0.5, (arg0\Field5 + (644.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Document SCP-035", "paper", (arg0\Field3 + (1168.0 * roomscale)), (104.0 * roomscale), (arg0\Field5 + (608.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room513"
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (704.0 * roomscale)), 0.0, (arg0\Field5 + (304.0 * roomscale)), 0.0, arg0, $00, $00, $02, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (arg0\Field5 + (288.0 * roomscale)), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (arg0\Field5 + (320.0 * roomscale)), $01)
            local2 = createsecuritycam((arg0\Field3 - (312.0 * roomscale)), (arg0\Field4 + (414.0 * roomscale)), (arg0\Field5 + (656.0 * roomscale)), arg0, $00)
            local2\Field21 = $01
            local6 = createitem("SCP-513", "scp513", (arg0\Field3 - (60.0 * roomscale)), (arg0\Field4 + (196.0 * roomscale)), (arg0\Field5 + (688.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Blood-stained Note", "paper", (arg0\Field3 + (736.0 * roomscale)), 1.0, (arg0\Field5 + (48.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Document SCP-513", "paper", (arg0\Field3 - (480.0 * roomscale)), (104.0 * roomscale), (arg0\Field5 - (176.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            If ((rand($00, $01) And networkserver\Field15) <> 0) Then
                local6 = createitem("SCP-035", "scp035", (arg0\Field3 - (600.0 * roomscale)), (arg0\Field4 + (196.0 * roomscale)), (arg0\Field5 + (688.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
        Case "room966"
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (400.0 * roomscale)), 0.0, arg0\Field5, -90.0, arg0, $00, $00, $03, "", $00)
            local0 = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - (480.0 * roomscale)), 180.0, arg0, $00, $00, $03, "", $00)
            local2 = createsecuritycam((arg0\Field3 - (312.0 * roomscale)), (arg0\Field4 + (414.0 * roomscale)), (arg0\Field5 + (656.0 * roomscale)), arg0, $00)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], arg0\Field3, 0.5, (arg0\Field5 + (512.0 * roomscale)), $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 + (64.0 * roomscale)), 0.5, (arg0\Field5 - (640.0 * roomscale)), $01)
            arg0\Field25[$02] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$02], arg0\Field3, 0.5, arg0\Field5, $01)
            arg0\Field25[$03] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$03], (arg0\Field3 + (320.0 * roomscale)), 0.5, (arg0\Field5 + (704.0 * roomscale)), $01)
            local6 = createitem("Night Vision Goggles", "nvgoggles", (arg0\Field3 + (320.0 * roomscale)), 0.5, (arg0\Field5 + (704.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6\Field13 = 300.0
        Case "room3storage"
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], arg0\Field3, (240.0 * roomscale), (arg0\Field5 + (752.0 * roomscale)), $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 + (5840.0 * roomscale)), (-5392.0 * roomscale), (arg0\Field5 + (1360.0 * roomscale)), $01)
            arg0\Field25[$02] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$02], (arg0\Field3 + (608.0 * roomscale)), (240.0 * roomscale), (arg0\Field5 - (624.0 * roomscale)), $01)
            arg0\Field25[$03] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$03], (arg0\Field3 - (456.0 * roomscale)), (-5392.0 * roomscale), (arg0\Field5 - (1136.0 * roomscale)), $01)
            arg0\Field25[$04] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$04], (arg0\Field3 + (2128.0 * roomscale)), (-5550.0 * roomscale), (arg0\Field5 + (2048.0 * roomscale)), $01)
            arg0\Field25[$05] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$05], (arg0\Field3 + (2128.0 * roomscale)), (-5550.0 * roomscale), (arg0\Field5 - (1136.0 * roomscale)), $01)
            arg0\Field25[$06] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$06], (arg0\Field3 + (3824.0 * roomscale)), (-5550.0 * roomscale), (arg0\Field5 - (1168.0 * roomscale)), $01)
            arg0\Field25[$07] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$07], (arg0\Field3 + (3760.0 * roomscale)), (-5550.0 * roomscale), (arg0\Field5 + (2048.0 * roomscale)), $01)
            arg0\Field25[$08] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$08], (arg0\Field3 + (4848.0 * roomscale)), (-5550.0 * roomscale), (arg0\Field5 + (112.0 * roomscale)), $01)
            arg0\Field25[$09] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$09], (arg0\Field3 + (592.0 * roomscale)), (-5550.0 * roomscale), (arg0\Field5 + (6352.0 * roomscale)), $01)
            arg0\Field25[$0A] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$0A], (arg0\Field3 + (2928.0 * roomscale)), (-5550.0 * roomscale), (arg0\Field5 + (6352.0 * roomscale)), $01)
            arg0\Field25[$0B] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$0B], (arg0\Field3 + (2928.0 * roomscale)), (-5550.0 * roomscale), (arg0\Field5 + (5200.0 * roomscale)), $01)
            arg0\Field25[$0C] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$0C], (arg0\Field3 + (592.0 * roomscale)), (-5550.0 * roomscale), (arg0\Field5 + (5200.0 * roomscale)), $01)
            arg0\Field25[$0D] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$0D], (arg0\Field3 + (1136.0 * roomscale)), (-5550.0 * roomscale), (arg0\Field5 + (2944.0 * roomscale)), $01)
            arg0\Field25[$0E] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$0E], (arg0\Field3 + (1104.0 * roomscale)), (-5550.0 * roomscale), (arg0\Field5 + (1184.0 * roomscale)), $01)
            arg0\Field25[$0F] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$0F], (arg0\Field3 - (464.0 * roomscale)), (-5550.0 * roomscale), (arg0\Field5 + (1216.0 * roomscale)), $01)
            arg0\Field25[$10] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$10], (arg0\Field3 - (432.0 * roomscale)), (-5550.0 * roomscale), (arg0\Field5 + (2976.0 * roomscale)), $01)
            arg0\Field25[$14] = loadmesh_strict("GFX\map\room3storage_hb.b3d", arg0\Field2)
            entitypickmode(arg0\Field25[$14], $02, $01)
            entitytype(arg0\Field25[$14], $01, $00)
            entityalpha(arg0\Field25[$14], 0.0)
            arg0\Field29[$00] = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 + (448.0 * roomscale)), 0.0, arg0, $01, $03, $00, "", $00)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $01
            positionentity(arg0\Field29[$00]\Field3[$01], (arg0\Field3 - (160.0 * roomscale)), 0.7, (arg0\Field5 + (480.0 * roomscale)), $01)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + (160.0 * roomscale)), 0.7, (arg0\Field5 + (416.0 * roomscale)), $01)
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 + (5840.0 * roomscale)), (-5632.0 * roomscale), (arg0\Field5 + (1048.0 * roomscale)), 0.0, arg0, $00, $03, $00, "", $00)
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field5 = $00
            positionentity(arg0\Field29[$01]\Field3[$00], (arg0\Field3 + (6000.0 * roomscale)), entityy(arg0\Field29[$01]\Field3[$00], $01), (arg0\Field5 + (1008.0 * roomscale)), $01)
            positionentity(arg0\Field29[$01]\Field3[$01], (arg0\Field3 + (5680.0 * roomscale)), entityy(arg0\Field29[$01]\Field3[$01], $01), (arg0\Field5 + (1088.0 * roomscale)), $01)
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 + (608.0 * roomscale)), 0.0, (arg0\Field5 - (312.0 * roomscale)), 0.0, arg0, $01, $03, $00, "", $00)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$02]\Field5 = $01
            positionentity(arg0\Field29[$02]\Field3[$01], (arg0\Field3 + (448.0 * roomscale)), 0.7, (arg0\Field5 - (272.0 * roomscale)), $01)
            positionentity(arg0\Field29[$02]\Field3[$00], (arg0\Field3 + (768.0 * roomscale)), 0.7, (arg0\Field5 - (352.0 * roomscale)), $01)
            arg0\Field29[$03] = createdoor(arg0\Field0, (arg0\Field3 - (456.0 * roomscale)), (-5632.0 * roomscale), (arg0\Field5 - (824.0 * roomscale)), 0.0, arg0, $00, $03, $00, "", $00)
            arg0\Field29[$03]\Field21 = $00
            arg0\Field29[$03]\Field5 = $00
            positionentity(arg0\Field29[$03]\Field3[$00], (arg0\Field3 - (280.0 * roomscale)), entityy(arg0\Field29[$03]\Field3[$00], $01), (arg0\Field5 - (864.0 * roomscale)), $01)
            positionentity(arg0\Field29[$03]\Field3[$01], (arg0\Field3 - (632.0 * roomscale)), entityy(arg0\Field29[$03]\Field3[$01], $01), (arg0\Field5 - (784.0 * roomscale)), $01)
            local14 = createemitter((arg0\Field3 + (5218.0 * roomscale)), (-5584.0 * roomscale), (arg0\Field5 - (600.0 * roomscale)), $00, 0.0)
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
            local6 = createitem("Black Severed Hand", "hand2", (arg0\Field3 + (local21 * roomscale)), ((-5596.0 * roomscale) + 1.0), (arg0\Field5 + (local22 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Night Vision Goggles", "nvgoggles", (arg0\Field3 + (1936.0 * roomscale)), (arg0\Field4 - (5496.0 * roomscale)), (arg0\Field5 - (944.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6\Field13 = 450.0
            local3 = createdecal($03, (arg0\Field3 + (local21 * roomscale)), ((-5632.0 * roomscale) + 0.01), (arg0\Field5 + (local22 * roomscale)), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
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
                        positionentity(arg0\Field25[((local18 Shl $01) + local7)], (arg0\Field3 + (3101.0 * roomscale)), (arg0\Field4 - (5461.0 * roomscale)), (arg0\Field5 + (6568.0 * roomscale)), $01)
                    Else
                        positionentity(arg0\Field25[((local18 Shl $01) + local7)], (arg0\Field3 + (1209.0 * roomscale)), (arg0\Field4 - (5461.0 * roomscale)), (arg0\Field5 + (3164.0 * roomscale)), $01)
                    EndIf
                    entityparent(arg0\Field25[((local18 Shl $01) + local7)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field25[(local18 Shl $01)], 0.0, 0.0, 0.0, $00)
                rotateentity(arg0\Field25[((local18 Shl $01) + $01)], -10.0, -180.0, 0.0, $00)
                entityradius(arg0\Field25[((local18 Shl $01) + $01)], 0.1, 0.0)
                addentitytoroomprops(arg0, arg0\Field25[(local18 Shl $01)])
                addentitytoroomprops(arg0, arg0\Field25[((local18 Shl $01) + $01)])
            Next
            arg0\Field29[$04] = createdoor(arg0\Field0, (arg0\Field3 + (56.0 * roomscale)), (arg0\Field4 - (5632.0 * roomscale)), (arg0\Field5 + (6344.0 * roomscale)), 90.0, arg0, $00, $02, $00, "", $00)
            arg0\Field29[$04]\Field21 = $00
            arg0\Field29[$04]\Field5 = $00
            For local7 = $00 To $01 Step $01
                freeentity(arg0\Field29[$04]\Field3[local7])
                arg0\Field29[$04]\Field3[local7] = $00
            Next
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (1157.0 * roomscale)), (arg0\Field4 - (5632.0 * roomscale)), (arg0\Field5 + (660.0 * roomscale)), 0.0, arg0, $00, $02, $00, "", $00)
            local0\Field4 = $01
            local0\Field5 = $00
            local0\Field21 = $00
            For local7 = $00 To $01 Step $01
                freeentity(local0\Field3[local7])
                local0\Field3[local7] = $00
            Next
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (234.0 * roomscale)), (arg0\Field4 - (5632.0 * roomscale)), (arg0\Field5 + (5239.0 * roomscale)), 90.0, arg0, $00, $02, $00, "", $00)
            local0\Field4 = $01
            local0\Field5 = $00
            local0\Field21 = $00
            For local7 = $00 To $01 Step $01
                freeentity(local0\Field3[local7])
                local0\Field3[local7] = $00
            Next
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (3446.0 * roomscale)), (arg0\Field4 - (5632.0 * roomscale)), (arg0\Field5 + (6369.0 * roomscale)), 90.0, arg0, $00, $02, $00, "", $00)
            local0\Field4 = $01
            local0\Field5 = $00
            local0\Field21 = $00
            For local7 = $00 To $01 Step $01
                freeentity(local0\Field3[local7])
                local0\Field3[local7] = $00
            Next
        Case "room049"
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 + (640.0 * roomscale)), (240.0 * roomscale), (arg0\Field5 + (656.0 * roomscale)), $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 + (3211.0 * roomscale)), (-3280.0 * roomscale), (arg0\Field5 + (1824.0 * roomscale)), $01)
            arg0\Field25[$02] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$02], (arg0\Field3 - (672.0 * roomscale)), (240.0 * roomscale), (arg0\Field5 - (93.0 * roomscale)), $01)
            arg0\Field25[$03] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$03], (arg0\Field3 - (2766.0 * roomscale)), (-3280.0 * roomscale), (arg0\Field5 - (1277.0 * roomscale)), $01)
            arg0\Field25[$04] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$04], (arg0\Field3 + (528.0 * roomscale)), (-3440.0 * roomscale), (arg0\Field5 + (96.0 * roomscale)), $01)
            arg0\Field25[$05] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$05], (arg0\Field3 + (64.0 * roomscale)), (-3440.0 * roomscale), (arg0\Field5 - (1000.0 * roomscale)), $01)
            For local18 = $00 To $01 Step $01
                arg0\Field25[((local18 Shl $01) + $06)] = copyentity(leverbaseobj, $00)
                arg0\Field25[((local18 Shl $01) + $07)] = copyentity(leverobj, $00)
                arg0\Field28[local18] = arg0\Field25[((local18 Shl $01) + $07)]
                For local7 = $00 To $01 Step $01
                    scaleentity(arg0\Field25[(((local18 Shl $01) + $06) + local7)], 0.03, 0.03, 0.03, $00)
                    Select local18
                        Case $00
                            positionentity(arg0\Field25[(((local18 Shl $01) + $06) + local7)], (arg0\Field3 + (852.0 * roomscale)), (arg0\Field4 - (3374.0 * roomscale)), (arg0\Field5 - (854.0 * roomscale)), $01)
                        Case $01
                            positionentity(arg0\Field25[(((local18 Shl $01) + $06) + local7)], (arg0\Field3 - (834.0 * roomscale)), (arg0\Field4 - (3400.0 * roomscale)), (arg0\Field5 + (1093.0 * roomscale)), $01)
                    End Select
                    entityparent(arg0\Field25[(((local18 Shl $01) + $06) + local7)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field25[((local18 Shl $01) + $06)], 0.0, (Float (((local18 = $00) * $5A) + $B4)), 0.0, $00)
                rotateentity(arg0\Field25[((local18 Shl $01) + $07)], (Float ($51 - ($5C * local18))), (Float ((local18 = $00) * $5A)), 0.0, $00)
                entityradius(arg0\Field25[((local18 Shl $01) + $07)], 0.1, 0.0)
                addentitytoroomprops(arg0, arg0\Field25[((local18 Shl $01) + $06)])
                addentitytoroomprops(arg0, arg0\Field25[((local18 Shl $01) + $07)])
            Next
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 + (330.0 * roomscale)), 0.0, (arg0\Field5 + (656.0 * roomscale)), 90.0, arg0, $01, $03, $00, "", $00)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $01
            positionentity(arg0\Field29[$00]\Field3[$01], (arg0\Field3 + (288.0 * roomscale)), 0.7, (arg0\Field5 + (512.0 * roomscale)), $01)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + (368.0 * roomscale)), 0.7, (arg0\Field5 + (840.0 * roomscale)), $01)
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 + (2898.0 * roomscale)), (-3520.0 * roomscale), (arg0\Field5 + (1824.0 * roomscale)), 90.0, arg0, $00, $03, $00, "", $00)
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field5 = $00
            positionentity(arg0\Field29[$01]\Field3[$01], (arg0\Field3 + (2881.0 * roomscale)), entityy(arg0\Field29[$01]\Field3[$01], $01), (arg0\Field5 + (1663.0 * roomscale)), $01)
            positionentity(arg0\Field29[$01]\Field3[$00], (arg0\Field3 + (2936.0 * roomscale)), entityy(arg0\Field29[$01]\Field3[$00], $01), (arg0\Field5 + (2009.0 * roomscale)), $01)
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 - (672.0 * roomscale)), 0.0, (arg0\Field5 - (408.0 * roomscale)), 0.0, arg0, $01, $03, $00, "", $00)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$02]\Field5 = $01
            positionentity(arg0\Field29[$02]\Field3[$00], (arg0\Field3 - (487.0 * roomscale)), 0.7, (arg0\Field5 - (447.0 * roomscale)), $01)
            positionentity(arg0\Field29[$02]\Field3[$01], (arg0\Field3 - (857.0 * roomscale)), 0.7, (arg0\Field5 - (369.0 * roomscale)), $01)
            arg0\Field29[$03] = createdoor(arg0\Field0, (arg0\Field3 - (2766.0 * roomscale)), (-3520.0 * roomscale), (arg0\Field5 - (1592.0 * roomscale)), 0.0, arg0, $00, $03, $00, "", $00)
            arg0\Field29[$03]\Field21 = $00
            arg0\Field29[$03]\Field5 = $00
            positionentity(arg0\Field29[$03]\Field3[$00], (arg0\Field3 - (2581.0 * roomscale)), entityy(arg0\Field29[$03]\Field3[$00], $01), (arg0\Field5 - (1631.0 * roomscale)), $01)
            positionentity(arg0\Field29[$03]\Field3[$01], (arg0\Field3 - (2951.0 * roomscale)), entityy(arg0\Field29[$03]\Field3[$01], $01), (arg0\Field5 - (1553.0 * roomscale)), $01)
            arg0\Field29[$04] = createdoor(arg0\Field0, (arg0\Field3 + (272.0 * roomscale)), (-3552.0 * roomscale), (arg0\Field5 + (104.0 * roomscale)), 90.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$04]\Field21 = $00
            arg0\Field29[$04]\Field5 = $01
            arg0\Field29[$04]\Field4 = $01
            arg0\Field29[$05] = createdoor(arg0\Field0, (arg0\Field3 + (264.0 * roomscale)), (-3520.0 * roomscale), (arg0\Field5 - (1824.0 * roomscale)), 90.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$05]\Field21 = $00
            arg0\Field29[$05]\Field5 = $01
            arg0\Field29[$05]\Field4 = $01
            arg0\Field29[$06] = createdoor(arg0\Field0, (arg0\Field3 - (264.0 * roomscale)), (-3520.0 * roomscale), (arg0\Field5 + (1824.0 * roomscale)), 90.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$06]\Field21 = $00
            arg0\Field29[$06]\Field5 = $01
            arg0\Field29[$06]\Field4 = $01
            local0 = createdoor($00, arg0\Field3, 0.0, arg0\Field5, 0.0, arg0, $00, $02, $FFFFFFFE, "", $00)
            local6 = createitem("Document SCP-049", "paper", (arg0\Field3 - (608.0 * roomscale)), (arg0\Field4 - (3332.0 * roomscale)), (arg0\Field5 + (876.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Level 4 Key Card", "key4", (arg0\Field3 - (512.0 * roomscale)), (arg0\Field4 - (3412.0 * roomscale)), (arg0\Field5 + (864.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("First Aid Kit", "firstaid", (arg0\Field3 + (385.0 * roomscale)), (arg0\Field4 - (3412.0 * roomscale)), (arg0\Field5 + (271.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (272.0 * roomscale)), (arg0\Field4 - (3552.0 * roomscale)), (arg0\Field5 + (98.0 * roomscale)), 90.0, arg0, $01, $01, $00, "", $00)
            local0\Field21 = $00
            local0\Field5 = $01
            local0\Field24 = $00
            local0\Field4 = $01
            For local7 = $00 To $01 Step $01
                freeentity(local0\Field3[local7])
                local0\Field3[local7] = $00
            Next
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (2990.0 * roomscale)), (arg0\Field4 - (3520.0 * roomscale)), (arg0\Field5 - (1824.0 * roomscale)), 90.0, arg0, $00, $02, $00, "", $00)
            local0\Field4 = $01
            local0\Field14 = $01
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (896.0 * roomscale)), arg0\Field4, (arg0\Field5 - (640.0 * roomscale)), 90.0, arg0, $00, $02, $00, "", $00)
            local0\Field4 = $01
            local0\Field14 = $01
            arg0\Field25[$0A] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$0A], (arg0\Field3 - (832.0 * roomscale)), (arg0\Field4 - (3484.0 * roomscale)), (arg0\Field5 + (1572.0 * roomscale)), $01)
            arg0\Field25[$0B] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$0B], (arg0\Field3 + (2642.0 * roomscale)), (arg0\Field4 - (3516.0 * roomscale)), (arg0\Field5 + (1822.0 * roomscale)), $01)
            arg0\Field25[$0C] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$0C], (arg0\Field3 - (2666.0 * roomscale)), (arg0\Field4 - (3516.0 * roomscale)), (arg0\Field5 - (1792.0 * roomscale)), $01)
        Case "room2_2"
            For local4 = Each rooms
                If (local4 <> arg0) Then
                    If (local4\Field7\Field11 = "room2_2") Then
                        arg0\Field25[$00] = copyentity(local4\Field25[$00], $00)
                        Exit
                    EndIf
                EndIf
            Next
            If (arg0\Field25[$00] = $00) Then
                arg0\Field25[$00] = loadmesh_strict("GFX\map\fan.b3d", $00)
            EndIf
            scaleentity(arg0\Field25[$00], roomscale, roomscale, roomscale, $00)
            positionentity(arg0\Field25[$00], (arg0\Field3 - (248.0 * roomscale)), (528.0 * roomscale), arg0\Field5, $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            addentitytoroomprops(arg0, arg0\Field25[$00])
        Case "room012"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (264.0 * roomscale)), 0.0, (arg0\Field5 + (672.0 * roomscale)), 270.0, arg0, $00, $00, $03, "", $00)
            positionentity(local0\Field3[$00], (arg0\Field3 + (224.0 * roomscale)), entityy(local0\Field3[$00], $01), (arg0\Field5 + (540.0 * roomscale)), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 + (304.0 * roomscale)), entityy(local0\Field3[$01], $01), (arg0\Field5 + (840.0 * roomscale)), $01)
            turnentity(local0\Field3[$01], 0.0, 0.0, 0.0, $01)
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 - (512.0 * roomscale)), (-768.0 * roomscale), (arg0\Field5 - (336.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $00
            arg0\Field29[$00]\Field4 = $01
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + (176.0 * roomscale)), (-512.0 * roomscale), (arg0\Field5 - (364.0 * roomscale)), $01)
            freeentity(arg0\Field29[$00]\Field3[$01])
            arg0\Field29[$00]\Field3[$01] = $00
            arg0\Field25[$00] = copyentity(leverbaseobj, $00)
            arg0\Field25[$01] = copyentity(leverobj, $00)
            addentitytoroomprops(arg0, arg0\Field25[$00])
            addentitytoroomprops(arg0, arg0\Field25[$01])
            arg0\Field28[$00] = arg0\Field25[$01]
            For local7 = $00 To $01 Step $01
                scaleentity(arg0\Field25[local7], 0.04, 0.04, 0.04, $00)
                positionentity(arg0\Field25[local7], (arg0\Field3 + (240.0 * roomscale)), (arg0\Field4 - (512.0 * roomscale)), (arg0\Field5 - (364.0 * roomscale)), $01)
                entityparent(arg0\Field25[local7], arg0\Field2, $01)
            Next
            rotateentity(arg0\Field25[$01], 10.0, -180.0, 0.0, $00)
            entitypickmode(arg0\Field25[$01], $01, $00)
            entityradius(arg0\Field25[$01], 0.1, 0.0)
            arg0\Field25[$02] = loadmesh_strict("GFX\map\room012_2.b3d", $00)
            scaleentity(arg0\Field25[$02], roomscale, roomscale, roomscale, $00)
            positionentity(arg0\Field25[$02], (arg0\Field3 - (360.0 * roomscale)), (-130.0 * roomscale), (arg0\Field5 + (456.0 * roomscale)), $00)
            entityparent(arg0\Field25[$02], arg0\Field2, $01)
            addentitytoroomprops(arg0, arg0\Field25[$02])
            arg0\Field25[$03] = createsprite($00)
            positionentity(arg0\Field25[$03], (arg0\Field3 - (43.5 * roomscale)), (-574.0 * roomscale), (arg0\Field5 - (362.0 * roomscale)), $00)
            scalesprite(arg0\Field25[$03], 0.015, 0.015)
            entitytexture(arg0\Field25[$03], lightspritetex($01), $00, $00)
            entityblend(arg0\Field25[$03], $03)
            entityparent(arg0\Field25[$03], arg0\Field2, $01)
            hideentity(arg0\Field25[$03])
            arg0\Field25[$04] = loadmesh_strict("GFX\map\room012_3.b3d", $00)
            local24 = loadtexture_strict("GFX\map\scp-012_0.jpg", $01)
            entitytexture(arg0\Field25[$04], local24, $00, $01)
            scaleentity(arg0\Field25[$04], roomscale, roomscale, roomscale, $00)
            positionentity(arg0\Field25[$04], (arg0\Field3 - (360.0 * roomscale)), (-130.0 * roomscale), (arg0\Field5 + (456.0 * roomscale)), $00)
            entityparent(arg0\Field25[$04], arg0\Field25[$02], $01)
            freetexture(local24)
            addentitytoroomprops(arg0, arg0\Field25[$04])
            local6 = createitem("Document SCP-012", "paper", (arg0\Field3 - (56.0 * roomscale)), (arg0\Field4 - (576.0 * roomscale)), (arg0\Field5 - (408.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Severed Hand", "hand", (arg0\Field3 - (784.0 * roomscale)), ((-576.0 * roomscale) + 0.3), (arg0\Field5 + (640.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local3 = createdecal($03, (arg0\Field3 - (784.0 * roomscale)), ((-768.0 * roomscale) + 0.01), (arg0\Field5 + (640.0 * roomscale)), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
            local3\Field2 = 0.5
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityparent(local3\Field0, arg0\Field2, $01)
        Case "tunnel2"
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], arg0\Field3, (544.0 * roomscale), (arg0\Field5 + (512.0 * roomscale)), $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], arg0\Field3, (544.0 * roomscale), (arg0\Field5 - (512.0 * roomscale)), $01)
        Case "room2pipes"
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 + (368.0 * roomscale)), 0.0, arg0\Field5, $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 - (368.0 * roomscale)), 0.0, arg0\Field5, $01)
            arg0\Field25[$02] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$02], ((arg0\Field3 + (224.0 * roomscale)) - 0.005), (192.0 * roomscale), arg0\Field5, $01)
            arg0\Field25[$03] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$03], ((arg0\Field3 - (224.0 * roomscale)) + 0.005), (192.0 * roomscale), arg0\Field5, $01)
        Case "room3pit"
            local14 = createemitter((arg0\Field3 + (512.0 * roomscale)), (-76.0 * roomscale), (arg0\Field5 - (688.0 * roomscale)), $00, 0.0)
            turnentity(local14\Field0, -90.0, 0.0, 0.0, $00)
            entityparent(local14\Field0, arg0\Field2, $01)
            local14\Field10 = 55.0
            local14\Field9 = 0.0005
            local14\Field12 = -0.015
            local14\Field11 = 0.007
            local14 = createemitter((arg0\Field3 - (512.0 * roomscale)), (-76.0 * roomscale), (arg0\Field5 - (688.0 * roomscale)), $00, 0.0)
            turnentity(local14\Field0, -90.0, 0.0, 0.0, $00)
            entityparent(local14\Field0, arg0\Field2, $01)
            local14\Field10 = 55.0
            local14\Field9 = 0.0005
            local14\Field12 = -0.015
            local14\Field11 = 0.007
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 + (704.0 * roomscale)), (112.0 * roomscale), (arg0\Field5 - (416.0 * roomscale)), $01)
        Case "room2servers"
            local0 = createdoor($00, arg0\Field3, 0.0, arg0\Field5, 0.0, arg0, $00, $02, $00, "", $00)
            local0\Field4 = $01
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 - (208.0 * roomscale)), 0.0, (arg0\Field5 - (736.0 * roomscale)), 90.0, arg0, $01, $00, $00, "", $01)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 - (208.0 * roomscale)), 0.0, (arg0\Field5 + (736.0 * roomscale)), 90.0, arg0, $01, $00, $00, "", $01)
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 - (672.0 * roomscale)), 0.0, (arg0\Field5 - (1024.0 * roomscale)), 0.0, arg0, $00, $00, $00, "GEAR", $00)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$02]\Field14 = $01
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
                            positionentity(arg0\Field25[((local18 Shl $01) + local7)], (arg0\Field3 - (1260.0 * roomscale)), (arg0\Field4 + (234.0 * roomscale)), (arg0\Field5 + (750.0 * roomscale)), $01)
                        Case $01
                            positionentity(arg0\Field25[((local18 Shl $01) + local7)], (arg0\Field3 - (920.0 * roomscale)), (arg0\Field4 + (164.0 * roomscale)), (arg0\Field5 + (898.0 * roomscale)), $01)
                        Case $02
                            positionentity(arg0\Field25[((local18 Shl $01) + local7)], (arg0\Field3 - (837.0 * roomscale)), (arg0\Field4 + (152.0 * roomscale)), (arg0\Field5 + (886.0 * roomscale)), $01)
                    End Select
                    entityparent(arg0\Field25[((local18 Shl $01) + local7)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field25[((local18 Shl $01) + $01)], 81.0, -180.0, 0.0, $00)
                entityradius(arg0\Field25[((local18 Shl $01) + $01)], 0.1, 0.0)
                addentitytoroomprops(arg0, arg0\Field25[(local18 Shl $01)])
                addentitytoroomprops(arg0, arg0\Field25[((local18 Shl $01) + $01)])
            Next
            rotateentity(arg0\Field25[$03], -81.0, -180.0, 0.0, $00)
            rotateentity(arg0\Field25[$05], -81.0, -180.0, 0.0, $00)
            arg0\Field25[$06] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$06], (arg0\Field3 - (320.0 * roomscale)), 0.5, arg0\Field5, $01)
            arg0\Field25[$07] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$07], (arg0\Field3 - (1328.0 * roomscale)), 0.5, (arg0\Field5 + (528.0 * roomscale)), $01)
            arg0\Field25[$08] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$08], (arg0\Field3 - (1376.0 * roomscale)), 0.5, (arg0\Field5 + (32.0 * roomscale)), $01)
            arg0\Field25[$09] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$09], (arg0\Field3 - (848.0 * roomscale)), 0.5, (arg0\Field5 + (576.0 * roomscale)), $01)
        Case "room3servers"
            local6 = createitem("9V Battery", "bat", (arg0\Field3 - (132.0 * roomscale)), (arg0\Field4 - (368.0 * roomscale)), (arg0\Field5 - (648.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("9V Battery", "bat", (arg0\Field3 - (76.0 * roomscale)), (arg0\Field4 - (368.0 * roomscale)), (arg0\Field5 - (648.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("S-NAV 300 Navigator", "nav", (arg0\Field3 + (124.0 * roomscale)), (arg0\Field4 - (368.0 * roomscale)), (arg0\Field5 - (648.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            local6\Field13 = 20.0
            entityparent(local6\Field1, arg0\Field2, $01)
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 + (736.0 * roomscale)), (-512.0 * roomscale), (arg0\Field5 - (400.0 * roomscale)), $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 - (552.0 * roomscale)), (-512.0 * roomscale), (arg0\Field5 - (528.0 * roomscale)), $01)
            arg0\Field25[$02] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$02], (arg0\Field3 + (736.0 * roomscale)), (-512.0 * roomscale), (arg0\Field5 + (272.0 * roomscale)), $01)
            arg0\Field25[$03] = loadmesh_strict("GFX\npcs\duck_low_res.b3d", $00)
            scaleentity(arg0\Field25[$03], 0.07, 0.07, 0.07, $00)
            local24 = loadtexture_strict("GFX\npcs\duck2.png", $01)
            entitytexture(arg0\Field25[$03], local24, $00, $00)
            positionentity(arg0\Field25[$03], (arg0\Field3 + (928.0 * roomscale)), (-640.0 * roomscale), (arg0\Field5 + (704.0 * roomscale)), $00)
            freetexture(local24)
            entityparent(arg0\Field25[$03], arg0\Field2, $01)
            addentitytoroomprops(arg0, arg0\Field25[$03])
        Case "room3servers2"
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 - (504.0 * roomscale)), (-512.0 * roomscale), (arg0\Field5 + (271.0 * roomscale)), $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 + (628.0 * roomscale)), (-512.0 * roomscale), (arg0\Field5 + (271.0 * roomscale)), $01)
            arg0\Field25[$02] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$02], (arg0\Field3 - (532.0 * roomscale)), (-512.0 * roomscale), (arg0\Field5 - (877.0 * roomscale)), $01)
            local6 = createitem("Document SCP-970", "paper", (arg0\Field3 + (960.0 * roomscale)), (arg0\Field4 - (448.0 * roomscale)), (arg0\Field5 + (251.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            rotateentity(local6\Field1, 0.0, (Float arg0\Field6), 0.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Gas Mask", "gasmask", (arg0\Field3 + (954.0 * roomscale)), (arg0\Field4 - (504.0 * roomscale)), (arg0\Field5 + (235.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "testroom"
            For local8 = $00 To $01 Step $01
                For local10 = $FFFFFFFF To $01 Step $01
                    arg0\Field25[((local8 * $03) + (local10 + $01))] = createpivot($00)
                    positionentity(arg0\Field25[((local8 * $03) + (local10 + $01))], (arg0\Field3 + (((280.0 * (Float local8)) + -236.0) * roomscale)), (-700.0 * roomscale), (arg0\Field5 + ((384.0 * (Float local10)) * roomscale)), $00)
                    entityparent(arg0\Field25[((local8 * $03) + (local10 + $01))], arg0\Field2, $01)
                Next
            Next
            arg0\Field25[$06] = createpivot($00)
            positionentity(arg0\Field25[$06], (arg0\Field3 + (754.0 * roomscale)), (arg0\Field4 - (1248.0 * roomscale)), arg0\Field5, $00)
            entityparent(arg0\Field25[$06], arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 + (744.0 * roomscale)), (arg0\Field4 - (856.0 * roomscale)), (arg0\Field5 + (236.0 * roomscale)), arg0, $00)
            local2\Field21 = $01
            createdoor($00, (arg0\Field3 + (720.0 * roomscale)), 0.0, arg0\Field5, 0.0, arg0, $00, $02, $FFFFFFFF, "", $00)
            createdoor($00, (arg0\Field3 - (624.0 * roomscale)), (-1280.0 * roomscale), arg0\Field5, 90.0, arg0, $01, $00, $00, "", $00)
            local6 = createitem("Document SCP-682", "paper", (arg0\Field3 + (656.0 * roomscale)), (arg0\Field4 - (1200.0 * roomscale)), (arg0\Field5 - (16.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room2closets"
            If (networkserver\Field15 = $00) Then
                local6 = createitem("Document SCP-1048", "paper", (arg0\Field3 + (736.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 + (736.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (arg0\Field3 + (736.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 + (736.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("Gas Mask", "gasmask", (arg0\Field3 + (736.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 + (544.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            If (networkserver\Field15 = $00) Then
                local6 = createitem("9V Battery", "bat", (arg0\Field3 + (736.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 - (448.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
                local6 = createitem("9V Battery", "bat", (arg0\Field3 + (730.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 - (496.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("Strange Bottle", "veryfinefirstaid", (arg0\Field3 + (736.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 - (448.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
                local6 = createitem("Strange Bottle", "veryfinefirstaid", (arg0\Field3 + (730.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 - (496.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("Level 1 Key Card", "key1", (arg0\Field3 + (736.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 + (752.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Clipboard", "clipboard", (arg0\Field3 + (736.0 * roomscale)), (arg0\Field4 + (224.0 * roomscale)), (arg0\Field5 - (480.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Incident Report SCP-1048-A", "paper", (arg0\Field3 + (736.0 * roomscale)), (arg0\Field4 + (224.0 * roomscale)), (arg0\Field5 - (480.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 - (1120.0 * roomscale)), (-256.0 * roomscale), (arg0\Field5 + (896.0 * roomscale)), $01)
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 - (1232.0 * roomscale)), (-256.0 * roomscale), (arg0\Field5 - (160.0 * roomscale)), $01)
            local0 = createdoor($00, (arg0\Field3 - (240.0 * roomscale)), 0.0, arg0\Field5, 90.0, arg0, $00, $00, $00, "", $00)
            positionentity(local0\Field3[$00], (arg0\Field3 - (230.0 * roomscale)), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 - (250.0 * roomscale)), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0\Field5 = $00
            local0\Field21 = $00
            local2 = createsecuritycam(arg0\Field3, (arg0\Field4 + (704.0 * roomscale)), (arg0\Field5 + (863.0 * roomscale)), arg0, $00)
            local2\Field11 = 180.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room2offices"
            If (networkserver\Field15 = $00) Then
                local6 = createitem("Document SCP-106", "paper", (arg0\Field3 + (404.0 * roomscale)), (arg0\Field4 + (145.0 * roomscale)), (arg0\Field5 + (559.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (arg0\Field3 + (404.0 * roomscale)), (arg0\Field4 + (145.0 * roomscale)), (arg0\Field5 + (559.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("Level 2 Key Card", "key2", (arg0\Field3 - (156.0 * roomscale)), (arg0\Field4 + (151.0 * roomscale)), (arg0\Field5 + (72.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("S-NAV 300 Navigator", "nav", (arg0\Field3 + (305.0 * roomscale)), (arg0\Field4 + (153.0 * roomscale)), (arg0\Field5 + (944.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            local6\Field13 = 20.0
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Notification", "paper", (arg0\Field3 - (137.0 * roomscale)), (arg0\Field4 + (153.0 * roomscale)), (arg0\Field5 + (464.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local26 = createwaypoint((arg0\Field3 - (32.0 * roomscale)), (arg0\Field4 + (66.0 * roomscale)), (arg0\Field5 + (288.0 * roomscale)), Null, arg0)
            local27 = createwaypoint(arg0\Field3, (arg0\Field4 + (66.0 * roomscale)), (arg0\Field5 - (448.0 * roomscale)), Null, arg0)
            local26\Field4[$00] = local27
            local26\Field5[$00] = entitydistance(local26\Field0, local27\Field0)
            local27\Field4[$00] = local26
            local27\Field5[$00] = local26\Field5[$00]
        Case "room2offices2"
            local6 = createitem("Level 1 Key Card", "key1", (arg0\Field3 - (368.0 * roomscale)), (arg0\Field4 - (48.0 * roomscale)), (arg0\Field5 + (80.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Document SCP-895", "paper", (arg0\Field3 - (800.0 * roomscale)), (arg0\Field4 - (48.0 * roomscale)), (arg0\Field5 + (368.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Document SCP-860", "paper", (arg0\Field3 - (800.0 * roomscale)), (arg0\Field4 - (48.0 * roomscale)), (arg0\Field5 - (464.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("S-NAV 300 Navigator", "nav", (arg0\Field3 - (336.0 * roomscale)), (arg0\Field4 - (48.0 * roomscale)), (arg0\Field5 - (480.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            local6\Field13 = 28.0
            entityparent(local6\Field1, arg0\Field2, $01)
            arg0\Field25[$00] = loadmesh_strict("GFX\npcs\duck_low_res.b3d", $00)
            scaleentity(arg0\Field25[$00], 0.07, 0.07, 0.07, $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            addentitytoroomprops(arg0, arg0\Field25[$00])
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 - (808.0 * roomscale)), (-72.0 * roomscale), (arg0\Field5 - (40.0 * roomscale)), $01)
            arg0\Field25[$02] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$02], (arg0\Field3 - (488.0 * roomscale)), (160.0 * roomscale), (arg0\Field5 + (700.0 * roomscale)), $01)
            arg0\Field25[$03] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$03], (arg0\Field3 - (488.0 * roomscale)), (160.0 * roomscale), (arg0\Field5 - (668.0 * roomscale)), $01)
            arg0\Field25[$04] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$04], (arg0\Field3 - (572.0 * roomscale)), (350.0 * roomscale), (arg0\Field5 - (4.0 * roomscale)), $01)
            local19 = rand($01, $04)
            positionentity(arg0\Field25[$00], entityx(arg0\Field25[local19], $01), entityy(arg0\Field25[local19], $01), entityz(arg0\Field25[local19], $01), $01)
        Case "room2offices3"
            local6 = createitem("Mobile Task Forces", "paper", (arg0\Field3 + (744.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 + (944.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Object Classes", "paper", (arg0\Field3 + (160.0 * roomscale)), (arg0\Field4 + (240.0 * roomscale)), (arg0\Field5 + (568.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Document", "paper", (arg0\Field3 - (1440.0 * roomscale)), (arg0\Field4 + (624.0 * roomscale)), (arg0\Field5 + (152.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Radio Transceiver", "radio", (arg0\Field3 - (1184.0 * roomscale)), (arg0\Field4 + (480.0 * roomscale)), (arg0\Field5 - (800.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("ReVision Eyedrops", "eyedrops", (arg0\Field3 - (1529.0 * roomscale)), (arg0\Field4 + (563.0 * roomscale)), ((arg0\Field5 - (572.0 * roomscale)) + 0.0), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("9V Battery", "bat", (arg0\Field3 - (1545.0 * roomscale)), (arg0\Field4 + (603.0 * roomscale)), (arg0\Field5 - (372.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("9V Battery", "bat", (arg0\Field3 - (1540.0 * roomscale)), (arg0\Field4 + (603.0 * roomscale)), (arg0\Field5 - (340.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 - (1056.0 * roomscale)), (384.0 * roomscale), (arg0\Field5 + (290.0 * roomscale)), 90.0, arg0, $01, $00, $00, "", $00)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $01
            positionentity(arg0\Field29[$00]\Field3[$00], entityx(arg0\Field29[$00]\Field3[$00], $01), entityy(arg0\Field29[$00]\Field3[$00], $01), (arg0\Field5 + (161.0 * roomscale)), $01)
            positionentity(arg0\Field29[$00]\Field3[$01], entityx(arg0\Field29[$00]\Field3[$01], $01), entityy(arg0\Field29[$00]\Field3[$01], $01), (arg0\Field5 + (161.0 * roomscale)), $01)
        Case "room3"
            If (rand($00, $01) = $01) Then
                placehalloweenscene(arg0, $17, rand($00, ($03 - newyearindex)), (arg0\Field3 - (12.3613 * roomscale)), (arg0\Field4 + (77.312 * roomscale)), (arg0\Field5 + (433.168 * roomscale)), -180.0)
            EndIf
        Case "start"
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 + (4000.0 * roomscale)), (384.0 * roomscale), (arg0\Field5 + (1696.0 * roomscale)), 90.0, arg0, $01, $01, $00, "", $00)
            arg0\Field29[$01]\Field4 = $00
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field9 = $01
            arg0\Field29[$01]\Field5 = $01
            freeentity(arg0\Field29[$01]\Field3[$00])
            arg0\Field29[$01]\Field3[$00] = $00
            freeentity(arg0\Field29[$01]\Field3[$01])
            arg0\Field29[$01]\Field3[$01] = $00
            arg0\Field29[$01]\Field24 = $00
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 + (2704.0 * roomscale)), (384.0 * roomscale), (arg0\Field5 + (624.0 * roomscale)), 90.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$02]\Field5 = $00
            freeentity(arg0\Field29[$02]\Field3[$00])
            arg0\Field29[$02]\Field3[$00] = $00
            freeentity(arg0\Field29[$02]\Field3[$01])
            arg0\Field29[$02]\Field3[$01] = $00
            arg0\Field29[$02]\Field24 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (1392.0 * roomscale)), (384.0 * roomscale), (arg0\Field5 + (64.0 * roomscale)), 90.0, arg0, $01, $00, $00, "", $00)
            local0\Field21 = $00
            local0\Field24 = $00
            local0\Field4 = $01
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (640.0 * roomscale)), (384.0 * roomscale), (arg0\Field5 + (64.0 * roomscale)), 90.0, arg0, $00, $00, $00, "", $00)
            local0\Field4 = $01
            local0\Field21 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (1280.0 * roomscale)), (384.0 * roomscale), (arg0\Field5 + (312.0 * roomscale)), 180.0, arg0, $01, $00, $00, "", $00)
            local0\Field4 = $01
            local0\Field21 = $00
            positionentity(local0\Field3[$00], (arg0\Field3 + (1120.0 * roomscale)), entityy(local0\Field3[$00], $01), (arg0\Field5 + (328.0 * roomscale)), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 + (1120.0 * roomscale)), entityy(local0\Field3[$01], $01), (arg0\Field5 + (296.0 * roomscale)), $01)
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0\Field24 = $00
            local0 = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 + (1184.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            local0\Field4 = $01
            arg0\Field25[$00] = loadmesh_strict("GFX\map\IntroDesk.b3d", $00)
            scaleentity(arg0\Field25[$00], roomscale, roomscale, roomscale, $00)
            positionentity(arg0\Field25[$00], (arg0\Field3 + (272.0 * roomscale)), 0.0, (arg0\Field5 + (400.0 * roomscale)), $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            addentitytoroomprops(arg0, arg0\Field25[$00])
            local3 = createdecal($00, (arg0\Field3 + (272.0 * roomscale)), 0.005, (arg0\Field5 + (262.0 * roomscale)), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
            entityparent(local3\Field0, arg0\Field2, $01)
            arg0\Field25[$01] = loadmesh_strict("GFX\map\IntroDrawer.b3d", $00)
            scaleentity(arg0\Field25[$01], roomscale, roomscale, roomscale, $00)
            positionentity(arg0\Field25[$01], (arg0\Field3 + (448.0 * roomscale)), 0.0, (arg0\Field5 + (192.0 * roomscale)), $00)
            entityparent(arg0\Field25[$01], arg0\Field2, $01)
            addentitytoroomprops(arg0, arg0\Field25[$01])
            local3 = createdecal($00, (arg0\Field3 + (456.0 * roomscale)), 0.005, (arg0\Field5 + (135.0 * roomscale)), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
            entityparent(local3\Field0, arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 - (336.0 * roomscale)), (arg0\Field4 + (352.0 * roomscale)), (arg0\Field5 + (48.0 * roomscale)), arg0, $01)
            local2\Field11 = 270.0
            local2\Field12 = 45.0
            local2\Field20 = arg0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 + (1689.43 * roomscale)), (arg0\Field4 + (385.312 * roomscale)), (arg0\Field5 - (273.563 * roomscale)), 0.0)
            placehalloweenscene(arg0, $17, rand($00, ($03 - newyearindex)), (arg0\Field3 - (447.691 * roomscale)), (arg0\Field4 + (77.312 * roomscale)), (arg0\Field5 + (973.848 * roomscale)), -115.0)
            positionentity(local2\Field4, (arg0\Field3 + (1456.0 * roomscale)), (608.0 * roomscale), (arg0\Field5 + (352.0 * roomscale)), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            arg0\Field25[$02] = createpivot($00)
            positionentity(arg0\Field25[$02], (entityx(arg0\Field2, $00) + (40.0 * roomscale)), (460.0 * roomscale), (entityz(arg0\Field2, $00) + (1072.0 * roomscale)), $00)
            arg0\Field25[$03] = createpivot($00)
            positionentity(arg0\Field25[$03], (entityx(arg0\Field2, $00) - (80.0 * roomscale)), (100.0 * roomscale), (entityz(arg0\Field2, $00) + (526.0 * roomscale)), $00)
            arg0\Field25[$04] = createpivot($00)
            positionentity(arg0\Field25[$04], (entityx(arg0\Field2, $00) - (128.0 * roomscale)), (100.0 * roomscale), (entityz(arg0\Field2, $00) + (320.0 * roomscale)), $00)
            arg0\Field25[$05] = createpivot($00)
            positionentity(arg0\Field25[$05], (entityx(arg0\Field2, $00) + (660.0 * roomscale)), (100.0 * roomscale), (entityz(arg0\Field2, $00) + (526.0 * roomscale)), $00)
            arg0\Field25[$06] = createpivot($00)
            positionentity(arg0\Field25[$06], (entityx(arg0\Field2, $00) + (700.0 * roomscale)), (100.0 * roomscale), (entityz(arg0\Field2, $00) + (320.0 * roomscale)), $00)
            arg0\Field25[$07] = createpivot($00)
            positionentity(arg0\Field25[$07], (entityx(arg0\Field2, $00) + (1472.0 * roomscale)), (100.0 * roomscale), (entityz(arg0\Field2, $00) + (912.0 * roomscale)), $00)
            For local7 = $02 To $07 Step $01
                entityparent(arg0\Field25[local7], arg0\Field2, $01)
            Next
            createdevilemitter((arg0\Field3 + (3384.0 * roomscale)), (arg0\Field4 + (510.0 * roomscale)), (arg0\Field5 + (2400.0 * roomscale)), arg0, $01, 4.0)
        Case "room2scps"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (264.0 * roomscale)), 0.0, arg0\Field5, 90.0, arg0, $01, $00, $03, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], (arg0\Field3 + (320.0 * roomscale)), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 + (224.0 * roomscale)), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (264.0 * roomscale)), 0.0, arg0\Field5, 270.0, arg0, $01, $00, $03, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], (arg0\Field3 - (320.0 * roomscale)), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 - (224.0 * roomscale)), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 - (560.0 * roomscale)), 0.0, (arg0\Field5 - (272.0 * roomscale)), 0.0, arg0, $01, $00, $03, "", $00)
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field5 = $00
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 + (560.0 * roomscale)), 0.0, (arg0\Field5 - (272.0 * roomscale)), 180.0, arg0, $01, $00, $03, "", $00)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$02]\Field5 = $00
            arg0\Field29[$03] = createdoor(arg0\Field0, (arg0\Field3 + (560.0 * roomscale)), 0.0, (arg0\Field5 + (272.0 * roomscale)), 180.0, arg0, $01, $00, $03, "", $00)
            arg0\Field29[$03]\Field21 = $00
            arg0\Field29[$03]\Field5 = $00
            arg0\Field29[$04] = createdoor(arg0\Field0, (arg0\Field3 - (560.0 * roomscale)), 0.0, (arg0\Field5 + (272.0 * roomscale)), 0.0, arg0, $01, $00, $03, "", $00)
            arg0\Field29[$04]\Field21 = $00
            arg0\Field29[$04]\Field5 = $00
            local6 = createitem("SCP-714", "scp714", (arg0\Field3 - (552.0 * roomscale)), (arg0\Field4 + (220.0 * roomscale)), (arg0\Field5 - (760.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("SCP-1025", "scp1025", (arg0\Field3 + (552.0 * roomscale)), (arg0\Field4 + (224.0 * roomscale)), (arg0\Field5 - (758.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            If (networkserver\Field15 = $00) Then
                local6 = createitem("SCP-860", "scp860", (arg0\Field3 + (568.0 * roomscale)), (arg0\Field4 + (178.0 * roomscale)), (arg0\Field5 + (760.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local2 = createsecuritycam((arg0\Field3 + (560.0 * roomscale)), (arg0\Field4 + (386.0 * roomscale)), (arg0\Field5 - (416.0 * roomscale)), arg0, $00)
            local2\Field11 = 180.0
            local2\Field12 = 30.0
            turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 - (560.0 * roomscale)), (arg0\Field4 + (386.0 * roomscale)), (arg0\Field5 - (416.0 * roomscale)), arg0, $00)
            local2\Field11 = 180.0
            local2\Field12 = 30.0
            turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 + (560.0 * roomscale)), (arg0\Field4 + (386.0 * roomscale)), (arg0\Field5 + (480.0 * roomscale)), arg0, $00)
            local2\Field11 = 0.0
            local2\Field12 = 30.0
            turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 - (560.0 * roomscale)), (arg0\Field4 + (386.0 * roomscale)), (arg0\Field5 + (480.0 * roomscale)), arg0, $00)
            local2\Field11 = 0.0
            local2\Field12 = 30.0
            turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            local6 = createitem("Document SCP-714", "paper", (arg0\Field3 - (728.0 * roomscale)), (arg0\Field4 + (288.0 * roomscale)), (arg0\Field5 - (360.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Document SCP-427", "paper", (arg0\Field3 - (608.0 * roomscale)), (arg0\Field4 + (66.0 * roomscale)), (arg0\Field5 + (636.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
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
                local3 = createdecal(rand($0F, $10), (arg0\Field3 + (local28 * roomscale)), 0.005, (arg0\Field5 + (local31 * roomscale)), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
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
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 + (128.0 * roomscale)), 0.0, (arg0\Field5 + (640.0 * roomscale)), 90.0, arg0, $01, $00, $03, "", $00)
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field5 = $00
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 - (1392.0 * roomscale)), (-128.0 * roomscale), (arg0\Field5 - (384.0 * roomscale)), 0.0, arg0, $01, $00, $03, "", $01)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $00
            freeentity(arg0\Field29[$00]\Field3[$00])
            arg0\Field29[$00]\Field3[$00] = $00
            freeentity(arg0\Field29[$00]\Field3[$01])
            arg0\Field29[$00]\Field3[$01] = $00
            local2 = createsecuritycam((arg0\Field3 - (1152.0 * roomscale)), (arg0\Field4 + (900.0 * roomscale)), (arg0\Field5 + (176.0 * roomscale)), arg0, $01)
            local2\Field11 = 90.0
            local2\Field12 = 0.0
            entityparent(local2\Field0, arg0\Field2, $01)
            local2\Field23 = $00
            local2\Field19 = 0.0
            entityparent(local2\Field4, $00, $01)
            positionentity(local2\Field4, (arg0\Field3 - (1716.0 * roomscale)), (arg0\Field4 + (160.0 * roomscale)), (arg0\Field5 + (176.0 * roomscale)), $01)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            scalesprite(local2\Field4, (448.0 * roomscale), (448.0 * roomscale))
            entityparent(local2\Field4, arg0\Field2, $01)
            camerazoom(local2\Field8, 1.5)
            hideentity(local2\Field10)
            hideentity(local2\Field1)
            arg0\Field25[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$00], (arg0\Field3 - (1536.0 * roomscale)), (arg0\Field4 + (730.0 * roomscale)), (arg0\Field5 + (192.0 * roomscale)), $01)
            rotateentity(arg0\Field25[$00], 0.0, -90.0, 0.0, $01)
            arg0\Field25[$01] = local2\Field4
        Case "endroom"
            arg0\Field29[$00] = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 + (1136.0 * roomscale)), 0.0, arg0, $00, $01, $06, "", $00)
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $00
            arg0\Field29[$00]\Field4 = $01
            freeentity(arg0\Field29[$00]\Field3[$00])
            arg0\Field29[$00]\Field3[$00] = $00
            freeentity(arg0\Field29[$00]\Field3[$01])
            arg0\Field29[$00]\Field3[$01] = $00
        Case "endroomc"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (1024.0 * roomscale)), 0.0, arg0\Field5, 0.0, arg0, $00, $02, $00, "", $00)
            local0\Field5 = $00
            local0\Field21 = $00
            local0\Field4 = $01
        Case "coffin"
            local0 = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - (448.0 * roomscale)), 0.0, arg0, $00, $01, $02, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], (arg0\Field3 - (384.0 * roomscale)), 0.7, (arg0\Field5 - (280.0 * roomscale)), $01)
            local2 = createsecuritycam((arg0\Field3 - (320.0 * roomscale)), (arg0\Field4 + (704.0 * roomscale)), (arg0\Field5 + (288.0 * roomscale)), arg0, $01)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            local2\Field22 = $01
            turnentity(local2\Field3, 120.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            coffincam = local2
            positionentity(local2\Field4, (arg0\Field3 - (800.0 * roomscale)), (288.0 * roomscale), (arg0\Field5 - (340.0 * roomscale)), $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            turnentity(local2\Field4, 0.0, 180.0, 0.0, $00)
            arg0\Field25[$02] = copyentity(leverbaseobj, $00)
            arg0\Field25[$03] = copyentity(leverobj, $00)
            addentitytoroomprops(arg0, arg0\Field25[$02])
            addentitytoroomprops(arg0, arg0\Field25[$03])
            arg0\Field28[$00] = arg0\Field25[$03]
            For local7 = $00 To $01 Step $01
                scaleentity(arg0\Field25[($02 + local7)], 0.04, 0.04, 0.04, $00)
                positionentity(arg0\Field25[($02 + local7)], (arg0\Field3 - (800.0 * roomscale)), (arg0\Field4 + (180.0 * roomscale)), (arg0\Field5 - (336.0 * roomscale)), $01)
                entityparent(arg0\Field25[($02 + local7)], arg0\Field2, $01)
            Next
            rotateentity(arg0\Field25[$02], 0.0, 180.0, 0.0, $00)
            rotateentity(arg0\Field25[$03], 10.0, 0.0, 0.0, $00)
            entityradius(arg0\Field25[$03], 0.1, 0.0)
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], arg0\Field3, (-1320.0 * roomscale), (arg0\Field5 + (2304.0 * roomscale)), $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            local6 = createitem("Document SCP-895", "paper", (arg0\Field3 - (688.0 * roomscale)), (arg0\Field4 + (133.0 * roomscale)), (arg0\Field5 - (304.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Level 3 Key Card", "key3", (arg0\Field3 + (240.0 * roomscale)), (arg0\Field4 - (1456.0 * roomscale)), (arg0\Field5 + (2064.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Night Vision Goggles", "nvgoggles", (arg0\Field3 + (280.0 * roomscale)), (arg0\Field4 - (1456.0 * roomscale)), (arg0\Field5 + (2164.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6\Field13 = 400.0
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 + (96.0 * roomscale)), (-1532.0 * roomscale), (arg0\Field5 + (2016.0 * roomscale)), $01)
        Case "room2tesla","room2tesla_lcz","room2tesla_hcz"
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (arg0\Field3 - (114.0 * roomscale)), 0.0, arg0\Field5, $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            arg0\Field25[$01] = createpivot($00)
            positionentity(arg0\Field25[$01], (arg0\Field3 + (114.0 * roomscale)), 0.0, arg0\Field5, $00)
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
            local26 = createwaypoint(arg0\Field3, (arg0\Field4 + (66.0 * roomscale)), (arg0\Field5 + (292.0 * roomscale)), Null, arg0)
            local27 = createwaypoint(arg0\Field3, (arg0\Field4 + (66.0 * roomscale)), (arg0\Field5 - (284.0 * roomscale)), Null, arg0)
            local26\Field4[$00] = local27
            local26\Field5[$00] = entitydistance(local26\Field0, local27\Field0)
            local27\Field4[$00] = local26
            local27\Field5[$00] = local26\Field5[$00]
            arg0\Field25[$04] = createsprite($00)
            positionentity(arg0\Field25[$04], (arg0\Field3 - (32.0 * roomscale)), (568.0 * roomscale), arg0\Field5, $00)
            scalesprite(arg0\Field25[$04], 0.03, 0.03)
            entitytexture(arg0\Field25[$04], lightspritetex($01), $00, $00)
            entityblend(arg0\Field25[$04], $03)
            entityparent(arg0\Field25[$04], arg0\Field2, $01)
            hideentity(arg0\Field25[$04])
            arg0\Field25[$05] = createpivot($00)
            positionentity(arg0\Field25[$05], arg0\Field3, 0.0, (arg0\Field5 - (800.0 * roomscale)), $00)
            entityparent(arg0\Field25[$05], arg0\Field2, $01)
            arg0\Field25[$06] = createpivot($00)
            positionentity(arg0\Field25[$06], arg0\Field3, 0.0, (arg0\Field5 + (800.0 * roomscale)), $00)
            entityparent(arg0\Field25[$06], arg0\Field2, $01)
            For local4 = Each rooms
                If (local4 <> arg0) Then
                    If ((((local4\Field7\Field11 = "room2tesla") Or (local4\Field7\Field11 = "room2tesla_lcz")) Or (local4\Field7\Field11 = "room2tesla_hcz")) <> 0) Then
                        arg0\Field25[$07] = copyentity(local4\Field25[$07], arg0\Field2)
                        Exit
                    EndIf
                EndIf
            Next
            If (arg0\Field25[$07] = $00) Then
                arg0\Field25[$07] = loadmesh_strict("GFX\map\room2tesla_caution.b3d", arg0\Field2)
            EndIf
        Case "room2doors"
            local0 = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 + (528.0 * roomscale)), 0.0, arg0, $01, $00, $00, "", $00)
            local0\Field21 = $00
            positionentity(local0\Field3[$00], (arg0\Field3 - (832.0 * roomscale)), 0.7, (arg0\Field5 + (160.0 * roomscale)), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 + (160.0 * roomscale)), 0.7, (arg0\Field5 + (536.0 * roomscale)), $01)
            local1 = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - (528.0 * roomscale)), 180.0, arg0, $01, $00, $00, "", $00)
            local1\Field21 = $00
            freeentity(local1\Field3[$00])
            local1\Field3[$00] = $00
            positionentity(local1\Field3[$01], (arg0\Field3 + (160.0 * roomscale)), 0.7, (arg0\Field5 - (536.0 * roomscale)), $01)
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (arg0\Field3 - (832.0 * roomscale)), 0.5, arg0\Field5, $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            local1\Field22 = local0
            local0\Field22 = local1
            local0\Field5 = $00
            local1\Field5 = $01
        Case "room4"
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 + (365.5559 * roomscale)), (arg0\Field4 + (416.0 * roomscale)), (arg0\Field5 + (19.29553 * roomscale)), 90.0)
        Case "914"
            arg0\Field29[$02] = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - (368.0 * roomscale)), 0.0, arg0, $00, $01, $02, "", $00)
            arg0\Field29[$02]\Field9 = $01
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$02]\Field5 = $00
            positionentity(arg0\Field29[$02]\Field3[$00], (arg0\Field3 - (496.0 * roomscale)), 0.7, (arg0\Field5 - (272.0 * roomscale)), $01)
            turnentity(arg0\Field29[$02]\Field3[$00], 0.0, 90.0, 0.0, $00)
            arg0\Field25[$00] = loadmesh_strict("GFX\map\914key.x", $00)
            arg0\Field25[$01] = loadmesh_strict("GFX\map\914knob.x", $00)
            addentitytoroomprops(arg0, arg0\Field25[$00])
            addentitytoroomprops(arg0, arg0\Field25[$01])
            For local7 = $00 To $01 Step $01
                scaleentity(arg0\Field25[local7], roomscale, roomscale, roomscale, $00)
                entitypickmode(arg0\Field25[local7], $02, $01)
            Next
            positionentity(arg0\Field25[$00], arg0\Field3, (arg0\Field4 + (190.0 * roomscale)), (arg0\Field5 + (374.0 * roomscale)), $00)
            positionentity(arg0\Field25[$01], arg0\Field3, (arg0\Field4 + (230.0 * roomscale)), (arg0\Field5 + (374.0 * roomscale)), $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            entityparent(arg0\Field25[$01], arg0\Field2, $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (624.0 * roomscale)), 0.0, (arg0\Field5 + (528.0 * roomscale)), 180.0, arg0, $01, $00, $00, "", $00)
            freeentity(local0\Field1)
            local0\Field1 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local0\Field9 = $04
            arg0\Field29[$00] = local0
            local0\Field21 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (816.0 * roomscale)), 0.0, (arg0\Field5 + (528.0 * roomscale)), 180.0, arg0, $01, $00, $00, "", $00)
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
            positionentity(arg0\Field25[$02], (arg0\Field3 - (712.0 * roomscale)), 0.5, (arg0\Field5 + (640.0 * roomscale)), $00)
            positionentity(arg0\Field25[$03], (arg0\Field3 + (728.0 * roomscale)), 0.5, (arg0\Field5 + (640.0 * roomscale)), $00)
            entityparent(arg0\Field25[$02], arg0\Field2, $01)
            entityparent(arg0\Field25[$03], arg0\Field2, $01)
            local6 = createitem("Addendum: 5/14 Test Log", "paper", (arg0\Field3 + (954.0 * roomscale)), (arg0\Field4 + (228.0 * roomscale)), (arg0\Field5 + (127.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("First Aid Kit", "firstaid", (arg0\Field3 + (960.0 * roomscale)), (arg0\Field4 + (112.0 * roomscale)), (arg0\Field5 - (40.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            rotateentity(local6\Field1, 0.0, 90.0, 0.0, $00)
            local6 = createitem("Dr. L's Note", "paper", (arg0\Field3 - (928.0 * roomscale)), (160.0 * roomscale), (arg0\Field5 - (160.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            placehalloweenscene(arg0, $16, rand($00, ($03 - newyearindex)), (arg0\Field3 - (866.6299 * roomscale)), 0.0, (arg0\Field5 + (148.122 * roomscale)), -90.0)
            local15 = createcube($00)
            entityalpha(local15, 0.0)
            positionentity(local15, arg0\Field3, arg0\Field4, (arg0\Field5 + (374.0 * roomscale)), $00)
            moveentity(local15, 0.0, 2.5, 0.0)
            scaleentity(local15, 2.92, 1.0, 3.39, $00)
            entitytype(local15, $09, $00)
            entityparent(local15, arg0\Field2, $01)
        Case "173"
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (entityx(arg0\Field2, $00) + (40.0 * roomscale)), (460.0 * roomscale), (entityz(arg0\Field2, $00) + (1072.0 * roomscale)), $00)
            arg0\Field25[$01] = createpivot($00)
            positionentity(arg0\Field25[$01], (entityx(arg0\Field2, $00) - (80.0 * roomscale)), (100.0 * roomscale), (entityz(arg0\Field2, $00) + (526.0 * roomscale)), $00)
            arg0\Field25[$02] = createpivot($00)
            positionentity(arg0\Field25[$02], (entityx(arg0\Field2, $00) - (128.0 * roomscale)), (100.0 * roomscale), (entityz(arg0\Field2, $00) + (320.0 * roomscale)), $00)
            arg0\Field25[$03] = createpivot($00)
            positionentity(arg0\Field25[$03], (entityx(arg0\Field2, $00) + (660.0 * roomscale)), (100.0 * roomscale), (entityz(arg0\Field2, $00) + (526.0 * roomscale)), $00)
            arg0\Field25[$04] = createpivot($00)
            positionentity(arg0\Field25[$04], (entityx(arg0\Field2, $00) + (700.0 * roomscale)), (100.0 * roomscale), (entityz(arg0\Field2, $00) + (320.0 * roomscale)), $00)
            arg0\Field25[$05] = createpivot($00)
            positionentity(arg0\Field25[$05], (entityx(arg0\Field2, $00) + (1472.0 * roomscale)), (100.0 * roomscale), (entityz(arg0\Field2, $00) + (912.0 * roomscale)), $00)
            For local7 = $00 To $05 Step $01
                entityparent(arg0\Field25[local7], arg0\Field2, $01)
            Next
            arg0\Field29[$01] = createdoor(arg0\Field0, (entityx(arg0\Field2, $00) + (288.0 * roomscale)), 0.0, (entityz(arg0\Field2, $00) + (384.0 * roomscale)), 90.0, arg0, $00, $01, $00, "", $00)
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field9 = $01
            arg0\Field29[$01]\Field5 = $00
            freeentity(arg0\Field29[$01]\Field3[$00])
            arg0\Field29[$01]\Field3[$00] = $00
            freeentity(arg0\Field29[$01]\Field3[$01])
            arg0\Field29[$01]\Field3[$01] = $00
            local3 = createdecal(rand($04, $05), entityx(arg0\Field25[$05], $01), 0.002, entityz(arg0\Field25[$05], $01), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
            local3\Field2 = 1.2
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            For local8 = $00 To $01 Step $01
                For local10 = $00 To $01 Step $01
                    local3 = createdecal(rand($04, $06), (((arg0\Field3 + (700.0 * roomscale)) + (((Float local8) * 700.0) * roomscale)) + rnd(-0.5, 0.5)), rnd(0.001, 0.0018), ((arg0\Field5 + ((Float ($258 * local10)) * roomscale)) + rnd(-0.5, 0.5)), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
                    local3\Field2 = rnd(0.5, 0.8)
                    local3\Field5 = rnd(0.8, 1.0)
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Next
            Next
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 - (1008.0 * roomscale)), 0.0, (arg0\Field5 - (688.0 * roomscale)), 90.0, arg0, $01, $00, $00, "", $01)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$02]\Field5 = $00
            arg0\Field29[$02]\Field4 = $01
            freeentity(arg0\Field29[$02]\Field3[$00])
            arg0\Field29[$02]\Field3[$00] = $00
            freeentity(arg0\Field29[$02]\Field3[$01])
            arg0\Field29[$02]\Field3[$01] = $00
            arg0\Field29[$03] = createdoor(arg0\Field0, (arg0\Field3 - (2320.0 * roomscale)), 0.0, (arg0\Field5 - (1248.0 * roomscale)), 90.0, arg0, $01, $00, $00, "", $00)
            arg0\Field29[$03]\Field21 = $00
            arg0\Field29[$03]\Field5 = $01
            arg0\Field29[$03]\Field4 = $01
            arg0\Field29[$04] = createdoor(arg0\Field0, (arg0\Field3 - (4352.0 * roomscale)), 0.0, (arg0\Field5 - (1248.0 * roomscale)), 90.0, arg0, $01, $00, $00, "", $00)
            arg0\Field29[$04]\Field21 = $00
            arg0\Field29[$04]\Field5 = $01
            arg0\Field29[$04]\Field4 = $01
            arg0\Field29[$07] = createdoor(arg0\Field0, (arg0\Field3 - (3712.0 * roomscale)), (-385.0 * roomscale), (arg0\Field5 - (128.0 * roomscale)), 0.0, arg0, $01, $00, $00, "", $00)
            arg0\Field29[$07]\Field21 = $00
            arg0\Field29[$07]\Field5 = $01
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (3712.0 * roomscale)), (-385.0 * roomscale), (arg0\Field5 - (2336.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            local0\Field4 = $01
            local0\Field14 = $01
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (6864.0 * roomscale)), 0.0, (arg0\Field5 - (1248.0 * roomscale)), 90.0, arg0, $01, $00, $00, "", $00)
            local0\Field21 = $00
            local0\Field4 = $01
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (5856.0 * roomscale)), 0.0, (arg0\Field5 - (1504.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            local0\Field4 = $01
            local0\Field14 = $01
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (2432.0 * roomscale)), 0.0, (arg0\Field5 - (1000.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            positionentity(local0\Field3[$00], (arg0\Field3 - (2592.0 * roomscale)), entityy(local0\Field3[$00], $01), (arg0\Field5 - (1016.0 * roomscale)), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 - (2592.0 * roomscale)), entityy(local0\Field3[$00], $01), (arg0\Field5 - (984.0 * roomscale)), $01)
            local0\Field4 = $01
            local0\Field14 = $01
            local24 = loadtexture_strict("GFX\map\Door02.jpg", $01)
            For local10 = $00 To $01 Step $01
                local0 = createdoor(arg0\Field0, (arg0\Field3 - (5760.0 * roomscale)), 0.0, (arg0\Field5 + ((Float (($380 * local10) + $140)) * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
                local0\Field4 = $01
                local0\Field14 = $01
                local0 = createdoor(arg0\Field0, (arg0\Field3 - (8288.0 * roomscale)), 0.0, (arg0\Field5 + ((Float (($380 * local10) + $140)) * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
                local0\Field4 = $01
                If (local10 = $00) Then
                    local0\Field5 = $01
                Else
                    local0\Field14 = $01
                EndIf
                For local8 = $00 To $02 Step $01
                    local0 = createdoor(arg0\Field0, (arg0\Field3 - ((7424.0 - (512.0 * (Float local8))) * roomscale)), 0.0, (arg0\Field5 + ((1008.0 - (480.0 * (Float local10))) * roomscale)), (Float ((local10 = $00) * $B4)), arg0, $00, $00, $00, "", $00)
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
                    local0 = createdoor(arg0\Field0, (arg0\Field3 - ((5120.0 - (512.0 * (Float local8))) * roomscale)), 0.0, (arg0\Field5 + ((1008.0 - (480.0 * (Float local10))) * roomscale)), (Float ((local10 = $00) * $B4)), arg0, $00, $00, $00, "", $00)
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
            createitem("Class D Orientation Leaflet", "paper", (arg0\Field3 - (3938.0 * roomscale)), (170.0 * roomscale), (arg0\Field5 + (40.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            local2 = createsecuritycam((arg0\Field3 - (4048.0 * roomscale)), (arg0\Field4 - (32.0 * roomscale)), (arg0\Field5 - (1232.0 * roomscale)), arg0, $01)
            local2\Field11 = 270.0
            local2\Field12 = 45.0
            local2\Field20 = arg0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, (arg0\Field3 - (2256.0 * roomscale)), (224.0 * roomscale), (arg0\Field5 - (928.0 * roomscale)), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            arg0\Field25[$09] = loadmesh_strict("GFX\map\173_2.b3d", arg0\Field2)
            entitytype(arg0\Field25[$09], $01, $00)
            entitypickmode(arg0\Field25[$09], $02, $01)
            addentitytoroomprops(arg0, arg0\Field25[$09])
            arg0\Field25[$0A] = loadmesh_strict("GFX\map\intro_labels.b3d", arg0\Field2)
            addentitytoroomprops(arg0, arg0\Field25[$0A])
            freetexture(local24)
        Case "room2ccont"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (64.0 * roomscale)), 0.0, (arg0\Field5 + (368.0 * roomscale)), 180.0, arg0, $00, $00, $02, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            If (networkserver\Field15 = $00) Then
                local6 = createitem("Note from Daniel", "paper", (arg0\Field3 - (400.0 * roomscale)), (1040.0 * roomscale), (arg0\Field5 + (115.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("FN P90", "p90", (arg0\Field3 - (400.0 * roomscale)), (1040.0 * roomscale), (arg0\Field5 + (115.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            For local18 = $00 To $02 Step $01
                arg0\Field25[(local18 Shl $01)] = copyentity(leverbaseobj, $00)
                arg0\Field25[((local18 Shl $01) + $01)] = copyentity(leverobj, $00)
                arg0\Field28[local18] = arg0\Field25[((local18 Shl $01) + $01)]
                For local7 = $00 To $01 Step $01
                    scaleentity(arg0\Field25[((local18 Shl $01) + local7)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field25[((local18 Shl $01) + local7)], (arg0\Field3 - (240.0 * roomscale)), (arg0\Field4 + (1104.0 * roomscale)), (arg0\Field5 + ((632.0 - (64.0 * (Float local18))) * roomscale)), $01)
                    entityparent(arg0\Field25[((local18 Shl $01) + local7)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field25[(local18 Shl $01)], 0.0, -90.0, 0.0, $00)
                rotateentity(arg0\Field25[((local18 Shl $01) + $01)], 10.0, -270.0, 0.0, $00)
                entityradius(arg0\Field25[((local18 Shl $01) + $01)], 0.1, 0.0)
                addentitytoroomprops(arg0, arg0\Field25[(local18 Shl $01)])
                addentitytoroomprops(arg0, arg0\Field25[((local18 Shl $01) + $01)])
            Next
            local2 = createsecuritycam((arg0\Field3 - (265.0 * roomscale)), (arg0\Field4 + (1280.0 * roomscale)), (arg0\Field5 + (105.0 * roomscale)), arg0, $00)
            local2\Field11 = 45.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room106"
            local6 = createitem("Level 5 Key Card", "key5", (arg0\Field3 - (752.0 * roomscale)), (arg0\Field4 - (592.0 * roomscale)), (arg0\Field5 + (3026.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Dr. Allok's Note", "paper", (arg0\Field3 - (416.0 * roomscale)), (arg0\Field4 - (576.0 * roomscale)), (arg0\Field5 + (2492.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Recall Protocol RP-106-N", "paper", (arg0\Field3 + (268.0 * roomscale)), (arg0\Field4 - (576.0 * roomscale)), (arg0\Field5 + (2593.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (968.0 * roomscale)), (-764.0 * roomscale), (arg0\Field5 + (1392.0 * roomscale)), 0.0, arg0, $00, $00, $04, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            local0 = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - (464.0 * roomscale)), 0.0, arg0, $00, $00, $04, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (624.0 * roomscale)), (-1280.0 * roomscale), arg0\Field5, 90.0, arg0, $00, $00, $04, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            If (networkserver\Field15 <> 0) Then
                local6 = createitem("Micro-HID", "microhid", (arg0\Field3 - (237.3699 * roomscale)), (arg0\Field4 - (576.0 * roomscale)), (arg0\Field5 + (2483.665 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            arg0\Field25[$06] = loadmesh_strict("GFX\map\room1062.b3d", $00)
            scaleentity(arg0\Field25[$06], roomscale, roomscale, roomscale, $00)
            entitytype(arg0\Field25[$06], $01, $00)
            entitypickmode(arg0\Field25[$06], $03, $01)
            positionentity(arg0\Field25[$06], (arg0\Field3 + (784.0 * roomscale)), (-980.0 * roomscale), (arg0\Field5 + (720.0 * roomscale)), $01)
            entityparent(arg0\Field25[$06], arg0\Field2, $01)
            addentitytoroomprops(arg0, arg0\Field25[$06])
            For local18 = $00 To $02 Step $02
                arg0\Field25[local18] = copyentity(leverbaseobj, $00)
                arg0\Field25[(local18 + $01)] = copyentity(leverobj, $00)
                arg0\Field28[(local18 Sar $01)] = arg0\Field25[(local18 + $01)]
                For local7 = $00 To $01 Step $01
                    scaleentity(arg0\Field25[(local18 + local7)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field25[(local18 + local7)], (arg0\Field3 - ((555.0 - (81.0 * (Float (local18 Sar $01)))) * roomscale)), (arg0\Field4 - (576.0 * roomscale)), (arg0\Field5 + (3040.0 * roomscale)), $01)
                    entityparent(arg0\Field25[(local18 + local7)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field25[local18], 0.0, 0.0, 0.0, $00)
                rotateentity(arg0\Field25[(local18 + $01)], 10.0, -180.0, 0.0, $00)
                entitypickmode(arg0\Field25[(local18 + $01)], $01, $00)
                entityradius(arg0\Field25[(local18 + $01)], 0.1, 0.0)
                addentitytoroomprops(arg0, arg0\Field25[local18])
                addentitytoroomprops(arg0, arg0\Field25[(local18 + $01)])
            Next
            rotateentity(arg0\Field25[$01], 81.0, -180.0, 0.0, $00)
            rotateentity(arg0\Field25[$03], -81.0, -180.0, 0.0, $00)
            arg0\Field25[$04] = createbutton((arg0\Field3 - (146.0 * roomscale)), (arg0\Field4 - (576.0 * roomscale)), (arg0\Field5 + (3045.0 * roomscale)), 0.0, 0.0, 0.0)
            entityparent(arg0\Field25[$04], arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 + (768.0 * roomscale)), (arg0\Field4 + (1392.0 * roomscale)), (arg0\Field5 + (1696.0 * roomscale)), arg0, $01)
            local2\Field11 = 315.0
            local2\Field12 = 20.0
            turnentity(local2\Field3, 45.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            arg0\Field25[$07] = local2\Field3
            arg0\Field25[$08] = local2\Field0
            positionentity(local2\Field4, (arg0\Field3 - (272.0 * roomscale)), (-544.0 * roomscale), (arg0\Field5 + (3020.0 * roomscale)), $00)
            turnentity(local2\Field4, 0.0, -10.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            local2\Field22 = $00
            arg0\Field25[$05] = createpivot($00)
            turnentity(arg0\Field25[$05], 0.0, 180.0, 0.0, $00)
            positionentity(arg0\Field25[$05], (arg0\Field3 + (1088.0 * roomscale)), (1104.0 * roomscale), (arg0\Field5 + (1888.0 * roomscale)), $00)
            entityparent(arg0\Field25[$05], arg0\Field2, $01)
            arg0\Field25[$09] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$09], (arg0\Field3 - (272.0 * roomscale)), (arg0\Field4 - (672.0 * roomscale)), (arg0\Field5 + (2736.0 * roomscale)), $01)
            arg0\Field25[$0A] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$0A], arg0\Field3, arg0\Field4, (arg0\Field5 - (720.0 * roomscale)), $01)
        Case "room1archive"
            If (networkserver\Field15 = $00) Then
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
                            local21 = (((864.0 * (Float local8)) + -672.0) * roomscale)
                            local39 = (((96.0 * (Float local9)) + 96.0) * roomscale)
                            local22 = (((480.0 - (352.0 * (Float local10))) + rnd(-96.0, 96.0)) * roomscale)
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
                                    local37 = rand($01, $05)
                                    Select local37
                                        Case $01
                                            local32 = "MP5-SD"
                                            local33 = "mp5sd"
                                        Case $02
                                            local32 = "Strange Bottle"
                                            local33 = "veryfinefirstaid"
                                        Case $03
                                            local32 = "Strange Bottle"
                                            local33 = "veryfinefirstaid"
                                        Case $04
                                            local32 = "FN P90"
                                            local33 = "p90"
                                        Case $05
                                            local32 = "USP Tactical"
                                            local33 = "usp"
                                    End Select
                                Case ((local34 >= $28) And (local34 < $2D))
                                    local37 = rand($01, $03)
                                    local32 = (("Level " + (Str local37)) + " Key Card")
                                    local33 = ("key" + (Str local37))
                                Case ((local34 >= $2D) And (local34 < $32))
                                    local32 = "First Aid Kit"
                                    local33 = "firstaid"
                                Case ((local34 >= $32) And (local34 < $3C))
                                    local37 = rand($01, $05)
                                    Select local37
                                        Case $01
                                            local32 = "MP5-SD"
                                            local33 = "mp5sd"
                                        Case $02
                                            local32 = "Rocket Launcher"
                                            local33 = "rpg"
                                        Case $03
                                            local32 = "Strange Bottle"
                                            local33 = "veryfinefirstaid"
                                        Case $04
                                            local32 = "FN P90"
                                            local33 = "p90"
                                        Case $05
                                            local32 = "USP Tactical"
                                            local33 = "usp"
                                    End Select
                                Case ((local34 >= $3C) And (local34 < $46))
                                    local37 = rand($01, $05)
                                    Select local37
                                        Case $01
                                            local32 = "MP5-SD"
                                            local33 = "mp5sd"
                                        Case $02
                                            local32 = "Strange Bottle"
                                            local33 = "veryfinefirstaid"
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
                                    local37 = rand($01, $05)
                                    Select local37
                                        Case $01
                                            local32 = "MP5-SD"
                                            local33 = "mp5sd"
                                        Case $02
                                            local32 = "Rocket Launcher"
                                            local33 = "rpg"
                                        Case $03
                                            local32 = "Strange Bottle"
                                            local33 = "veryfinefirstaid"
                                        Case $04
                                            local32 = "FN P90"
                                            local33 = "p90"
                                        Case $05
                                            local32 = "USP Tactical"
                                            local33 = "usp"
                                    End Select
                                Case ((local34 >= $55) And (local34 < $5F))
                                    local37 = rand($01, $05)
                                    Select local37
                                        Case $01
                                            local32 = "Strange Bottle"
                                            local33 = "veryfinefirstaid"
                                        Case $02
                                            local32 = "Rocket Launcher"
                                            local33 = "rpg"
                                        Case $03
                                            local32 = "Strange Bottle"
                                            local33 = "veryfinefirstaid"
                                        Case $04
                                            local32 = "FN P90"
                                            local33 = "p90"
                                        Case $05
                                            local32 = "USP Tactical"
                                            local33 = "usp"
                                    End Select
                                Case ((local34 >= $5F) And (local34 <= $64))
                                    local37 = rand($01, $05)
                                    Select local37
                                        Case $01
                                            local32 = "MP5-SD"
                                            local33 = "mp5sd"
                                        Case $02
                                            local32 = "Strange Bottle"
                                            local33 = "veryfinefirstaid"
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
                            local21 = (((864.0 * (Float local8)) + -672.0) * roomscale)
                            local39 = (((96.0 * (Float local9)) + 96.0) * roomscale)
                            local22 = (((480.0 - (352.0 * (Float local10))) + rnd(-96.0, 96.0)) * roomscale)
                            local6 = createitem(local32, local33, (arg0\Field3 + local21), local39, (arg0\Field5 + local22), $00, $00, $00, 1.0, $00, $01)
                            entityparent(local6\Field1, arg0\Field2, $01)
                        Next
                    Next
                Next
            EndIf
            arg0\Field29[$00] = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, (arg0\Field5 - (528.0 * roomscale)), 0.0, arg0, $00, $00, $06, "", $00)
            local2 = createsecuritycam((arg0\Field3 - (256.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 + (640.0 * roomscale)), arg0, $00)
            local2\Field11 = 180.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room2test1074"
            arg0\Field29[$00] = createdoor(arg0\Field0, arg0\Field3, arg0\Field4, arg0\Field5, 0.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$00]\Field4 = $01
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 + (336.0 * roomscale)), arg0\Field4, (arg0\Field5 + (671.0 * roomscale)), 90.0, arg0, $01, $00, $03, "", $00)
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$02] = createdoor(arg0\Field0, (arg0\Field3 + (336.0 * roomscale)), arg0\Field4, (arg0\Field5 - (800.0 * roomscale)), 90.0, arg0, $01, $00, $03, "", $00)
            arg0\Field29[$02]\Field21 = $00
            arg0\Field29[$03] = createdoor(arg0\Field0, (arg0\Field3 + (672.0 * roomscale)), arg0\Field4, arg0\Field5, 0.0, arg0, $00, $00, $00, "", $00)
            arg0\Field37[$00] = loadtexture("GFX\map\1074tex0.jpg", $01)
            arg0\Field37[$01] = loadtexture("GFX\map\1074tex1.jpg", $01)
            textureblend(arg0\Field37[$00], $05)
            textureblend(arg0\Field37[$01], $05)
            local6 = createitem("Document SCP-1074", "paper", (arg0\Field3 + (300.0 * roomscale)), (arg0\Field4 + (20.0 * roomscale)), (arg0\Field5 + (671.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (arg0\Field3 + (835.0 * roomscale)), (arg0\Field4 + (165.0 * roomscale)), (arg0\Field5 + (540.0 * roomscale)), $01)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            arg0\Field25[$01] = createpivot($00)
            positionentity(arg0\Field25[$01], (arg0\Field3 + (835.0 * roomscale)), (arg0\Field4 + (10.0 * roomscale)), (arg0\Field5 + (300.0 * roomscale)), $01)
            entityparent(arg0\Field25[$01], arg0\Field2, $01)
            local47 = getchild(arg0\Field2, $02)
            arg0\Field36[$00] = getsurface(local47, $01)
            For local48 = $01 To countsurfaces(local47) Step $01
                local49 = getsurface(local47, local48)
                local50 = getsurfacebrush(local49)
                local51 = getbrushtexture(local50, $01)
                local52 = strippath(texturename(local51))
                debuglog(("texname: " + local52))
                If (lower(local52) = "1074tex1.jpg") Then
                    arg0\Field36[$00] = local49
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
            If (networkserver\Field15 = $00) Then
                local6 = createitem("Document SCP-1123", "paper", (arg0\Field3 + (511.0 * roomscale)), (arg0\Field4 + (125.0 * roomscale)), (arg0\Field5 - (936.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (arg0\Field3 + (511.0 * roomscale)), (arg0\Field4 + (125.0 * roomscale)), (arg0\Field5 - (936.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("SCP-1123", "1123", (arg0\Field3 + (832.0 * roomscale)), (arg0\Field4 + (166.0 * roomscale)), (arg0\Field5 + (784.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Leaflet", "paper", (arg0\Field3 - (816.0 * roomscale)), (arg0\Field4 + (704.0 * roomscale)), (arg0\Field5 + (888.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Gas Mask", "gasmask", (arg0\Field3 + (457.0 * roomscale)), (arg0\Field4 + (150.0 * roomscale)), (arg0\Field5 + (960.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (832.0 * roomscale)), 0.0, (arg0\Field5 + (367.0 * roomscale)), 0.0, arg0, $00, $00, $03, "", $00)
            positionentity(local0\Field3[$00], (arg0\Field3 + (956.0 * roomscale)), entityy(local0\Field3[$00], $01), (arg0\Field5 + (352.0 * roomscale)), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 + (713.0 * roomscale)), entityy(local0\Field3[$01], $01), (arg0\Field5 + (384.0 * roomscale)), $01)
            freeentity(local0\Field1)
            local0\Field1 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (280.0 * roomscale)), 0.0, (arg0\Field5 - (607.0 * roomscale)), 90.0, arg0, $00, $00, $00, "", $00)
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (280.0 * roomscale)), (512.0 * roomscale), (arg0\Field5 - (607.0 * roomscale)), 90.0, arg0, $00, $00, $00, "", $00)
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            arg0\Field29[$00] = local0
            arg0\Field25[$03] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$03], (arg0\Field3 + (832.0 * roomscale)), (arg0\Field4 + (166.0 * roomscale)), (arg0\Field5 + (784.0 * roomscale)), $01)
            arg0\Field25[$04] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$04], (arg0\Field3 - (648.0 * roomscale)), (arg0\Field4 + (592.0 * roomscale)), (arg0\Field5 + (692.0 * roomscale)), $01)
            arg0\Field25[$05] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$05], (arg0\Field3 + (828.0 * roomscale)), (arg0\Field4 + (592.0 * roomscale)), (arg0\Field5 + (592.0 * roomscale)), $01)
            arg0\Field25[$06] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$06], (arg0\Field3 - (76.0 * roomscale)), (arg0\Field4 + (620.0 * roomscale)), (arg0\Field5 + (744.0 * roomscale)), $01)
            arg0\Field25[$07] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$07], (arg0\Field3 - (640.0 * roomscale)), (arg0\Field4 + (620.0 * roomscale)), (arg0\Field5 - (864.0 * roomscale)), $01)
            arg0\Field25[$08] = loadmesh_strict("GFX\map\forest\door_frame.b3d", $00)
            positionentity(arg0\Field25[$08], (arg0\Field3 - (272.0 * roomscale)), (512.0 * roomscale), (arg0\Field5 + (288.0 * roomscale)), $01)
            rotateentity(arg0\Field25[$08], 0.0, 90.0, 0.0, $01)
            scaleentity(arg0\Field25[$08], (45.0 * roomscale), (45.0 * roomscale), (80.0 * roomscale), $01)
            entityparent(arg0\Field25[$08], arg0\Field2, $01)
            addentitytoroomprops(arg0, arg0\Field25[$08])
            arg0\Field25[$09] = loadmesh_strict("GFX\map\forest\door.b3d", $00)
            positionentity(arg0\Field25[$09], (arg0\Field3 - (272.0 * roomscale)), (512.0 * roomscale), (arg0\Field5 + (218.0 * roomscale)), $01)
            rotateentity(arg0\Field25[$09], 0.0, 10.0, 0.0, $01)
            entitytype(arg0\Field25[$09], $01, $00)
            scaleentity(arg0\Field25[$09], (46.0 * roomscale), (45.0 * roomscale), (46.0 * roomscale), $01)
            entityparent(arg0\Field25[$09], arg0\Field2, $01)
            addentitytoroomprops(arg0, arg0\Field25[$09])
            arg0\Field25[$0A] = copyentity(arg0\Field25[$08], $00)
            positionentity(arg0\Field25[$0A], (arg0\Field3 - (272.0 * roomscale)), (512.0 * roomscale), (arg0\Field5 + (736.0 * roomscale)), $01)
            rotateentity(arg0\Field25[$0A], 0.0, 90.0, 0.0, $01)
            scaleentity(arg0\Field25[$0A], (45.0 * roomscale), (45.0 * roomscale), (80.0 * roomscale), $01)
            entityparent(arg0\Field25[$0A], arg0\Field2, $01)
            addentitytoroomprops(arg0, arg0\Field25[$0A])
            arg0\Field25[$0B] = copyentity(arg0\Field25[$09], $00)
            positionentity(arg0\Field25[$0B], (arg0\Field3 - (272.0 * roomscale)), (512.0 * roomscale), (arg0\Field5 + (666.0 * roomscale)), $01)
            rotateentity(arg0\Field25[$0B], 0.0, 90.0, 0.0, $01)
            entitytype(arg0\Field25[$0B], $01, $00)
            scaleentity(arg0\Field25[$0B], (46.0 * roomscale), (45.0 * roomscale), (46.0 * roomscale), $01)
            entityparent(arg0\Field25[$0B], arg0\Field2, $01)
            addentitytoroomprops(arg0, arg0\Field25[$0B])
            arg0\Field25[$0C] = copyentity(arg0\Field25[$08], $00)
            positionentity(arg0\Field25[$0C], (arg0\Field3 - (592.0 * roomscale)), (512.0 * roomscale), (arg0\Field5 - (704.0 * roomscale)), $01)
            rotateentity(arg0\Field25[$0C], 0.0, 0.0, 0.0, $01)
            scaleentity(arg0\Field25[$0C], (45.0 * roomscale), (45.0 * roomscale), (80.0 * roomscale), $01)
            entityparent(arg0\Field25[$0C], arg0\Field2, $01)
            addentitytoroomprops(arg0, arg0\Field25[$0C])
            arg0\Field25[$0D] = copyentity(arg0\Field25[$09], $00)
            positionentity(arg0\Field25[$0D], (arg0\Field3 - (662.0 * roomscale)), (512.0 * roomscale), (arg0\Field5 - (704.0 * roomscale)), $01)
            rotateentity(arg0\Field25[$0D], 0.0, 0.0, 0.0, $01)
            entitytype(arg0\Field25[$0D], $01, $00)
            scaleentity(arg0\Field25[$0D], (46.0 * roomscale), (45.0 * roomscale), (46.0 * roomscale), $01)
            entityparent(arg0\Field25[$0D], arg0\Field2, $01)
            addentitytoroomprops(arg0, arg0\Field25[$0D])
            arg0\Field25[$0E] = loadmesh_strict("GFX\map\1123_hb.b3d", arg0\Field2)
            entitypickmode(arg0\Field25[$0E], $02, $01)
            entitytype(arg0\Field25[$0E], $01, $00)
            entityalpha(arg0\Field25[$0E], 0.0)
        Case "pocketdimension"
            local53 = loadmesh_strict("GFX\map\pocketdimension2.b3d", $00)
            arg0\Field25[$08] = loadmesh_strict("GFX\map\pocketdimension3.b3d", $00)
            arg0\Field25[$09] = loadmesh_strict("GFX\map\pocketdimension4.b3d", $00)
            arg0\Field25[$0A] = copyentity(arg0\Field25[$09], $00)
            arg0\Field25[$0B] = loadmesh_strict("GFX\map\pocketdimension5.b3d", $00)
            addentitytoroomprops(arg0, arg0\Field25[$08])
            addentitytoroomprops(arg0, arg0\Field25[$09])
            addentitytoroomprops(arg0, arg0\Field25[$0A])
            addentitytoroomprops(arg0, arg0\Field25[$0B])
            local54 = loadmesh_strict("GFX\map\pocketdimensionterrain.b3d", $00)
            scaleentity(local54, roomscale, roomscale, roomscale, $01)
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
                scaleentity(arg0\Field25[local7], roomscale, roomscale, roomscale, $00)
                entitytype(arg0\Field25[local7], $01, $00)
                entitypickmode(arg0\Field25[local7], $02, $01)
                positionentity(arg0\Field25[local7], arg0\Field3, arg0\Field4, (arg0\Field5 + 32.0), $01)
            Next
            scaleentity(local54, roomscale, roomscale, roomscale, $00)
            entitytype(local54, $01, $00)
            entitypickmode(local54, $03, $01)
            positionentity(local54, arg0\Field3, (arg0\Field4 + (2944.0 * roomscale)), (arg0\Field5 + 32.0), $01)
            arg0\Field29[$00] = createdoor($00, arg0\Field3, (2048.0 * roomscale), ((arg0\Field5 + 32.0) - (1024.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            arg0\Field29[$01] = createdoor($00, arg0\Field3, (2048.0 * roomscale), ((arg0\Field5 + 32.0) + (1024.0 * roomscale)), 180.0, arg0, $00, $00, $00, "", $00)
            local3 = createdecal($12, (arg0\Field3 - (1536.0 * roomscale)), 0.02, ((arg0\Field5 + (608.0 * roomscale)) + 32.0), 90.0, 0.0, 0.0, 1.0, 1.0)
            entityparent(local3\Field0, arg0\Field2, $01)
            local3\Field2 = rnd(0.8, 0.8)
            local3\Field6 = $02
            local3\Field7 = $09
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            entityfx(local3\Field0, $09)
            entityblend(local3\Field0, $02)
            scaleentity(arg0\Field25[$0A], (roomscale * 1.5), (roomscale * 2.0), (roomscale * 1.5), $01)
            positionentity(arg0\Field25[$0B], arg0\Field3, arg0\Field4, (arg0\Field5 + 64.0), $01)
            For local7 = $01 To $08 Step $01
                arg0\Field25[(local7 - $01)] = copyentity(local53, $00)
                scaleentity(arg0\Field25[(local7 - $01)], roomscale, roomscale, roomscale, $00)
                local57 = ((Float (local7 - $01)) * 45.0)
                entitytype(arg0\Field25[(local7 - $01)], $01, $00)
                entitypickmode(arg0\Field25[(local7 - $01)], $02, $01)
                rotateentity(arg0\Field25[(local7 - $01)], 0.0, (local57 - 90.0), 0.0, $00)
                positionentity(arg0\Field25[(local7 - $01)], (arg0\Field3 + ((512.0 * roomscale) * cos(local57))), 0.0, (arg0\Field5 + ((512.0 * roomscale) * sin(local57))), $00)
                entityparent(arg0\Field25[(local7 - $01)], arg0\Field2, $01)
                If (local7 < $06) Then
                    local3 = createdecal((local7 + $07), (arg0\Field3 + (((512.0 * roomscale) * cos(local57)) * 3.0)), 0.02, (arg0\Field5 + (((512.0 * roomscale) * sin(local57)) * 3.0)), 90.0, (local57 - 90.0), 0.0, 1.0, 1.0)
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
                        positionentity(arg0\Field25[local7], arg0\Field3, (arg0\Field4 + (200.0 * roomscale)), (arg0\Field5 + 64.0), $01)
                    Case $0D
                        positionentity(arg0\Field25[local7], (arg0\Field3 + (390.0 * roomscale)), (arg0\Field4 + (200.0 * roomscale)), ((arg0\Field5 + 64.0) + (272.0 * roomscale)), $01)
                    Case $0E
                        positionentity(arg0\Field25[local7], (arg0\Field3 + (838.0 * roomscale)), (arg0\Field4 + (200.0 * roomscale)), ((arg0\Field5 + 64.0) - (551.0 * roomscale)), $01)
                    Case $0F
                        positionentity(arg0\Field25[local7], (arg0\Field3 - (139.0 * roomscale)), (arg0\Field4 + (200.0 * roomscale)), ((arg0\Field5 + 64.0) + (1201.0 * roomscale)), $01)
                    Case $10
                        positionentity(arg0\Field25[local7], (arg0\Field3 - (1238.0 * roomscale)), (arg0\Field4 - (1664.0 * roomscale)), ((arg0\Field5 + 64.0) + (381.0 * roomscale)), $01)
                End Select
            Next
            local59 = loadtexture_strict("GFX\npcs\oldmaneyes.jpg", $01)
            arg0\Field25[$11] = createsprite($00)
            scalesprite(arg0\Field25[$11], 0.03, 0.03)
            entitytexture(arg0\Field25[$11], local59, $00, $00)
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
            freetexture(local51)
            freeentity(local53)
            freetexture(local59)
        Case "room3z3"
            local2 = createsecuritycam((arg0\Field3 - (320.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 + (512.25 * roomscale)), arg0, $00)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room2_3","room3_3"
            local26 = createwaypoint(arg0\Field3, (arg0\Field4 + (66.0 * roomscale)), arg0\Field5, Null, arg0)
        Case "room1lifts"
            arg0\Field25[$00] = createbutton((arg0\Field3 + (96.0 * roomscale)), (arg0\Field4 + (160.0 * roomscale)), (arg0\Field5 + (64.0 * roomscale)), 0.0, 0.0, 0.0)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            arg0\Field25[$01] = createbutton((arg0\Field3 - (96.0 * roomscale)), (arg0\Field4 + (160.0 * roomscale)), (arg0\Field5 + (64.0 * roomscale)), 0.0, 0.0, 0.0)
            entityparent(arg0\Field25[$01], arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 + (384.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 - (960.0 * roomscale)), arg0, $00)
            local2\Field11 = 45.0
            local2\Field12 = 45.0
            local2\Field20 = arg0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            local26 = createwaypoint(arg0\Field3, (arg0\Field4 + (66.0 * roomscale)), arg0\Field5, Null, arg0)
        Case "room2servers2"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (264.0 * roomscale)), 0.0, (arg0\Field5 + (672.0 * roomscale)), 270.0, arg0, $00, $00, $03, "", $00)
            positionentity(local0\Field3[$00], (arg0\Field3 + (224.0 * roomscale)), entityy(local0\Field3[$00], $01), (arg0\Field5 + (510.0 * roomscale)), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 + (304.0 * roomscale)), entityy(local0\Field3[$01], $01), (arg0\Field5 + (840.0 * roomscale)), $01)
            turnentity(local0\Field3[$01], 0.0, 0.0, 0.0, $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (512.0 * roomscale)), (-768.0 * roomscale), (arg0\Field5 - (336.0 * roomscale)), 0.0, arg0, $00, $00, $03, "", $00)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (509.0 * roomscale)), (-768.0 * roomscale), (arg0\Field5 - (1037.0 * roomscale)), 0.0, arg0, $00, $00, $03, "", $00)
            local0\Field4 = $01
            local0\Field14 = $01
            local6 = createitem("Night Vision Goggles", "nvgoggles", (arg0\Field3 + (56.0154 * roomscale)), (arg0\Field4 - (648.0 * roomscale)), (arg0\Field5 + (749.638 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            local6\Field13 = 200.0
            rotateentity(local6\Field1, 0.0, (Float (arg0\Field6 + rand($F5, $01))), 0.0, $00)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room2gw","room2gw_b"
            If (arg0\Field7\Field11 = "room2gw_b") Then
                arg0\Field25[$02] = createpivot(arg0\Field2)
                positionentity(arg0\Field25[$02], (arg0\Field3 - (156.825 * roomscale)), (-37.3458 * roomscale), (arg0\Field5 + (121.364 * roomscale)), $01)
                local3 = createdecal($03, (arg0\Field3 - (156.825 * roomscale)), (-37.3458 * roomscale), (arg0\Field5 + (121.364 * roomscale)), 90.0, rnd(360.0, 0.0), 0.0, 1.0, 1.0)
                local3\Field2 = 0.5
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                entityparent(local3\Field0, arg0\Field2, $01)
                arg0\Field25[$00] = createpivot($00)
                positionentity(arg0\Field25[$00], (arg0\Field3 + (280.0 * roomscale)), (arg0\Field4 + (345.0 * roomscale)), (arg0\Field5 - (340.0 * roomscale)), $01)
                entityparent(arg0\Field25[$00], arg0\Field2, $01)
            EndIf
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 + (336.0 * roomscale)), 0.0, (arg0\Field5 - (382.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + (580.822 * roomscale)), entityy(arg0\Field29[$00]\Field3[$00], $01), (arg0\Field5 - (606.679 * roomscale)), $01)
            positionentity(arg0\Field29[$00]\Field3[$01], (arg0\Field3 + (580.822 * roomscale)), entityy(arg0\Field29[$00]\Field3[$01], $01), (arg0\Field5 - (606.679 * roomscale)), $01)
            arg0\Field29[$00]\Field9 = $00
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $01
            arg0\Field29[$00]\Field4 = $01
            arg0\Field29[$00]\Field24 = $00
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 + (336.0 * roomscale)), 0.0, (arg0\Field5 + (462.0 * roomscale)), 180.0, arg0, $00, $00, $00, "", $00)
            positionentity(arg0\Field29[$01]\Field3[$00], (arg0\Field3 + (580.822 * roomscale)), entityy(arg0\Field29[$01]\Field3[$00], $01), (arg0\Field5 - (606.679 * roomscale)), $01)
            positionentity(arg0\Field29[$01]\Field3[$01], (arg0\Field3 + (580.822 * roomscale)), entityy(arg0\Field29[$01]\Field3[$01], $01), (arg0\Field5 - (606.679 * roomscale)), $01)
            arg0\Field29[$01]\Field9 = $00
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field5 = $01
            arg0\Field29[$01]\Field4 = $01
            arg0\Field29[$01]\Field24 = $00
            For local4 = Each rooms
                If (local4 <> arg0) Then
                    If (((local4\Field7\Field11 = "room2gw") Or (local4\Field7\Field11 = "room2gw_b")) <> 0) Then
                        arg0\Field25[$03] = copyentity(local4\Field25[$03], arg0\Field2)
                        Exit
                    EndIf
                EndIf
            Next
            If (arg0\Field25[$03] = $00) Then
                arg0\Field25[$03] = loadmesh_strict("GFX\map\room2gw_pipes.b3d", arg0\Field2)
            EndIf
            entitypickmode(arg0\Field25[$03], $02, $01)
            addentitytoroomprops(arg0, arg0\Field25[$03])
            If (arg0\Field7\Field11 = "room2gw") Then
                arg0\Field25[$00] = createpivot($00)
                positionentity(arg0\Field25[$00], (arg0\Field3 + (344.0 * roomscale)), (128.0 * roomscale), arg0\Field5, $00)
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
                    scaleentity(arg0\Field25[$01], ((204.0 * roomscale) / meshwidth(arg0\Field25[$01])), ((312.0 * roomscale) / meshheight(arg0\Field25[$01])), ((16.0 * roomscale) / meshdepth(arg0\Field25[$01])), $00)
                    entitytype(arg0\Field25[$01], $01, $00)
                    positionentity(arg0\Field25[$01], (arg0\Field3 + (336.0 * roomscale)), 0.0, (arg0\Field5 + (462.0 * roomscale)), $00)
                    rotateentity(arg0\Field25[$01], 0.0, 360.0, 0.0, $00)
                    entityparent(arg0\Field25[$01], arg0\Field2, $01)
                    moveentity(arg0\Field25[$01], 120.0, 0.0, 5.0)
                    room2gw_brokendoor = $01
                    room2gw_x = arg0\Field3
                    room2gw_z = arg0\Field5
                    freeentity(arg0\Field29[$01]\Field1)
                    arg0\Field29[$01]\Field1 = $00
                    addentitytoroomprops(arg0, arg0\Field25[$01])
                EndIf
            EndIf
        Case "room3gw"
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (728.0 * roomscale)), 0.0, (arg0\Field5 - (458.0 * roomscale)), 0.0, arg0, $00, $00, $03, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            local0\Field4 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (223.0 * roomscale)), 0.0, (arg0\Field5 - (736.0 * roomscale)), -90.0, arg0, $00, $00, $03, "", $00)
            local0\Field21 = $00
            local0\Field5 = $00
            local0\Field4 = $00
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 - (459.0 * roomscale)), 0.0, (arg0\Field5 + (339.0 * roomscale)), 90.0, arg0, $00, $00, $00, "", $00)
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + (580.822 * roomscale)), entityy(arg0\Field29[$00]\Field3[$00], $01), (arg0\Field5 - (606.679 * roomscale)), $01)
            positionentity(arg0\Field29[$00]\Field3[$01], (arg0\Field3 + (580.822 * roomscale)), entityy(arg0\Field29[$00]\Field3[$01], $01), (arg0\Field5 - (606.679 * roomscale)), $01)
            arg0\Field29[$00]\Field9 = $00
            arg0\Field29[$00]\Field21 = $00
            arg0\Field29[$00]\Field5 = $01
            arg0\Field29[$00]\Field4 = $01
            arg0\Field29[$00]\Field24 = $00
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 + (385.0 * roomscale)), 0.0, (arg0\Field5 + (339.0 * roomscale)), 270.0, arg0, $00, $00, $00, "", $00)
            positionentity(arg0\Field29[$01]\Field3[$00], (arg0\Field3 + (580.822 * roomscale)), entityy(arg0\Field29[$01]\Field3[$00], $01), (arg0\Field5 - (606.679 * roomscale)), $01)
            positionentity(arg0\Field29[$01]\Field3[$01], (arg0\Field3 + (580.822 * roomscale)), entityy(arg0\Field29[$01]\Field3[$01], $01), (arg0\Field5 - (606.679 * roomscale)), $01)
            arg0\Field29[$01]\Field9 = $00
            arg0\Field29[$01]\Field21 = $00
            arg0\Field29[$01]\Field5 = $01
            arg0\Field29[$01]\Field4 = $01
            arg0\Field29[$01]\Field24 = $00
            freeentity(arg0\Field29[$01]\Field1)
            arg0\Field29[$01]\Field1 = $00
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (arg0\Field3 - (48.0 * roomscale)), (128.0 * roomscale), (arg0\Field5 + (320.0 * roomscale)), $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            For local4 = Each rooms
                If (local4 <> arg0) Then
                    If (local4\Field7\Field11 = "room3gw") Then
                        arg0\Field25[$03] = copyentity(local4\Field25[$03], arg0\Field2)
                        Exit
                    EndIf
                EndIf
            Next
            If (arg0\Field25[$03] = $00) Then
                arg0\Field25[$03] = loadmesh_strict("GFX\map\room3gw_pipes.b3d", arg0\Field2)
            EndIf
            addentitytoroomprops(arg0, arg0\Field25[$03])
            entitypickmode(arg0\Field25[$03], $02, $01)
        Case "room1162"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (248.0 * roomscale)), 0.0, (arg0\Field5 - (736.0 * roomscale)), 90.0, arg0, $00, $00, ($02 - networkserver\Field15), "", $00)
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (arg0\Field3 + (1012.0 * roomscale)), (arg0\Field4 + (128.0 * roomscale)), (arg0\Field5 - (640.0 * roomscale)), $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            If (networkserver\Field15 = $00) Then
                local6 = createitem("Document SCP-1162", "paper", (arg0\Field3 + (863.227 * roomscale)), (arg0\Field4 + (152.0 * roomscale)), (arg0\Field5 - (953.231 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("USP Tactical", "usp", (arg0\Field3 + (863.227 * roomscale)), (arg0\Field4 + (152.0 * roomscale)), (arg0\Field5 - (953.231 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
                local6 = createitem("Level 2 Key Card", "key2", (arg0\Field3 + (866.227 * roomscale)), (arg0\Field4 + (152.0 * roomscale)), (arg0\Field5 - (953.231 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local2 = createsecuritycam((arg0\Field3 - (192.0 * roomscale)), (arg0\Field4 + (704.0 * roomscale)), (arg0\Field5 + (192.0 * roomscale)), arg0, $00)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
        Case "room2scps2"
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 + (288.0 * roomscale)), arg0\Field4, (arg0\Field5 + (576.0 * roomscale)), 90.0, arg0, $00, $00, $03, "", $00)
            arg0\Field29[$00]\Field5 = $00
            arg0\Field29[$00]\Field4 = $01
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (777.0 * roomscale)), arg0\Field4, (arg0\Field5 + (671.0 * roomscale)), 90.0, arg0, $00, $00, $04, "", $00)
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (556.0 * roomscale)), arg0\Field4, (arg0\Field5 + (296.0 * roomscale)), 0.0, arg0, $00, $00, $03, "", $00)
            arg0\Field25[$00] = createpivot($00)
            positionentity(arg0\Field25[$00], (arg0\Field3 + (576.0 * roomscale)), (arg0\Field4 + (160.0 * roomscale)), (arg0\Field5 + (632.0 * roomscale)), $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            If (networkserver\Field15 = $00) Then
                local6 = createitem("SCP-1499", "scp1499", (arg0\Field3 + (600.0 * roomscale)), (arg0\Field4 + (176.0 * roomscale)), (arg0\Field5 - (228.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                rotateentity(local6\Field1, 0.0, (Float arg0\Field6), 0.0, $00)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("Document SCP-1499", "paper", (arg0\Field3 + (840.0 * roomscale)), (arg0\Field4 + (260.0 * roomscale)), (arg0\Field5 + (224.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            If (networkserver\Field15 = $00) Then
                local6 = createitem("Document SCP-500", "paper", (arg0\Field3 + (1152.0 * roomscale)), (arg0\Field4 + (224.0 * roomscale)), (arg0\Field5 + (336.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            Else
                local6 = createitem("FN P90", "p90", (arg0\Field3 + (1152.0 * roomscale)), (arg0\Field4 + (224.0 * roomscale)), (arg0\Field5 + (336.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
                entityparent(local6\Field1, arg0\Field2, $01)
            EndIf
            local6 = createitem("Emily Ross' Badge", "badge", (arg0\Field3 + (364.0 * roomscale)), (arg0\Field4 + (5.0 * roomscale)), (arg0\Field5 + (716.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 + (850.0 * roomscale)), (arg0\Field4 + (350.0 * roomscale)), (arg0\Field5 + (876.0 * roomscale)), arg0, $00)
            local2\Field11 = 220.0
            local2\Field12 = 30.0
            turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 + (600.0 * roomscale)), (arg0\Field4 + (514.0 * roomscale)), (arg0\Field5 + (150.0 * roomscale)), arg0, $00)
            local2\Field11 = 180.0
            local2\Field12 = 30.0
            turnentity(local2\Field3, 30.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
        Case "room3offices"
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (736.0 * roomscale)), 0.0, (arg0\Field5 + (240.0 * roomscale)), 0.0, arg0, $00, $00, $03, "", $00)
            positionentity(local0\Field3[$00], (arg0\Field3 + (892.0 * roomscale)), entityy(local0\Field3[$00], $01), (arg0\Field5 + (224.0 * roomscale)), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 + (892.0 * roomscale)), entityy(local0\Field3[$01], $01), (arg0\Field5 + (255.0 * roomscale)), $01)
            freeentity(local0\Field1)
            local0\Field1 = $00
            arg0\Field25[$00] = loadmesh_strict("GFX\map\room3offices_hb.b3d", arg0\Field2)
            entitypickmode(arg0\Field25[$00], $02, $01)
            entitytype(arg0\Field25[$00], $01, $00)
            entityalpha(arg0\Field25[$00], 0.0)
        Case "room2offices4"
            local0 = createdoor($00, (arg0\Field3 - (240.0 * roomscale)), 0.0, arg0\Field5, 90.0, arg0, $00, $00, $00, "", $00)
            positionentity(local0\Field3[$00], (arg0\Field3 - (230.0 * roomscale)), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 - (250.0 * roomscale)), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0\Field5 = $00
            local0\Field21 = $00
            local6 = createitem("Sticky Note", "paper", (arg0\Field3 - (991.0 * roomscale)), (arg0\Field4 - (242.0 * roomscale)), (arg0\Field5 + (904.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "room2sl"
            local61 = ((roomscale * 4.5) * 0.4)
            arg0\Field37[$00] = loadanimtexture("GFX\SL_monitors_checkpoint.jpg", $01, $200, $200, $00, $04)
            arg0\Field37[$01] = loadanimtexture("GFX\Sl_monitors.jpg", $01, $100, $100, $00, $08)
            For local7 = $00 To $0E Step $01
                If (local7 <> $07) Then
                    arg0\Field25[local7] = copyentity(monitor, $00)
                    scaleentity(arg0\Field25[local7], local61, local61, local61, $00)
                    If (((local7 <> $04) And (local7 <> $0D)) <> 0) Then
                        local62 = createsprite($00)
                        entityfx(local62, $11)
                        spriteviewmode(local62, $02)
                        scalesprite(local62, (((meshwidth(monitor) * local61) * 0.95) * 0.5), (((meshheight(monitor) * local61) * 0.95) * 0.5))
                        Select local7
                            Case $00
                                entitytexture(local62, arg0\Field37[$01], $00, $00)
                            Case $02
                                entitytexture(local62, arg0\Field37[$01], $02, $00)
                            Case $03
                                entitytexture(local62, arg0\Field37[$01], $01, $00)
                            Case $08
                                entitytexture(local62, arg0\Field37[$01], $04, $00)
                            Case $09
                                entitytexture(local62, arg0\Field37[$01], $05, $00)
                            Case $0A
                                entitytexture(local62, arg0\Field37[$01], $03, $00)
                            Case $0B
                                entitytexture(local62, arg0\Field37[$01], $07, $00)
                            Default
                                entitytexture(local62, arg0\Field37[$00], $03, $00)
                        End Select
                        entityparent(local62, arg0\Field25[local7], $01)
                    ElseIf (local7 = $04) Then
                        arg0\Field25[$14] = createsprite($00)
                        entityfx(arg0\Field25[$14], $11)
                        spriteviewmode(arg0\Field25[$14], $02)
                        scalesprite(arg0\Field25[$14], (((meshwidth(monitor) * local61) * 0.95) * 0.5), (((meshheight(monitor) * local61) * 0.95) * 0.5))
                        entitytexture(arg0\Field25[$14], arg0\Field37[$00], $02, $00)
                        entityparent(arg0\Field25[$14], arg0\Field25[local7], $01)
                    Else
                        arg0\Field25[$15] = createsprite($00)
                        entityfx(arg0\Field25[$15], $11)
                        spriteviewmode(arg0\Field25[$15], $02)
                        scalesprite(arg0\Field25[$15], (((meshwidth(monitor) * local61) * 0.95) * 0.5), (((meshheight(monitor) * local61) * 0.95) * 0.5))
                        entitytexture(arg0\Field25[$15], arg0\Field37[$01], $06, $00)
                        entityparent(arg0\Field25[$15], arg0\Field25[local7], $01)
                    EndIf
                    addentitytoroomprops(arg0, arg0\Field25[local7])
                EndIf
            Next
            For local7 = $00 To $02 Step $01
                positionentity(arg0\Field25[local7], (arg0\Field3 - (207.94 * roomscale)), (arg0\Field4 + ((648.0 + (Float ($70 * local7))) * roomscale)), (arg0\Field5 - (60.0686 * roomscale)), $00)
                rotateentity(arg0\Field25[local7], 0.0, (Float (arg0\Field6 + $69)), 0.0, $00)
                entityparent(arg0\Field25[local7], arg0\Field2, $01)
                debuglog((Str local7))
            Next
            For local7 = $03 To $05 Step $01
                positionentity(arg0\Field25[local7], (arg0\Field3 - (231.489 * roomscale)), (arg0\Field4 + ((648.0 + (Float ((local7 - $03) * $70))) * roomscale)), (arg0\Field5 + (95.7443 * roomscale)), $00)
                rotateentity(arg0\Field25[local7], 0.0, (Float (arg0\Field6 + $5A)), 0.0, $00)
                entityparent(arg0\Field25[local7], arg0\Field2, $01)
                debuglog((Str local7))
            Next
            For local7 = $06 To $08 Step $02
                positionentity(arg0\Field25[local7], (arg0\Field3 - (231.489 * roomscale)), (arg0\Field4 + ((648.0 + (Float ((local7 - $06) * $70))) * roomscale)), (arg0\Field5 + (255.744 * roomscale)), $00)
                rotateentity(arg0\Field25[local7], 0.0, (Float (arg0\Field6 + $5A)), 0.0, $00)
                entityparent(arg0\Field25[local7], arg0\Field2, $01)
                debuglog((Str local7))
            Next
            For local7 = $09 To $0B Step $01
                positionentity(arg0\Field25[local7], (arg0\Field3 - (231.489 * roomscale)), (arg0\Field4 + ((648.0 + (Float ((local7 - $09) * $70))) * roomscale)), (arg0\Field5 + (415.744 * roomscale)), $00)
                rotateentity(arg0\Field25[local7], 0.0, (Float (arg0\Field6 + $5A)), 0.0, $00)
                entityparent(arg0\Field25[local7], arg0\Field2, $01)
                debuglog((Str local7))
            Next
            For local7 = $0C To $0E Step $01
                positionentity(arg0\Field25[local7], (arg0\Field3 - (208.138 * roomscale)), (arg0\Field4 + ((648.0 + (Float ((local7 - $0C) * $70))) * roomscale)), (arg0\Field5 + (571.583 * roomscale)), $00)
                rotateentity(arg0\Field25[local7], 0.0, (Float (arg0\Field6 + $4B)), 0.0, $00)
                entityparent(arg0\Field25[local7], arg0\Field2, $01)
                debuglog((Str local7))
            Next
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 + (480.0 * roomscale)), arg0\Field4, (arg0\Field5 - (640.0 * roomscale)), 90.0, arg0, $00, $00, $03, "", $00)
            arg0\Field29[$00]\Field21 = $00
            positionentity(arg0\Field29[$00]\Field3[$00], (arg0\Field3 + (576.0 * roomscale)), entityy(arg0\Field29[$00]\Field3[$00], $01), (arg0\Field5 - (480.0 * roomscale)), $01)
            rotateentity(arg0\Field29[$00]\Field3[$00], 0.0, 270.0, 0.0, $00)
            arg0\Field29[$01] = createdoor(arg0\Field0, (arg0\Field3 + (544.0 * roomscale)), (arg0\Field4 + (480.0 * roomscale)), (arg0\Field5 + (256.0 * roomscale)), 270.0, arg0, $00, $00, $03, "", $00)
            arg0\Field29[$01]\Field21 = $00
            freeentity(arg0\Field29[$01]\Field1)
            arg0\Field29[$01]\Field1 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 + (1504.0 * roomscale)), (arg0\Field4 + (480.0 * roomscale)), (arg0\Field5 + (960.0 * roomscale)), 0.0, arg0, $00, $00, $00, "", $00)
            local0\Field21 = $00
            local0\Field4 = $01
            arg0\Field25[$07] = createpivot($00)
            positionentity(arg0\Field25[$07], arg0\Field3, (arg0\Field4 + (100.0 * roomscale)), (arg0\Field5 - (800.0 * roomscale)), $01)
            entityparent(arg0\Field25[$07], arg0\Field2, $01)
            arg0\Field25[$0F] = createpivot($00)
            positionentity(arg0\Field25[$0F], (arg0\Field3 + (700.0 * roomscale)), (arg0\Field4 + (700.0 * roomscale)), (arg0\Field5 + (256.0 * roomscale)), $01)
            entityparent(arg0\Field25[$0F], arg0\Field2, $01)
            arg0\Field25[$10] = createpivot($00)
            positionentity(arg0\Field25[$10], (arg0\Field3 - (60.0 * roomscale)), (arg0\Field4 + (700.0 * roomscale)), (arg0\Field5 + (200.0 * roomscale)), $01)
            entityparent(arg0\Field25[$10], arg0\Field2, $01)
            arg0\Field25[$11] = createpivot($00)
            positionentity(arg0\Field25[$11], (arg0\Field3 - (48.0 * roomscale)), (arg0\Field4 + (540.0 * roomscale)), (arg0\Field5 + (656.0 * roomscale)), $01)
            entityparent(arg0\Field25[$11], arg0\Field2, $01)
            arg0\Field25[$12] = copyentity(leverbaseobj, $00)
            arg0\Field25[$13] = copyentity(leverobj, $00)
            addentitytoroomprops(arg0, arg0\Field25[$12])
            addentitytoroomprops(arg0, arg0\Field25[$13])
            arg0\Field28[$00] = arg0\Field25[$13]
            For local7 = $00 To $01 Step $01
                scaleentity(arg0\Field25[($12 + local7)], 0.04, 0.04, 0.04, $00)
                positionentity(arg0\Field25[($12 + local7)], (arg0\Field3 - (49.0 * roomscale)), (arg0\Field4 + (689.0 * roomscale)), (arg0\Field5 + (912.0 * roomscale)), $01)
                entityparent(arg0\Field25[($12 + local7)], arg0\Field2, $01)
            Next
            rotateentity(arg0\Field25[$12], 0.0, 0.0, 0.0, $00)
            rotateentity(arg0\Field25[$13], 10.0, -180.0, 0.0, $00)
            entityradius(arg0\Field25[$13], 0.1, 0.0)
            local2 = createsecuritycam((arg0\Field3 - (159.0 * roomscale)), (arg0\Field4 + (384.0 * roomscale)), (arg0\Field5 - (929.0 * roomscale)), arg0, $01)
            local2\Field11 = 315.0
            local2\Field20 = arg0
            turnentity(local2\Field3, 20.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, (arg0\Field3 - (231.489 * roomscale)), (arg0\Field4 + (760.0 * roomscale)), (arg0\Field5 + (255.744 * roomscale)), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field2, $01)
        Case "room2_4"
            arg0\Field25[$06] = createpivot($00)
            positionentity(arg0\Field25[$06], (arg0\Field3 + (640.0 * roomscale)), (8.0 * roomscale), (arg0\Field5 - (896.0 * roomscale)), $00)
            entityparent(arg0\Field25[$06], arg0\Field2, $01)
        Case "room3z2"
            For local4 = Each rooms
                If (((local4\Field7\Field11 = arg0\Field7\Field11) And (local4 <> arg0)) <> 0) Then
                    arg0\Field25[$00] = copyentity(local4\Field25[$00], arg0\Field2)
                    Exit
                EndIf
            Next
            If (arg0\Field25[$00] = $00) Then
                arg0\Field25[$00] = loadmesh_strict("GFX\map\room3z2_hb.b3d", arg0\Field2)
            EndIf
            entitypickmode(arg0\Field25[$00], $02, $01)
            entitytype(arg0\Field25[$00], $01, $00)
            entityalpha(arg0\Field25[$00], 0.0)
        Case "lockroom3"
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (736.0 * roomscale)), 0.0, (arg0\Field5 - (104.0 * roomscale)), 0.0, arg0, $01, $00, $00, "", $00)
            local0\Field10 = (((networkserver\Field15 * $05) + $05) * $46)
            local0\Field21 = $00
            local0\Field5 = $00
            local0\Field4 = $01
            entityparent(local0\Field3[$00], $00, $01)
            positionentity(local0\Field3[$00], (arg0\Field3 - (288.0 * roomscale)), 0.7, (arg0\Field5 - (640.0 * roomscale)), $00)
            entityparent(local0\Field3[$00], arg0\Field2, $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local1 = createdoor(arg0\Field0, (arg0\Field3 + (104.0 * roomscale)), 0.0, (arg0\Field5 + (736.0 * roomscale)), 270.0, arg0, $01, $00, $00, "", $00)
            local1\Field10 = (((networkserver\Field15 * $05) + $05) * $46)
            local1\Field21 = $00
            local1\Field5 = $00
            local1\Field4 = $01
            entityparent(local1\Field3[$00], $00, $01)
            positionentity(local1\Field3[$00], (arg0\Field3 + (640.0 * roomscale)), 0.7, (arg0\Field5 + (288.0 * roomscale)), $00)
            rotateentity(local1\Field3[$00], 0.0, 90.0, 0.0, $00)
            entityparent(local1\Field3[$00], arg0\Field2, $01)
            freeentity(local1\Field3[$01])
            local1\Field3[$01] = $00
            local0\Field22 = local1
            local1\Field22 = local0
            local61 = ((roomscale * 4.5) * 0.4)
            arg0\Field25[$00] = copyentity(monitor, $00)
            scaleentity(arg0\Field25[$00], local61, local61, local61, $00)
            positionentity(arg0\Field25[$00], (arg0\Field3 + (668.0 * roomscale)), 1.1, (arg0\Field5 - (96.0 * roomscale)), $01)
            rotateentity(arg0\Field25[$00], 0.0, 90.0, 0.0, $00)
            entityparent(arg0\Field25[$00], arg0\Field2, $01)
            arg0\Field25[$01] = copyentity(monitor, $00)
            scaleentity(arg0\Field25[$01], local61, local61, local61, $00)
            positionentity(arg0\Field25[$01], (arg0\Field3 + (96.0 * roomscale)), 1.1, (arg0\Field5 - (668.0 * roomscale)), $01)
            entityparent(arg0\Field25[$01], arg0\Field2, $01)
            addentitytoroomprops(arg0, arg0\Field25[$00])
            addentitytoroomprops(arg0, arg0\Field25[$01])
        Case "medibay"
            arg0\Field25[$00] = loadmesh_strict("GFX\map\medibay_props.b3d", arg0\Field2)
            entitytype(arg0\Field25[$00], $01, $00)
            entitypickmode(arg0\Field25[$00], $02, $01)
            addentitytoroomprops(arg0, arg0\Field25[$00])
            arg0\Field25[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$01], (arg0\Field3 - (762.0 * roomscale)), (arg0\Field4 + (0.0 * roomscale)), (arg0\Field5 - (346.0 * roomscale)), $01)
            arg0\Field25[$02] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$02], (entityx(arg0\Field25[$01], $01) + (126.0 * roomscale)), entityy(arg0\Field25[$01], $01), entityz(arg0\Field25[$01], $01), $01)
            local6 = createitem("First Aid Kit", "firstaid", (arg0\Field3 - (506.0 * roomscale)), (arg0\Field4 + (192.0 * roomscale)), (arg0\Field5 - (322.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Syringe", "syringe", (arg0\Field3 - (333.0 * roomscale)), (arg0\Field4 + (100.0 * roomscale)), (arg0\Field5 + (97.3 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            local6 = createitem("Syringe", "syringe", (arg0\Field3 - (340.0 * roomscale)), (arg0\Field4 + (100.0 * roomscale)), (arg0\Field5 + (52.3 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
            arg0\Field29[$00] = createdoor(arg0\Field0, (arg0\Field3 - (264.0 * roomscale)), (arg0\Field4 - (0.0 * roomscale)), (arg0\Field5 + (640.0 * roomscale)), 90.0, arg0, $00, $00, $03, "", $00)
            arg0\Field25[$03] = createpivot(arg0\Field2)
            positionentity(arg0\Field25[$03], (arg0\Field3 - (820.0 * roomscale)), arg0\Field4, (arg0\Field5 - (318.399 * roomscale)), $01)
        Case "room2cpit"
            local14 = createemitter((arg0\Field3 + (512.0 * roomscale)), (-76.0 * roomscale), (arg0\Field5 - (688.0 * roomscale)), $00, 0.0)
            turnentity(local14\Field0, -90.0, 0.0, 0.0, $00)
            entityparent(local14\Field0, arg0\Field2, $01)
            local14\Field10 = 55.0
            local14\Field9 = 0.0005
            local14\Field12 = -0.015
            local14\Field11 = 0.007
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (256.0 * roomscale)), 0.0, (arg0\Field5 - (752.0 * roomscale)), 90.0, arg0, $00, $02, $03, "", $00)
            local0\Field4 = $01
            local0\Field5 = $00
            local0\Field21 = $00
            local0\Field24 = $00
            local0\Field14 = $01
            positionentity(local0\Field3[$00], (arg0\Field3 - (240.0 * roomscale)), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            local6 = createitem("Dr L's Note", "paper", (arg0\Field3 - (160.0 * roomscale)), (32.0 * roomscale), (arg0\Field5 - (353.0 * roomscale)), $00, $00, $00, 1.0, $00, $01)
            entityparent(local6\Field1, arg0\Field2, $01)
        Case "dimension1499"
            arg0\Field28[$01] = loadmesh_strict("GFX\map\dimension1499\1499object0_cull.b3d", arg0\Field2)
            entitytype(arg0\Field28[$01], $01, $00)
            entityalpha(arg0\Field28[$01], 0.0)
            arg0\Field28[$00] = createpivot($00)
            positionentity(arg0\Field28[$00], (arg0\Field3 + (205.0 * roomscale)), (arg0\Field4 + (200.0 * roomscale)), (arg0\Field5 + (2287.0 * roomscale)), $00)
            entityparent(arg0\Field28[$00], arg0\Field2, $01)
    End Select
    For local64 = Each lighttemplates
        If (local64\Field0 = arg0\Field7) Then
            local65 = addlight(arg0, (arg0\Field3 + local64\Field2), (arg0\Field4 + local64\Field3), (arg0\Field5 + local64\Field4), local64\Field1, local64\Field5, local64\Field6, local64\Field7, local64\Field8)
            If (local65 <> $00) Then
                If (local64\Field1 = $03) Then
                    lightconeangles(local65, (Float local64\Field11), local64\Field12)
                    rotateentity(local65, local64\Field9, local64\Field10, 0.0, $00)
                EndIf
            EndIf
        EndIf
    Next
    For local66 = Each tempscreens
        If (local66\Field4 = arg0\Field7) Then
            createscreen((arg0\Field3 + local66\Field1), (arg0\Field4 + local66\Field2), (arg0\Field5 + local66\Field3), local66\Field0, arg0)
        EndIf
    Next
    For local67 = Each tempwaypoints
        If (local67\Field3 = arg0\Field7) Then
            createwaypoint((arg0\Field3 + local67\Field0), (arg0\Field4 + local67\Field1), (arg0\Field5 + local67\Field2), Null, arg0)
        EndIf
    Next
    If (arg0\Field7\Field15 > $00) Then
        arg0\Field40 = arg0\Field7\Field15
        For local7 = $00 To (arg0\Field40 - $01) Step $01
            arg0\Field41[local7] = copyentity(arg0\Field7\Field16[local7], arg0\Field2)
            arg0\Field42[local7] = arg0\Field7\Field17[local7]
            debuglog(("Triggerbox found: " + (Str local7)))
            debuglog(((("Triggerbox " + (Str local7)) + " name: ") + arg0\Field42[local7]))
        Next
    EndIf
    For local7 = $00 To $07 Step $01
        If (arg0\Field7\Field5[local7] <> $00) Then
            arg0\Field13[local7] = createpivot(arg0\Field2)
            positionentity(arg0\Field13[local7], (arg0\Field3 + arg0\Field7\Field6[local7]), (arg0\Field4 + arg0\Field7\Field7[local7]), (arg0\Field5 + arg0\Field7\Field8[local7]), $01)
            entityparent(arg0\Field13[local7], arg0\Field2, $01)
            arg0\Field12[local7] = arg0\Field7\Field5[local7]
            arg0\Field14[local7] = arg0\Field7\Field9[local7]
        EndIf
    Next
    initroomdoors(arg0, $00)
    allowroomsdoorsinit = $00
    Return $00
End Function
