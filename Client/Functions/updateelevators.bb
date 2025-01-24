Function updateelevators#(arg0#, arg1.doors, arg2.doors, arg3%, arg4%, arg5.events, arg6%, arg7%)
    Local local0.npcs
    Local local1.items
    Local local2.decals
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7%
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
    Local local29.emitter
    arg1\Field22 = $01
    arg2\Field22 = $01
    If ((((arg1\Field6 And (arg2\Field6 = $00)) And (180.0 = arg1\Field8)) And (518.0 > arg0)) <> 0) Then
        arg0 = -1.0
        arg1\Field4 = $00
        If ((((d_i\Field9 = arg2\Field3[$00]) Lor (d_i\Field9 = arg2\Field3[$01])) And mo\Field0) <> 0) Then
            openclosedoor(arg1, $01, $00)
            updateelevatorpanel(arg2)
        EndIf
    ElseIf (((arg2\Field6 And (arg1\Field6 = $00)) And (180.0 = arg2\Field8)) <> 0) Then
        arg0 = 1.0
        arg2\Field4 = $00
        If ((((d_i\Field9 = arg1\Field3[$00]) Lor (d_i\Field9 = arg1\Field3[$01])) And mo\Field0) <> 0) Then
            openclosedoor(arg2, $01, $00)
            updateelevatorpanel(arg1)
        EndIf
    ElseIf (0.2 > (Abs (arg1\Field8 - arg2\Field8))) Then
        arg1\Field22 = $02
        arg2\Field22 = $02
    EndIf
    arg1\Field4 = $01
    arg2\Field4 = $01
    If (arg1\Field6 <> 0) Then
        arg1\Field22 = $03
        If (me\Field65 <> 0) Then
            If (518.0 > arg0) Then
                arg1\Field4 = $00
            EndIf
            arg1\Field22 = $01
        EndIf
    EndIf
    If (arg2\Field6 <> 0) Then
        arg2\Field22 = $03
        If (me\Field65 <> 0) Then
            arg2\Field4 = $00
            arg2\Field22 = $01
        EndIf
    EndIf
    local8 = $00
    If (n_i\Field4 <> Null) Then
        If ((((((1.0 < n_i\Field4\Field10) And (n_i\Field4\Field34 = Null)) And (infacility = $00)) And me\Field65) And (chs\Field2 = $00)) <> 0) Then
            local8 = $01
        EndIf
    EndIf
    If (local8 = $00) Then
        If (((arg1\Field6 = $00) And (arg2\Field6 = $00)) <> 0) Then
            If (me\Field65 <> 0) Then
                cansave = $00
            EndIf
            arg1\Field4 = $01
            arg2\Field4 = $01
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
                If (0.0 > arg0) Then
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
                    If ((((arg7 = $00) And (-500.0 > arg0)) Lor (-1000.0 > arg0)) <> 0) Then
                        arg1\Field4 = $01
                        arg2\Field4 = $00
                        arg0 = 0.0
                        If (local26 <> 0) Then
                            If (arg6 = $00) Then
                                local5 = distance(local9, local12, local11, local14, 0.0, 0.0)
                                local6 = pointdirection(local9, local11, local12, local14)
                                local6 = ((local6 + local19) - local15)
                                local6 = wrapangle(local6, 360.0)
                                local3 = clamp((cos(local6) * local5), local21, local20)
                                local4 = clamp((sin(local6) * local5), local21, local20)
                                rotateentity(me\Field60, entitypitch(me\Field60, $01), (angledist(entityyaw(me\Field60, $01), local15) + local19), entityroll(me\Field60, $01), $01)
                            Else
                                local3 = clamp((local9 - local12), local21, local20)
                                local4 = clamp((local11 - local14), local21, local20)
                            EndIf
                            teleportentity(me\Field60, (local16 + local3), ((local22 + local17) + (local10 - local13)), (local18 + local4), 0.3, $01, 2.0, $00)
                            me\Field36 = 0.0
                            updatelightstimer = 0.0
                            updatelightvolume()
                            updatedoors()
                            updaterooms()
                            arg1\Field17 = playsoundex(opendoorsfx($01, rand($00, $02)), camera, arg1\Field0, 10.0, 1.0, $00)
                        EndIf
                        For local0 = Each npcs
                            local23 = entityx(local0\Field3, $01)
                            local24 = entityy(local0\Field3, $01)
                            local25 = entityz(local0\Field3, $01)
                            If (isinsideelevator(local23, local24, local25, arg3) <> 0) Then
                                If (arg6 = $00) Then
                                    local5 = distance(local23, local12, local25, local14, 0.0, 0.0)
                                    local6 = pointdirection(local23, local25, local12, local14)
                                    local6 = ((local6 + local19) - local15)
                                    local6 = wrapangle(local6, 360.0)
                                    local3 = clamp((cos(local6) * local5), local21, local20)
                                    local4 = clamp((sin(local6) * local5), local21, local20)
                                    rotateentity(local0\Field3, entitypitch(local0\Field3, $01), (angledist(entityyaw(local0\Field3, $01), local15) + local19), entityroll(local0\Field3, $01), $01)
                                Else
                                    local3 = clamp((local23 - local12), local21, local20)
                                    local4 = clamp((local25 - local14), local21, local20)
                                EndIf
                                teleportentity(local0\Field3, (local16 + local3), ((local22 + local17) + (local24 - local13)), (local18 + local4), local0\Field6, $01, 2.0, $00)
                            EndIf
                        Next
                        For local1 = Each items
                            local23 = entityx(local1\Field2, $01)
                            local24 = entityy(local1\Field2, $01)
                            local25 = entityz(local1\Field2, $01)
                            If (isinsideelevator(local23, local24, local25, arg3) <> 0) Then
                                If (arg6 = $00) Then
                                    local5 = distance(local23, local12, local25, local14, 0.0, 0.0)
                                    local6 = pointdirection(local23, local25, local12, local14)
                                    local6 = ((local6 + local19) - local15)
                                    local6 = wrapangle(local6, 360.0)
                                    local3 = clamp((cos(local6) * local5), local21, local20)
                                    local4 = clamp((sin(local6) * local5), local21, local20)
                                    rotateentity(local1\Field2, entitypitch(local1\Field2, $01), (angledist(entityyaw(local1\Field2, $01), local15) + local19), entityroll(local1\Field2, $01), $01)
                                Else
                                    local3 = clamp((local23 - local12), local21, local20)
                                    local4 = clamp((local25 - local14), local21, local20)
                                EndIf
                                teleportentity(local1\Field2, (local16 + local3), ((local22 + local17) + (local24 - local13)), (local18 + local4), 0.01, $01, 2.0, $00)
                                local1\Field11 = 0.0
                                updateitems()
                            EndIf
                        Next
                        For local2 = Each decals
                            local23 = entityx(local2\Field0, $01)
                            local24 = entityy(local2\Field0, $01)
                            local25 = entityz(local2\Field0, $01)
                            If (isinsideelevator(local23, local24, local25, arg3) <> 0) Then
                                If (arg6 = $00) Then
                                    local5 = distance(local23, local12, entityz(local2\Field0, $01), local14, 0.0, 0.0)
                                    local6 = pointdirection(local23, entityz(local2\Field0, $01), local12, local14)
                                    local6 = ((local6 + local19) - local15)
                                    local6 = wrapangle(local6, 360.0)
                                    local3 = clamp((cos(local6) * local5), local21, local20)
                                    local4 = clamp((sin(local6) * local5), local21, local20)
                                    rotateentity(local2\Field0, entitypitch(local2\Field0, $01), (angledist(entityyaw(local2\Field0, $01), local15) + local19), entityroll(local2\Field0, $01), $01)
                                Else
                                    local3 = clamp((local23 - local12), local21, local20)
                                    local4 = clamp((local25 - local14), local21, local20)
                                EndIf
                                teleportentity(local2\Field0, (local16 + local3), ((local22 + local17) + (local24 - local13)), (local18 + local4), -0.01, $01, 2.0, $00)
                                updatedecals()
                            EndIf
                        Next
                        openclosedoor(arg2, (me\Field65 = $00), $00)
                        arg1\Field6 = $00
                        clearelevatorpaneltexture(arg1)
                        clearelevatorpaneltexture(arg2)
                        playsoundex(snd_i\Field42, camera, arg3, 4.0, 1.0, $00)
                    EndIf
                Else
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
                    If ((((arg7 = $00) And (500.0 < arg0)) Lor (1000.0 < arg0)) <> 0) Then
                        arg1\Field4 = $00
                        arg2\Field4 = $01
                        arg0 = 0.0
                        If (local26 <> 0) Then
                            If (arg6 = $00) Then
                                local5 = distance(local9, local16, local11, local18, 0.0, 0.0)
                                local6 = pointdirection(local9, local11, local16, local18)
                                local6 = ((local6 + local15) - local19)
                                local3 = clamp((cos(local6) * local5), local21, local20)
                                local4 = clamp((sin(local6) * local5), local21, local20)
                                rotateentity(me\Field60, entitypitch(me\Field60, $01), (angledist(entityyaw(me\Field60, $01), local19) + local15), entityroll(me\Field60, $01), $01)
                            Else
                                local3 = clamp((local9 - local16), local21, local20)
                                local4 = clamp((local11 - local18), local21, local20)
                            EndIf
                            teleportentity(me\Field60, (local12 + local3), ((local22 + local13) + (local10 - local17)), (local14 + local4), 0.3, $01, 2.0, $00)
                            me\Field36 = 0.0
                            updatelightstimer = 0.0
                            updatelightvolume()
                            updatedoors()
                            updaterooms()
                            arg2\Field17 = playsoundex(opendoorsfx($01, rand($00, $02)), camera, arg2\Field0, 10.0, 1.0, $00)
                        EndIf
                        For local0 = Each npcs
                            local23 = entityx(local0\Field3, $01)
                            local24 = entityy(local0\Field3, $01)
                            local25 = entityz(local0\Field3, $01)
                            If (isinsideelevator(local23, local24, local25, arg4) <> 0) Then
                                If (arg6 = $00) Then
                                    local5 = distance(local23, local16, local25, local18, 0.0, 0.0)
                                    local6 = pointdirection(local23, local25, local16, local18)
                                    local6 = ((local6 + local15) - local19)
                                    local3 = clamp((cos(local6) * local5), local21, local20)
                                    local4 = clamp((sin(local6) * local5), local21, local20)
                                    rotateentity(local0\Field3, entitypitch(local0\Field3, $01), (angledist(entityyaw(local0\Field3, $01), local19) + local15), entityroll(local0\Field3, $01), $01)
                                Else
                                    local3 = clamp((local23 - local16), local21, local20)
                                    local4 = clamp((local25 - local18), local21, local20)
                                EndIf
                                teleportentity(local0\Field3, (local12 + local3), ((local22 + local13) + (local24 - local17)), (local14 + local4), local0\Field6, $01, 2.0, $00)
                            EndIf
                        Next
                        For local1 = Each items
                            local23 = entityx(local1\Field2, $01)
                            local24 = entityy(local1\Field2, $01)
                            local25 = entityz(local1\Field2, $01)
                            If (isinsideelevator(local23, local24, local25, arg4) <> 0) Then
                                If (arg6 = $00) Then
                                    local5 = distance(local23, local16, local25, local18, 0.0, 0.0)
                                    local6 = pointdirection(local23, local25, local16, local18)
                                    local6 = ((local6 + local15) - local19)
                                    local3 = clamp((cos(local6) * local5), local21, local20)
                                    local4 = clamp((sin(local6) * local5), local21, local20)
                                    rotateentity(local1\Field2, entitypitch(local1\Field2, $01), (angledist(entityyaw(local1\Field2, $01), local19) + local15), entityroll(local1\Field2, $01), $01)
                                Else
                                    local3 = clamp((local23 - local16), local21, local20)
                                    local4 = clamp((local25 - local18), local21, local20)
                                EndIf
                                teleportentity(local1\Field2, (local12 + local3), ((local22 + local13) + (local24 - local17)), (local14 + local4), 0.01, $01, 2.0, $00)
                                local1\Field11 = 0.0
                                updateitems()
                            EndIf
                        Next
                        For local2 = Each decals
                            local23 = entityx(local2\Field0, $01)
                            local24 = entityy(local2\Field0, $01)
                            local25 = entityz(local2\Field0, $01)
                            If (isinsideelevator(local23, local24, local25, arg4) <> 0) Then
                                If (arg6 = $00) Then
                                    local5 = distance(local23, local16, local25, local18, 0.0, 0.0)
                                    local6 = pointdirection(local23, local25, local16, local18)
                                    local6 = ((local6 + local15) - local19)
                                    local3 = clamp((cos(local6) * local5), local21, local20)
                                    local4 = clamp((sin(local6) * local5), local21, local20)
                                    rotateentity(local2\Field0, entitypitch(local2\Field0, $01), (angledist(entityyaw(local2\Field0, $01), local19) + local15), entityroll(local2\Field0, $01), $01)
                                Else
                                    local3 = clamp((local23 - local16), local21, local20)
                                    local4 = clamp((local25 - local18), local21, local20)
                                EndIf
                                teleportentity(local2\Field0, (local12 + local3), ((local22 + local13) + (local24 - local17)), (local14 + local4), -0.01, $01, 2.0, $00)
                                updatedecals()
                            EndIf
                        Next
                        openclosedoor(arg1, (me\Field65 = $00), $00)
                        arg2\Field6 = $00
                        clearelevatorpaneltexture(arg1)
                        clearelevatorpaneltexture(arg2)
                        playsoundex(snd_i\Field42, camera, arg4, 4.0, 1.0, $00)
                    EndIf
                EndIf
            EndIf
            For local7 = $00 To $01 Step $01
                entitytexture(arg1\Field3[local7], d_i\Field3[$01], $00, $00)
                entitytexture(arg2\Field3[local7], d_i\Field3[$01], $00, $00)
            Next
        EndIf
    Else
        local28 = arg0
        If (0.0 > arg0) Then
            arg0 = 0.0
            local28 = 0.0
        EndIf
        If (((0.0 = arg1\Field8) And (arg1\Field6 = $00)) <> 0) Then
            If (me\Field65 <> 0) Then
                If (0.0 = arg0) Then
                    teleportentity(n_i\Field4\Field3, entityx(arg1\Field2, $00), (entityy(arg1\Field2, $00) + 1.0), entityz(arg1\Field2, $00), n_i\Field4\Field6, $00, 2.0, $00)
                    pointentity(n_i\Field4\Field3, arg3, 0.0)
                    rotateentity(n_i\Field4\Field3, 0.0, entityyaw(n_i\Field4\Field3, $00), 0.0, $00)
                    moveentity(n_i\Field4\Field3, 0.0, 0.0, -0.5)
                    resetentity(n_i\Field4\Field3)
                    n_i\Field4\Field10 = 6.0
                    setnpcframe(n_i\Field4, 0.0)
                    loadeventsound(arg5, "SFX\SCP\096\ElevatorSlam.ogg", $00)
                    arg0 = ((fps\Field7[$00] * 1.4) + arg0)
                    arg1\Field4 = $01
                    updateelevatorpanel(arg1)
                EndIf
            EndIf
        EndIf
        If (0.0 < arg0) Then
            If (0.0 = local28) Then
                arg5\Field6 = playsound_strict(arg5\Field8, $01)
            EndIf
            If (((133.0 < arg0) And (arg0 < (fps\Field7[$00] + 140.0))) <> 0) Then
                me\Field24 = 7.0
            ElseIf (((294.0 < arg0) And (arg0 < (fps\Field7[$00] + 297.5))) <> 0) Then
                me\Field24 = 2.0
            ElseIf (((413.0 < arg0) And (arg0 < (fps\Field7[$00] + 416.5))) <> 0) Then
                me\Field24 = 2.0
            ElseIf (((507.5 < arg0) And (arg0 < (fps\Field7[$00] + 511.0))) <> 0) Then
                me\Field24 = 2.0
                arg1\Field9 = $01
                arg1\Field6 = $01
                local29 = setemitter(Null, entityx(arg1\Field0, $01), entityy(arg1\Field0, $01), entityz(arg1\Field0, $01), $10)
                entityparent(local29\Field6, arg1\Field0, $01)
                n_i\Field4\Field10 = 5.0
                n_i\Field4\Field29 = $01
            ElseIf (((567.0 < arg0) And (arg0 < (fps\Field7[$00] + 570.5))) <> 0) Then
                me\Field24 = 2.0
            EndIf
            If (567.0 >= arg0) Then
                arg1\Field8 = min(arg1\Field8, 20.0)
            EndIf
            arg0 = (fps\Field7[$00] + arg0)
        EndIf
    EndIf
    Return arg0
    Return 0.0
End Function
