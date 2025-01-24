Function rendercredits%()
    Local local0.creditsline
    Local local1.creditsline
    Local local2#
    Local local3%
    Local local4%
    Local local5%
    local2 = (((me\Field45 + 2000.0) / 2.0) + ((Float opt\Field47) + 10.0))
    local3 = $00
    local4 = $00
    cls()
    hidepointer()
    If (rand($12C, $01) > $01) Then
        drawblock(me\Field46, (Int ((Float mo\Field9) - (400.0 * menuscale))), (Int ((Float mo\Field10) - (400.0 * menuscale))), $00)
    EndIf
    local1 = Null
    color($FF, $FF, $FF)
    For local0 = Each creditsline
        local0\Field1 = local3
        If (left(local0\Field0, $01) = "*") Then
            setfontex(fo\Field0[$07])
            If (local0\Field2 = $00) Then
                textex(mo\Field9, (Int (((Float (local0\Field1 * $18)) * menuscale) + local2)), right(local0\Field0, (len(local0\Field0) - $01)), $01, $00)
            EndIf
        ElseIf (left(local0\Field0, $01) = "/") Then
            local1 = (Before local0)
        Else
            setfontex(fo\Field0[$06])
            If (local0\Field2 = $00) Then
                textex(mo\Field9, (Int (((Float (local0\Field1 * $18)) * menuscale) + local2)), local0\Field0, $01, $00)
            EndIf
        EndIf
        If (local1 <> Null) Then
            local0\Field2 = (local0\Field1 > local1\Field1)
        EndIf
        If (local0\Field2 <> 0) Then
            local4 = (local4 + $01)
        EndIf
        local3 = (local3 + $01)
    Next
    If ((Float (- stringheight(local1\Field0))) > (((Float (local1\Field1 * $18)) * menuscale) + local2)) Then
        If (((0.0 <= me\Field47) And (255.0 > me\Field47)) <> 0) Then
            local5 = (Int clamp(me\Field47, 0.0, 255.0))
            color(local5, local5, local5)
        ElseIf (255.0 <= me\Field47) Then
            color($FF, $FF, $FF)
        Else
            local5 = (Int clamp((- me\Field47), 0.0, 255.0))
            color(local5, local5, local5)
        EndIf
    EndIf
    If (0.0 <> me\Field47) Then
        For local0 = Each creditsline
            If (local0\Field2 <> 0) Then
                setfontex(fo\Field0[$06])
                If (left(local0\Field0, $01) = "/") Then
                    textex(mo\Field9, (Int ((Float (mo\Field10 + (local4 Sar $01))) + ((Float (local0\Field1 * $18)) * menuscale))), right(local0\Field0, (len(local0\Field0) - $01)), $01, $00)
                Else
                    textex(mo\Field9, (Int ((((Float ((local0\Field1 - local1\Field1) * $18)) * menuscale) + (Float mo\Field10)) - ((Float ((local4 Sar $01) * $18)) * menuscale))), local0\Field0, $01, $00)
                EndIf
            EndIf
        Next
    EndIf
    renderloadingtext((Int (20.0 * menuscale)), (Int ((Float opt\Field47) - (35.0 * menuscale))), getlocalstring("menu", "anykey"), $00, $00)
    If (-1.0 = me\Field47) Then
        freefont(fo\Field0[$06])
        fo\Field0[$06] = $00
        freefont(fo\Field0[$07])
        fo\Field0[$07] = $00
        freeimage(me\Field46)
        me\Field46 = $00
        freeimage(me\Field44)
        me\Field44 = $00
        Return $00
    EndIf
    Return $00
End Function
