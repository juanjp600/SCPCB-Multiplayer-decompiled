Function update427%()
    Local local0.decals
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5#
    local5 = i_427\Field1
    If (25200.0 > i_427\Field1) Then
        If (i_427\Field0 <> 0) Then
            i_427\Field1 = (i_427\Field1 + fps\Field7[$00])
            If (0.0 < me\Field31) Then
                me\Field31 = max((me\Field31 - (fps\Field7[$00] * 0.0006)), 0.0)
            EndIf
            If (((0.0 < me\Field32) And (1.0 >= me\Field31)) <> 0) Then
                me\Field32 = max((me\Field32 - (fps\Field7[$00] * 0.001)), 0.0)
            EndIf
            If (0.0 < i_008\Field0) Then
                i_008\Field0 = max((i_008\Field0 - (fps\Field7[$00] * 0.001)), 0.0)
            EndIf
            If (0.0 < i_409\Field0) Then
                i_409\Field0 = max((i_409\Field0 - (fps\Field7[$00] * 0.003)), 0.0)
            EndIf
            If (0.0 < i_1048a\Field0) Then
                i_1048a\Field0 = max((i_1048a\Field0 - (fps\Field7[$00] / 2.0)), 0.0)
            EndIf
            For local2 = $00 To $06 Step $01
                If (0.0 < i_1025\Field0[local2]) Then
                    i_1025\Field0[local2] = max((i_1025\Field0[local2] - (fps\Field7[$00] * 0.001)), 0.0)
                EndIf
            Next
            If (0.0 < i_1025\Field1[$00]) Then
                If (0.05 > i_1025\Field1[$00]) Then
                    For local2 = (maxitemamount - $02) To (maxitemamount - $01) Step $01
                        If (inventory(local2) <> Null) Then
                            dropitem(inventory(local2), $01)
                        EndIf
                    Next
                    maxitemamount = (maxitemamount - $02)
                    i_1025\Field1[$00] = 0.0
                Else
                    i_1025\Field1[$00] = max((i_1025\Field1[$00] - (fps\Field7[$00] * 0.0003)), 0.0)
                EndIf
            EndIf
            i_1025\Field1[$01] = max((i_1025\Field1[$01] - (fps\Field7[$00] * 0.0008)), 0.0)
            For local2 = $02 To $04 Step $01
                If (0.0 < i_1025\Field1[local2]) Then
                    i_1025\Field1[local2] = max((i_1025\Field1[local2] - (fps\Field7[$00] * 0.0006)), 0.0)
                EndIf
            Next
            If (i_427\Field2[$00] = $00) Then
                i_427\Field2[$00] = loadsound_strict("SFX\SCP\427\Effect.ogg")
            EndIf
            If (channelplaying(i_427\Field3[$00]) = $00) Then
                i_427\Field3[$00] = playsound_strict(i_427\Field2[$00], $00)
            EndIf
            If (12600.0 <= i_427\Field1) Then
                If (i_427\Field2[$01] = $00) Then
                    i_427\Field2[$01] = loadsound_strict("SFX\SCP\427\Transform.ogg")
                EndIf
                If (channelplaying(i_427\Field3[$01]) = $00) Then
                    i_427\Field3[$01] = playsound_strict(i_427\Field2[$01], $00)
                EndIf
            EndIf
            If (((4200.0 > local5) And (4200.0 <= i_427\Field1)) <> 0) Then
                createmsg(getlocalstring("msg", "freshener"), 6.0)
            ElseIf (((12600.0 > local5) And (12600.0 <= i_427\Field1)) <> 0) Then
                createmsg(getlocalstring("msg", "gentlemuscle"), 6.0)
            EndIf
        Else
            For local2 = $00 To $01 Step $01
                If (channelplaying(i_427\Field3[local2]) <> 0) Then
                    stopchannel(i_427\Field3[local2])
                    i_427\Field3[local2] = $00
                EndIf
            Next
        EndIf
    Else
        cansave = $00
        If (((25200.0 > (local5 - fps\Field7[$00])) And (25200.0 <= i_427\Field1)) <> 0) Then
            createmsg(getlocalstring("msg", "muscleswelling"), 6.0)
        ElseIf (((27300.0 > (local5 - fps\Field7[$00])) And (27300.0 <= i_427\Field1)) <> 0) Then
            createmsg(getlocalstring("msg", "nolegs"), 6.0)
        EndIf
        i_427\Field1 = (i_427\Field1 + fps\Field7[$00])
        If (i_427\Field2[$00] = $00) Then
            i_427\Field2[$00] = loadsound_strict("SFX\SCP\427\Effect.ogg")
        EndIf
        If (i_427\Field2[$01] = $00) Then
            i_427\Field2[$01] = loadsound_strict("SFX\SCP\427\Transform.ogg")
        EndIf
        For local2 = $00 To $01 Step $01
            If (channelplaying(i_427\Field3[local2]) = $00) Then
                i_427\Field3[local2] = playsound_strict(i_427\Field2[local2], $00)
            EndIf
        Next
        If (2.0 > rnd(200.0, 0.0)) Then
            local3 = createpivot($00)
            positionentity(local3, (entityx(me\Field60, $00) + rnd(-0.05, 0.05)), (entityy(me\Field60, $00) - 0.05), (entityz(me\Field60, $00) + rnd(-0.05, 0.05)), $00)
            turnentity(local3, 90.0, 0.0, 0.0, $00)
            entitypick(local3, 0.3)
            local0 = createdecal($12, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, rnd(360.0, 0.0), 0.0, (rnd(0.03, 0.08) * 2.0), 1.0, $00, $01, $00, $00, $00)
            local0\Field4 = rnd(0.001, 0.0015)
            local0\Field5 = (local0\Field3 + 0.009)
            entityparent(local0\Field0, playerroom\Field2, $01)
            local4 = playsound_strict(snd_i\Field30[rand($00, $03)], $00)
            channelvolume(local4, ((rnd(0.0, 0.8) * opt\Field20) * opt\Field16))
            channelpitch(local4, rand($4E20, $7530))
            freeentity(local3)
            local3 = $00
            me\Field49 = 800.0
        EndIf
        If (29400.0 <= i_427\Field1) Then
            msg\Field2 = getlocalstring("death", "morepower")
            kill($00, $01, $00, $01)
        ElseIf (27300.0 <= i_427\Field1) Then
            If (me\Field39 = $00) Then
                setcrouch($01)
            EndIf
        EndIf
    EndIf
    Return $00
End Function
