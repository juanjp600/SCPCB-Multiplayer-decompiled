Function mp_updateelevators#(arg0#, arg1.doors, arg2.doors, arg3%, arg4%, arg5.events, arg6%, arg7%, arg8%)
    Local local0%
    Local local1.npcs
    Local local2.items
    Local local3.decals
    Local local4#
    Local local5#
    Local local6#
    Local local7#
    Local local8%
    Local local9#
    Local local10#
    Local local11#
    Local local12#
    Local local13#
    Local local14#
    Local local15#
    Local local16#
    Local local17#
    Local local18#
    Local local19#
    Local local20#
    Local local21#
    Local local22#
    Local local23#
    Local local24#
    Local local25#
    Local local26%
    Local local27%
    Local local28#
    local0 = me\Field60
    me\Field60 = event_getmypivot()
    If (arg8 = $00) Then
        If (entityy(arg4, $01) < entityy(arg3, $01)) Then
            arg1\Field32 = $FFFFFFFF
            arg2\Field32 = $01
        Else
            arg1\Field32 = $01
            arg2\Field32 = $FFFFFFFF
        EndIf
    ElseIf (entityy(arg4, $01) < entityy(arg3, $01)) Then
        arg1\Field32 = $01
        arg2\Field32 = $FFFFFFFF
    Else
        arg1\Field32 = $FFFFFFFF
        arg2\Field32 = $01
    EndIf
    arg1\Field22 = $01
    arg2\Field22 = $01
    arg1\Field29 = arg2
    arg1\Field30 = arg3
    arg2\Field29 = arg1
    arg2\Field30 = arg4
    arg1\Field4 = $00
    arg2\Field4 = $00
    If (((arg1\Field6 = $00) And (arg2\Field6 = $00)) <> 0) Then
        If (((0.0 = arg1\Field8) And (0.0 = arg2\Field8)) <> 0) Then
            local9 = entityx(me\Field60, $01)
            local10 = entityy(me\Field60, $01)
            local11 = entityz(me\Field60, $01)
            local12 = entityx(arg3, $01)
            local13 = entityy(arg3, $01)
            local14 = entityz(arg3, $01)
            local15 = entityyaw(arg3, $01)
            local16 = entityx(arg4, $01)
            local17 = entityy(arg4, $01)
            local18 = entityz(arg4, $01)
            local19 = entityyaw(arg4, $01)
            local20 = 0.87375
            local21 = -0.87375
            local22 = (fps\Field7[$00] * 0.1)
            local26 = $00
            local28 = 0.0
            If (arg1\Field31 <> 0) Then
                arg0 = (arg0 - fps\Field7[$00])
                local26 = isinsideelevator(local9, local10, local11, arg3)
                If (local26 <> 0) Then
                    If (arg7 <> 0) Then
                        If (((-250.0 < arg0) Lor (-500.0 >= arg0)) <> 0) Then
                            If (channelplaying(arg1\Field18) = $00) Then
                                arg1\Field18 = playsound_strict(snd_i\Field43, $00)
                                updateelevatorpanel(arg1)
                            EndIf
                            local27 = (Int ((Float (-500.0 >= arg0)) + 1.0))
                            me\Field23 = (sin(((Abs arg0) / (3.0 * (Float local27)))) * (0.3 * (Float local27)))
                            If (((-235.0 <= arg0) And (-235.0 > (arg0 - fps\Field7[$00]))) <> 0) Then
                                playsound_strict(loadtempsound("SFX\Room\Blackout.ogg"), $00)
                            EndIf
                        ElseIf (-500.0 < arg0) Then
                            If (channelplaying(arg1\Field18) <> 0) Then
                                playsound_strict(loadtempsound("SFX\Room\Intro\Bang2.ogg"), $00)
                                me\Field50 = 6.5
                                stopchannel(arg1\Field18)
                                arg1\Field18 = $00
                                clearelevatorpaneltexture(arg1)
                                clearelevatorpaneltexture(arg2)
                                me\Field24 = 5.3
                            EndIf
                            If (((-490.0 <= arg0) And (-490.0 > (arg0 - fps\Field7[$00]))) <> 0) Then
                                playsound_strict(snd_i\Field18, $00)
                            EndIf
                        EndIf
                    Else
                        If (channelplaying(arg1\Field18) = $00) Then
                            arg1\Field18 = playsound_strict(snd_i\Field43, $00)
                            updateelevatorpanel(arg1)
                        EndIf
                        me\Field23 = (sin(((Abs arg0) / 3.0)) * 0.3)
                    EndIf
                EndIf
                local28 = (-500.0 - (500.0 * (Float arg7)))
                If (((local28 > arg0) And (-2000.0 < arg0)) <> 0) Then
                    If (local26 <> 0) Then
                        If (arg6 = $00) Then
                            local6 = distance(local9, local12, local11, local14, 0.0, 0.0)
                            local7 = pointdirection(local9, local11, local12, local14)
                            local7 = ((local7 + local19) - local15)
                            local7 = wrapangle(local7, 360.0)
                            local4 = clamp((cos(local7) * local6), local21, local20)
                            local5 = clamp((sin(local7) * local6), local21, local20)
                            rotateentity(me\Field60, entitypitch(me\Field60, $01), (angledist(entityyaw(me\Field60, $01), local15) + local19), entityroll(me\Field60, $01), $01)
                        Else
                            local4 = clamp((local9 - local12), local21, local20)
                            local5 = clamp((local11 - local14), local21, local20)
                        EndIf
                        teleportentity(me\Field60, (local16 + local4), ((local22 + local17) + (local10 - local13)), (local18 + local5), 0.3, $01, 2.0, $00)
                        me\Field36 = 0.0
                        updatelightstimer = 0.0
                        updatelightvolume()
                        updatedoors()
                        updaterooms()
                        arg1\Field17 = playsoundex(opendoorsfx($01, rand($00, $02)), camera, arg1\Field0, 10.0, 1.0, $00)
                    EndIf
                    For local1 = Each npcs
                        local23 = entityx(local1\Field3, $01)
                        local24 = entityy(local1\Field3, $01)
                        local25 = entityz(local1\Field3, $01)
                        If (isinsideelevator(local23, local24, local25, arg3) <> 0) Then
                            If (arg6 = $00) Then
                                local6 = distance(local23, local12, local25, local14, 0.0, 0.0)
                                local7 = pointdirection(local23, local25, local12, local14)
                                local7 = ((local7 + local19) - local15)
                                local7 = wrapangle(local7, 360.0)
                                local4 = clamp((cos(local7) * local6), local21, local20)
                                local5 = clamp((sin(local7) * local6), local21, local20)
                                rotateentity(local1\Field3, entitypitch(local1\Field3, $01), (angledist(entityyaw(local1\Field3, $01), local15) + local19), entityroll(local1\Field3, $01), $01)
                            Else
                                local4 = clamp((local23 - local12), local21, local20)
                                local5 = clamp((local25 - local14), local21, local20)
                            EndIf
                            teleportentity(local1\Field3, (local16 + local4), ((local22 + local17) + (local24 - local13)), (local18 + local5), local1\Field6, $01, 2.0, $00)
                        EndIf
                    Next
                    For local2 = Each items
                        local23 = entityx(local2\Field2, $01)
                        local24 = entityy(local2\Field2, $01)
                        local25 = entityz(local2\Field2, $01)
                        If (isinsideelevator(local23, local24, local25, arg3) <> 0) Then
                            If (arg6 = $00) Then
                                local6 = distance(local23, local12, local25, local14, 0.0, 0.0)
                                local7 = pointdirection(local23, local25, local12, local14)
                                local7 = ((local7 + local19) - local15)
                                local7 = wrapangle(local7, 360.0)
                                local4 = clamp((cos(local7) * local6), local21, local20)
                                local5 = clamp((sin(local7) * local6), local21, local20)
                                rotateentity(local2\Field2, entitypitch(local2\Field2, $01), (angledist(entityyaw(local2\Field2, $01), local15) + local19), entityroll(local2\Field2, $01), $01)
                            Else
                                local4 = clamp((local23 - local12), local21, local20)
                                local5 = clamp((local25 - local14), local21, local20)
                            EndIf
                            teleportentity(local2\Field2, (local16 + local4), ((local22 + local17) + (local24 - local13)), (local18 + local5), 0.01, $01, 2.0, $00)
                            local2\Field11 = 0.0
                            updateitems()
                        EndIf
                    Next
                    For local3 = Each decals
                        local23 = entityx(local3\Field0, $01)
                        local24 = entityy(local3\Field0, $01)
                        local25 = entityz(local3\Field0, $01)
                        If (isinsideelevator(local23, local24, local25, arg3) <> 0) Then
                            If (arg6 = $00) Then
                                local6 = distance(local23, local12, entityz(local3\Field0, $01), local14, 0.0, 0.0)
                                local7 = pointdirection(local23, entityz(local3\Field0, $01), local12, local14)
                                local7 = ((local7 + local19) - local15)
                                local7 = wrapangle(local7, 360.0)
                                local4 = clamp((cos(local7) * local6), local21, local20)
                                local5 = clamp((sin(local7) * local6), local21, local20)
                                rotateentity(local3\Field0, entitypitch(local3\Field0, $01), (angledist(entityyaw(local3\Field0, $01), local15) + local19), entityroll(local3\Field0, $01), $01)
                            Else
                                local4 = clamp((local23 - local12), local21, local20)
                                local5 = clamp((local25 - local14), local21, local20)
                            EndIf
                            teleportentity(local3\Field0, (local16 + local4), ((local22 + local17) + (local24 - local13)), (local18 + local5), -0.01, $01, 2.0, $00)
                            updatedecals()
                        EndIf
                    Next
                    arg0 = -2000.0
                Else
                    local28 = -2140.0
                    If (local28 > arg0) Then
                        playsoundex(snd_i\Field42, camera, arg3, 4.0, 1.0, $00)
                        openclosedoor(arg2, $01, $00)
                        arg2\Field6 = $01
                        clearelevatorpaneltexture(arg1)
                        clearelevatorpaneltexture(arg2)
                        arg1\Field31 = $00
                        arg0 = 0.0
                    EndIf
                EndIf
            ElseIf (arg2\Field31 <> 0) Then
                arg0 = (fps\Field7[$00] + arg0)
                local26 = isinsideelevator(local9, local10, local11, arg4)
                If (local26 <> 0) Then
                    If (arg7 <> 0) Then
                        If (((250.0 > arg0) Lor (500.0 <= arg0)) <> 0) Then
                            If (channelplaying(arg2\Field18) = $00) Then
                                arg2\Field18 = playsound_strict(snd_i\Field43, $00)
                                updateelevatorpanel(arg2)
                            EndIf
                            local27 = (Int ((Float (500.0 <= arg0)) + 1.0))
                            me\Field23 = (sin(((Abs arg0) / (3.0 * (Float local27)))) * (0.3 * (Float local27)))
                            If (((235.0 >= arg0) And (235.0 < (fps\Field7[$00] + arg0))) <> 0) Then
                                playsound_strict(loadtempsound("SFX\Room\Blackout.ogg"), $00)
                            EndIf
                        ElseIf (500.0 > arg0) Then
                            If (channelplaying(arg2\Field18) <> 0) Then
                                playsound_strict(loadtempsound("SFX\Room\Intro\Bang2.ogg"), $00)
                                me\Field50 = 6.5
                                stopchannel(arg2\Field18)
                                arg2\Field18 = $00
                                clearelevatorpaneltexture(arg1)
                                clearelevatorpaneltexture(arg2)
                                me\Field24 = 5.3
                            EndIf
                            If (((490.0 >= arg0) And (490.0 < (fps\Field7[$00] + arg0))) <> 0) Then
                                playsound_strict(snd_i\Field18, $00)
                            EndIf
                        EndIf
                    Else
                        If (channelplaying(arg2\Field18) = $00) Then
                            arg2\Field18 = playsound_strict(snd_i\Field43, $00)
                            updateelevatorpanel(arg2)
                        EndIf
                        me\Field23 = (sin(((Abs arg0) / 3.0)) * 0.3)
                    EndIf
                EndIf
                local28 = ((500.0 * (Float arg7)) + 500.0)
                If (((local28 < arg0) And (2000.0 > arg0)) <> 0) Then
                    If (local26 <> 0) Then
                        If (arg6 = $00) Then
                            local6 = distance(local9, local16, local11, local18, 0.0, 0.0)
                            local7 = pointdirection(local9, local11, local16, local18)
                            local7 = ((local7 + local15) - local19)
                            local4 = clamp((cos(local7) * local6), local21, local20)
                            local5 = clamp((sin(local7) * local6), local21, local20)
                            rotateentity(me\Field60, entitypitch(me\Field60, $01), (angledist(entityyaw(me\Field60, $01), local19) + local15), entityroll(me\Field60, $01), $01)
                        Else
                            local4 = clamp((local9 - local16), local21, local20)
                            local5 = clamp((local11 - local18), local21, local20)
                        EndIf
                        teleportentity(me\Field60, (local12 + local4), ((local22 + local13) + (local10 - local17)), (local14 + local5), 0.3, $01, 2.0, $00)
                        me\Field36 = 0.0
                        updatelightstimer = 0.0
                        updatelightvolume()
                        updatedoors()
                        updaterooms()
                        arg2\Field17 = playsoundex(opendoorsfx($01, rand($00, $02)), camera, arg2\Field0, 10.0, 1.0, $00)
                    EndIf
                    For local1 = Each npcs
                        local23 = entityx(local1\Field3, $01)
                        local24 = entityy(local1\Field3, $01)
                        local25 = entityz(local1\Field3, $01)
                        If (isinsideelevator(local23, local24, local25, arg4) <> 0) Then
                            If (arg6 = $00) Then
                                local6 = distance(local23, local16, local25, local18, 0.0, 0.0)
                                local7 = pointdirection(local23, local25, local16, local18)
                                local7 = ((local7 + local15) - local19)
                                local4 = clamp((cos(local7) * local6), local21, local20)
                                local5 = clamp((sin(local7) * local6), local21, local20)
                                rotateentity(local1\Field3, entitypitch(local1\Field3, $01), (angledist(entityyaw(local1\Field3, $01), local19) + local15), entityroll(local1\Field3, $01), $01)
                            Else
                                local4 = clamp((local23 - local16), local21, local20)
                                local5 = clamp((local25 - local18), local21, local20)
                            EndIf
                            teleportentity(local1\Field3, (local12 + local4), ((local22 + local13) + (local24 - local17)), (local14 + local5), local1\Field6, $01, 2.0, $00)
                        EndIf
                    Next
                    For local2 = Each items
                        local23 = entityx(local2\Field2, $01)
                        local24 = entityy(local2\Field2, $01)
                        local25 = entityz(local2\Field2, $01)
                        If (isinsideelevator(local23, local24, local25, arg4) <> 0) Then
                            If (arg6 = $00) Then
                                local6 = distance(local23, local16, local25, local18, 0.0, 0.0)
                                local7 = pointdirection(local23, local25, local16, local18)
                                local7 = ((local7 + local15) - local19)
                                local4 = clamp((cos(local7) * local6), local21, local20)
                                local5 = clamp((sin(local7) * local6), local21, local20)
                                rotateentity(local2\Field2, entitypitch(local2\Field2, $01), (angledist(entityyaw(local2\Field2, $01), local19) + local15), entityroll(local2\Field2, $01), $01)
                            Else
                                local4 = clamp((local23 - local16), local21, local20)
                                local5 = clamp((local25 - local18), local21, local20)
                            EndIf
                            teleportentity(local2\Field2, (local12 + local4), ((local22 + local13) + (local24 - local17)), (local14 + local5), 0.01, $01, 2.0, $00)
                            local2\Field11 = 0.0
                            updateitems()
                        EndIf
                    Next
                    For local3 = Each decals
                        local23 = entityx(local3\Field0, $01)
                        local24 = entityy(local3\Field0, $01)
                        local25 = entityz(local3\Field0, $01)
                        If (isinsideelevator(local23, local24, local25, arg4) <> 0) Then
                            If (arg6 = $00) Then
                                local6 = distance(local23, local16, local25, local18, 0.0, 0.0)
                                local7 = pointdirection(local23, local25, local16, local18)
                                local7 = ((local7 + local15) - local19)
                                local4 = clamp((cos(local7) * local6), local21, local20)
                                local5 = clamp((sin(local7) * local6), local21, local20)
                                rotateentity(local3\Field0, entitypitch(local3\Field0, $01), (angledist(entityyaw(local3\Field0, $01), local19) + local15), entityroll(local3\Field0, $01), $01)
                            Else
                                local4 = clamp((local23 - local16), local21, local20)
                                local5 = clamp((local25 - local18), local21, local20)
                            EndIf
                            teleportentity(local3\Field0, (local12 + local4), ((local22 + local13) + (local24 - local17)), (local14 + local5), -0.01, $01, 2.0, $00)
                            updatedecals()
                        EndIf
                    Next
                    arg0 = 2000.0
                Else
                    local28 = 2140.0
                    If (local28 < arg0) Then
                        playsoundex(snd_i\Field42, camera, arg4, 4.0, 1.0, $00)
                        openclosedoor(arg1, $01, $00)
                        arg1\Field6 = $01
                        clearelevatorpaneltexture(arg1)
                        clearelevatorpaneltexture(arg2)
                        arg2\Field31 = $00
                        arg0 = 0.0
                    EndIf
                EndIf
            EndIf
        EndIf
        For local8 = $00 To $01 Step $01
            entitytexture(arg1\Field3[local8], d_i\Field3[$01], $00, $00)
            entitytexture(arg2\Field3[local8], d_i\Field3[$01], $00, $00)
        Next
    Else
        arg1\Field31 = $00
        arg2\Field31 = $00
    EndIf
    me\Field60 = local0
    Return arg0
    Return 0.0
End Function
