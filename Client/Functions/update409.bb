Function update409%()
    Local local0#
    If (0.0 < i_409\Field0) Then
        local0 = i_409\Field0
        If (entityhidden(t\Field3[$07]) <> 0) Then
            showentity(t\Field3[$07])
        EndIf
        If (25200.0 > i_427\Field1) Then
            If (i_409\Field1 <> 0) Then
                i_409\Field0 = max((i_409\Field0 - (fps\Field7[$00] * 0.02)), 0.0)
            ElseIf (i_427\Field0 = $00) Then
                i_409\Field0 = min((i_409\Field0 + (fps\Field7[$00] * 0.004)), 100.0)
                me\Field49 = max(((i_409\Field0 * 3.0) * (2.0 - me\Field40)), me\Field49)
            EndIf
        EndIf
        entityalpha(t\Field3[$07], min((((i_409\Field0 * 0.2) * (i_409\Field0 * 0.2)) / 1000.0), 0.5))
        If (i_409\Field1 <> 0) Then
            If (((40.0 >= i_409\Field0) And (40.0 < local0)) <> 0) Then
                createmsg(getlocalstring("msg", "409legs_1"), 6.0)
            ElseIf (((55.0 >= i_409\Field0) And (55.0 < local0)) <> 0) Then
                createmsg(getlocalstring("msg", "409abdomen_1"), 6.0)
            ElseIf (((70.0 >= i_409\Field0) And (70.0 < local0)) <> 0) Then
                createmsg(getlocalstring("msg", "409arms_1"), 6.0)
            ElseIf (((85.0 >= i_409\Field0) And (85.0 < local0)) <> 0) Then
                createmsg(getlocalstring("msg", "409head_1"), 6.0)
            EndIf
        ElseIf (((40.0 < i_409\Field0) And (40.0 >= local0)) <> 0) Then
            createmsg(getlocalstring("msg", "409legs_2"), 6.0)
            playsound_strict(loadtempsound("SFX\SCP\409\Crackling0.ogg"), $00)
        ElseIf (((55.0 < i_409\Field0) And (55.0 >= local0)) <> 0) Then
            createmsg(getlocalstring("msg", "409abdomen_2"), 6.0)
            playsound_strict(loadtempsound("SFX\SCP\409\Crackling0.ogg"), $00)
        ElseIf (((70.0 < i_409\Field0) And (70.0 >= local0)) <> 0) Then
            createmsg(getlocalstring("msg", "409arms_2"), 6.0)
            playsound_strict(loadtempsound("SFX\SCP\409\Crackling0.ogg"), $00)
        ElseIf (((85.0 < i_409\Field0) And (85.0 >= local0)) <> 0) Then
            createmsg(getlocalstring("msg", "409head_2"), 6.0)
            playsound_strict(loadtempsound("SFX\SCP\409\Crackling1.ogg"), $00)
        ElseIf (((93.0 < i_409\Field0) And (93.0 >= local0)) <> 0) Then
            If (i_409\Field1 = $00) Then
                playsound_strict(snd_i\Field51[$0D], $01)
                me\Field31 = max(me\Field31, 2.0)
            EndIf
        ElseIf (94.0 < i_409\Field0) Then
            i_409\Field0 = min((i_409\Field0 + (fps\Field7[$00] * 0.004)), 100.0)
            makemeunplayable()
            me\Field49 = 4.0
            me\Field23 = 3.0
        EndIf
        If (55.0 <= i_409\Field0) Then
            me\Field18 = 1.2
            me\Field19 = 1.0
            me\Field17 = min(me\Field17, 60.0)
        EndIf
        If (96.92 <= i_409\Field0) Then
            msg\Field2 = format(getlocalstring("death", "409"), subjectname, "%s")
            kill($01, $01, $00, $01)
        EndIf
    Else
        i_409\Field1 = $00
        If (entityhidden(t\Field3[$07]) = $00) Then
            hideentity(t\Field3[$07])
        EndIf
    EndIf
    Return $00
End Function
