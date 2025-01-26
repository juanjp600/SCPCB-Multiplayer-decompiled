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
    Local local26#
    Local local27%
    Local local28%
    Local local29#
    Local local30.mp_playercorpse
    local0 = me\Field60
    me\Field60 = event_getmypivot()
    local9 = (50.0 * (Float (mp_ishoster() = $00)))
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
            local10 = entityx(me\Field60, $01)
            local11 = entityy(me\Field60, $01)
            local12 = entityz(me\Field60, $01)
            local13 = entityx(arg3, $01)
            local14 = entityy(arg3, $01)
            local15 = entityz(arg3, $01)
            local16 = entityyaw(arg3, $01)
            local17 = entityx(arg4, $01)
            local18 = entityy(arg4, $01)
            local19 = entityz(arg4, $01)
            local20 = entityyaw(arg4, $01)
            local21 = 0.87375
            local22 = -0.87375
            local23 = (fps\Field7[$00] * 0.1)
            local27 = $00
            local29 = 0.0
            If (arg1\Field31 <> 0) Then
                arg0 = (arg0 - fps\Field7[$00])
                local27 = isinsideelevator(local10, local11, local12, arg3)
                If (local27 <> 0) Then
                    If (arg7 <> 0) Then
                        If ((((-250.0 < arg0) Lor (-500.0 >= arg0)) And (-2000.0 < arg0)) <> 0) Then
                            If (channelplaying(arg1\Field18) = $00) Then
                                arg1\Field18 = playsound_strict(snd_i\Field43, $00)
                                updateelevatorpanel(arg1)
                            EndIf
                            local28 = (Int ((Float (-500.0 >= arg0)) + 1.0))
                            me\Field23 = (sin(((Abs arg0) / (3.0 * (Float local28)))) * (0.3 * (Float local28)))
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
                local29 = (-500.0 - (500.0 * (Float arg7)))
                If (((local29 > arg0) And (-2000.0 < arg0)) <> 0) Then
                    If (local27 <> 0) Then
                        If (arg6 = $00) Then
                            local6 = distance(local10, local13, local12, local15, 0.0, 0.0)
                            local7 = pointdirection(local10, local12, local13, local15)
                            local7 = ((local7 + local20) - local16)
                            local7 = wrapangle(local7, 360.0)
                            local4 = clamp((cos(local7) * local6), local22, local21)
                            local5 = clamp((sin(local7) * local6), local22, local21)
                            rotateentity(me\Field60, entitypitch(me\Field60, $01), (angledist(entityyaw(me\Field60, $01), local16) + local20), entityroll(me\Field60, $01), $01)
                        Else
                            local4 = clamp((local10 - local13), local22, local21)
                            local5 = clamp((local12 - local15), local22, local21)
                        EndIf
                        teleportentity(me\Field60, (local17 + local4), ((local23 + local18) + (local11 - local14)), (local19 + local5), 0.3, $01, 2.0, $00)
                        me\Field36 = 0.0
                        updatelightstimer = 0.0
                        updatelightvolume()
                        updatedoors()
                        updaterooms()
                    EndIf
                    For local1 = Each npcs
                        local24 = entityx(local1\Field3, $01)
                        local25 = entityy(local1\Field3, $01)
                        local26 = entityz(local1\Field3, $01)
                        If (isinsideelevator(local24, local25, local26, arg3) <> 0) Then
                            If (arg6 = $00) Then
                                local6 = distance(local24, local13, local26, local15, 0.0, 0.0)
                                local7 = pointdirection(local24, local26, local13, local15)
                                local7 = ((local7 + local20) - local16)
                                local7 = wrapangle(local7, 360.0)
                                local4 = clamp((cos(local7) * local6), local22, local21)
                                local5 = clamp((sin(local7) * local6), local22, local21)
                                rotateentity(local1\Field3, entitypitch(local1\Field3, $01), (angledist(entityyaw(local1\Field3, $01), local16) + local20), entityroll(local1\Field3, $01), $01)
                            Else
                                local4 = clamp((local24 - local13), local22, local21)
                                local5 = clamp((local26 - local15), local22, local21)
                            EndIf
                            teleportentity(local1\Field3, (local17 + local4), ((local23 + local18) + (local25 - local14)), (local19 + local5), local1\Field6, $01, 2.0, $00)
                        EndIf
                    Next
                    For local2 = Each items
                        local24 = entityx(local2\Field2, $01)
                        local25 = entityy(local2\Field2, $01)
                        local26 = entityz(local2\Field2, $01)
                        If (isinsideelevator(local24, local25, local26, arg3) <> 0) Then
                            If (arg6 = $00) Then
                                local6 = distance(local24, local13, local26, local15, 0.0, 0.0)
                                local7 = pointdirection(local24, local26, local13, local15)
                                local7 = ((local7 + local20) - local16)
                                local7 = wrapangle(local7, 360.0)
                                local4 = clamp((cos(local7) * local6), local22, local21)
                                local5 = clamp((sin(local7) * local6), local22, local21)
                                rotateentity(local2\Field2, entitypitch(local2\Field2, $01), (angledist(entityyaw(local2\Field2, $01), local16) + local20), entityroll(local2\Field2, $01), $01)
                            Else
                                local4 = clamp((local24 - local13), local22, local21)
                                local5 = clamp((local26 - local15), local22, local21)
                            EndIf
                            teleportentity(local2\Field2, (local17 + local4), ((local23 + local18) + (local25 - local14)), (local19 + local5), 0.01, $01, 2.0, $00)
                            local2\Field11 = 0.0
                            updateitems()
                        EndIf
                    Next
                    For local3 = Each decals
                        local24 = entityx(local3\Field0, $01)
                        local25 = entityy(local3\Field0, $01)
                        local26 = entityz(local3\Field0, $01)
                        If (isinsideelevator(local24, local25, local26, arg3) <> 0) Then
                            If (arg6 = $00) Then
                                local6 = distance(local24, local13, entityz(local3\Field0, $01), local15, 0.0, 0.0)
                                local7 = pointdirection(local24, entityz(local3\Field0, $01), local13, local15)
                                local7 = ((local7 + local20) - local16)
                                local7 = wrapangle(local7, 360.0)
                                local4 = clamp((cos(local7) * local6), local22, local21)
                                local5 = clamp((sin(local7) * local6), local22, local21)
                                rotateentity(local3\Field0, entitypitch(local3\Field0, $01), (angledist(entityyaw(local3\Field0, $01), local16) + local20), entityroll(local3\Field0, $01), $01)
                            Else
                                local4 = clamp((local24 - local13), local22, local21)
                                local5 = clamp((local26 - local15), local22, local21)
                            EndIf
                            teleportentity(local3\Field0, (local17 + local4), ((local23 + local18) + (local25 - local14)), (local19 + local5), -0.01, $01, 2.0, $00)
                            updatedecals()
                        EndIf
                    Next
                    For local30 = Each mp_playercorpse
                        local24 = entityx(local30\Field2, $01)
                        local25 = entityy(local30\Field2, $01)
                        local26 = entityz(local30\Field2, $01)
                        If (isinsideelevator(local24, local25, local26, arg3) <> 0) Then
                            If (arg6 = $00) Then
                                local6 = distance(local24, local13, local26, local15, 0.0, 0.0)
                                local7 = pointdirection(local24, local26, local13, local15)
                                local7 = ((local7 + local20) - local16)
                                local7 = wrapangle(local7, 360.0)
                                local4 = clamp((cos(local7) * local6), local22, local21)
                                local5 = clamp((sin(local7) * local6), local22, local21)
                                rotateentity(local30\Field2, entitypitch(local30\Field2, $01), (angledist(entityyaw(local30\Field2, $01), local16) + local20), entityroll(local30\Field2, $01), $01)
                            Else
                                local4 = clamp((local24 - local13), local22, local21)
                                local5 = clamp((local26 - local15), local22, local21)
                            EndIf
                            teleportentity(local30\Field2, (local17 + local4), ((local23 + local18) + (local25 - local14)), (local19 + local5), 0.3, $01, 2.0, $00)
                        EndIf
                    Next
                    arg0 = -2000.0
                Else
                    local29 = (-2140.0 - local9)
                    If (local29 > arg0) Then
                        playsoundex(snd_i\Field42, camera, arg3, 4.0, 1.0, $00, $00)
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
                local27 = isinsideelevator(local10, local11, local12, arg4)
                If (local27 <> 0) Then
                    If (arg7 <> 0) Then
                        If ((((250.0 > arg0) Lor (500.0 <= arg0)) And (2000.0 > arg0)) <> 0) Then
                            If (channelplaying(arg2\Field18) = $00) Then
                                arg2\Field18 = playsound_strict(snd_i\Field43, $00)
                                updateelevatorpanel(arg2)
                            EndIf
                            local28 = (Int ((Float (500.0 <= arg0)) + 1.0))
                            me\Field23 = (sin(((Abs arg0) / (3.0 * (Float local28)))) * (0.3 * (Float local28)))
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
                local29 = ((500.0 * (Float arg7)) + 500.0)
                If (((local29 < arg0) And (2000.0 > arg0)) <> 0) Then
                    If (local27 <> 0) Then
                        If (arg6 = $00) Then
                            local6 = distance(local10, local17, local12, local19, 0.0, 0.0)
                            local7 = pointdirection(local10, local12, local17, local19)
                            local7 = ((local7 + local16) - local20)
                            local4 = clamp((cos(local7) * local6), local22, local21)
                            local5 = clamp((sin(local7) * local6), local22, local21)
                            rotateentity(me\Field60, entitypitch(me\Field60, $01), (angledist(entityyaw(me\Field60, $01), local20) + local16), entityroll(me\Field60, $01), $01)
                        Else
                            local4 = clamp((local10 - local17), local22, local21)
                            local5 = clamp((local12 - local19), local22, local21)
                        EndIf
                        teleportentity(me\Field60, (local13 + local4), ((local23 + local14) + (local11 - local18)), (local15 + local5), 0.3, $01, 2.0, $00)
                        me\Field36 = 0.0
                        updatelightstimer = 0.0
                        updatelightvolume()
                        updatedoors()
                        updaterooms()
                    EndIf
                    For local1 = Each npcs
                        local24 = entityx(local1\Field3, $01)
                        local25 = entityy(local1\Field3, $01)
                        local26 = entityz(local1\Field3, $01)
                        If (isinsideelevator(local24, local25, local26, arg4) <> 0) Then
                            If (arg6 = $00) Then
                                local6 = distance(local24, local17, local26, local19, 0.0, 0.0)
                                local7 = pointdirection(local24, local26, local17, local19)
                                local7 = ((local7 + local16) - local20)
                                local4 = clamp((cos(local7) * local6), local22, local21)
                                local5 = clamp((sin(local7) * local6), local22, local21)
                                rotateentity(local1\Field3, entitypitch(local1\Field3, $01), (angledist(entityyaw(local1\Field3, $01), local20) + local16), entityroll(local1\Field3, $01), $01)
                            Else
                                local4 = clamp((local24 - local17), local22, local21)
                                local5 = clamp((local26 - local19), local22, local21)
                            EndIf
                            teleportentity(local1\Field3, (local13 + local4), ((local23 + local14) + (local25 - local18)), (local15 + local5), local1\Field6, $01, 2.0, $00)
                        EndIf
                    Next
                    For local2 = Each items
                        local24 = entityx(local2\Field2, $01)
                        local25 = entityy(local2\Field2, $01)
                        local26 = entityz(local2\Field2, $01)
                        If (isinsideelevator(local24, local25, local26, arg4) <> 0) Then
                            If (arg6 = $00) Then
                                local6 = distance(local24, local17, local26, local19, 0.0, 0.0)
                                local7 = pointdirection(local24, local26, local17, local19)
                                local7 = ((local7 + local16) - local20)
                                local4 = clamp((cos(local7) * local6), local22, local21)
                                local5 = clamp((sin(local7) * local6), local22, local21)
                                rotateentity(local2\Field2, entitypitch(local2\Field2, $01), (angledist(entityyaw(local2\Field2, $01), local20) + local16), entityroll(local2\Field2, $01), $01)
                            Else
                                local4 = clamp((local24 - local17), local22, local21)
                                local5 = clamp((local26 - local19), local22, local21)
                            EndIf
                            teleportentity(local2\Field2, (local13 + local4), ((local23 + local14) + (local25 - local18)), (local15 + local5), 0.01, $01, 2.0, $00)
                            local2\Field11 = 0.0
                            updateitems()
                        EndIf
                    Next
                    For local3 = Each decals
                        local24 = entityx(local3\Field0, $01)
                        local25 = entityy(local3\Field0, $01)
                        local26 = entityz(local3\Field0, $01)
                        If (isinsideelevator(local24, local25, local26, arg4) <> 0) Then
                            If (arg6 = $00) Then
                                local6 = distance(local24, local17, local26, local19, 0.0, 0.0)
                                local7 = pointdirection(local24, local26, local17, local19)
                                local7 = ((local7 + local16) - local20)
                                local4 = clamp((cos(local7) * local6), local22, local21)
                                local5 = clamp((sin(local7) * local6), local22, local21)
                                rotateentity(local3\Field0, entitypitch(local3\Field0, $01), (angledist(entityyaw(local3\Field0, $01), local20) + local16), entityroll(local3\Field0, $01), $01)
                            Else
                                local4 = clamp((local24 - local17), local22, local21)
                                local5 = clamp((local26 - local19), local22, local21)
                            EndIf
                            teleportentity(local3\Field0, (local13 + local4), ((local23 + local14) + (local25 - local18)), (local15 + local5), -0.01, $01, 2.0, $00)
                            updatedecals()
                        EndIf
                    Next
                    For local30 = Each mp_playercorpse
                        local24 = entityx(local30\Field2, $01)
                        local25 = entityy(local30\Field2, $01)
                        local26 = entityz(local30\Field2, $01)
                        If (isinsideelevator(local24, local25, local26, arg4) <> 0) Then
                            If (arg6 = $00) Then
                                local6 = distance(local24, local17, local26, local19, 0.0, 0.0)
                                local7 = pointdirection(local24, local26, local17, local19)
                                local7 = ((local7 + local16) - local20)
                                local4 = clamp((cos(local7) * local6), local22, local21)
                                local5 = clamp((sin(local7) * local6), local22, local21)
                                rotateentity(local30\Field2, entitypitch(local30\Field2, $01), (angledist(entityyaw(local30\Field2, $01), local20) + local16), entityroll(local30\Field2, $01), $01)
                            Else
                                local4 = clamp((local24 - local17), local22, local21)
                                local5 = clamp((local26 - local19), local22, local21)
                            EndIf
                            teleportentity(local30\Field2, (local13 + local4), ((local23 + local14) + (local25 - local18)), (local15 + local5), 0.3, $01, 2.0, $00)
                        EndIf
                    Next
                    arg0 = 2000.0
                Else
                    local29 = (2140.0 + local9)
                    If (local29 < arg0) Then
                        playsoundex(snd_i\Field42, camera, arg4, 4.0, 1.0, $00, $00)
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
