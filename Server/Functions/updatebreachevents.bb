Function updatebreachevents%()
    Local local0#
    Local local1%
    Local local2%
    Local local3%
    Local local4$
    Local local5%
    Local local6%
    Local local7.particles
    Local local8%
    Local local9.rooms
    Local local10.events
    Local local11.events
    Local local12.items
    Local local13%
    Local local14%
    Local local15.securitycams
    Local local16%
    Local local17$
    Local local18#
    Local local19#
    Local local20#
    Local local21#
    Local local23.players
    Local local24%
    Local local25%
    Local local26%
    Local local27.decals
    Local local28%[7]
    Local local29$
    Local local30%
    Local local31%
    Local local32%
    Local local33%
    Local local34.doors
    Local local35%
    Local local36%
    Local local37%
    Local local38%
    Local local39%
    Local local40%
    Local local41%
    Local local43%
    Local local44%
    Local local45%
    Local local46%
    Local local47%
    Local local48%
    Local local51%
    Local local52.waypoints
    Local local55%
    Local local56%
    Local local57.forest
    Local local58%
    Local local59#
    Local local60%
    Local local61%
    Local local62%
    Local local63%
    Local local66%
    Local local67%
    Local local68%
    Local local69%
    Local local70%
    Local local71#
    Local local72#
    Local local73#
    Local local74$
    Local local76%
    Local local77#
    Local local78#
    Local local80%
    If (((quickloadpercent = $FFFFFFFF) Or (quickloadpercent = $64)) = $00) Then
        Return $01
    EndIf
    local17 = ""
    currstepsfx = $00
    For local10 = Each events
        local10\Field13 = findeventobject(local10)
        local10\Field20 = calculatedist(local10\Field13, local10\Field1)
        currentplayerinevent = local10\Field14
        Select local10\Field22
            Case $28
                If (playerinroom(local10) <> 0) Then
                    If (0.0 = local10\Field2) Then
                        If (player[local10\Field14]\Field59 = $00) Then
                            If (((2.5 > entitydistance(local10\Field13, local10\Field1\Field29[$00]\Field0)) And remotedooron) <> 0) Then
                                giveachievement($01, $01)
                                playsound_strict(horrorsfx($07))
                                playsound2(leversfx, camera, local10\Field1\Field29[$00]\Field0, 10.0, 1.0)
                                local10\Field2 = 1.0
                                local10\Field1\Field29[$00]\Field5 = $01
                                local10\Field1\Field29[$00]\Field4 = $01
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case $33
                If (((8.0 <= entityy(collider, $01)) And (12.0 >= entityy(collider, $01))) <> 0) Then
                    If ((((local10\Field1\Field3 - 6.0) <= entityx(collider, $01)) And (((local10\Field1\Field3 + 38.0) + 6.0) >= entityx(collider, $01))) <> 0) Then
                        If ((((local10\Field1\Field5 - 6.0) <= entityz(collider, $01)) And (((local10\Field1\Field5 + 38.0) + 6.0) >= entityz(collider, $01))) <> 0) Then
                            playerroom = local10\Field1
                        EndIf
                    EndIf
                EndIf
                If (playerinroom(local10) <> 0) Then
                    If (i_zone\Field2 <> 0) Then
                        If (local10\Field1\Field31\Field2[$00] = $00) Then
                            allowroomdoorsinit = local10\Field1
                            placegrid_mapcreator(local10\Field1)
                            allowroomdoorsinit = Null
                        EndIf
                    EndIf
                    If (local10\Field1\Field31 = Null) Then
                        allowroomdoorsinit = local10\Field1
                        local10\Field1\Field31 = (New grids)
                        local39 = rndseed()
                        seedrnd(generateseednumber(server\Field7))
                        local40 = (rand($00, $01) Shl $01)
                        local37 = (rand($FFFFFFFE, $02) + $09)
                        local38 = (rand($FFFFFFFE, $02) + $09)
                        local10\Field1\Field31\Field0[((local38 * $13) + local37)] = $01
                        If (local40 = $02) Then
                            local10\Field1\Field31\Field0[((local37 + $01) + (local38 * $13))] = $01
                        Else
                            local10\Field1\Field31\Field0[((local37 - $01) + (local38 * $13))] = $01
                        EndIf
                        local41 = $02
                        While (local41 < $64)
                            local35 = (rand($01, $05) Shl rand($01, $02))
                            For local1 = $01 To local35 Step $01
                                local36 = $01
                                Select local40
                                    Case $00
                                        If (local37 < ($11 - (local1 Mod $02))) Then
                                            local37 = (local37 + $01)
                                        Else
                                            local36 = $00
                                        EndIf
                                    Case $01
                                        If (local38 < ($11 - (local1 Mod $02))) Then
                                            local38 = (local38 + $01)
                                        Else
                                            local36 = $00
                                        EndIf
                                    Case $02
                                        If (local37 > ((local1 Mod $02) + $01)) Then
                                            local37 = (local37 - $01)
                                        Else
                                            local36 = $00
                                        EndIf
                                    Case $03
                                        If (local38 > ((local1 Mod $02) + $01)) Then
                                            local38 = (local38 - $01)
                                        Else
                                            local36 = $00
                                        EndIf
                                End Select
                                If (local36 <> 0) Then
                                    If (local10\Field1\Field31\Field0[((local38 * $13) + local37)] = $00) Then
                                        local10\Field1\Field31\Field0[((local38 * $13) + local37)] = $01
                                        local41 = (local41 + $01)
                                    EndIf
                                Else
                                    Exit
                                EndIf
                            Next
                            local40 = (local40 + ((rand($00, $01) Shl $01) - $01))
                            While (local40 < $00)
                                local40 = (local40 + $04)
                            Wend
                            While (local40 > $03)
                                local40 = (local40 - $04)
                            Wend
                        Wend
                        For local38 = $00 To $12 Step $01
                            For local37 = $00 To $12 Step $01
                                If (local10\Field1\Field31\Field0[((local38 * $13) + local37)] > $00) Then
                                    local10\Field1\Field31\Field0[((local38 * $13) + local37)] = ((((local10\Field1\Field31\Field0[(((local38 + $01) * $13) + local37)] > $00) + (local10\Field1\Field31\Field0[(((local38 - $01) * $13) + local37)] > $00)) + (local10\Field1\Field31\Field0[((local37 + $01) + (local38 * $13))] > $00)) + (local10\Field1\Field31\Field0[((local37 - $01) + (local38 * $13))] > $00))
                                EndIf
                            Next
                        Next
                        local43 = $12
                        local44 = $00
                        For local37 = $00 To local43 Step $01
                            For local38 = $00 To $12 Step $01
                                If (local10\Field1\Field31\Field0[((local37 + $01) + (local38 * $13))] > $00) Then
                                    local43 = local37
                                    If (((local10\Field1\Field31\Field0[((local37 + $01) + ((local38 + $01) * $13))] < $03) And (local10\Field1\Field31\Field0[((local37 + $01) + ((local38 - $01) * $13))] < $03)) <> 0) Then
                                        local44 = $01
                                        If (rand($00, $01) = $01) Then
                                            local10\Field1\Field31\Field0[((local37 + $01) + (local38 * $13))] = (local10\Field1\Field31\Field0[((local37 + $01) + (local38 * $13))] + $01)
                                            local10\Field1\Field31\Field0[((local38 * $13) + local37)] = $07
                                            local44 = $00
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                            If (local44 <> 0) Then
                                local37 = (local37 - $01)
                            EndIf
                        Next
                        local45 = $FFFFFFFF
                        local48 = $FFFFFFFF
                        local45 = $FFFFFFFF
                        local48 = $FFFFFFFF
                        For local38 = $00 To $12 Step $01
                            For local37 = $00 To $12 Step $01
                                If (local10\Field1\Field31\Field0[((local38 * $13) + local37)] = $02) Then
                                    If (((local10\Field1\Field31\Field0[((local37 + $01) + (local38 * $13))] > $00) And (local10\Field1\Field31\Field0[((local37 - $01) + (local38 * $13))] > $00)) <> 0) Then
                                        If (((local45 = $FFFFFFFF) Or (local47 = $FFFFFFFF)) <> 0) Then
                                            If (((((local10\Field1\Field31\Field0[((local37 - $01) + (local38 * $13))] < $03) And (local10\Field1\Field31\Field0[((local37 + $01) + (local38 * $13))] < $03)) And (local10\Field1\Field31\Field0[(((local38 - $01) * $13) + local37)] < $03)) And (local10\Field1\Field31\Field0[(((local38 + $01) * $13) + local37)] < $03)) <> 0) Then
                                                If (((((local10\Field1\Field31\Field0[((local37 - $01) + ((local38 - $01) * $13))] < $01) And (local10\Field1\Field31\Field0[((local37 + $01) + ((local38 - $01) * $13))] < $01)) And (local10\Field1\Field31\Field0[((local37 + $01) + ((local38 - $01) * $13))] < $01)) And (local10\Field1\Field31\Field0[((local37 - $01) + ((local38 + $01) * $13))] < $01)) <> 0) Then
                                                    local45 = local37
                                                    local47 = local38
                                                EndIf
                                            EndIf
                                        EndIf
                                        If (((((local10\Field1\Field31\Field0[((local37 - $01) + (local38 * $13))] < $03) And (local10\Field1\Field31\Field0[((local37 + $01) + (local38 * $13))] < $03)) And (local10\Field1\Field31\Field0[(((local38 - $01) * $13) + local37)] < $03)) And (local10\Field1\Field31\Field0[(((local38 + $01) * $13) + local37)] < $03)) <> 0) Then
                                            If (((((local10\Field1\Field31\Field0[((local37 - $01) + ((local38 - $01) * $13))] < $01) And (local10\Field1\Field31\Field0[((local37 + $01) + ((local38 - $01) * $13))] < $01)) And (local10\Field1\Field31\Field0[((local37 + $01) + ((local38 - $01) * $13))] < $01)) And (local10\Field1\Field31\Field0[((local37 - $01) + ((local38 + $01) * $13))] < $01)) <> 0) Then
                                                local46 = local37
                                                local48 = local38
                                            EndIf
                                        EndIf
                                    ElseIf (((local10\Field1\Field31\Field0[(((local38 + $01) * $13) + local37)] > $00) And (local10\Field1\Field31\Field0[(((local38 - $01) * $13) + local37)] > $00)) <> 0) Then
                                        If (((local45 = $FFFFFFFF) Or (local47 = $FFFFFFFF)) <> 0) Then
                                            If (((((local10\Field1\Field31\Field0[((local37 - $01) + (local38 * $13))] < $03) And (local10\Field1\Field31\Field0[((local37 + $01) + (local38 * $13))] < $03)) And (local10\Field1\Field31\Field0[(((local38 - $01) * $13) + local37)] < $03)) And (local10\Field1\Field31\Field0[(((local38 + $01) * $13) + local37)] < $03)) <> 0) Then
                                                If (((((local10\Field1\Field31\Field0[((local37 - $01) + ((local38 - $01) * $13))] < $01) And (local10\Field1\Field31\Field0[((local37 + $01) + ((local38 - $01) * $13))] < $01)) And (local10\Field1\Field31\Field0[((local37 + $01) + ((local38 - $01) * $13))] < $01)) And (local10\Field1\Field31\Field0[((local37 - $01) + ((local38 + $01) * $13))] < $01)) <> 0) Then
                                                    local45 = local37
                                                    local47 = local38
                                                EndIf
                                            EndIf
                                        EndIf
                                        If (((((local10\Field1\Field31\Field0[((local37 - $01) + (local38 * $13))] < $03) And (local10\Field1\Field31\Field0[((local37 + $01) + (local38 * $13))] < $03)) And (local10\Field1\Field31\Field0[(((local38 - $01) * $13) + local37)] < $03)) And (local10\Field1\Field31\Field0[(((local38 + $01) * $13) + local37)] < $03)) <> 0) Then
                                            If (((((local10\Field1\Field31\Field0[((local37 - $01) + ((local38 - $01) * $13))] < $01) And (local10\Field1\Field31\Field0[((local37 + $01) + ((local38 - $01) * $13))] < $01)) And (local10\Field1\Field31\Field0[((local37 + $01) + ((local38 - $01) * $13))] < $01)) And (local10\Field1\Field31\Field0[((local37 - $01) + ((local38 + $01) * $13))] < $01)) <> 0) Then
                                                local46 = local37
                                                local48 = local38
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        Next
                        If (((local46 = local45) And (local48 = local47)) <> 0) Then
                            runtimeerror("The maintenance tunnels could not be generated properly!")
                        EndIf
                        For local1 = $00 To $06 Step $01
                            local28[local1] = copyentity(objtunnel(local1), $00)
                            debuglog((Str local1))
                            hideentity(local28[local1])
                        Next
                        freetexturecache()
                        local35 = $00
                        For local38 = $00 To $12 Step $01
                            For local37 = $00 To $12 Step $01
                                If (local10\Field1\Field31\Field0[((local38 * $13) + local37)] > $00) Then
                                    Select local10\Field1\Field31\Field0[((local38 * $13) + local37)]
                                        Case $01,$07
                                            local35 = copyentity(local28[(local10\Field1\Field31\Field0[((local38 * $13) + local37)] - $01)], $00)
                                            If (local10\Field1\Field31\Field0[((local37 + $01) + (local38 * $13))] > $00) Then
                                                rotateentity(local35, 0.0, 90.0, 0.0, $00)
                                                local10\Field1\Field31\Field1[((local38 * $13) + local37)] = $01
                                            ElseIf (local10\Field1\Field31\Field0[((local37 - $01) + (local38 * $13))] > $00) Then
                                                rotateentity(local35, 0.0, 270.0, 0.0, $00)
                                                local10\Field1\Field31\Field1[((local38 * $13) + local37)] = $03
                                            ElseIf (local10\Field1\Field31\Field0[(((local38 + $01) * $13) + local37)] > $00) Then
                                                rotateentity(local35, 0.0, 180.0, 0.0, $00)
                                                local10\Field1\Field31\Field1[((local38 * $13) + local37)] = $02
                                            Else
                                                rotateentity(local35, 0.0, 0.0, 0.0, $00)
                                                local10\Field1\Field31\Field1[((local38 * $13) + local37)] = $00
                                            EndIf
                                        Case $02
                                            If ((((local37 = local45) And (local38 = local47)) Or ((local37 = local46) And (local38 = local48))) <> 0) Then
                                                local10\Field1\Field31\Field0[((local38 * $13) + local37)] = $06
                                            EndIf
                                            If (((local10\Field1\Field31\Field0[((local37 + $01) + (local38 * $13))] > $00) And (local10\Field1\Field31\Field0[((local37 - $01) + (local38 * $13))] > $00)) <> 0) Then
                                                local35 = copyentity(local28[(local10\Field1\Field31\Field0[((local38 * $13) + local37)] - $01)], $00)
                                                addlight(Null, (local10\Field1\Field3 + ((Float local37) * 2.0)), ((368.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local38) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                                local36 = rand($00, $01)
                                                rotateentity(local35, 0.0, (((Float local36) * 180.0) + 90.0), 0.0, $00)
                                                local10\Field1\Field31\Field1[((local38 * $13) + local37)] = ((local36 Shl $01) + $01)
                                            ElseIf (((local10\Field1\Field31\Field0[(((local38 + $01) * $13) + local37)] > $00) And (local10\Field1\Field31\Field0[(((local38 - $01) * $13) + local37)] > $00)) <> 0) Then
                                                local35 = copyentity(local28[(local10\Field1\Field31\Field0[((local38 * $13) + local37)] - $01)], $00)
                                                addlight(Null, (local10\Field1\Field3 + ((Float local37) * 2.0)), ((368.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local38) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                                local36 = rand($00, $01)
                                                rotateentity(local35, 0.0, ((Float local36) * 180.0), 0.0, $00)
                                                local10\Field1\Field31\Field1[((local38 * $13) + local37)] = (local36 Shl $01)
                                            Else
                                                local35 = copyentity(local28[local10\Field1\Field31\Field0[((local38 * $13) + local37)]], $00)
                                                addlight(Null, (local10\Field1\Field3 + ((Float local37) * 2.0)), ((412.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local38) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                                local30 = local10\Field1\Field31\Field0[(((local38 + $01) * $13) + local37)]
                                                local31 = local10\Field1\Field31\Field0[(((local38 - $01) * $13) + local37)]
                                                local32 = local10\Field1\Field31\Field0[((local37 + $01) + (local38 * $13))]
                                                local33 = local10\Field1\Field31\Field0[((local37 - $01) + (local38 * $13))]
                                                If (((local30 > $00) And (local32 > $00)) <> 0) Then
                                                    rotateentity(local35, 0.0, 0.0, 0.0, $00)
                                                    local10\Field1\Field31\Field1[((local38 * $13) + local37)] = $00
                                                ElseIf (((local30 > $00) And (local33 > $00)) <> 0) Then
                                                    rotateentity(local35, 0.0, 90.0, 0.0, $00)
                                                    local10\Field1\Field31\Field1[((local38 * $13) + local37)] = $01
                                                ElseIf (((local31 > $00) And (local32 > $00)) <> 0) Then
                                                    rotateentity(local35, 0.0, 270.0, 0.0, $00)
                                                    local10\Field1\Field31\Field1[((local38 * $13) + local37)] = $03
                                                Else
                                                    rotateentity(local35, 0.0, 180.0, 0.0, $00)
                                                    local10\Field1\Field31\Field1[((local38 * $13) + local37)] = $02
                                                EndIf
                                            EndIf
                                            If (((local37 = local45) And (local38 = local47)) <> 0) Then
                                                local10\Field1\Field31\Field0[((local38 * $13) + local37)] = $05
                                            EndIf
                                        Case $03
                                            local35 = copyentity(local28[local10\Field1\Field31\Field0[((local38 * $13) + local37)]], $00)
                                            local30 = local10\Field1\Field31\Field0[(((local38 + $01) * $13) + local37)]
                                            local31 = local10\Field1\Field31\Field0[(((local38 - $01) * $13) + local37)]
                                            local32 = local10\Field1\Field31\Field0[((local37 + $01) + (local38 * $13))]
                                            local33 = local10\Field1\Field31\Field0[((local37 - $01) + (local38 * $13))]
                                            If ((((local30 > $00) And (local32 > $00)) And (local33 > $00)) <> 0) Then
                                                rotateentity(local35, 0.0, 90.0, 0.0, $00)
                                                local10\Field1\Field31\Field1[((local38 * $13) + local37)] = $01
                                            ElseIf ((((local31 > $00) And (local32 > $00)) And (local33 > $00)) <> 0) Then
                                                rotateentity(local35, 0.0, 270.0, 0.0, $00)
                                                local10\Field1\Field31\Field1[((local38 * $13) + local37)] = $03
                                            ElseIf ((((local32 > $00) And (local30 > $00)) And (local31 > $00)) <> 0) Then
                                                rotateentity(local35, 0.0, 0.0, 0.0, $00)
                                                local10\Field1\Field31\Field1[((local38 * $13) + local37)] = $00
                                            Else
                                                rotateentity(local35, 0.0, 180.0, 0.0, $00)
                                                local10\Field1\Field31\Field1[((local38 * $13) + local37)] = $02
                                            EndIf
                                        Case $04
                                            local35 = copyentity(local28[local10\Field1\Field31\Field0[((local38 * $13) + local37)]], $00)
                                            local36 = rand($00, $03)
                                            rotateentity(local35, 0.0, ((Float local36) * 90.0), 0.0, $00)
                                            local10\Field1\Field31\Field1[((local38 * $13) + local37)] = local36
                                    End Select
                                    scaleentity(local35, roomscale, roomscale, roomscale, $01)
                                    positionentity(local35, (local10\Field1\Field3 + ((Float local37) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local38) * 2.0)), $01)
                                    Select local10\Field1\Field31\Field0[((local38 * $13) + local37)]
                                        Case $01
                                            addlight(Null, (local10\Field1\Field3 + ((Float local37) * 2.0)), ((368.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local38) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                        Case $03,$04
                                            addlight(Null, (local10\Field1\Field3 + ((Float local37) * 2.0)), ((412.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local38) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                        Case $07
                                            local51 = $01
                                            addlight(Null, (((local10\Field1\Field3 + ((Float local37) * 2.0)) - ((sin(entityyaw(local35, $01)) * 504.0) * roomscale)) + ((cos(entityyaw(local35, $01)) * 16.0) * roomscale)), ((396.0 * roomscale) + 8.0), (((local10\Field1\Field5 + ((Float local38) * 2.0)) + ((cos(entityyaw(local35, $01)) * 504.0) * roomscale)) + ((sin(entityyaw(local35, $01)) * 16.0) * roomscale)), $02, (500.0 * roomscale), $FF, $C8, $C8)
                                            local12 = createitem("SCP-500-01", "scp500", (((local10\Field1\Field3 + ((Float local37) * 2.0)) + ((cos(entityyaw(local35, $01)) * -208.0) * roomscale)) - ((sin(entityyaw(local35, $01)) * 1226.0) * roomscale)), ((80.0 * roomscale) + 8.0), (((local10\Field1\Field5 + ((Float local38) * 2.0)) + ((sin(entityyaw(local35, $01)) * -208.0) * roomscale)) + ((cos(entityyaw(local35, $01)) * 1226.0) * roomscale)), $00, $00, $00, 1.0, $00, $01)
                                            entitytype(local12\Field1, $03, $00)
                                            local12 = createitem("Night Vision Goggles", "nvgoggles", (((local10\Field1\Field3 + ((Float local37) * 2.0)) - ((sin(entityyaw(local35, $01)) * 504.0) * roomscale)) + ((cos(entityyaw(local35, $01)) * 16.0) * roomscale)), ((80.0 * roomscale) + 8.0), (((local10\Field1\Field5 + ((Float local38) * 2.0)) + ((cos(entityyaw(local35, $01)) * 504.0) * roomscale)) + ((sin(entityyaw(local35, $01)) * 16.0) * roomscale)), $00, $00, $00, 1.0, $00, $01)
                                            entitytype(local12\Field1, $03, $00)
                                            local51 = $00
                                    End Select
                                    If (((local10\Field1\Field31\Field0[((local38 * $13) + local37)] = $06) Or (local10\Field1\Field31\Field0[((local38 * $13) + local37)] = $05)) <> 0) Then
                                        local34 = createdoor(local10\Field1\Field0, ((local10\Field1\Field3 + ((Float local37) * 2.0)) + ((cos(entityyaw(local35, $01)) * 240.0) * roomscale)), 8.0, ((local10\Field1\Field5 + ((Float local38) * 2.0)) + ((sin(entityyaw(local35, $01)) * 240.0) * roomscale)), (entityyaw(local35, $01) + 90.0), Null, $00, $03, $00, "", $00)
                                        positionentity(local34\Field3[$00], (entityx(local34\Field3[$00], $01) + (cos(entityyaw(local35, $01)) * 0.05)), (entityy(local34\Field3[$00], $01) + 0.0), (entityz(local34\Field3[$00], $01) + (sin(entityyaw(local35, $01)) * 0.05)), $01)
                                        addlight(Null, ((local10\Field1\Field3 + ((Float local37) * 2.0)) + ((cos(entityyaw(local35, $01)) * 555.0) * roomscale)), ((469.0 * roomscale) + 8.0), ((local10\Field1\Field5 + ((Float local38) * 2.0)) + ((sin(entityyaw(local35, $01)) * 555.0) * roomscale)), $02, (600.0 * roomscale), $FF, $FF, $FF)
                                        local36 = createpivot($00)
                                        rotateentity(local36, 0.0, (entityyaw(local35, $01) + 180.0), 0.0, $01)
                                        positionentity(local36, ((local10\Field1\Field3 + ((Float local37) * 2.0)) + ((cos(entityyaw(local35, $01)) * 552.0) * roomscale)), ((240.0 * roomscale) + 8.0), ((local10\Field1\Field5 + ((Float local38) * 2.0)) + ((sin(entityyaw(local35, $01)) * 552.0) * roomscale)), $00)
                                        If (local10\Field1\Field31\Field0[((local38 * $13) + local37)] = $06) Then
                                            If (local10\Field1\Field29[$01] = Null) Then
                                                local34\Field5 = (local10\Field1\Field29[$00]\Field5 = $00)
                                                local10\Field1\Field29[$01] = local34
                                            Else
                                                removedoor(local34)
                                            EndIf
                                            If (local10\Field1\Field25[$03] = $00) Then
                                                local10\Field1\Field25[$03] = local36
                                                positionentity(local10\Field1\Field25[$01], (local10\Field1\Field3 + ((Float local37) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local38) * 2.0)), $01)
                                            Else
                                                freeentity(local36)
                                            EndIf
                                        Else
                                            If (local10\Field1\Field29[$03] = Null) Then
                                                local34\Field5 = (local10\Field1\Field29[$02]\Field5 = $00)
                                                local10\Field1\Field29[$03] = local34
                                            Else
                                                removedoor(local34)
                                            EndIf
                                            If (local10\Field1\Field25[$05] = $00) Then
                                                local10\Field1\Field25[$05] = local36
                                                positionentity(local10\Field1\Field25[$00], (local10\Field1\Field3 + ((Float local37) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local38) * 2.0)), $01)
                                            Else
                                                freeentity(local36)
                                            EndIf
                                        EndIf
                                    EndIf
                                    local10\Field1\Field31\Field3[((local38 * $13) + local37)] = local35
                                    local52 = createwaypoint((local10\Field1\Field3 + ((Float local37) * 2.0)), 8.2, (local10\Field1\Field5 + ((Float local38) * 2.0)), Null, local10\Field1)
                                    local10\Field1\Field31\Field4[((local38 * $13) + local37)] = local52
                                    If (local38 < $12) Then
                                        If (local10\Field1\Field31\Field4[(((local38 + $01) * $13) + local37)] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field0, local10\Field1\Field31\Field4[(((local38 + $01) * $13) + local37)]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[(((local38 + $01) * $13) + local37)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[(((local38 + $01) * $13) + local37)]
                                                    local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field31\Field4[(((local38 + $01) * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[((local38 * $13) + local37)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field31\Field4[(((local38 + $01) * $13) + local37)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field31\Field4[(((local38 + $01) * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[((local38 * $13) + local37)]
                                                    local10\Field1\Field31\Field4[(((local38 + $01) * $13) + local37)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local38 > $00) Then
                                        If (local10\Field1\Field31\Field4[(((local38 - $01) * $13) + local37)] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field0, local10\Field1\Field31\Field4[(((local38 - $01) * $13) + local37)]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[(((local38 - $01) * $13) + local37)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[(((local38 - $01) * $13) + local37)]
                                                    local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field31\Field4[(((local38 - $01) * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[((local38 * $13) + local37)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field31\Field4[(((local38 - $01) * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[((local38 * $13) + local37)]
                                                    local10\Field1\Field31\Field4[(((local38 - $01) * $13) + local37)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local37 > $00) Then
                                        If (local10\Field1\Field31\Field4[((local37 - $01) + (local38 * $13))] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field0, local10\Field1\Field31\Field4[((local37 - $01) + (local38 * $13))]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[((local37 - $01) + (local38 * $13))]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[((local37 - $01) + (local38 * $13))]
                                                    local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field31\Field4[((local37 - $01) + (local38 * $13))]\Field4[local1] = local10\Field1\Field31\Field4[((local38 * $13) + local37)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field31\Field4[((local37 - $01) + (local38 * $13))]\Field4[local1] = local10\Field1\Field31\Field4[((local38 * $13) + local37)]
                                                    local10\Field1\Field31\Field4[((local37 - $01) + (local38 * $13))]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local37 < $12) Then
                                        If (local10\Field1\Field31\Field4[((local37 + $01) + (local38 * $13))] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field0, local10\Field1\Field31\Field4[((local37 + $01) + (local38 * $13))]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[((local37 + $01) + (local38 * $13))]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[((local37 + $01) + (local38 * $13))]
                                                    local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field31\Field4[((local37 + $01) + (local38 * $13))]\Field4[local1] = local10\Field1\Field31\Field4[((local38 * $13) + local37)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field31\Field4[((local37 + $01) + (local38 * $13))]\Field4[local1] = local10\Field1\Field31\Field4[((local38 * $13) + local37)]
                                                    local10\Field1\Field31\Field4[((local37 + $01) + (local38 * $13))]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        Next
                        For local1 = $00 To $06 Step $01
                            local10\Field1\Field31\Field2[local1] = local28[local1]
                        Next
                        positionentity(local10\Field1\Field25[$00], (local10\Field1\Field3 + ((Float local45) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local47) * 2.0)), $01)
                        positionentity(local10\Field1\Field25[$01], (local10\Field1\Field3 + ((Float local46) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local48) * 2.0)), $01)
                    ElseIf (local10\Field1\Field31\Field2[$00] = $00) Then
                        For local1 = $00 To $06 Step $01
                            local28[local1] = copyentity(objtunnel(local1), $00)
                            debuglog((Str local1))
                            hideentity(local28[local1])
                        Next
                        freetexturecache()
                        local35 = $00
                        For local38 = $00 To $12 Step $01
                            For local37 = $00 To $12 Step $01
                                If (local10\Field1\Field31\Field0[((local38 * $13) + local37)] > $00) Then
                                    Select local10\Field1\Field31\Field0[((local38 * $13) + local37)]
                                        Case $01,$07
                                            local35 = copyentity(local28[(local10\Field1\Field31\Field0[((local38 * $13) + local37)] - $01)], $00)
                                        Case $02
                                            If (((local10\Field1\Field31\Field0[((local37 + $01) + (local38 * $13))] > $00) And (local10\Field1\Field31\Field0[((local37 - $01) + (local38 * $13))] > $00)) <> 0) Then
                                                local35 = copyentity(local28[(local10\Field1\Field31\Field0[((local38 * $13) + local37)] - $01)], $00)
                                                addlight(Null, (local10\Field1\Field3 + ((Float local37) * 2.0)), ((368.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local38) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                            ElseIf (((local10\Field1\Field31\Field0[(((local38 + $01) * $13) + local37)] > $00) And (local10\Field1\Field31\Field0[(((local38 - $01) * $13) + local37)] > $00)) <> 0) Then
                                                local35 = copyentity(local28[(local10\Field1\Field31\Field0[((local38 * $13) + local37)] - $01)], $00)
                                                addlight(Null, (local10\Field1\Field3 + ((Float local37) * 2.0)), ((368.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local38) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                            Else
                                                local35 = copyentity(local28[local10\Field1\Field31\Field0[((local38 * $13) + local37)]], $00)
                                                addlight(Null, (local10\Field1\Field3 + ((Float local37) * 2.0)), ((412.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local38) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                            EndIf
                                        Case $03,$04
                                            local35 = copyentity(local28[local10\Field1\Field31\Field0[((local38 * $13) + local37)]], $00)
                                        Case $05,$06
                                            local35 = copyentity(local28[$05], $00)
                                    End Select
                                    scaleentity(local35, roomscale, roomscale, roomscale, $01)
                                    rotateentity(local35, 0.0, ((Float local10\Field1\Field31\Field1[((local38 * $13) + local37)]) * 90.0), 0.0, $00)
                                    positionentity(local35, (local10\Field1\Field3 + ((Float local37) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local38) * 2.0)), $01)
                                    Select local10\Field1\Field31\Field0[((local38 * $13) + local37)]
                                        Case $01,$05,$06
                                            addlight(Null, (local10\Field1\Field3 + ((Float local37) * 2.0)), ((368.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local38) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                        Case $03,$04
                                            addlight(Null, (local10\Field1\Field3 + ((Float local37) * 2.0)), ((412.0 * roomscale) + 8.0), (local10\Field1\Field5 + ((Float local38) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                                        Case $07
                                            addlight(Null, (((local10\Field1\Field3 + ((Float local37) * 2.0)) - ((sin(entityyaw(local35, $01)) * 504.0) * roomscale)) + ((cos(entityyaw(local35, $01)) * 16.0) * roomscale)), ((396.0 * roomscale) + 8.0), (((local10\Field1\Field5 + ((Float local38) * 2.0)) + ((cos(entityyaw(local35, $01)) * 504.0) * roomscale)) + ((sin(entityyaw(local35, $01)) * 16.0) * roomscale)), $02, (500.0 * roomscale), $FF, $C8, $C8)
                                    End Select
                                    If (((local10\Field1\Field31\Field0[((local38 * $13) + local37)] = $06) Or (local10\Field1\Field31\Field0[((local38 * $13) + local37)] = $05)) <> 0) Then
                                        local34 = createdoor(local10\Field1\Field0, ((local10\Field1\Field3 + ((Float local37) * 2.0)) + ((cos(entityyaw(local35, $01)) * 240.0) * roomscale)), 8.0, ((local10\Field1\Field5 + ((Float local38) * 2.0)) + ((sin(entityyaw(local35, $01)) * 240.0) * roomscale)), (entityyaw(local35, $01) + 90.0), Null, $00, $03, $00, "", $00)
                                        addlight(Null, ((local10\Field1\Field3 + ((Float local37) * 2.0)) + ((cos(entityyaw(local35, $01)) * 555.0) * roomscale)), ((469.0 * roomscale) + 8.0), ((local10\Field1\Field5 + ((Float local38) * 2.0)) + ((sin(entityyaw(local35, $01)) * 555.0) * roomscale)), $02, (600.0 * roomscale), $FF, $FF, $FF)
                                        positionentity(local34\Field3[$00], (entityx(local34\Field3[$00], $01) + (cos(entityyaw(local35, $01)) * 0.05)), (entityy(local34\Field3[$00], $01) + 0.0), (entityz(local34\Field3[$00], $01) + (sin(entityyaw(local35, $01)) * 0.05)), $01)
                                        local36 = createpivot($00)
                                        rotateentity(local36, 0.0, (entityyaw(local35, $01) + 180.0), 0.0, $01)
                                        positionentity(local36, ((local10\Field1\Field3 + ((Float local37) * 2.0)) + ((cos(entityyaw(local35, $01)) * 552.0) * roomscale)), ((240.0 * roomscale) + 8.0), ((local10\Field1\Field5 + ((Float local38) * 2.0)) + ((sin(entityyaw(local35, $01)) * 552.0) * roomscale)), $00)
                                        If (local10\Field1\Field31\Field0[((local38 * $13) + local37)] = $06) Then
                                            If (local10\Field1\Field29[$01] = Null) Then
                                                local34\Field5 = (local10\Field1\Field29[$00]\Field5 = $00)
                                                local10\Field1\Field29[$01] = local34
                                            Else
                                                removedoor(local34)
                                            EndIf
                                            If (local10\Field1\Field25[$03] = $00) Then
                                                local10\Field1\Field25[$03] = local36
                                                positionentity(local10\Field1\Field25[$01], (local10\Field1\Field3 + ((Float local37) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local38) * 2.0)), $01)
                                            Else
                                                freeentity(local36)
                                            EndIf
                                        Else
                                            If (local10\Field1\Field29[$03] = Null) Then
                                                local34\Field5 = (local10\Field1\Field29[$02]\Field5 = $00)
                                                local10\Field1\Field29[$03] = local34
                                            Else
                                                removedoor(local34)
                                            EndIf
                                            If (local10\Field1\Field25[$05] = $00) Then
                                                local10\Field1\Field25[$05] = local36
                                                positionentity(local10\Field1\Field25[$00], (local10\Field1\Field3 + ((Float local37) * 2.0)), 8.0, (local10\Field1\Field5 + ((Float local38) * 2.0)), $01)
                                            Else
                                                freeentity(local36)
                                            EndIf
                                        EndIf
                                    EndIf
                                    local10\Field1\Field31\Field3[((local38 * $13) + local37)] = local35
                                    local52 = createwaypoint((local10\Field1\Field3 + ((Float local37) * 2.0)), 8.2, (local10\Field1\Field5 + ((Float local38) * 2.0)), Null, local10\Field1)
                                    local10\Field1\Field31\Field4[((local38 * $13) + local37)] = local52
                                    If (local38 < $12) Then
                                        If (local10\Field1\Field31\Field4[(((local38 + $01) * $13) + local37)] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field0, local10\Field1\Field31\Field4[(((local38 + $01) * $13) + local37)]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[(((local38 + $01) * $13) + local37)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[(((local38 + $01) * $13) + local37)]
                                                    local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field31\Field4[(((local38 + $01) * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[((local38 * $13) + local37)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field31\Field4[(((local38 + $01) * $13) + local37)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field31\Field4[(((local38 + $01) * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[((local38 * $13) + local37)]
                                                    local10\Field1\Field31\Field4[(((local38 + $01) * $13) + local37)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local38 > $00) Then
                                        If (local10\Field1\Field31\Field4[(((local38 - $01) * $13) + local37)] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field0, local10\Field1\Field31\Field4[(((local38 - $01) * $13) + local37)]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[(((local38 - $01) * $13) + local37)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[(((local38 - $01) * $13) + local37)]
                                                    local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field31\Field4[(((local38 - $01) * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[((local38 * $13) + local37)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field31\Field4[(((local38 - $01) * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[((local38 * $13) + local37)]
                                                    local10\Field1\Field31\Field4[(((local38 - $01) * $13) + local37)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local37 > $00) Then
                                        If (local10\Field1\Field31\Field4[((local37 - $01) + (local38 * $13))] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field0, local10\Field1\Field31\Field4[((local37 - $01) + (local38 * $13))]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[((local37 - $01) + (local38 * $13))]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[((local37 - $01) + (local38 * $13))]
                                                    local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field31\Field4[((local37 - $01) + (local38 * $13))]\Field4[local1] = local10\Field1\Field31\Field4[((local38 * $13) + local37)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field31\Field4[((local37 - $01) + (local38 * $13))]\Field4[local1] = local10\Field1\Field31\Field4[((local38 * $13) + local37)]
                                                    local10\Field1\Field31\Field4[((local37 - $01) + (local38 * $13))]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                    If (local37 < $12) Then
                                        If (local10\Field1\Field31\Field4[((local37 + $01) + (local38 * $13))] <> Null) Then
                                            local0 = entitydistance(local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field0, local10\Field1\Field31\Field4[((local37 + $01) + (local38 * $13))]\Field0)
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[((local37 + $01) + (local38 * $13))]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = local10\Field1\Field31\Field4[((local37 + $01) + (local38 * $13))]
                                                    local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                            For local1 = $00 To $03 Step $01
                                                If (local10\Field1\Field31\Field4[((local37 + $01) + (local38 * $13))]\Field4[local1] = local10\Field1\Field31\Field4[((local38 * $13) + local37)]) Then
                                                    Exit
                                                ElseIf (local10\Field1\Field31\Field4[((local38 * $13) + local37)]\Field4[local1] = Null) Then
                                                    local10\Field1\Field31\Field4[((local37 + $01) + (local38 * $13))]\Field4[local1] = local10\Field1\Field31\Field4[((local38 * $13) + local37)]
                                                    local10\Field1\Field31\Field4[((local37 + $01) + (local38 * $13))]\Field5[local1] = local0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        Next
                        For local1 = $00 To $06 Step $01
                            local10\Field1\Field31\Field2[local1] = local28[local1]
                        Next
                        seedrnd(local39)
                        For local12 = Each items
                            If (((8.0 <= entityy(local12\Field1, $01)) And (12.0 >= entityy(local12\Field1, $01))) <> 0) Then
                                debuglog((local12\Field0 + " is within Y limits"))
                                If ((((local10\Field1\Field3 - 6.0) <= entityx(local12\Field1, $01)) And (((local10\Field1\Field3 + 38.0) + 6.0) >= entityx(local12\Field1, $01))) <> 0) Then
                                    debuglog("and within X limits")
                                EndIf
                                If ((((local10\Field1\Field5 - 6.0) <= entityz(local12\Field1, $01)) And (((local10\Field1\Field5 + 38.0) + 6.0) >= entityz(local12\Field1, $01))) <> 0) Then
                                    debuglog("and within Z limits")
                                EndIf
                            EndIf
                            If (((((((8.0 <= entityy(local12\Field1, $01)) And (12.0 >= entityy(local12\Field1, $01))) And ((local10\Field1\Field3 - 6.0) <= entityx(local12\Field1, $01))) And (((local10\Field1\Field3 + 38.0) + 6.0) >= entityx(local12\Field1, $01))) And ((local10\Field1\Field5 - 6.0) <= entityz(local12\Field1, $01))) And (((local10\Field1\Field5 + 38.0) + 6.0) >= entityz(local12\Field1, $01))) <> 0) Then
                                debuglog(local12\Field0)
                                translateentity(local12\Field1, 0.0, 0.3, 0.0, $01)
                                resetentity(local12\Field1)
                            EndIf
                        Next
                        allowroomdoorsinit = Null
                    EndIf
                    For local38 = $00 To $12 Step $01
                        For local37 = $00 To $12 Step $01
                            If (local10\Field1\Field31\Field3[((local38 * $13) + local37)] <> $00) Then
                                showentity(local10\Field1\Field31\Field3[((local38 * $13) + local37)])
                            EndIf
                        Next
                    Next
                EndIf
                local10\Field1\Field29[$00]\Field29 = updateelevators(local10\Field1\Field29[$00]\Field29, local10\Field1\Field29[$00], local10\Field1\Field29[$01], local10\Field1\Field25[$02], local10\Field1\Field25[$03], $00)
                local10\Field1\Field29[$02]\Field29 = updateelevators(local10\Field1\Field29[$02]\Field29, local10\Field1\Field29[$02], local10\Field1\Field29[$03], local10\Field1\Field25[$04], local10\Field1\Field25[$05], $00)
            Case $1869F
            Case $22
                local10\Field1\Field29[$00]\Field4 = $00
                local10\Field1\Field29[$01]\Field4 = $00
                If (local10\Field2 <> (Float local10\Field1\Field29[$00]\Field5)) Then
                    If (local10\Field7 = $00) Then
                        loadeventsound(local10, "SFX\Door\DoorCheckpoint.ogg", $00)
                    EndIf
                    local10\Field5 = playsound2(local10\Field7, camera, local10\Field1\Field29[$00]\Field0, 10.0, 1.0)
                    local10\Field6 = playsound2(local10\Field7, camera, local10\Field1\Field29[$01]\Field0, 10.0, 1.0)
                EndIf
                local10\Field2 = (Float local10\Field1\Field29[$00]\Field5)
                If (channelplaying(local10\Field5) <> 0) Then
                    updatesoundorigin(local10\Field5, camera, local10\Field1\Field29[$00]\Field0, 10.0, 1.0)
                EndIf
                If (channelplaying(local10\Field6) <> 0) Then
                    updatesoundorigin(local10\Field6, camera, local10\Field1\Field29[$01]\Field0, 10.0, 1.0)
                EndIf
            Case $27
                If (playerinroom(local10) <> 0) Then
                    If ((-2848.0 * roomscale) >= entityy(local10\Field13, $00)) Then
                        If (0.0 < entitypitch(local10\Field1\Field25[$09], $01)) Then
                            local55 = $01
                        Else
                            local55 = $00
                        EndIf
                        local2 = (updatelever(local10\Field1\Field25[$07], $00) = $00)
                        local18 = (Float updatelever(local10\Field1\Field25[$09], $00))
                        local10\Field1\Field26[$07] = $00
                        local10\Field1\Field26[$09] = $00
                        If (local18 <> (Float local55)) Then
                            If (0.0 = local18) Then
                                playsound_strict(lightsfx)
                            Else
                                playsound_strict(teslapowerupsfx)
                            EndIf
                        EndIf
                        If ((Int local18) <> 0) Then
                            local56 = $08
                            local10\Field2 = max(local10\Field2, 12600.0)
                            If (local10\Field8 = $00) Then
                                loadeventsound(local10, "SFX\Ambient\Room ambience\fuelpump.ogg", $01)
                            EndIf
                            local10\Field6 = loopsound2(local10\Field8, local10\Field6, camera, local10\Field1\Field25[$0A], 6.0, 1.0)
                        ElseIf (channelplaying(local10\Field6) <> 0) Then
                            stopchannel(local10\Field6)
                        EndIf
                    EndIf
                EndIf
                local10\Field1\Field29[$00]\Field29 = updateelevators(local10\Field1\Field29[$00]\Field29, local10\Field1\Field29[$00], local10\Field1\Field29[$01], local10\Field1\Field25[$00], local10\Field1\Field25[$01], $01)
                local10\Field1\Field29[$02]\Field29 = updateelevators(local10\Field1\Field29[$02]\Field29, local10\Field1\Field29[$02], local10\Field1\Field29[$03], local10\Field1\Field25[$02], local10\Field1\Field25[$03], $01)
            Case $4A
                infinitestamina = $01
            Case $39
                local57 = local10\Field1\Field11
                If (local57 <> Null) Then
                    local58 = $00
                    hideentity(local57\Field4)
                    For local23 = Each players
                        If (local23\Field32 = local10\Field1\Field69) Then
                            updateforest(local57, local23\Field63)
                            local58 = $01
                        EndIf
                    Next
                    If (local58 = $00) Then
                        hideforest(local57)
                    EndIf
                EndIf
                If ((playerinroom(local10) And (local57 <> Null)) <> 0) Then
                    If ((server\Field57 And server\Field60) <> 0) Then
                        For local23 = Each players
                            If (local23\Field32 = local10\Field1\Field69) Then
                                If (local23\Field94 = $00) Then
                                    If ((entityy(local57\Field4, $01) + 0.5) < entityy(local23\Field63, $00)) Then
                                        moveentity(local23\Field63, 0.0, (((entityy(local57\Field4, $01) + 0.5) - entityy(local23\Field63, $00)) * fpsfactor), 0.0)
                                    EndIf
                                EndIf
                            EndIf
                        Next
                    EndIf
                EndIf
                If (local57 <> Null) Then
                    If (server\Field57 <> 0) Then
                        For local23 = Each players
                            If (local23\Field32 = local10\Field1\Field69) Then
                                If (1.0 > (Abs distance(entityx(local10\Field1\Field25[$03], $01), entityz(local10\Field1\Field25[$03], $01), entityx(local23\Field63, $01), entityz(local23\Field63, $01)))) Then
                                    If (local23\Field93 > millisecs()) Then
                                        playsound_strict(loadtempsound("SFX\Door\WoodenDoorOpen.ogg"))
                                        showentity(local57\Field4)
                                        selecteditem = $00
                                        blinktimer = -10.0
                                        local10\Field2 = 1.0
                                        local10\Field4 = 0.0
                                        If (local10\Field1\Field30[$00] <> Null) Then
                                            local10\Field1\Field30[$00]\Field9 = 0.0
                                        EndIf
                                        local3 = createpivot($00)
                                        positionentity(local3, entityx(getcamera(local23\Field30), $01), entityy(getcamera(local23\Field30), $01), entityz(getcamera(local23\Field30), $01), $00)
                                        pointentity(local3, local10\Field1\Field2, 0.0)
                                        local59 = wrapangle((entityyaw(local3, $00) - entityyaw(local10\Field1\Field2, $01)))
                                        If (((90.0 < local59) And (270.0 > local59)) <> 0) Then
                                            positionentity(local23\Field62, entityx(local57\Field5[$00], $01), ((entityy(local57\Field5[$00], $01) + entityy(local23\Field62, $01)) + 0.5), entityz(local57\Field5[$00], $01), $01)
                                            rotateentity(local23\Field62, 0.0, (entityyaw(local57\Field5[$00], $01) - 180.0), 0.0, $01)
                                            moveentity(local23\Field62, -0.5, 0.0, 0.5)
                                            local23\Field130 = 1.0
                                        Else
                                            positionentity(local23\Field62, entityx(local57\Field5[$01], $01), ((entityy(local57\Field5[$01], $01) + entityy(local23\Field62, $01)) + 0.5), entityz(local57\Field5[$01], $01), $01)
                                            rotateentity(local23\Field62, 0.0, (entityyaw(local57\Field5[$01], $01) - 180.0), 0.0, $01)
                                            moveentity(local23\Field62, -0.5, 0.0, 0.5)
                                            local23\Field130 = 0.0
                                        EndIf
                                        freeentity(local3)
                                        resetentity(local23\Field62)
                                        setplayerpositionex(local23\Field30, local23\Field32, entityx(local23\Field62, $00), entityy(local23\Field62, $00), entityz(local23\Field62, $00))
                                    EndIf
                                Else
                                    For local1 = $00 To $01 Step $01
                                        If (1.0 > entitydistance(local57\Field5[local1], local23\Field62)) Then
                                            If (entityinview(local57\Field5[local1], getcamera(local23\Field30)) <> 0) Then
                                                local60 = $01
                                                If (local23\Field93 > millisecs()) Then
                                                    If ((Float local1) = local23\Field130) Then
                                                        blinktimer = -10.0
                                                        playsound_strict(loadtempsound("SFX\Door\WoodenDoorOpen.ogg"))
                                                        rotateentity(local10\Field1\Field25[$03], 0.0, 0.0, 0.0, $00)
                                                        rotateentity(local10\Field1\Field25[$04], 0.0, 180.0, 0.0, $00)
                                                        positionentity(local23\Field62, entityx(local10\Field1\Field25[$02], $01), 0.5, entityz(local10\Field1\Field25[$02], $01), $00)
                                                        rotateentity(local23\Field62, 0.0, (entityyaw(local10\Field1\Field2, $01) + (local23\Field130 * 180.0)), 0.0, $00)
                                                        moveentity(local23\Field62, 0.0, 0.0, 1.5)
                                                        resetentity(local23\Field62)
                                                        local61 = $00
                                                        updatedoors()
                                                        local10\Field2 = 0.0
                                                        local10\Field4 = 0.0
                                                        mp_updateplayerposition(local23, $01)
                                                        setplayerpositionex(local23\Field30, local23\Field32, entityx(local23\Field62, $00), entityy(local23\Field62, $00), entityz(local23\Field62, $00))
                                                    Else
                                                        playsound_strict(loadtempsound("SFX\Door\WoodenDoorBudge.ogg"))
                                                        local24 = $00
                                                        local25 = $15E
                                                    EndIf
                                                EndIf
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                            EndIf
                        Next
                    EndIf
                EndIf
            Case $02
                local62 = $00
                For local23 = Each players
                    If (local23\Field32 = local10\Field1\Field69) Then
                        If (local62 = $00) Then
                            showentity(local10\Field1\Field2)
                            If (local10\Field7 = $00) Then
                                loadeventsound(local10, "SFX\Room\PocketDimension\Rumble.ogg", $00)
                            EndIf
                            If (local10\Field8 = $00) Then
                                local10\Field8 = loadeventsound(local10, "SFX\Room\PocketDimension\PrisonVoices.ogg", $01)
                            EndIf
                            If (0.0 = local10\Field2) Then
                                local10\Field2 = 0.1
                            EndIf
                            scaleentity(local10\Field1\Field2, roomscale, (((sin((local10\Field2 / 14.0)) * 0.2) + 1.0) * roomscale), roomscale, $00)
                            For local1 = $00 To $07 Step $01
                                scaleentity(local10\Field1\Field25[local1], (((Abs (sin(((local10\Field2 / 21.0) + ((Float local1) * 45.0))) * 0.1)) + 1.0) * roomscale), (((sin(((local10\Field2 / 14.0) + ((Float local1) * 20.0))) * 0.1) + 1.0) * roomscale), roomscale, $01)
                            Next
                            scaleentity(local10\Field1\Field25[$09], (((Abs (sin(((local10\Field2 / 21.0) + ((Float local1) * 45.0))) * 0.1)) + 1.5) * roomscale), (((sin(((local10\Field2 / 14.0) + ((Float local1) * 20.0))) * 0.1) + 1.0) * roomscale), roomscale, $01)
                            local10\Field2 = (local10\Field2 + fpsfactor)
                            positionentity(local10\Field1\Field25[$09], (entityx(local10\Field1\Field25[$08], $01) + (3384.0 * roomscale)), 0.0, entityz(local10\Field1\Field25[$08], $01), $00)
                            translateentity(local10\Field1\Field25[$09], (cos((local10\Field2 * 0.8)) * 5.0), 0.0, (sin((local10\Field2 * 1.6)) * 4.0), $01)
                            rotateentity(local10\Field1\Field25[$09], 0.0, (local10\Field2 * 2.0), 0.0, $00)
                            positionentity(local10\Field1\Field25[$0A], entityx(local10\Field1\Field25[$08], $01), 0.0, (entityz(local10\Field1\Field25[$08], $01) + (3384.0 * roomscale)), $00)
                            translateentity(local10\Field1\Field25[$0A], (sin((local10\Field2 * 1.6)) * 4.0), 0.0, (cos((local10\Field2 * 0.8)) * 5.0), $01)
                            rotateentity(local10\Field1\Field25[$0A], 0.0, (local10\Field2 * 2.0), 0.0, $00)
                            local10\Field1\Field26[$09] = $00
                            local10\Field1\Field26[$0A] = $00
                            local62 = $01
                        EndIf
                        local23\Field61 = (local23\Field61 + (fpsfactor * 0.00005))
                        If (local23\Field131 = $01) Then
                            If (6.0 < entityy(local23\Field62, $00)) Then
                                local56 = $0F
                                camerafogcolor(camera, 38.0, 55.0, 47.0)
                                cameraclscolor(camera, 38.0, 55.0, 47.0)
                                If (entityx(local10\Field1\Field25[$14], $01) < (entityx(local10\Field1\Field25[$08], $01) - (4000.0 * roomscale))) Then
                                    local10\Field6 = playsound_strict(local10\Field8)
                                    positionentity(local10\Field1\Field25[$14], (entityx(local23\Field62, $01) + (4000.0 * roomscale)), 12.0, entityz(local23\Field62, $01), $00)
                                EndIf
                                local18 = (((- fpsfactor) * roomscale) * 4.0)
                                local19 = ((17.0 - ((Abs (entityx(local23\Field62, $00) - entityx(local10\Field1\Field25[$14], $00))) * 0.5)) - entityy(local10\Field1\Field25[$14], $00))
                                local20 = (entityz(local23\Field62, $01) - entityz(local10\Field1\Field25[$14], $00))
                                translateentity(local10\Field1\Field25[$14], local18, local19, local20, $01)
                                rotateentity(local10\Field1\Field25[$14], (-90.0 - ((entityx(local23\Field62, $00) - entityx(local10\Field1\Field25[$14], $00)) * 1.5)), -90.0, 0.0, $01)
                                local63 = $00
                                For local1 = $00 To $02 Step $01
                                    Select local1
                                        Case $00
                                            local18 = (-1452.0 * roomscale)
                                            local20 = (-37.0 * roomscale)
                                        Case $01
                                            local18 = (-121.0 * roomscale)
                                            local20 = (188.0 * roomscale)
                                        Case $02
                                            local18 = (1223.0 * roomscale)
                                            local20 = (-196.0 * roomscale)
                                    End Select
                                    local18 = (entityx(local10\Field1\Field25[$08], $01) + local18)
                                    local20 = (entityz(local10\Field1\Field25[$08], $01) + local20)
                                    If ((200.0 * roomscale) > distance(entityx(local23\Field62, $00), entityz(local23\Field62, $00), local18, local20)) Then
                                        local63 = $01
                                        Exit
                                    EndIf
                                Next
                                local0 = entitydistance(local23\Field62, local10\Field1\Field25[$14])
                                If (((local10\Field6 <> $00) And channelplaying(local10\Field6)) <> 0) Then
                                    local10\Field6 = loopsound2(local10\Field8, local10\Field6, camera, camera, 10.0, (((Float (local63 = $00)) * 0.6) + 0.3))
                                EndIf
                                If (local63 = 0) Then
                                    If (8.0 > local0) Then
                                        local10\Field5 = loopsound2(local10\Field7, local10\Field5, camera, local10\Field1\Field25[$14], 8.0, 1.0)
                                        injuries = ((((8.0 - local0) * fpsfactor) * 0.0003) + injuries)
                                        If (7.0 > local0) Then
                                            local3 = createpivot($00)
                                            positionentity(local3, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                                            pointentity(local3, local10\Field1\Field25[$14], 0.0)
                                            turnentity(local3, 90.0, 0.0, 0.0, $00)
                                            user_camera_pitch = curveangle(entitypitch(local3, $00), (user_camera_pitch + 90.0), 10.0)
                                            user_camera_pitch = (user_camera_pitch - 90.0)
                                            rotateentity(local23\Field62, entitypitch(local23\Field62, $00), curveangle(entityyaw(local3, $00), entityyaw(local23\Field62, $00), 10.0), 0.0, $00)
                                            freeentity(local3)
                                        EndIf
                                    EndIf
                                EndIf
                                camerashake = max(((((Float (local63 = $00)) * 4.0) + 4.0) - local0), 0.0)
                                If (8.5 > entityy(local23\Field62, $00)) Then
                                    loadeventsound(local10, "SFX\Room\PocketDimension\Rumble.ogg", $00)
                                    loadeventsound(local10, "SFX\Room\PocketDimension\PrisonVoices.ogg", $01)
                                    blurtimer = 1500.0
                                    local23\Field131 = $01
                                    blinktimer = -10.0
                                    positionentity(local23\Field62, (entityx(local10\Field1\Field25[$08], $01) - (400.0 * roomscale)), (-304.0 * roomscale), entityz(local10\Field1\Field25[$08], $01), $00)
                                    resetentity(local23\Field62)
                                    setplayerpositionex(local23\Field30, local23\Field32, entityx(local23\Field62, $00), entityy(local23\Field62, $00), entityz(local23\Field62, $00))
                                    camerafogcolor(camera, 0.0, 0.0, 0.0)
                                    cameraclscolor(camera, 0.0, 0.0, 0.0)
                                EndIf
                            Else
                                local10\Field4 = 0.0
                                For local1 = $09 To $0A Step $01
                                    local0 = distance(entityx(local23\Field62, $00), entityz(local23\Field62, $00), entityx(local10\Field1\Field25[local1], $01), entityz(local10\Field1\Field25[local1], $01))
                                    If (6.0 > local0) Then
                                        If (local0 < (100.0 * roomscale)) Then
                                            local3 = createpivot($00)
                                            positionentity(local3, entityx(local10\Field1\Field25[local1], $01), entityy(local23\Field62, $00), entityz(local10\Field1\Field25[local1], $01), $00)
                                            pointentity(local3, local23\Field62, 0.0)
                                            rotateentity(local3, 0.0, (Float ((Int (entityyaw(local3, $00) / 90.0)) * $5A)), 0.0, $01)
                                            moveentity(local3, 0.0, 0.0, (100.0 * roomscale))
                                            positionentity(local23\Field62, entityx(local3, $00), entityy(local23\Field62, $00), entityz(local3, $00), $00)
                                            freeentity(local3)
                                            deathmsg = "In addition to the decomposed appearance typical of SCP-106's victims, the body exhibits injuries that have not been observed before: "
                                            deathmsg = (deathmsg + "massive skull fracture, three broken ribs, fractured shoulder and multiple heavy lacerations.")
                                            playsound_strict(loadtempsound("SFX\Room\PocketDimension\Impact.ogg"))
                                            If (local23\Field59 = $00) Then
                                                giveplayerhealth(local23\Field30, -1000.0, "was killed in pocket dimension")
                                                positionentity(local23\Field62, 0.0, 1000.0, 0.0, $00)
                                                resetentity(local23\Field62)
                                                setplayerpositionex(local23\Field30, local23\Field32, entityx(local23\Field62, $00), entityy(local23\Field62, $00), entityz(local23\Field62, $00))
                                            EndIf
                                        EndIf
                                        If (1000.0 > (Float local10\Field11)) Then
                                            local10\Field5 = loopsound2(local10\Field7, local10\Field5, camera, local10\Field1\Field25[local1], 6.0, 1.0)
                                        EndIf
                                    EndIf
                                Next
                                local3 = createpivot($00)
                                positionentity(local3, (entityx(local10\Field1\Field25[$08], $01) - (1536.0 * roomscale)), (500.0 * roomscale), (entityz(local10\Field1\Field25[$08], $01) + (608.0 * roomscale)), $00)
                                If (5.0 > entitydistance(local3, local23\Field62)) Then
                                    local10\Field6 = loopsound2(local10\Field8, local10\Field6, camera, local3, 3.0, 1.0)
                                EndIf
                                freeentity(local3)
                                showentity(local10\Field1\Field25[$11])
                                positionentity(local10\Field1\Field25[$11], entityx(local10\Field1\Field25[$08], $01), (1376.0 * roomscale), (entityz(local10\Field1\Field25[$08], $01) - (2848.0 * roomscale)), $00)
                                pointentity(local10\Field1\Field25[$11], local23\Field62, 0.0)
                                turnentity(local10\Field1\Field25[$11], 0.0, 180.0, 0.0, $00)
                                local2 = (Int entitydistance(local23\Field62, local10\Field1\Field25[$11]))
                                If ((Float local2) < (2000.0 * roomscale)) Then
                                    injuries = ((fpsfactor / 4000.0) + injuries)
                                    local10\Field11 = (Str ((Float local10\Field11) + (fpsfactor / 1000.0)))
                                    If (((1.0 < (Float local10\Field11)) And (1000.0 > (Float local10\Field11))) <> 0) Then
                                        playsound_strict(loadtempsound("SFX\Room\PocketDimension\Kneel.ogg"))
                                        loadeventsound(local10, "SFX\Room\PocketDimension\Screech.ogg", $00)
                                        local10\Field11 = "1000.0"
                                        debuglog("Loaded screech sound")
                                    EndIf
                                    sanity = max((sanity - ((fpsfactor / (Float local2)) / 8.0)), -1000.0)
                                    currcamerazoom = max(currcamerazoom, (((sin(((Float millisecs2()) / 20.0)) + 1.0) * 15.0) * max(((6.0 - (Float local2)) / 6.0), 0.0)))
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                                    pointentity(local3, local10\Field1\Field25[$11], 0.0)
                                    turnentity(local3, 90.0, 0.0, 0.0, $00)
                                    user_camera_pitch = curveangle(entitypitch(local3, $00), (user_camera_pitch + 90.0), min(max((15000.0 / (- sanity)), 15.0), 500.0))
                                    user_camera_pitch = (user_camera_pitch - 90.0)
                                    rotateentity(local23\Field62, entitypitch(local23\Field62, $00), curveangle(entityyaw(local3, $00), entityyaw(local23\Field62, $00), min(max((15000.0 / (- sanity)), 15.0), 500.0)), 0.0, $00)
                                    freeentity(local3)
                                    If ((Int local23\Field26) <> 0) Then
                                        blinktimer = -10.0
                                        positionentity(local23\Field62, (entityx(local10\Field1\Field25[$08], $01) - (1344.0 * roomscale)), (2944.0 * roomscale), (entityz(local10\Field1\Field25[$08], $01) - (1184.0 * roomscale)), $00)
                                        resetentity(local23\Field62)
                                        setplayerpositionex(local23\Field30, local23\Field32, entityx(local23\Field62, $00), entityy(local23\Field62, $00), entityz(local23\Field62, $00))
                                        loadeventsound(local10, "SFX\Room\PocketDimension\Explosion.ogg", $00)
                                        loadeventsound(local10, "SFX\Room\PocketDimension\TrenchPlane.ogg", $01)
                                        positionentity(local10\Field1\Field25[$14], (entityx(local10\Field1\Field25[$08], $01) - 1000.0), 0.0, 0.0, $01)
                                        local10\Field11 = "0.0"
                                    EndIf
                                ElseIf ((-180.0 * roomscale) > entityy(local23\Field62, $00)) Then
                                    local2 = (Int distance(entityx(local23\Field62, $00), entityz(local23\Field62, $00), (entityx(local10\Field1\Field25[$08], $01) + (1024.0 * roomscale)), entityz(local10\Field1\Field25[$08], $01)))
                                    If ((Float local2) < (640.0 * roomscale)) Then
                                        blurtimer = (((640.0 * roomscale) - (Float local2)) * 3000.0)
                                        local10\Field6 = loopsound2(decaysfx(rand($01, $03)), local10\Field6, camera, local23\Field62, 2.0, ((((640.0 * roomscale) - (Float local2)) * (Abs currspeed)) * 100.0))
                                        currspeed = curvevalue(0.0, currspeed, (Float (local2 * $0A)))
                                        If ((Float local2) < (130.0 * roomscale)) Then
                                            For local9 = Each rooms
                                                If (local9\Field7\Field10 = "room2shaft") Then
                                                    giveachievement($21, $01)
                                                    local23\Field131 = $00
                                                    blurtimer = 1500.0
                                                    playerroom = local9
                                                    playsound_strict(loadtempsound("SFX\Room\PocketDimension\Exit.ogg"))
                                                    teleportentity(local23\Field62, entityx(local9\Field25[$00], $01), 0.4, entityz(local9\Field25[$00], $01), 0.3, $01, 2.0, $00)
                                                    local27 = createdecal($00, entityx(local9\Field25[$00], $01), entityy(local9\Field25[$00], $01), entityz(local9\Field25[$00], $01), 270.0, (Float rand($168, $01)), 0.0)
                                                    teleportentity(local27\Field0, entityx(local9\Field25[$00], $01), (entityy(local9\Field25[$00], $01) + 0.6), entityz(local9\Field25[$00], $01), 0.0, $01, 4.0, $01)
                                                    setplayerpositionex(local23\Field30, local9\Field69, entityx(local23\Field62, $00), entityy(local23\Field62, $00), entityz(local23\Field62, $00))
                                                    For local11 = Each events
                                                        If (local11\Field0 = "room2sl") Then
                                                            local11\Field4 = 0.0
                                                            updatelever(local11\Field1\Field28[$00], $00)
                                                            rotateentity(local11\Field1\Field28[$00], 0.0, entityyaw(local11\Field1\Field28[$00], $00), 0.0, $00)
                                                            turncheckpointmonitorsoff($00)
                                                            Exit
                                                        EndIf
                                                    Next
                                                    Exit
                                                    Return $00
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                            If ((-1600.0 * roomscale) > entityy(local23\Field62, $00)) Then
                                If ((4750.0 * roomscale) < entitydistance(local23\Field62, local10\Field1\Field25[$08])) Then
                                    camerafogcolor(camera, 0.0, 0.0, 0.0)
                                    cameraclscolor(camera, 0.0, 0.0, 0.0)
                                    dropspeed = $00
                                    blurtimer = 500.0
                                    blurtimer = 1500.0
                                    positionentity(local23\Field62, entityx(local10\Field1\Field2, $01), 0.4, entityx(local10\Field1\Field2, $01), $00)
                                    For local9 = Each rooms
                                        If (local9\Field7\Field10 = "room106") Then
                                            local10\Field2 = 0.0
                                            local23\Field131 = $00
                                            teleportentity(local23\Field62, entityx(local9\Field25[$0A], $01), 0.4, entityz(local9\Field25[$0A], $01), 0.3, $01, 2.0, $00)
                                            giveachievement($21, $01)
                                            For local11 = Each events
                                                If (local11\Field0 = "room2sl") Then
                                                    local11\Field4 = 0.0
                                                    updatelever(local11\Field1\Field28[$00], $00)
                                                    rotateentity(local11\Field1\Field28[$00], 0.0, entityyaw(local11\Field1\Field28[$00], $00), 0.0, $00)
                                                    turncheckpointmonitorsoff($00)
                                                    Exit
                                                EndIf
                                            Next
                                            Exit
                                            Return $00
                                        EndIf
                                    Next
                                    resetentity(local23\Field62)
                                    setplayerpositionex(local23\Field30, local9\Field69, entityx(local23\Field62, $00), entityy(local23\Field62, $00), entityz(local23\Field62, $00))
                                    local23\Field131 = $00
                                Else
                                    giveplayerhealth(local23\Field30, -1000.0, "was killed in pocket dimension")
                                    blurtimer = 3000.0
                                EndIf
                            EndIf
                        ElseIf (local23\Field131 = $00) Then
                            local0 = entitydistance(local23\Field62, local10\Field1\Field2)
                            If (local0 > (1700.0 * roomscale)) Then
                                blinktimer = -10.0
                                Select rand($19, $01)
                                    Case $01,$02,$03,$04
                                        playsound_strict(oldmansfx($03))
                                        local3 = createpivot($00)
                                        positionentity(local3, entityx(local23\Field62, $00), entityy(local23\Field62, $00), entityz(local23\Field62, $00), $00)
                                        pointentity(local3, local10\Field1\Field2, 0.0)
                                        moveentity(local3, 0.0, 0.0, (local0 * 1.9))
                                        positionentity(local23\Field62, entityx(local3, $00), entityy(local23\Field62, $00), entityz(local3, $00), $00)
                                        resetentity(local23\Field62)
                                        moveentity(local3, 0.0, 0.0, 0.8)
                                        positionentity(local10\Field1\Field25[$0A], entityx(local3, $00), 0.0, entityz(local3, $00), $00)
                                        rotateentity(local10\Field1\Field25[$0A], 0.0, entityyaw(local3, $00), 0.0, $01)
                                        freeentity(local3)
                                    Case $05,$06,$07,$08,$09,$0A
                                        local23\Field131 = $01
                                        blinktimer = -10.0
                                        playsound_strict(oldmansfx($03))
                                        positionentity(local23\Field62, entityx(local10\Field1\Field25[$08], $01), 0.5, entityz(local10\Field1\Field25[$08], $01), $00)
                                        resetentity(local23\Field62)
                                    Case $0B,$0C
                                        blurtimer = 500.0
                                        positionentity(local23\Field62, entityx(local10\Field1\Field2, $00), 0.5, entityz(local10\Field1\Field2, $00), $00)
                                    Case $0D,$0E,$0F
                                        blurtimer = 1500.0
                                        local23\Field131 = $01
                                        blinktimer = -10.0
                                        positionentity(local23\Field62, (entityx(local10\Field1\Field25[$08], $01) - (400.0 * roomscale)), (-304.0 * roomscale), entityz(local10\Field1\Field25[$08], $01), $00)
                                        resetentity(local23\Field62)
                                    Case $10,$11,$12,$13
                                        blurtimer = 1500.0
                                        For local9 = Each rooms
                                            If (local9\Field7\Field10 = "tunnel") Then
                                                giveachievement($21, $01)
                                                local10\Field2 = 0.0
                                                local23\Field131 = $00
                                                teleportentity(local23\Field62, entityx(local9\Field2, $01), 0.4, entityz(local9\Field2, $01), 0.3, $01, 2.0, $00)
                                                setplayerpositionex(local23\Field30, local9\Field69, entityx(local23\Field62, $00), entityy(local23\Field62, $00), entityz(local23\Field62, $00))
                                                For local11 = Each events
                                                    If (local11\Field0 = "room2sl") Then
                                                        local11\Field4 = 0.0
                                                        updatelever(local11\Field1\Field28[$00], $00)
                                                        rotateentity(local11\Field1\Field28[$00], 0.0, entityyaw(local11\Field1\Field28[$00], $00), 0.0, $00)
                                                        turncheckpointmonitorsoff($00)
                                                        Exit
                                                    EndIf
                                                Next
                                                Exit
                                                Return $00
                                            EndIf
                                        Next
                                    Case $14,$15,$16
                                        blinktimer = -10.0
                                        positionentity(local23\Field62, entityx(local10\Field1\Field25[$0C], $01), 0.6, entityz(local10\Field1\Field25[$0C], $01), $00)
                                        resetentity(local23\Field62)
                                        local23\Field131 = $0F
                                    Case $17,$18,$19
                                        blurtimer = 1500.0
                                        local23\Field131 = $01
                                        local10\Field4 = 1.0
                                        blinktimer = -10.0
                                        playsound_strict(oldmansfx($03))
                                        positionentity(local23\Field62, entityx(local10\Field1\Field25[$08], $01), (2288.0 * roomscale), entityz(local10\Field1\Field25[$08], $01), $00)
                                        resetentity(local23\Field62)
                                End Select
                                setplayerpositionex(local23\Field30, local23\Field32, entityx(local23\Field62, $00), entityy(local23\Field62, $00), entityz(local23\Field62, $00))
                            EndIf
                        Else
                            camerafogcolor(camera, 19.0, 27.5, 23.5)
                            cameraclscolor(camera, 19.0, 27.5, 23.5)
                            If (particleamount > $00) Then
                                If (rand($320, $01) = $01) Then
                                    local21 = (entityyaw(camera, $01) + rnd(150.0, 210.0))
                                    local7 = createparticle((entityx(local23\Field62, $00) + (cos(local21) * 7.5)), 0.0, (entityz(local23\Field62, $00) + (sin(local21) * 7.5)), $03, 4.0, 0.0, $9C4)
                                    entityblend(local7\Field0, $02)
                                    local7\Field9 = 0.01
                                    local7\Field16 = 0.0
                                    pointentity(local7\Field1, camera, 0.0)
                                    turnentity(local7\Field1, 0.0, 145.0, 0.0, $01)
                                    turnentity(local7\Field1, (Float rand($0A, $14)), 0.0, 0.0, $01)
                                EndIf
                            EndIf
                            If ((-1600.0 * roomscale) > entityy(local23\Field62, $00)) Then
                                If ((144.0 * roomscale) > distance(entityx(local10\Field1\Field25[$10], $01), entityz(local10\Field1\Field25[$10], $01), entityx(local23\Field62, $00), entityz(local23\Field62, $00))) Then
                                    camerafogcolor(camera, 0.0, 0.0, 0.0)
                                    cameraclscolor(camera, 0.0, 0.0, 0.0)
                                    dropspeed = $00
                                    blurtimer = 500.0
                                    positionentity(local23\Field62, entityx(local10\Field1\Field2, $00), 0.5, entityz(local10\Field1\Field2, $00), $00)
                                    resetentity(local23\Field62)
                                    local23\Field131 = $00
                                    setplayerpositionex(local23\Field30, local23\Field32, entityx(local23\Field62, $00), entityy(local23\Field62, $00), entityz(local23\Field62, $00))
                                Else
                                    giveplayerhealth(local23\Field30, -1000.0, "was killed in pocket dimension")
                                    blurtimer = 3000.0
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                Next
                If (local62 = $00) Then
                    hideentity(local10\Field1\Field2)
                EndIf
            Case $14
            Case $3D
                local10\Field1\Field29[$00]\Field4 = $01
                local10\Field1\Field29[$01]\Field4 = $01
                local66 = $00
                If (local10\Field1\Field25[$01] <> $00) Then
                    local66 = $01
                EndIf
                If (playerinroom(local10) <> 0) Then
                    If (0.0 = local10\Field2) Then
                        If (((1.4 > entitydistance(local10\Field1\Field25[$00], local10\Field13)) And (0.0 = local10\Field4)) <> 0) Then
                            local10\Field2 = 1.0
                            If (local66 <> 0) Then
                                If (local10\Field8 <> $00) Then
                                    freesound_strict(local10\Field8)
                                    local10\Field8 = $00
                                EndIf
                                local10\Field8 = loadsound_strict("SFX\Door\DoorSparks.ogg")
                                local10\Field6 = playsound2(local10\Field8, camera, local10\Field1\Field25[$01], 5.0, 1.0)
                            EndIf
                            stopchannel(local10\Field5)
                            local10\Field5 = $00
                            If (local10\Field7 <> $00) Then
                                freesound_strict(local10\Field7)
                                local10\Field7 = $00
                            EndIf
                            local10\Field7 = loadsound_strict("SFX\Door\Airlock.ogg")
                            local10\Field1\Field29[$00]\Field4 = $00
                            local10\Field1\Field29[$01]\Field4 = $00
                            usedoor(local10\Field1\Field29[$00], $01, $01, $00, $00)
                            usedoor(local10\Field1\Field29[$01], $01, $01, $00, $00)
                            playsound_strict(alarmsfx($04))
                        ElseIf (2.4 < entitydistance(local10\Field1\Field25[$00], local10\Field13)) Then
                            local10\Field4 = 0.0
                        EndIf
                    ElseIf (490.0 > local10\Field3) Then
                        local10\Field3 = (local10\Field3 + fpsfactor)
                        local10\Field1\Field29[$00]\Field5 = $00
                        local10\Field1\Field29[$01]\Field5 = $00
                        If (70.0 > local10\Field3) Then
                            If (local66 <> 0) Then
                                local3 = createpivot($00)
                                local67 = local10\Field1\Field25[$01]
                                positionentity(local3, entityx(local67, $01), (entityy(local67, $01) + rnd(0.0, 0.05)), entityz(local67, $01), $00)
                                rotateentity(local3, 0.0, (entityyaw(local67, $01) + 90.0), 0.0, $00)
                                moveentity(local3, 0.0, 0.0, 0.2)
                                If (particleamount > $00) Then
                                    For local1 = $00 To (((particleamount - $01) Shl $01) + $01) Step $01
                                        local7 = createparticle(entityx(local3, $00), entityy(local3, $00), entityz(local3, $00), $07, 0.002, 0.0, $19)
                                        local7\Field9 = rnd(0.01, 0.05)
                                        rotateentity(local7\Field1, rnd(-45.0, 0.0), (entityyaw(local3, $00) + rnd(-10.0, 10.0)), 0.0, $00)
                                        local7\Field7 = 0.0075
                                        scalesprite(local7\Field0, local7\Field7, local7\Field7)
                                        local7\Field15 = -0.05
                                    Next
                                EndIf
                                freeentity(local3)
                            EndIf
                        ElseIf (((210.0 < local10\Field3) And (385.0 > local10\Field2)) <> 0) Then
                            local3 = createpivot(local10\Field1\Field2)
                            For local1 = $00 To $01 Step $01
                                If (local10\Field1\Field7\Field10 = "room3gw") Then
                                    If (local1 = $00) Then
                                        positionentity(local3, -288.0, 416.0, 320.0, $00)
                                    Else
                                        positionentity(local3, 192.0, 416.0, 320.0, $00)
                                    EndIf
                                ElseIf (local1 = $00) Then
                                    positionentity(local3, 312.0, 416.0, -128.0, $00)
                                Else
                                    positionentity(local3, 312.0, 416.0, 224.0, $00)
                                EndIf
                                local7 = createparticle(entityx(local3, $01), entityy(local3, $01), entityz(local3, $01), $06, 0.8, 0.0, $32)
                                local7\Field9 = 0.025
                                rotateentity(local7\Field1, 90.0, 0.0, 0.0, $00)
                                local7\Field15 = -0.02
                            Next
                            freeentity(local3)
                            If (local10\Field5 = $00) Then
                                local10\Field5 = playsound2(local10\Field7, camera, local10\Field1\Field25[$00], 5.0, 1.0)
                            EndIf
                        EndIf
                    Else
                        local10\Field2 = 0.0
                        local10\Field3 = 0.0
                        local10\Field4 = 1.0
                        If (local10\Field1\Field29[$00]\Field5 = $00) Then
                            local10\Field1\Field29[$00]\Field4 = $00
                            local10\Field1\Field29[$01]\Field4 = $00
                            usedoor(local10\Field1\Field29[$00], $01, $01, $00, $00)
                            usedoor(local10\Field1\Field29[$01], $01, $01, $00, $00)
                        EndIf
                        removeevent(local10)
                    EndIf
                    If (local10 <> Null) Then
                        If (local66 <> 0) Then
                            If (channelplaying(local10\Field6) <> 0) Then
                                updatesoundorigin(local10\Field6, camera, local10\Field1\Field25[$01], 5.0, 1.0)
                            EndIf
                        EndIf
                        If (channelplaying(local10\Field5) <> 0) Then
                            updatesoundorigin(local10\Field5, camera, local10\Field1\Field25[$00], 5.0, 1.0)
                        EndIf
                    EndIf
                Else
                    local10\Field4 = 0.0
                EndIf
            Case $34
                If (playerinroom(local10) <> 0) Then
                    If (1.0 > entitydistance(local10\Field1\Field25[$03], local10\Field13)) Then
                        If (0.0 = local10\Field2) Then
                            local10\Field2 = max(local10\Field2, 1.0)
                            playsound_strict(horrorsfx($07))
                            playsound_strict(leversfx)
                        EndIf
                    EndIf
                    updatelever(local10\Field1\Field25[$01], $00)
                    local68 = (Int local10\Field3)
                    local10\Field3 = (Float updatelever(local10\Field1\Field25[$03], $00))
                    If (((0.0 < local10\Field2) And (200.0 > local10\Field2)) <> 0) Then
                        local10\Field2 = (local10\Field2 + fpsfactor)
                        rotateentity(local10\Field1\Field25[$03], curvevalue(-85.0, entitypitch(local10\Field1\Field25[$03], $00), 5.0), entityyaw(local10\Field1\Field25[$03], $00), 0.0, $00)
                    EndIf
                EndIf
            Case $49
                local10\Field24 = $00
                If (0.0 = local10\Field2) Then
                    local10\Field2 = (Float rand($01, $03))
                Else
                    local10\Field1\Field29[$00]\Field12 = (Int local10\Field2)
                EndIf
            Case $3E
                If (server\Field57 <> 0) Then
                    For local23 = Each players
                        If (local23\Field32 <> local10\Field1\Field69) Then
                            If ((entityy(local10\Field1\Field2, $00) - 0.5) < entityy(local23\Field62, $00)) Then
                                mp_setplayerroomid(local23, local10\Field1)
                            EndIf
                        EndIf
                    Next
                EndIf
            Case $42
                If (playerroom <> local10\Field1) Then
                    hideentity(local10\Field1\Field25[$00])
                Else
                    showentity(local10\Field1\Field25[$00])
                EndIf
            Case $43
                If (playerinroom(local10) <> 0) Then
                    If (player[local10\Field14]\Field32 = local10\Field1\Field69) Then
                        If (((player[local10\Field14]\Field101 = $00) And (player[local10\Field14]\Field59 = $00)) <> 0) Then
                            If ((-512.0 * roomscale) > entityy(getobject(local10), $00)) Then
                                player[local10\Field14]\Field156 = (player[local10\Field14]\Field156 + $01)
                                If (player[local10\Field14]\Field156 >= $04) Then
                                    giveplayerhealth(local10\Field14, -10000.0, "")
                                EndIf
                            Else
                                player[local10\Field14]\Field156 = $00
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case $44
                If (playerroom = local10\Field1) Then
                    For local1 = $00 To $01 Step $01
                        updatebutton(local10\Field1\Field25[local1])
                        If (((local69 = local10\Field1\Field25[local1]) And mousehit1) <> 0) Then
                            local24 = $00
                            playsound2(buttonsfx2, camera, local10\Field1\Field25[local1], 10.0, 1.0)
                            local25 = $15E
                            mousehit1 = $00
                        EndIf
                    Next
                EndIf
            Case $1F
                local10\Field1\Field29[$00]\Field29 = updateelevators(local10\Field1\Field29[$00]\Field29, local10\Field1\Field29[$00], local10\Field1\Field29[$01], local10\Field1\Field25[$04], local10\Field1\Field25[$05], $01)
                If (playerinroom(local10) <> 0) Then
                    local10\Field2 = (Float updatelever(local10\Field1\Field25[$01], $00))
                    updatelever(local10\Field1\Field25[$03], $00)
                EndIf
            Case $07
                If (playerinroom(local10) <> 0) Then
                    If (0.0 >= local10\Field3) Then
                        local10\Field1\Field29[$01]\Field4 = $00
                        local10\Field1\Field29[$04]\Field4 = $00
                        local10\Field3 = 350.0
                    Else
                        local10\Field3 = (local10\Field3 - fpsfactor)
                    EndIf
                    lightvolume = (templightvolume * 0.5)
                    tformpoint(entityx(local10\Field13, $00), entityy(local10\Field13, $00), entityz(local10\Field13, $00), $00, local10\Field1\Field2)
                    local2 = $00
                    If (730.0 < tformedx()) Then
                        giveachievement($17, $01)
                        updateworld(1.0)
                        tformpoint(entityx(local10\Field13, $00), entityy(local10\Field13, $00), entityz(local10\Field13, $00), $00, local10\Field1\Field2)
                        For local1 = $01 To $02 Step $01
                            local10\Field1\Field29[local1]\Field5 = local10\Field1\Field29[(local1 + $02)]\Field5
                            local10\Field1\Field29[local1]\Field7 = local10\Field1\Field29[(local1 + $02)]\Field7
                            positionentity(local10\Field1\Field29[local1]\Field0, entityx(local10\Field1\Field29[(local1 + $02)]\Field0, $00), entityy(local10\Field1\Field29[(local1 + $02)]\Field0, $00), entityz(local10\Field1\Field29[(local1 + $02)]\Field0, $00), $00)
                            positionentity(local10\Field1\Field29[local1]\Field1, entityx(local10\Field1\Field29[(local1 + $02)]\Field1, $00), entityy(local10\Field1\Field29[(local1 + $02)]\Field1, $00), entityz(local10\Field1\Field29[(local1 + $02)]\Field1, $00), $00)
                            local10\Field1\Field29[(local1 + $02)]\Field5 = $00
                            local10\Field1\Field29[(local1 + $02)]\Field7 = 0.0
                            positionentity(local10\Field1\Field29[(local1 + $02)]\Field0, entityx(local10\Field1\Field29[$00]\Field0, $00), entityy(local10\Field1\Field29[$00]\Field0, $00), entityz(local10\Field1\Field29[$00]\Field0, $00), $00)
                            positionentity(local10\Field1\Field29[(local1 + $02)]\Field1, entityx(local10\Field1\Field29[$00]\Field1, $00), entityy(local10\Field1\Field29[$00]\Field1, $00), entityz(local10\Field1\Field29[$00]\Field1, $00), $00)
                        Next
                        tformpoint((tformedx() - 1024.0), tformedy(), tformedz(), local10\Field1\Field2, $00)
                        hideentity(local10\Field13)
                        positionentity(local10\Field13, tformedx(), entityy(local10\Field13, $00), tformedz(), $01)
                        showentity(local10\Field13)
                        debuglog("tformedx()>720")
                        local2 = $01
                    ElseIf (-730.0 > tformedx()) Then
                        giveachievement($17, $01)
                        updateworld(1.0)
                        tformpoint(entityx(local10\Field13, $00), entityy(local10\Field13, $00), entityz(local10\Field13, $00), $00, local10\Field1\Field2)
                        For local1 = $01 To $02 Step $01
                            local10\Field1\Field29[(local1 + $02)]\Field5 = local10\Field1\Field29[local1]\Field5
                            local10\Field1\Field29[(local1 + $02)]\Field7 = local10\Field1\Field29[local1]\Field7
                            positionentity(local10\Field1\Field29[(local1 + $02)]\Field0, entityx(local10\Field1\Field29[local1]\Field0, $00), entityy(local10\Field1\Field29[local1]\Field0, $00), entityz(local10\Field1\Field29[local1]\Field0, $00), $00)
                            positionentity(local10\Field1\Field29[(local1 + $02)]\Field1, entityx(local10\Field1\Field29[local1]\Field1, $00), entityy(local10\Field1\Field29[local1]\Field1, $00), entityz(local10\Field1\Field29[local1]\Field1, $00), $00)
                            local10\Field1\Field29[local1]\Field5 = $00
                            local10\Field1\Field29[local1]\Field7 = 0.0
                            positionentity(local10\Field1\Field29[local1]\Field0, entityx(local10\Field1\Field29[$00]\Field0, $00), entityy(local10\Field1\Field29[$00]\Field0, $00), entityz(local10\Field1\Field29[$00]\Field0, $00), $00)
                            positionentity(local10\Field1\Field29[local1]\Field1, entityx(local10\Field1\Field29[$00]\Field1, $00), entityy(local10\Field1\Field29[$00]\Field1, $00), entityz(local10\Field1\Field29[$00]\Field1, $00), $00)
                        Next
                        tformpoint((tformedx() + 1024.0), tformedy(), tformedz(), local10\Field1\Field2, $00)
                        hideentity(local10\Field13)
                        positionentity(local10\Field13, tformedx(), entityy(local10\Field13, $00), tformedz(), $01)
                        showentity(local10\Field13)
                        debuglog("tformedx()<720")
                        local2 = $01
                    EndIf
                    If (local2 = $01) Then
                        local10\Field2 = (local10\Field2 + 1.0)
                        If (rand($0A, $01) = $01) Then
                            local2 = rand($00, $02)
                            playsound_strict(ambientsfx(local2, rand($00, (ambientsfxamount(local2) - $01))))
                        EndIf
                    ElseIf (local10\Field1\Field30[$00] <> Null) Then
                        If (3.0 > entitydistance(local10\Field13, local10\Field1\Field30[$00]\Field4)) Then
                            If (entityinview(local10\Field1\Field30[$00]\Field0, camera) <> 0) Then
                                currcamerazoom = ((sin(((Float millisecs2()) / 20.0)) + 1.0) * 15.0)
                                heartbeatvolume = max(curvevalue(0.3, heartbeatvolume, 2.0), heartbeatvolume)
                                heartbeatrate = max(heartbeatrate, 120.0)
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case $21,$20
                If ((Float millisecs2()) > local10\Field2) Then
                    If (playerzone > $00) Then
                        If (0.0 < entitypitch(local10\Field1\Field28[$00], $01)) Then
                            For local15 = Each securitycams
                                If ((((local15\Field21 = $00) And (local15\Field19\Field7\Field10 <> "room106")) And (local15\Field19\Field7\Field10 <> "room205")) <> 0) Then
                                    local15\Field21 = $02
                                EndIf
                                If (local15\Field19 = local10\Field1) Then
                                    local15\Field7 = $01
                                EndIf
                            Next
                        Else
                            For local15 = Each securitycams
                                If (local15\Field21 <> $01) Then
                                    local15\Field21 = $00
                                EndIf
                                If (local15\Field19 = local10\Field1) Then
                                    local15\Field7 = $00
                                EndIf
                            Next
                        EndIf
                    EndIf
                    local10\Field2 = (Float (millisecs2() + $BB8))
                EndIf
                If (playerinroom(local10) <> 0) Then
                    coffindistance = entitydistance(local10\Field13, local10\Field1\Field25[$01])
                    If (1.5 > coffindistance) Then
                        giveachievement($13, $01)
                        If ((((contained106 = $00) And (local10\Field0 = "coffin106")) And (0.0 = local10\Field3)) <> 0) Then
                            local27 = createdecal($00, entityx(local10\Field1\Field25[$01], $01), (-1531.0 * roomscale), entityz(local10\Field1\Field25[$01], $01), 90.0, (Float rand($168, $01)), 0.0)
                            local27\Field2 = 0.05
                            local27\Field1 = 0.001
                            entityalpha(local27\Field0, 0.8)
                            updatedecals()
                            local10\Field3 = 1.0
                        EndIf
                    EndIf
                    If (wearingnightvision > $00) Then
                        If ((((4.0 > coffindistance) And local70) And (wearing714 = $00)) <> 0) Then
                            local71 = point_direction(entityx(local10\Field13, $01), entityz(local10\Field13, $01), entityx(local10\Field1\Field25[$01], $01), entityz(local10\Field1\Field25[$01], $01))
                            local72 = entityyaw(local10\Field13, $00)
                            local73 = angledist(((local71 + 90.0) + sin(wrapangle((local10\Field4 / 10.0)))), local72)
                            turnentity(local10\Field13, 0.0, (local73 / 4.0), 0.0, $01)
                            local71 = (Abs point_distance(entityx(local10\Field13, $01), entityz(local10\Field13, $01), entityx(local10\Field1\Field25[$01], $01), entityz(local10\Field1\Field25[$01], $01)))
                            local72 = (min(max(((2.0 - local71) / 2.0), 0.0), 1.0) * -60.0)
                            user_camera_pitch = ((user_camera_pitch * 0.8) + (local72 * 0.2))
                            sanity = (sanity - ((fpsfactor * 1.1) / (Float wearingnightvision)))
                            restoresanity = $00
                            blurtimer = (sin((Float (millisecs2() / $0A))) * (Abs sanity))
                            If (0.0 > vomittimer) Then
                                restoresanity = $00
                                sanity = -1010.0
                            EndIf
                            If (-1000.0 > sanity) Then
                                If (wearingnightvision > $01) Then
                                    deathmsg = (chr($22) + "Class D viewed SCP-895 through a pair of digital night vision goggles, presumably enhanced by SCP-914. It might be possible that the subject ")
                                    deathmsg = ((deathmsg + "was able to resist the memetic effects partially through these goggles. The goggles have been stored for further study.") + chr($22))
                                Else
                                    deathmsg = ((chr($22) + "Class D viewed SCP-895 through a pair of digital night vision goggles, killing him.") + chr($22))
                                EndIf
                                entitytexture(nvoverlay, nvtexture, $00, $00)
                                If (-10.0 > vomittimer) Then
                                    kill("", $00)
                                EndIf
                            ElseIf (-800.0 > sanity) Then
                                If (rand($03, $01) = $01) Then
                                    entitytexture(nvoverlay, nvtexture, $00, $00)
                                EndIf
                                If (rand($06, $01) < $05) Then
                                    entitytexture(nvoverlay, gorepics(rand($00, $05)), $00, $00)
                                EndIf
                                blurtimer = 1000.0
                                If (0.0 = vomittimer) Then
                                    vomittimer = 1.0
                                EndIf
                            ElseIf (-500.0 > sanity) Then
                                If (rand($07, $01) = $01) Then
                                    entitytexture(nvoverlay, nvtexture, $00, $00)
                                EndIf
                                If (rand($32, $01) = $01) Then
                                    entitytexture(nvoverlay, gorepics(rand($00, $05)), $00, $00)
                                EndIf
                            Else
                                entitytexture(nvoverlay, nvtexture, $00, $00)
                            EndIf
                        EndIf
                    EndIf
                    If (0.0 < local10\Field4) Then
                        local10\Field4 = max((local10\Field4 - fpsfactor), 0.0)
                    EndIf
                    If (0.0 = local10\Field4) Then
                        local10\Field4 = -1.0
                        entitytexture(nvoverlay, nvtexture, $00, $00)
                        If (wearingnightvision = $01) Then
                            entitycolor(nvoverlay, 0.0, 255.0, 0.0)
                        ElseIf (wearingnightvision = $02) Then
                            entitycolor(nvoverlay, 0.0, 100.0, 255.0)
                        EndIf
                    EndIf
                    local56 = $42
                    If (updatelever(local10\Field1\Field28[$00], $00) <> 0) Then
                        For local15 = Each securitycams
                            If (((local15\Field21 = $00) And (local15\Field19\Field7\Field10 <> "room106")) <> 0) Then
                                local15\Field21 = $02
                            EndIf
                            If (local15\Field21 = $01) Then
                                entityblend(local15\Field10, $03)
                            EndIf
                            If (local15\Field19 = local10\Field1) Then
                                local15\Field7 = $01
                            EndIf
                        Next
                    Else
                        For local15 = Each securitycams
                            If (local15\Field21 <> $01) Then
                                local15\Field21 = $00
                            EndIf
                            If (local15\Field21 = $01) Then
                                entityblend(local15\Field10, $00)
                            EndIf
                            If (local15\Field19 = local10\Field1) Then
                                local15\Field7 = $00
                            EndIf
                        Next
                    EndIf
                Else
                    coffindistance = local10\Field20
                EndIf
            Case $41
                local10\Field4 = (Float updatelever(local10\Field1\Field28[$00], $00))
                If (playerinroom(local10) <> 0) Then
                    If (1.0 = local10\Field4) Then
                        updatecheckpointmonitors($00)
                        If (50.0 > monitortimer) Then
                            entitytexture(local10\Field1\Field25[$14], local10\Field1\Field35[$00], $01, $00)
                        Else
                            entitytexture(local10\Field1\Field25[$14], local10\Field1\Field35[$00], $02, $00)
                        EndIf
                    Else
                        turncheckpointmonitorsoff($00)
                        entitytexture(local10\Field1\Field25[$14], local10\Field1\Field35[$00], $00, $00)
                    EndIf
                    If (1.0 < (Abs (entityy(local10\Field1\Field29[$00]\Field2, $00) - entityy(local10\Field13, $00)))) Then
                        For local1 = $00 To $0E Step $01
                            If (((local10\Field1\Field25[local1] <> $00) And (local1 <> $07)) <> 0) Then
                                showentity(local10\Field1\Field25[local1])
                            EndIf
                        Next
                        For local15 = Each securitycams
                            If (local15\Field19 = local10\Field1) Then
                                If (local15\Field4 <> $00) Then
                                    showentity(local15\Field4)
                                EndIf
                                If (local15\Field10 <> $00) Then
                                    showentity(local15\Field10)
                                EndIf
                                Exit
                            EndIf
                        Next
                        For local1 = $00 To $03 Step $01
                            If (playerroom\Field32[local1] <> Null) Then
                                entityalpha(getchild(playerroom\Field32[local1]\Field2, $02), 0.0)
                            EndIf
                        Next
                    Else
                        For local1 = $00 To $0E Step $01
                            If (((local10\Field1\Field25[local1] <> $00) And (local1 <> $07)) <> 0) Then
                                hideentity(local10\Field1\Field25[local1])
                            EndIf
                        Next
                        For local15 = Each securitycams
                            If (local15\Field19 = local10\Field1) Then
                                If (local15\Field4 <> $00) Then
                                    hideentity(local15\Field4)
                                EndIf
                                If (local15\Field10 <> $00) Then
                                    hideentity(local15\Field10)
                                EndIf
                                Exit
                            EndIf
                        Next
                    EndIf
                EndIf
                For local11 = Each events
                    If (local11\Field22 = $2A) Then
                        If (2.0 = local11\Field2) Then
                            entitytexture(local10\Field1\Field25[$15], local10\Field1\Field35[$00], $03, $00)
                        Else
                            entitytexture(local10\Field1\Field25[$15], local10\Field1\Field35[$01], $06, $00)
                        EndIf
                        Exit
                    EndIf
                Next
            Case $1C
                If (0.0 = local10\Field2) Then
                    If (playerinroom(local10) <> 0) Then
                        local10\Field2 = (Float (rand($12C, $3E8) * $46))
                    EndIf
                ElseIf (((((playerroom\Field7\Field10 <> "pocketdimension") And (playerroom\Field7\Field10 <> "room860")) And (playerroom\Field7\Field10 <> "room1123")) And (playerroom\Field7\Field10 <> "dimension1499")) <> 0) Then
                    local10\Field2 = (local10\Field2 - fpsfactor)
                    If (1190.0 > local10\Field2) Then
                        If (1190.0 <= (local10\Field2 + fpsfactor)) Then
                            loadeventsound(local10, "SFX\SCP\682\Roar.ogg", $00)
                            local10\Field5 = playsound_strict(local10\Field7)
                        EndIf
                        If (980.0 < local10\Field2) Then
                            camerashake = 0.5
                        EndIf
                        If (((665.0 > local10\Field2) And (420.0 < local10\Field2)) <> 0) Then
                            camerashake = 2.0
                        EndIf
                        If (70.0 > local10\Field2) Then
                            If (local10\Field7 <> $00) Then
                                freesound_strict(local10\Field7)
                            EndIf
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
            Case $2D
                If (playerinroom(local10) <> 0) Then
                    If (local10\Field1\Field29[$02]\Field5 <> 0) Then
                        giveachievement($14, $01)
                        local10\Field3 = 1.0
                    EndIf
                    If (((1.0 = local10\Field3) And (playerroom = local10\Field1)) <> 0) Then
                        local56 = $16
                    EndIf
                    If (0.0 = local10\Field2) Then
                        local21 = wrapangle(entityroll(local10\Field1\Field25[$00], $00))
                        If (90.0 > local21) Then
                            rotateentity(local10\Field1\Field25[$00], 0.0, 0.0, 361.0, $00)
                        ElseIf (180.0 > local21) Then
                            rotateentity(local10\Field1\Field25[$00], 0.0, 0.0, 180.0, $00)
                        EndIf
                        If (((181.0 > local21) And (90.0 < local21)) <> 0) Then
                            For local12 = Each items
                                If (((local12\Field1 <> $00) And (local12\Field15 = $00)) <> 0) Then
                                    If (200.0 > (Abs (entityx(local12\Field1, $00) - (local10\Field1\Field3 - (712.0 * roomscale))))) Then
                                        If (104.0 > (Abs (entityy(local12\Field1, $00) - (local10\Field1\Field4 + (648.0 * roomscale))))) Then
                                            local10\Field2 = 1.0
                                            local10\Field5 = playsound2(machinesfx, camera, local10\Field1\Field25[$01], 10.0, 1.0)
                                            local10\Field1\Field29[$01]\Field16 = playsound2(loadtempsound("SFX\SCP\914\DoorClose.ogg"), camera, local10\Field1\Field29[$01]\Field0, 10.0, 1.0)
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            Next
                        EndIf
                    EndIf
                    local74 = ""
                    local21 = wrapangle(entityroll(local10\Field1\Field25[$01], $00))
                    If (22.5 > local21) Then
                        local21 = 0.0
                        local74 = "1:1"
                    ElseIf (67.5 > local21) Then
                        local21 = 40.0
                        local74 = "coarse"
                    ElseIf (180.0 > local21) Then
                        local21 = 90.0
                        local74 = "rough"
                    ElseIf (337.5 < local21) Then
                        local21 = -1.0
                        local74 = "1:1"
                    ElseIf (292.5 < local21) Then
                        local21 = -40.0
                        local74 = "fine"
                    Else
                        local21 = -90.0
                        local74 = "very fine"
                    EndIf
                    rotateentity(local10\Field1\Field25[$01], 0.0, 0.0, curvevalue(local21, entityroll(local10\Field1\Field25[$01], $00), 20.0), $00)
                    For local1 = $00 To $01 Step $01
                        If (grabbedentity = local10\Field1\Field25[local1]) Then
                            If (entityinview(local10\Field1\Field25[local1], camera) = $00) Then
                                grabbedentity = $00
                            ElseIf (1.0 < entitydistance(local10\Field1\Field25[local1], camera)) Then
                                grabbedentity = $00
                            EndIf
                        EndIf
                    Next
                    If (0.0 < local10\Field2) Then
                        local10\Field2 = (local10\Field2 + fpsfactor)
                        local10\Field1\Field29[$01]\Field5 = $00
                        If (140.0 < local10\Field2) Then
                            If (local10\Field1\Field29[$00]\Field5 = $01) Then
                                local10\Field1\Field29[$00]\Field16 = playsound2(loadtempsound("SFX\SCP\914\DoorClose.ogg"), camera, local10\Field1\Field29[$00]\Field0, 10.0, 1.0)
                            EndIf
                            local10\Field1\Field29[$00]\Field5 = $00
                        EndIf
                        If (420.0 < local10\Field2) Then
                            rotateentity(local10\Field1\Field25[$00], entitypitch(local10\Field1\Field25[$00], $00), entityyaw(local10\Field1\Field25[$00], $00), curveangle(0.0, entityroll(local10\Field1\Field25[$00], $00), 10.0), $00)
                        Else
                            rotateentity(local10\Field1\Field25[$00], entitypitch(local10\Field1\Field25[$00], $00), entityyaw(local10\Field1\Field25[$00], $00), 180.0, $00)
                        EndIf
                        If (840.0 < local10\Field2) Then
                            For local12 = Each items
                                If (((local12\Field1 <> $00) And (local12\Field15 = $00)) <> 0) Then
                                    If ((180.0 * roomscale) > distance(entityx(local12\Field1, $00), entityz(local12\Field1, $00), entityx(local10\Field1\Field25[$02], $01), entityz(local10\Field1\Field25[$02], $01))) Then
                                        use914(local12, local74, entityx(local10\Field1\Field25[$03], $01), entityy(local10\Field1\Field25[$03], $01), entityz(local10\Field1\Field25[$03], $01))
                                    EndIf
                                EndIf
                            Next
                            For local23 = Each players
                                If (local23\Field32 = local10\Field1\Field69) Then
                                    If ((170.0 * roomscale) > distance(entityx(local23\Field62, $00), entityz(local23\Field62, $00), entityx(local10\Field1\Field25[$02], $01), entityz(local10\Field1\Field25[$02], $01))) Then
                                        If (getscripts() <> 0) Then
                                            public_inqueue($45, $00)
                                            public_addparam($00, local74, $03)
                                            public_addparam($00, (Str entityx(local10\Field1\Field25[$03], $01)), $02)
                                            public_addparam($00, (Str entityy(local10\Field1\Field25[$03], $01)), $02)
                                            public_addparam($00, (Str entityz(local10\Field1\Field25[$03], $01)), $02)
                                            public_addparam($00, "0", $01)
                                            public_addparam($00, (Str local23\Field30), $01)
                                            callback($00)
                                        EndIf
                                        If (se_return_value\Field8 = $00) Then
                                            setplayerpositionex(local23\Field30, local23\Field32, entityx(local10\Field1\Field25[$03], $01), (entityy(local10\Field1\Field25[$03], $01) + 1.0), entityz(local10\Field1\Field25[$03], $01))
                                        EndIf
                                        Select local74
                                            Case "fine","very fine"
                                                local23\Field173 = 6.0
                                        End Select
                                    EndIf
                                EndIf
                            Next
                            local10\Field1\Field29[$00]\Field5 = $01
                            local10\Field1\Field29[$01]\Field5 = $01
                            rotateentity(local10\Field1\Field25[$00], 0.0, 0.0, 0.0, $00)
                            local10\Field2 = 0.0
                            local76 = loadtempsound("SFX\SCP\914\DoorOpen.ogg")
                            local10\Field1\Field29[$00]\Field16 = playsound2(local76, camera, local10\Field1\Field29[$00]\Field0, 10.0, 1.0)
                            local10\Field1\Field29[$01]\Field16 = playsound2(local76, camera, local10\Field1\Field29[$01]\Field0, 10.0, 1.0)
                        EndIf
                    EndIf
                EndIf
                updatesoundorigin(local10\Field5, camera, local10\Field1\Field25[$01], 10.0, 1.0)
            Case $36
                If (playerinroom(local10) <> 0) Then
                    showentity(local10\Field1\Field2)
                    If (local10\Field1\Field25[$00] = $00) Then
                        local10\Field1\Field25[$00] = loadmesh_strict("GFX\MAP\gateatunnel.b3d", $00)
                        positionentity(local10\Field1\Field25[$00], entityx(local10\Field1\Field2, $01), entityy(local10\Field1\Field2, $01), entityz(local10\Field1\Field2, $01), $00)
                        scaleentity(local10\Field1\Field25[$00], roomscale, roomscale, roomscale, $00)
                        entitytype(local10\Field1\Field25[$00], $01, $00)
                        entitypickmode(local10\Field1\Field25[$00], $02, $01)
                        entityparent(local10\Field1\Field25[$00], local10\Field1\Field2, $01)
                        hidedistance = 35.0
                        local77 = entityx(local10\Field1\Field25[$09], $01)
                        local78 = entityz(local10\Field1\Field25[$09], $01)
                        freeentity(local10\Field1\Field25[$09])
                        local10\Field1\Field25[$09] = loadmesh_strict("GFX\map\lightgunbase.b3d", $00)
                        scaleentity(local10\Field1\Field25[$09], roomscale, roomscale, roomscale, $00)
                        entityfx(local10\Field1\Field25[$09], $00)
                        positionentity(local10\Field1\Field25[$09], local77, (local10\Field1\Field4 + (992.0 * roomscale)), local78, $00)
                        local10\Field1\Field25[$0A] = loadmesh_strict("GFX\map\lightgun.b3d", $00)
                        entityfx(local10\Field1\Field25[$0A], $00)
                        scaleentity(local10\Field1\Field25[$0A], roomscale, roomscale, roomscale, $00)
                        positionentity(local10\Field1\Field25[$0A], local77, (local10\Field1\Field4 + (1280.0 * roomscale)), (local78 - (176.0 * roomscale)), $01)
                        entityparent(local10\Field1\Field25[$0A], local10\Field1\Field25[$09], $01)
                        rotateentity(local10\Field1\Field25[$09], 0.0, 48.0, 0.0, $00)
                        rotateentity(local10\Field1\Field25[$0A], 40.0, 0.0, 0.0, $00)
                        local10\Field2 = 1.0
                    EndIf
                EndIf
            Case $1E
                local2 = $01
                If (((245.0 < local10\Field3) And (6300.0 > local10\Field3)) <> 0) Then
                    local2 = $00
                EndIf
                If (((local2 And (entityy(local10\Field1\Field2, $01) < entityy(local10\Field13, $01))) And (4.0 > entityy(local10\Field13, $01))) <> 0) Then
                    If (local10\Field7 = $00) Then
                        local10\Field7 = loadsound_strict("SFX\Room\Tesla\Shock.ogg")
                    EndIf
                    If (0.0 = local10\Field2) Then
                        If (8.0 > local10\Field20) Then
                            hideentity(local10\Field1\Field25[$03])
                            If ((millisecs2() Mod $5DC) < $320) Then
                                showentity(local10\Field1\Field25[$04])
                            Else
                                hideentity(local10\Field1\Field25[$04])
                            EndIf
                            If (local10\Field5 = $00) Then
                                local10\Field5 = playsound2(teslaidlesfx, camera, local10\Field1\Field25[$03], 4.0, 0.5)
                            ElseIf (channelplaying(local10\Field5) = $00) Then
                                local10\Field5 = playsound2(teslaidlesfx, camera, local10\Field1\Field25[$03], 4.0, 0.5)
                            EndIf
                            For local1 = $00 To $02 Step $01
                                If ((300.0 * roomscale) > distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), entityx(local10\Field1\Field25[local1], $01), entityz(local10\Field1\Field25[local1], $01))) Then
                                    If (0.0 <= killtimer) Then
                                        playersoundvolume = max(8.0, playersoundvolume)
                                        stopchannel(local10\Field5)
                                        local10\Field5 = playsound2(teslaactivatesfx, camera, local10\Field1\Field25[$03], 4.0, 0.5)
                                        local10\Field2 = 1.0
                                        Exit
                                    EndIf
                                EndIf
                            Next
                        Else
                            hideentity(local10\Field1\Field25[$04])
                        EndIf
                    Else
                        local10\Field2 = (local10\Field2 + fpsfactor)
                        If (40.0 >= local10\Field2) Then
                            hideentity(local10\Field1\Field25[$03])
                            If ((millisecs2() Mod $64) < $32) Then
                                showentity(local10\Field1\Field25[$04])
                            Else
                                hideentity(local10\Field1\Field25[$04])
                            EndIf
                        Else
                            If (40.0 >= (local10\Field2 - fpsfactor)) Then
                                playsound2(local10\Field7, camera, local10\Field1\Field25[$02], 10.0, 1.0)
                            EndIf
                            If (70.0 > local10\Field2) Then
                                If (0.0 <= killtimer) Then
                                    For local1 = $00 To $02 Step $01
                                        If ((250.0 * roomscale) > distance(entityx(collider, $00), entityz(collider, $00), entityx(local10\Field1\Field25[local1], $01), entityz(local10\Field1\Field25[local1], $01))) Then
                                            showentity(light)
                                            lightflash = 0.4
                                        EndIf
                                    Next
                                EndIf
                                hideentity(local10\Field1\Field25[$03])
                                hideentity(local10\Field1\Field25[$04])
                                If (rand($05, $01) < $05) Then
                                    positiontexture(teslatexture, 0.0, rnd(0.0, 1.0))
                                    showentity(local10\Field1\Field25[$03])
                                EndIf
                            Else
                                If (70.0 > (local10\Field2 - fpsfactor)) Then
                                    stopchannel(local10\Field5)
                                    local10\Field5 = playsound2(teslapowerupsfx, camera, local10\Field1\Field25[$03], 4.0, 0.5)
                                EndIf
                                hideentity(local10\Field1\Field25[$03])
                                If (150.0 < local10\Field2) Then
                                    local10\Field2 = 0.0
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                Else
                    hideentity(local10\Field1\Field25[$04])
                EndIf
            Case $35
                local10\Field24 = $00
                local10\Field1\Field29[$00]\Field29 = updateelevators(local10\Field1\Field29[$00]\Field29, local10\Field1\Field29[$00], gateaevent\Field1\Field29[$01], local10\Field1\Field25[$00], local10\Field1\Field25[$01], $01)
            Case $37
                local10\Field24 = $00
                If (playerinroom(local10) <> 0) Then
                    If (local10\Field1\Field25[$17] = $00) Then
                        local3 = createpivot($00)
                        positionentity(local3, entityx(local10\Field1\Field25[$00], $01), entityy(local10\Field1\Field25[$00], $01), entityz(local10\Field1\Field25[$00], $01), $00)
                        local10\Field1\Field25[$17] = loadmesh_strict("GFX\map\exit1terrain.b3d", local10\Field1\Field2)
                        scaleentity(local10\Field1\Field25[$17], roomscale, roomscale, roomscale, $01)
                        rotateentity(local10\Field1\Field25[$17], 0.0, (Float local10\Field1\Field6), 0.0, $01)
                        positionentity(local10\Field1\Field25[$17], entityx(local3, $00), entityy(local3, $00), entityz(local3, $00), $01)
                        freeentity(local3)
                    EndIf
                EndIf
                local10\Field1\Field29[$00]\Field29 = updateelevators(local10\Field1\Field29[$00]\Field29, local10\Field1\Field29[$00], local10\Field1\Field29[$01], local10\Field1\Field25[$08], local10\Field1\Field25[$09], $01)
            Case $3F
            Case $40
                If (15.0 > local10\Field20) Then
                    local10\Field2 = 2.0
                    If (2.0 > local10\Field2) Then
                        If (0.0 = local10\Field2) Then
                            loadeventsound(local10, "SFX\Character\Scientist\EmilyScream.ogg", $00)
                            local10\Field5 = playsound2(local10\Field7, camera, local10\Field1\Field25[$00], 100.0, 1.0)
                            local27 = createdecal($00, entityx(local10\Field1\Field25[$00], $01), (local10\Field1\Field4 + (2.0 * roomscale)), entityz(local10\Field1\Field25[$00], $01), 90.0, (Float rand($168, $01)), 0.0)
                            local27\Field2 = 0.5
                            entityalpha(local27\Field0, 0.8)
                            entityfx(local27\Field0, $01)
                            local10\Field2 = 1.0
                        ElseIf (1.0 = local10\Field2) Then
                            If (channelplaying(local10\Field5) = $00) Then
                                local10\Field2 = 2.0
                                local10\Field1\Field29[$00]\Field4 = $00
                            Else
                                updatesoundorigin(local10\Field5, camera, local10\Field1\Field25[$00], 100.0, 1.0)
                            EndIf
                        EndIf
                    Else
                        debuglog("Removed 'room2scps2' event")
                        local10\Field1\Field29[$00]\Field4 = $00
                        local27 = createdecal($00, entityx(local10\Field1\Field25[$00], $01), (local10\Field1\Field4 + (2.0 * roomscale)), entityz(local10\Field1\Field25[$00], $01), 90.0, (Float rand($168, $01)), 0.0)
                        local27\Field2 = 0.5
                        entityalpha(local27\Field0, 0.8)
                        entityfx(local27\Field0, $01)
                        removeevent(local10)
                    EndIf
                EndIf
            Case $25
                If (((0.0 = local10\Field2) Or (local10\Field25 = Null)) <> 0) Then
                    local27 = createdecal($00, (entityx(local10\Field1\Field2, $00) + rnd(-0.5, 0.5)), 0.01, (entityz(local10\Field1\Field2, $00) + rnd(-0.5, 0.5)), 90.0, (Float rand($168, $01)), 0.0)
                    local27\Field2 = 2.5
                    scalesprite(local27\Field0, local27\Field2, local27\Field2)
                    local10\Field25 = local27
                    local10\Field2 = 1.0
                ElseIf (playerinroom(local10) <> 0) Then
                    If (local10\Field7 = $00) Then
                        local10\Field7 = loadsound_strict("SFX\Room\Sinkhole.ogg")
                    Else
                        local10\Field5 = loopsound2(local10\Field7, local10\Field5, camera, local10\Field1\Field2, 4.5, 1.5)
                    EndIf
                    If (server\Field57 <> 0) Then
                        For local23 = Each players
                            If (local23\Field32 = local10\Field1\Field69) Then
                                local0 = distance(entityx(local23\Field62, $00), entityz(local23\Field62, $00), entityx(local10\Field1\Field2, $00), entityz(local10\Field1\Field2, $00))
                                If (2.0 > local0) Then
                                    currstepsfx = $01
                                    local23\Field84 = curvevalue(0.0, local23\Field84, max((local0 * 50.0), 1.0))
                                    crouchstate = ((2.0 - local0) / 2.0)
                                    If (mp_isascp(local23\Field36) = $00) Then
                                        If (0.5 > local0) Then
                                            local23\Field84 = curvevalue(0.0, local23\Field84, max((local0 * 50.0), 1.0))
                                            local23\Field141 = min((local23\Field141 + (fpsfactor / 200.0)), 2.0)
                                            lightblink = min((local23\Field141 * 5.0), 10.0)
                                            If (2.0 = local23\Field141) Then
                                                movetopocketdimension(local23\Field30)
                                                local23\Field141 = 0.0
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        Next
                    EndIf
                EndIf
            Case $38
                If (playerinroom(local10) <> 0) Then
                    If (((0.0 = local10\Field2) Or (local10\Field1\Field25[$00] = $00)) <> 0) Then
                        If (((local10\Field11 = "") And (quickloadpercent = $FFFFFFFF)) <> 0) Then
                            quickloadpercent = $00
                            quickload_currevent = local10
                            local10\Field11 = "load0"
                        EndIf
                        If (local10\Field1\Field25[$03] <> $00) Then
                            hideentity(local10\Field1\Field25[$03])
                            hideentity(local10\Field1\Field25[$04])
                            hideentity(local10\Field1\Field25[$05])
                            hideentity(local10\Field1\Field25[$06])
                        EndIf
                        If (local10\Field1\Field29[$01]\Field5 = $01) Then
                            local10\Field2 = 1.0
                            giveachievement($09, $01)
                        EndIf
                    Else
                        local56 = $10
                        If (65.0 > local10\Field2) Then
                            If (2.0 > distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), entityx(local10\Field1\Field25[$00], $01), entityz(local10\Field1\Field25[$00], $01))) Then
                                playsound_strict(loadtempsound("SFX\SCP\205\Enter.ogg"))
                                local10\Field2 = max(local10\Field2, 65.0)
                                showentity(local10\Field1\Field25[$03])
                                showentity(local10\Field1\Field25[$04])
                                showentity(local10\Field1\Field25[$05])
                                hideentity(local10\Field1\Field25[$06])
                                setanimtime(local10\Field1\Field25[$03], 492.0, $00)
                                setanimtime(local10\Field1\Field25[$04], 434.0, $00)
                                setanimtime(local10\Field1\Field25[$05], 434.0, $00)
                                local10\Field1\Field29[$00]\Field5 = $00
                            EndIf
                            If (7.0 < local10\Field2) Then
                                If (rand($00, $12C) = $01) Then
                                    local10\Field1\Field29[$00]\Field5 = (local10\Field1\Field29[$00]\Field5 = $00)
                                EndIf
                            EndIf
                            local10\Field3 = (local10\Field3 + fpsfactor)
                        EndIf
                        Select local10\Field2
                            Case 1.0
                                showentity(local10\Field1\Field25[$01])
                                hideentity(local10\Field1\Field25[$05])
                                hideentity(local10\Field1\Field25[$04])
                                hideentity(local10\Field1\Field25[$03])
                                showentity(local10\Field1\Field25[$06])
                                animate2(local10\Field1\Field25[$06], animtime(local10\Field1\Field25[$06]), $20E, $212, 0.2, $01)
                                If (1400.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                EndIf
                            Case 3.0
                                showentity(local10\Field1\Field25[$01])
                                hideentity(local10\Field1\Field25[$05])
                                hideentity(local10\Field1\Field25[$04])
                                hideentity(local10\Field1\Field25[$03])
                                showentity(local10\Field1\Field25[$06])
                                animate2(local10\Field1\Field25[$06], animtime(local10\Field1\Field25[$06]), $179, $20D, 0.2, $01)
                                If (2100.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                EndIf
                            Case 5.0
                                showentity(local10\Field1\Field25[$01])
                                hideentity(local10\Field1\Field25[$05])
                                hideentity(local10\Field1\Field25[$04])
                                hideentity(local10\Field1\Field25[$03])
                                showentity(local10\Field1\Field25[$06])
                                animate2(local10\Field1\Field25[$06], animtime(local10\Field1\Field25[$06]), $E4, $178, 0.2, $01)
                                If (2800.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                    playsound2(loadtempsound("SFX\SCP\205\Horror.ogg"), camera, local10\Field1\Field25[$06], 10.0, 0.3)
                                EndIf
                            Case 7.0
                                showentity(local10\Field1\Field25[$01])
                                showentity(local10\Field1\Field25[$06])
                                hideentity(local10\Field1\Field25[$04])
                                hideentity(local10\Field1\Field25[$03])
                                showentity(local10\Field1\Field25[$05])
                                animate2(local10\Field1\Field25[$05], animtime(local10\Field1\Field25[$05]), $1F4, $288, 0.2, $01)
                                If (4200.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                    playsound2(loadtempsound("SFX\SCP\205\Horror.ogg"), camera, local10\Field1\Field25[$06], 10.0, 0.5)
                                EndIf
                            Case 9.0
                                showentity(local10\Field1\Field25[$01])
                                showentity(local10\Field1\Field25[$06])
                                showentity(local10\Field1\Field25[$05])
                                hideentity(local10\Field1\Field25[$03])
                                showentity(local10\Field1\Field25[$04])
                                animate2(local10\Field1\Field25[$04], animtime(local10\Field1\Field25[$04]), $02, $C8, 0.2, $01)
                                animate2(local10\Field1\Field25[$05], animtime(local10\Field1\Field25[$05]), $04, $7D, 0.2, $01)
                                If (5600.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                    playsound_strict(loadtempsound("SFX\SCP\205\Horror.ogg"))
                                EndIf
                            Case 11.0
                                showentity(local10\Field1\Field25[$01])
                                showentity(local10\Field1\Field25[$06])
                                showentity(local10\Field1\Field25[$05])
                                showentity(local10\Field1\Field25[$04])
                                showentity(local10\Field1\Field25[$03])
                                animate2(local10\Field1\Field25[$03], animtime(local10\Field1\Field25[$03]), $02, $E2, 0.2, $01)
                                animate2(local10\Field1\Field25[$04], animtime(local10\Field1\Field25[$04]), $02, $C8, 0.2, $01)
                                animate2(local10\Field1\Field25[$05], animtime(local10\Field1\Field25[$05]), $04, $7D, 0.2, $01)
                                If (5950.0 < local10\Field3) Then
                                    local10\Field2 = (local10\Field2 + 1.0)
                                EndIf
                            Case 13.0
                                showentity(local10\Field1\Field25[$01])
                                showentity(local10\Field1\Field25[$06])
                                showentity(local10\Field1\Field25[$05])
                                showentity(local10\Field1\Field25[$04])
                                showentity(local10\Field1\Field25[$03])
                                If (227.0 <> animtime(local10\Field1\Field25[$06])) Then
                                    setanimtime(local10\Field1\Field25[$06], 227.0, $00)
                                EndIf
                                animate2(local10\Field1\Field25[$03], animtime(local10\Field1\Field25[$03]), $02, $1EB, 0.05, $01)
                                animate2(local10\Field1\Field25[$04], animtime(local10\Field1\Field25[$04]), $C5, $1B1, 0.05, $01)
                                animate2(local10\Field1\Field25[$05], animtime(local10\Field1\Field25[$05]), $02, $1B1, 0.05, $01)
                            Case 66.0
                                showentity(local10\Field1\Field25[$01])
                                animate2(local10\Field1\Field25[$03], animtime(local10\Field1\Field25[$03]), $1EC, $216, 0.1, $00)
                                animate2(local10\Field1\Field25[$04], animtime(local10\Field1\Field25[$04]), $1B2, $1D2, 0.1, $00)
                                animate2(local10\Field1\Field25[$05], animtime(local10\Field1\Field25[$05]), $1B2, $1EE, 0.1, $00)
                                If (515.0 < animtime(local10\Field1\Field25[$03])) Then
                                    If (533.0 < animtime(local10\Field1\Field25[$03])) Then
                                        local10\Field2 = 67.0
                                        local10\Field3 = 0.0
                                        local10\Field4 = 0.0
                                        hideentity(local10\Field1\Field25[$01])
                                    EndIf
                                EndIf
                            Case 67.0
                                If (((rand($96, $01) = $01) And ((2.0 > distance(entityx(local10\Field13, $00), entityz(local10\Field13, $00), entityx(local10\Field1\Field25[$00], $01), entityz(local10\Field1\Field25[$00], $01))) And (local10\Field13 = collider))) <> 0) Then
                                    deathmsg = "The SCP-205 cycle seems to have resumed its normal course after the anomalies observed during "
                                    deathmsg = (deathmsg + "[REDACTED]. The body of subject D-9341 was discovered inside the chamber. ")
                                    deathmsg = (deathmsg + "The subject exhibits signs of blunt force trauma typical for personnel who have ")
                                    deathmsg = (deathmsg + "entered the chamber when the lights are off.")
                                    injuries = (rnd(0.4, 0.8) + injuries)
                                    playsound_strict(damagesfx(rand($02, $03)))
                                    camerashake = 0.5
                                    local10\Field3 = rnd(-0.1, 0.1)
                                    local10\Field4 = rnd(-0.1, 0.1)
                                    If (5.0 < injuries) Then
                                        kill("", $00)
                                    EndIf
                                EndIf
                                translateentity(local10\Field13, local10\Field3, 0.0, local10\Field4, $00)
                                local10\Field3 = curvevalue(local10\Field3, 0.0, 10.0)
                                local10\Field4 = curvevalue(local10\Field4, 0.0, 10.0)
                            Default
                                If (rand($03, $01) = $01) Then
                                    hideentity(local10\Field1\Field25[$01])
                                Else
                                    showentity(local10\Field1\Field25[$01])
                                EndIf
                                local10\Field4 = (local10\Field4 + fpsfactor)
                                If (50.0 < local10\Field4) Then
                                    showentity(local10\Field1\Field25[$01])
                                    local10\Field2 = (local10\Field2 + 1.0)
                                    local10\Field4 = 0.0
                                EndIf
                        End Select
                    EndIf
                ElseIf (local10\Field1\Field25[$03] <> $00) Then
                    hideentity(local10\Field1\Field25[$03])
                    hideentity(local10\Field1\Field25[$04])
                    hideentity(local10\Field1\Field25[$05])
                    hideentity(local10\Field1\Field25[$06])
                Else
                    local10\Field2 = 0.0
                    local10\Field11 = ""
                EndIf
            Case $26
                If (playerinroom(local10) <> 0) Then
                    If (0.0 = local10\Field2) Then
                        local10\Field2 = 1.0
                    EndIf
                    If (playerroom = local10\Field1) Then
                        local56 = $04
                    EndIf
                    If (remotedooron <> 0) Then
                        If (local10\Field1\Field29[$00]\Field5 <> 0) Then
                            If (((50.0 < local10\Field1\Field29[$00]\Field7) Or (0.5 > entitydistance(local10\Field13, local10\Field1\Field29[$00]\Field2))) <> 0) Then
                                local10\Field1\Field29[$00]\Field7 = min(local10\Field1\Field29[$00]\Field7, 50.0)
                                local10\Field1\Field29[$00]\Field5 = $00
                                playsound_strict(loadtempsound("SFX\Door\DoorError.ogg"))
                            EndIf
                        EndIf
                    ElseIf (10000.0 > local10\Field2) Then
                        If (1.0 = local10\Field2) Then
                            local10\Field2 = 2.0
                        ElseIf (2.0 = local10\Field2) Then
                            If (3.0 > entitydistance(local10\Field1\Field25[$00], local10\Field13)) Then
                                giveachievement($05, $01)
                                local10\Field2 = 3.0
                                local10\Field3 = 1.0
                                local10\Field5 = streamsound_strict("SFX\SCP\079\Speech.ogg", (Float local80), $00)
                                local10\Field9 = $01
                            EndIf
                        ElseIf (2000.0 > local10\Field2) Then
                            If (isstreamplaying_strict(local10\Field5) <> 0) Then
                                If (rand($03, $01) = $01) Then
                                    entitytexture(local10\Field1\Field25[$01], oldaipics($00), $00, $00)
                                    showentity(local10\Field1\Field25[$01])
                                ElseIf (rand($0A, $01) = $01) Then
                                    hideentity(local10\Field1\Field25[$01])
                                EndIf
                            Else
                                If (local10\Field5 <> $00) Then
                                    stopstream_strict(local10\Field5)
                                    local10\Field5 = $00
                                EndIf
                                entitytexture(local10\Field1\Field25[$01], oldaipics($01), $00, $00)
                                showentity(local10\Field1\Field25[$01])
                                local10\Field2 = (local10\Field2 + fpsfactor)
                            EndIf
                        ElseIf (2.5 > entitydistance(local10\Field1\Field25[$00], local10\Field13)) Then
                            local10\Field2 = 10001.0
                            If (local10\Field5 <> $00) Then
                                stopstream_strict(local10\Field5)
                                local10\Field5 = $00
                            EndIf
                            local10\Field5 = streamsound_strict("SFX\SCP\079\Refuse.ogg", (Float local80), $00)
                        EndIf
                    ElseIf (local10\Field5 <> $00) Then
                        If (isstreamplaying_strict(local10\Field5) = $00) Then
                            local10\Field5 = $00
                            entitytexture(local10\Field1\Field25[$01], oldaipics($01), $00, $00)
                            showentity(local10\Field1\Field25[$01])
                        ElseIf (rand($03, $01) = $01) Then
                            entitytexture(local10\Field1\Field25[$01], oldaipics($00), $00, $00)
                            showentity(local10\Field1\Field25[$01])
                        ElseIf (rand($0A, $01) = $01) Then
                            hideentity(local10\Field1\Field25[$01])
                        EndIf
                    EndIf
                EndIf
                If (1.0 = local10\Field3) Then
                    If (remotedooron <> 0) Then
                        If (local10\Field5 <> $00) Then
                            stopstream_strict(local10\Field5)
                            local10\Field5 = $00
                        EndIf
                        local10\Field5 = streamsound_strict("SFX\SCP\079\GateB.ogg", (Float local80), $00)
                        local10\Field9 = $01
                        local10\Field3 = 2.0
                        For local11 = Each events
                            If (((local11\Field0 = "exit1") Or (local11\Field0 = "gateaentrance")) <> 0) Then
                                local11\Field4 = 1.0
                            EndIf
                        Next
                    EndIf
                EndIf
            Case $0E
                local10\Field1\Field29[$00]\Field29 = updateelevators(local10\Field1\Field29[$00]\Field29, local10\Field1\Field29[$00], local10\Field1\Field29[$01], local10\Field1\Field25[$00], local10\Field1\Field25[$01], $01)
                local10\Field1\Field29[$02]\Field29 = updateelevators(local10\Field1\Field29[$02]\Field29, local10\Field1\Field29[$02], local10\Field1\Field29[$03], local10\Field1\Field25[$02], local10\Field1\Field25[$03], $01)
                If (playerinroom(local10) <> 0) Then
                    If ((-4600.0 * roomscale) > entityy(local10\Field13, $00)) Then
                        If (0.0 = local10\Field2) Then
                            local10\Field2 = 1.0
                        EndIf
                        If (local10\Field1\Field29[$04]\Field5 = $00) Then
                            If (updatelever(local10\Field1\Field28[$00], $00) <> 0) Then
                                local10\Field1\Field29[$04]\Field5 = $01
                                If (local10\Field8 <> $00) Then
                                    freesound_strict(local10\Field8)
                                    local10\Field8 = $00
                                EndIf
                                local10\Field8 = loadsound_strict("SFX\Door\Door2Open1_dist.ogg")
                                local10\Field6 = playsound2(local10\Field8, camera, local10\Field1\Field29[$04]\Field0, 400.0, 1.0)
                            EndIf
                            If (updatelever(local10\Field1\Field28[$01], $00) <> 0) Then
                                local10\Field1\Field29[$04]\Field5 = $01
                                If (local10\Field8 <> $00) Then
                                    freesound_strict(local10\Field8)
                                    local10\Field8 = $00
                                EndIf
                                local10\Field8 = loadsound_strict("SFX\Door\Door2Open1_dist.ogg")
                                local10\Field6 = playsound2(local10\Field8, camera, local10\Field1\Field29[$04]\Field0, 400.0, 1.0)
                            EndIf
                        EndIf
                        updatelever(local10\Field1\Field28[$00], local10\Field1\Field29[$04]\Field5)
                        updatelever(local10\Field1\Field28[$01], local10\Field1\Field29[$04]\Field5)
                        If (channelplaying(local10\Field6) <> 0) Then
                            updatesoundorigin(local10\Field6, camera, local10\Field1\Field29[$04]\Field0, 400.0, 1.0)
                        EndIf
                        playerfallingpickdistance = 0.0
                        If (player[local10\Field14]\Field32 = local10\Field1\Field69) Then
                            If (((player[local10\Field14]\Field101 = $00) And (player[local10\Field14]\Field59 = $00)) <> 0) Then
                                If ((-6400.0 * roomscale) > entityy(player[local10\Field14]\Field62, $00)) Then
                                    player[local10\Field14]\Field156 = (player[local10\Field14]\Field156 + $01)
                                    If (player[local10\Field14]\Field156 >= $04) Then
                                        giveplayerhealth(local10\Field14, -10000.0, "")
                                    EndIf
                                Else
                                    player[local10\Field14]\Field156 = $00
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case $18
                local10\Field1\Field29[$00]\Field4 = $00
                local10\Field1\Field29[$01]\Field4 = $00
            Case $0B
                If (playerinroom(local10) <> 0) Then
                    turnentity(local10\Field1\Field25[$00], (local10\Field4 * fpsfactor), 0.0, 0.0, $00)
                    If (0.01 < local10\Field4) Then
                        local10\Field1\Field10 = loopsound2(roomambience[$09], local10\Field1\Field10, camera, local10\Field1\Field25[$00], 5.0, (local10\Field4 / 4.0))
                    EndIf
                    local10\Field4 = curvevalue((local10\Field3 * 5.0), local10\Field4, 150.0)
                EndIf
                If (16.0 > local10\Field20) Then
                    If (0.0 > local10\Field2) Then
                        local10\Field2 = (Float (rand($0F, $1E) * $46))
                        local2 = (Int local10\Field3)
                        local10\Field3 = (Float rand($00, $01))
                        If (playerinroom(local10) = $00) Then
                            local10\Field4 = (local10\Field3 * 5.0)
                        ElseIf (((local2 = $00) And (1.0 = local10\Field3)) <> 0) Then
                            playsound2(loadtempsound("SFX\ambient\Room ambience\FanOn.ogg"), camera, local10\Field1\Field25[$00], 8.0, 1.0)
                        ElseIf (((local2 = $01) And (0.0 = local10\Field3)) <> 0) Then
                            playsound2(loadtempsound("SFX\ambient\Room ambience\FanOff.ogg"), camera, local10\Field1\Field25[$00], 8.0, 1.0)
                        EndIf
                    Else
                        local10\Field2 = (local10\Field2 - fpsfactor)
                    EndIf
                EndIf
            Case $01
                local10\Field24 = $00
                local10\Field1\Field26[$00] = $00
                local10\Field1\Field26[$01] = $00
                If (local10\Field1\Field29[$05] = Null) Then
                    For local1 = $00 To $03 Step $01
                        If (local10\Field1\Field33[local1] <> Null) Then
                            local10\Field1\Field29[$05] = local10\Field1\Field33[local1]
                            local10\Field1\Field29[$05]\Field5 = $01
                            Exit
                        EndIf
                    Next
                EndIf
                If (0.0 = local10\Field2) Then
                    local10\Field1\Field29[$02]\Field5 = $01
                    showentity(fog)
                    ambientlight((Float brightness), (Float brightness), (Float brightness))
                    camerafogrange(camera, camerafognear, camerafogfar)
                    camerafogmode(camera, $01)
                    While (180.0 > local10\Field1\Field29[$01]\Field7)
                        local10\Field1\Field29[$01]\Field7 = min(180.0, (local10\Field1\Field29[$01]\Field7 + 0.8))
                        moveentity(local10\Field1\Field29[$01]\Field0, (sin(local10\Field1\Field29[$01]\Field7) / 180.0), 0.0, 0.0)
                        moveentity(local10\Field1\Field29[$01]\Field1, ((- sin(local10\Field1\Field29[$01]\Field7)) / 180.0), 0.0, 0.0)
                    Wend
                    local10\Field2 = 1.0
                    local10\Field3 = 1.0
                Else
                    If (500.0 <= local10\Field2) Then
                        local10\Field2 = (local10\Field2 + fpsfactor)
                        positionentity(local10\Field1\Field25[$00], entityx(local10\Field1\Field25[$00], $01), ((- max((local10\Field2 - 1300.0), 0.0)) / 4500.0), entityz(local10\Field1\Field25[$00], $01), $01)
                        rotateentity(local10\Field1\Field25[$00], ((- max((local10\Field2 - 1320.0), 0.0)) / 130.0), 0.0, ((- max((local10\Field2 - 1300.0), 0.0)) / 40.0), $01)
                        positionentity(local10\Field1\Field25[$01], entityx(local10\Field1\Field25[$01], $01), ((- max((local10\Field2 - 1800.0), 0.0)) / 5000.0), entityz(local10\Field1\Field25[$01], $01), $01)
                        rotateentity(local10\Field1\Field25[$01], ((- max((local10\Field2 - 2040.0), 0.0)) / 135.0), 0.0, ((- max((local10\Field2 - 2040.0), 0.0)) / 43.0), $01)
                        If (2.5 > entitydistance(local10\Field1\Field25[$00], local10\Field13)) Then
                            If (rand($12C, $01) = $02) Then
                                playsound2(decaysfx(rand($01, $03)), camera, local10\Field1\Field25[$00], 3.0, 1.0)
                            EndIf
                        EndIf
                    EndIf
                    If (2000.0 > local10\Field2) Then
                        If (local10\Field5 = $00) Then
                            local10\Field5 = playsound_strict(alarmsfx($00))
                        ElseIf (channelplaying(local10\Field5) = $00) Then
                            local10\Field5 = playsound_strict(alarmsfx($00))
                        EndIf
                    EndIf
                    If (11.0 > local10\Field4) Then
                        If (channelplaying(local10\Field6) = $00) Then
                            local10\Field4 = (local10\Field4 + 1.0)
                            If (local10\Field8 <> $00) Then
                                freesound_strict(local10\Field8)
                                local10\Field8 = $00
                            EndIf
                            local10\Field8 = loadsound_strict((("SFX\Alarm\Alarm2_" + (Str (Int local10\Field4))) + ".ogg"))
                            local10\Field6 = playsound_strict(local10\Field8)
                        ElseIf ((Int local10\Field4) = $08) Then
                            camerashake = 1.0
                        EndIf
                    EndIf
                    If (((300.0 < (local10\Field2 Mod 600.0)) And (300.0 > ((local10\Field2 + fpsfactor) Mod 600.0))) <> 0) Then
                        local1 = (Int (floor(((local10\Field2 - 5000.0) / 600.0)) + 1.0))
                        If (local1 = $00) Then
                            playsound_strict(loadtempsound("SFX\Room\Intro\PA\scripted\scripted6.ogg"))
                        EndIf
                        If (((local1 > $00) And (local1 < $1A)) <> 0) Then
                            If (commotionstate(local1) = $00) Then
                                playsound_strict(loadtempsound((("SFX\Room\Intro\Commotion\Commotion" + (Str local1)) + ".ogg")))
                                commotionstate(local1) = $01
                            EndIf
                        EndIf
                        If (local1 > $1A) Then
                            debuglog("delete alarm")
                            removeevent(local10)
                        EndIf
                    EndIf
                EndIf
        End Select
    Next
    currentplayerinevent = $00
    Return $00
End Function
