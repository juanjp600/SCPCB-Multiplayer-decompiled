Function updatemoving%()
    Local local0.mp_player
    Local local1.decals
    Local local2#
    Local local3#
    Local local4%
    Local local5%
    Local local6#
    Local local7%
    Local local8#
    Local local9#
    Local local10#
    Local local11#
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16#
    catcherrors("UpdateMoving()")
    local0 = ue_players[mp_getmyindex()]
    local2 = 1.0
    local3 = 0.018
    If (((entityhidden(t\Field3[$00]) = $00) And (opt\Field39 = $00)) <> 0) Then
        hideentity(t\Field3[$00])
    EndIf
    If (chs\Field6 <> 0) Then
        cansave = $00
        local3 = (local3 * 3.0)
        chs\Field7 = (chs\Field7 + fps\Field7[$00])
        me\Field23 = (sin((chs\Field7 / 5.0)) * (chs\Field7 / 1500.0))
        If (3500.0 < chs\Field7) Then
            msg\Field2 = getlocalstring("death", "superman")
            kill($00, $01, $00, $01)
            If ((entityhidden(t\Field3[$00]) And opt\Field39) <> 0) Then
                showentity(t\Field3[$00])
            EndIf
        Else
            me\Field49 = 500.0
            If (entityhidden(t\Field3[$00]) = $00) Then
                hideentity(t\Field3[$00])
            EndIf
        EndIf
    EndIf
    If (0.0 < me\Field4) Then
        cansave = $00
        me\Field4 = (me\Field4 - fps\Field7[$00])
        If (1.0 > me\Field4) Then
            me\Field4 = -1.0
        EndIf
    ElseIf (0.0 > me\Field4) Then
        kill($00, $01, $00, $01)
        me\Field4 = 0.0
    EndIf
    If (me\Field20 > me\Field17) Then
        local7 = (0.0 < me\Field38)
        me\Field17 = min(((((((Float local7) * 0.6) + (Float (local7 = $00))) / (i_966\Field1 + 1.0)) * (fps\Field7[$00] * 0.2)) + me\Field17), 100.0)
    EndIf
    me\Field20 = 100.0
    If (0.0 < me\Field19) Then
        me\Field19 = (me\Field19 - (fps\Field7[$00] / 70.0))
    Else
        me\Field18 = 1.0
    EndIf
    If (0.0 < i_966\Field0) Then
        i_966\Field0 = (i_966\Field0 - fps\Field7[$00])
    Else
        i_966\Field1 = 0.0
    EndIf
    If (i_714\Field0 = $02) Then
        me\Field20 = 15.0
        me\Field17 = curvevalue(min(me\Field20, me\Field17), me\Field17, 10.0)
        me\Field5 = max(-850.0, me\Field5)
    ElseIf (i_714\Field0 = $01) Then
        me\Field20 = 30.0
        me\Field17 = curvevalue(min(me\Field20, me\Field17), me\Field17, 15.0)
    Else
        If (((wi\Field3 = $02) Lor (wi\Field2 = $01)) <> 0) Then
            me\Field20 = 60.0
            me\Field17 = curvevalue(min(me\Field20, me\Field17), me\Field17, 20.0)
        EndIf
        If ((((wi\Field0 = $03) Lor (wi\Field2 = $03)) Lor (i_1499\Field0 = $02)) <> 0) Then
            me\Field17 = min(100.0, ((((100.0 - me\Field17) * 0.002) * fps\Field7[$00]) + me\Field17))
        EndIf
        If (((wi\Field0 = $04) Lor (wi\Field2 = $04)) <> 0) Then
            me\Field17 = min(100.0, ((((100.0 - me\Field17) * 0.01) * fps\Field7[$00]) + me\Field17))
        EndIf
    EndIf
    If ((((0.0 = me\Field0) And (chs\Field3 = $00)) And ((keydown(key\Field7) And (invopen = $00)) And (otheropen = Null))) <> 0) Then
        If (5.0 > me\Field17) Then
            If (channelplaying(breathchn) = $00) Then
                local7 = $00
                If ((((wi\Field0 > $00) Lor (i_1499\Field0 > $00)) Lor (wi\Field2 > $00)) <> 0) Then
                    local7 = $01
                EndIf
                breathchn = playsound_strict(breathsfx(local7, $00), $01)
                channelvolume(breathchn, (opt\Field21 * opt\Field16))
            EndIf
        ElseIf (40.0 > me\Field17) Then
            If (channelplaying(breathchn) = $00) Then
                local7 = $00
                If ((((wi\Field0 > $00) Lor (i_1499\Field0 > $00)) Lor (wi\Field2 > $00)) <> 0) Then
                    local7 = $01
                EndIf
                breathchn = playsound_strict(breathsfx(local7, rand($03, $01)), $01)
                channelvolume(breathchn, ((min(((70.0 - me\Field17) / 70.0), 1.0) * opt\Field21) * opt\Field16))
            EndIf
        EndIf
    EndIf
    If (me\Field56 <> 0) Then
        If (me\Field39 <> 0) Then
            setcrouch($00)
        EndIf
    EndIf
    If (0.001 > (Abs (me\Field40 - (Float me\Field39)))) Then
        me\Field40 = (Float me\Field39)
    Else
        me\Field40 = curvevalue((Float me\Field39), me\Field40, 10.0)
    EndIf
    If (((local0 <> Null) And (0.0 >= local0\Field15)) <> 0) Then
        If (me\Field39 = $00) Then
            local0\Field14 = $01
        Else
            local0\Field14 = $04
        EndIf
    EndIf
    local9 = 0.0
    If ((((((d_i\Field6 <> Null) Lor (selectedscreen <> Null)) Lor i_294\Field0) = $00) And (((((menuopen Lor consoleopen) Lor (0.0 > me\Field45)) Lor ismultiplayerhudenabled) And (mp_getsocket() <> $00)) = $00)) <> 0) Then
        If (chs\Field3 = $00) Then
            If (((me\Field9 And (0.0 <= me\Field3)) And (0.0 = me\Field0)) <> 0) Then
                If ((((keydown(key\Field4) Xor keydown(key\Field3)) Lor (keydown(key\Field2) Xor keydown(key\Field1))) Lor (0.0 < me\Field7)) <> 0) Then
                    If (((((me\Field39 = $00) And (me\Field56 = $00)) And ((keydown(key\Field7) And (invopen = $00)) And (otheropen = Null))) And (0.0 < me\Field17)) <> 0) Then
                        me\Field17 = (me\Field17 - ((fps\Field7[$00] * ((i_966\Field1 * 0.4) + 0.4)) * me\Field18))
                        If (0.0 >= me\Field17) Then
                            me\Field17 = -20.0
                        EndIf
                        local2 = 2.5
                        If (((local0 <> Null) And (0.0 >= local0\Field15)) <> 0) Then
                            local0\Field14 = $03
                        EndIf
                    ElseIf (((local0 <> Null) And (0.0 >= local0\Field15)) <> 0) Then
                        If (me\Field39 = $00) Then
                            local0\Field14 = $02
                        Else
                            local0\Field14 = $05
                        EndIf
                    EndIf
                    If (playerroom\Field7\Field6 = $69) Then
                        local10 = entityy(me\Field60, $00)
                        If ((((1.0 / 0.128) > local10) Lor (10.1875 < local10)) <> 0) Then
                            local3 = 0.015
                            me\Field17 = max((me\Field17 - (fps\Field7[$00] * 0.4)), -20.0)
                        EndIf
                    EndIf
                    If (((invopen Lor (otheropen <> Null)) Lor (selectedcorpse <> Null)) <> 0) Then
                        local3 = 0.009
                    EndIf
                    If (0.0 < me\Field7) Then
                        local3 = (me\Field7 * local3)
                    EndIf
                    If (selecteditem <> Null) Then
                        If (((((selecteditem\Field4\Field2 = $34) Lor (selecteditem\Field4\Field2 = $36)) Lor (selecteditem\Field4\Field2 = $35)) And (wi\Field2 = $00)) <> 0) Then
                            local2 = 0.0
                        EndIf
                    EndIf
                    local8 = (me\Field22 Mod 360.0)
                    me\Field22 = ((((fps\Field7[$00] * min(local2, 1.5)) * 7.0) + me\Field22) Mod 720.0)
                    If (((180.0 > local8) And (180.0 <= (me\Field22 Mod 360.0))) <> 0) Then
                        playstepsound((2.5 = local2))
                    EndIf
                EndIf
                If (((((keyhit(key\Field10) And (me\Field56 = $00)) And (60.0 >= me\Field32)) And (27300.0 > i_427\Field1)) And ((selecteditem = Null) Lor (((selecteditem\Field4\Field2 <> $34) And (selecteditem\Field4\Field2 <> $36)) And (selecteditem\Field4\Field2 <> $35)))) <> 0) Then
                    setcrouch((me\Field39 = $00))
                EndIf
            EndIf
        ElseIf (((keydown(key\Field7) And (invopen = $00)) And (otheropen = Null)) <> 0) Then
            local2 = 2.5
        ElseIf (keydown(key\Field10) <> 0) Then
            local2 = 0.5
        EndIf
        local11 = ((local3 * local2) / (me\Field40 + 1.0))
        If (chs\Field3 <> 0) Then
            me\Field22 = 0.0
            me\Field38 = 0.0
            me\Field39 = $00
            rotateentity(me\Field60, wrapangle(entitypitch(camera, $00), 360.0), wrapangle(entityyaw(camera, $00), 360.0), 0.0, $00)
            local11 = (chs\Field4 * local11)
            If (keydown(key\Field4) <> 0) Then
                moveentity(me\Field60, 0.0, 0.0, (fps\Field7[$00] * (- local11)))
            EndIf
            If (keydown(key\Field3) <> 0) Then
                moveentity(me\Field60, 0.0, 0.0, (fps\Field7[$00] * local11))
            EndIf
            If (keydown(key\Field1) <> 0) Then
                moveentity(me\Field60, (fps\Field7[$00] * (- local11)), 0.0, 0.0)
            EndIf
            If (keydown(key\Field2) <> 0) Then
                moveentity(me\Field60, (fps\Field7[$00] * local11), 0.0, 0.0)
            EndIf
            resetentity(me\Field60)
        Else
            local11 = (local11 / max((((me\Field31 + 3.0) - ((Float (0.0 < i_1025\Field1[$03])) * 2.25)) / 3.0), 1.0))
            If (0.5 < me\Field31) Then
                local11 = (min((sin((me\Field22 / 2.0)) + 1.2), 1.0) * local11)
            EndIf
            local8 = 0.0
            If (((me\Field9 And (0.0 <= me\Field3)) And (0.0 = me\Field0)) <> 0) Then
                If (me\Field56 = $00) Then
                    If ((((keydown(key\Field7) = $00) And (invopen = $00)) And (otheropen = Null)) <> 0) Then
                        If (keydown(key\Field12) <> 0) Then
                            If (keydown(key\Field13) = $00) Then
                                local9 = 15.0
                            EndIf
                        ElseIf (keydown(key\Field13) <> 0) Then
                            local9 = -15.0
                        EndIf
                    EndIf
                    If (keydown(key\Field4) <> 0) Then
                        If (keydown(key\Field3) = $00) Then
                            local8 = 1.0
                            local6 = 180.0
                            If (keydown(key\Field1) <> 0) Then
                                If (keydown(key\Field2) = $00) Then
                                    local6 = 135.0
                                EndIf
                            ElseIf (keydown(key\Field2) <> 0) Then
                                local6 = -135.0
                            EndIf
                        ElseIf (keydown(key\Field1) <> 0) Then
                            If (keydown(key\Field2) = $00) Then
                                local8 = 1.0
                                local6 = 90.0
                            EndIf
                        ElseIf (keydown(key\Field2) <> 0) Then
                            local8 = 1.0
                            local6 = -90.0
                        EndIf
                    ElseIf (keydown(key\Field3) <> 0) Then
                        local8 = 1.0
                        local6 = 0.0
                        If (keydown(key\Field1) <> 0) Then
                            If (keydown(key\Field2) = $00) Then
                                local6 = 45.0
                            EndIf
                        ElseIf (keydown(key\Field2) <> 0) Then
                            local6 = -45.0
                        EndIf
                    ElseIf (0.0 < me\Field7) Then
                        local8 = 1.0
                        local6 = me\Field8
                    ElseIf (keydown(key\Field1) <> 0) Then
                        If (keydown(key\Field2) = $00) Then
                            local8 = 1.0
                            local6 = 90.0
                        EndIf
                    ElseIf (keydown(key\Field2) <> 0) Then
                        local8 = 1.0
                        local6 = -90.0
                    EndIf
                Else
                    local8 = 1.0
                    local6 = me\Field8
                EndIf
                local6 = wrapangle(((entityyaw(me\Field60, $01) + local6) + 90.0), 360.0)
                If ((Int local8) <> 0) Then
                    me\Field38 = curvevalue(local11, me\Field38, 20.0)
                Else
                    me\Field38 = max(curvevalue(0.0, (me\Field38 - 0.1), 1.0), 0.0)
                EndIf
                translateentity(me\Field60, ((me\Field38 * cos(local6)) * fps\Field7[$00]), 0.0, ((me\Field38 * sin(local6)) * fps\Field7[$00]), $01)
            EndIf
        EndIf
        me\Field7 = 0.0
    EndIf
    me\Field41 = curvevalue(local9, me\Field41, (((Float (3.0 < me\Field31)) * 6.0) + 6.0))
    If (chs\Field3 = $00) Then
        local12 = $00
        local13 = countcollisions(me\Field60)
        For local5 = $01 To local13 Step $01
            If ((entityy(me\Field60, $00) - 0.25) > collisiony(me\Field60, local5)) Then
                local12 = $01
                Exit
            EndIf
        Next
        If (local12 <> 0) Then
            If (-0.07 > me\Field36) Then
                playstepsound((2.5 = local2))
                If (local0 <> Null) Then
                    local0\Field14 = $07
                    local0\Field15 = 35.0
                EndIf
            EndIf
            me\Field36 = 0.0
        Else
            If (0.0 <> playerfallingpickdistance) Then
                local14 = linepick(entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00), 0.0, (- playerfallingpickdistance), 0.0, 0.0)
                If (local14 <> 0) Then
                    me\Field36 = clamp((me\Field36 - (fps\Field7[$00] * 0.006)), -2.0, 0.0)
                Else
                    me\Field36 = 0.0
                EndIf
            Else
                me\Field36 = clamp((me\Field36 - (fps\Field7[$00] * 0.006)), -2.0, 0.0)
            EndIf
            If (-0.07 > me\Field36) Then
                If (((local0 <> Null) And (0.0 >= local0\Field15)) <> 0) Then
                    local0\Field14 = $06
                EndIf
            EndIf
        EndIf
        playerfallingpickdistance = 10.0
        If ((me\Field9 And shouldentitiesfall) <> 0) Then
            translateentity(me\Field60, 0.0, (me\Field36 * fps\Field7[$00]), 0.0, $00)
        EndIf
    ElseIf (local0 <> Null) Then
        local0\Field14 = $06
        me\Field36 = -0.1
    EndIf
    If (local0 <> Null) Then
        local0\Field15 = (local0\Field15 - fps\Field7[$01])
    EndIf
    update008()
    update409()
    update1048aears()
    local15 = $00
    If (1.0 < me\Field31) Then
        local11 = me\Field32
        me\Field49 = max(max(((sin(((Float millisec) / 100.0)) * me\Field32) * 30.0), ((me\Field32 * 2.0) * (2.0 - me\Field40))), me\Field49)
        If (((i_427\Field0 = $00) And (25200.0 > i_427\Field1)) <> 0) Then
            me\Field32 = min((((min(me\Field31, 3.5) / 300.0) * fps\Field7[$00]) + me\Field32), 100.0)
        EndIf
        If (((60.0 >= local11) And (60.0 < me\Field32)) <> 0) Then
            createmsg(getlocalstring("msg", "bloodloss"), 6.0)
        EndIf
        If (((0.0 < me\Field32) And (0.0 <= me\Field26)) <> 0) Then
            If (min(me\Field31, 4.0) > rnd(200.0, 0.0)) Then
                If ((mp_ishoster() Lor (mp_getsocket() = $00)) <> 0) Then
                    local4 = createpivot($00)
                    positionentity(local4, (entityx(me\Field60, $00) + rnd(-0.05, 0.05)), (entityy(me\Field60, $00) - 0.05), (entityz(me\Field60, $00) + rnd(-0.05, 0.05)), $00)
                    turnentity(local4, 90.0, 0.0, 0.0, $00)
                    entitypick(local4, 0.3)
                    local1 = createdecal(rand($10, $11), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, rnd(360.0, 0.0), 0.0, (rnd(0.03, 0.08) * min(me\Field31, 2.5)), 1.0, $00, $01, $00, $00, $00)
                    local1\Field4 = rnd(0.001, 0.0015)
                    local1\Field5 = (local1\Field3 + rnd(0.008, 0.009))
                    entityparent(local1\Field0, playerroom\Field2, $01)
                    mp_server_synchronizedecal(local1, playerroom\Field31)
                    freeentity(local4)
                    local4 = $00
                EndIf
                local15 = playsound_strict(snd_i\Field30[rand($00, $03)], $00)
                channelvolume(local15, ((rnd(0.0, 0.8) * opt\Field20) * opt\Field16))
                channelpitch(local15, (Float rand($4E20, $7530)))
            EndIf
            me\Field52 = max(me\Field52, (((sin(((Float millisec) / 20.0)) + 1.0) * me\Field32) * 0.2))
            If (60.0 < me\Field32) Then
                cansave = $00
                If (((me\Field39 = $00) And (chs\Field3 = $00)) <> 0) Then
                    setcrouch($01)
                EndIf
            EndIf
            If (100.0 <= me\Field32) Then
                me\Field30 = 0.0
                kill($01, $01, $00, $01)
            ElseIf (80.0 < me\Field32) Then
                me\Field28 = max((150.0 - ((me\Field32 - 80.0) * 5.0)), me\Field28)
                me\Field30 = max(me\Field30, (((me\Field32 - 80.0) * (1.0 / 80.0)) + 0.75))
            ElseIf (35.0 < me\Field32) Then
                me\Field28 = max((me\Field32 + 70.0), me\Field28)
                me\Field30 = max(me\Field30, ((me\Field32 - 35.0) / 60.0))
            EndIf
        EndIf
    ElseIf (60.0 < me\Field32) Then
        me\Field32 = max(60.0, (me\Field32 - (fps\Field7[$00] / ((me\Field31 + 1.0) * 490.0))))
    EndIf
    If (0.0 < me\Field35) Then
        local16 = (fps\Field7[$00] / 70.0)
        me\Field32 = min((me\Field32 + (local16 / 4.0)), 100.0)
        me\Field31 = max((me\Field31 - (local16 / 40.0)), 0.0)
        me\Field35 = max((me\Field35 - local16), 0.0)
    EndIf
    If (0.0 < me\Field30) Then
        If (0.0 >= me\Field29) Then
            local15 = playsound_strict(snd_i\Field52, $00)
            channelvolume(local15, ((me\Field30 * opt\Field20) * opt\Field16))
            me\Field29 = ((60.0 / max(me\Field28, 1.0)) * 70.0)
        Else
            me\Field29 = (me\Field29 - fps\Field7[$00])
        EndIf
        me\Field30 = max((me\Field30 - (fps\Field7[$00] * 0.05)), 0.0)
    EndIf
    catcherrors("Uncaught: UpdateMoving()")
    Return $00
End Function
