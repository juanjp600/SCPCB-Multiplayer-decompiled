Function rendermenuinputboxes%()
    Local local0.menuinputbox
    For local0 = Each menuinputbox
        renderframe(local0\Field0, local0\Field1, local0\Field2, local0\Field3, (local0\Field0 Mod $100), (local0\Field1 Mod $100), $00)
        If (mouseon(local0\Field0, local0\Field1, local0\Field2, local0\Field3) <> 0) Then
            color($32, $32, $32)
            rect((Int ((Float local0\Field0) + (3.0 * menuscale))), (Int ((Float local0\Field1) + (3.0 * menuscale))), (Int ((Float local0\Field2) - (6.0 * menuscale))), (Int ((Float local0\Field3) - (6.0 * menuscale))), $01)
        EndIf
        color($FF, $FF, $FF)
        If (selectedinputbox = local0\Field6) Then
            If ((((((millisec Mod $320) < $190) Lor keydown($CD)) Lor keydown($CB)) Lor insertmode) <> 0) Then
                rect((Int ((((Float (local0\Field2 Sar $01)) * local0\Field7) + (Float local0\Field0)) + ((Float stringwidth(left(local0\Field4, (Int max((Float cursorpos), 0.0))))) / (2.0 - (Float (1.0 <> local0\Field7)))))), (Int ((Float (local0\Field1 + (local0\Field3 Sar $01))) - (5.0 * menuscale))), (Int (2.0 * menuscale)), (Int (12.0 * menuscale)), $01)
            EndIf
        EndIf
        setfontex(fo\Field0[local0\Field5])
        textex((Int (((Float (local0\Field2 Sar $01)) * local0\Field7) + (Float local0\Field0))), (local0\Field1 + (local0\Field3 Sar $01)), local0\Field4, (Int local0\Field7), $01)
    Next
    Return $00
End Function
