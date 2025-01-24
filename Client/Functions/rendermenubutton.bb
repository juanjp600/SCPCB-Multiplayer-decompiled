Function rendermenubutton%(arg0.menubutton)
    If (arg0\Field13 = $00) Then
        renderframe(arg0\Field0, arg0\Field1, arg0\Field2, arg0\Field3, (arg0\Field0 Mod $100), (arg0\Field1 Mod $100), arg0\Field6)
        If (((mouseon(arg0\Field0, arg0\Field1, arg0\Field2, arg0\Field3) And (arg0\Field7 = $00)) Lor (arg0\Field6 And arg0\Field7)) <> 0) Then
            color($1E, $1E, $1E)
            rect((Int ((Float arg0\Field0) + (3.0 * menuscale))), (Int ((Float arg0\Field1) + (3.0 * menuscale))), (Int ((Float arg0\Field2) - (6.0 * menuscale))), (Int ((Float arg0\Field3) - (6.0 * menuscale))), $01)
        EndIf
        If (arg0\Field6 <> 0) Then
            If ((((arg0\Field8 <> $FF) Lor (arg0\Field9 <> $FF)) Lor (arg0\Field10 <> $FF)) <> 0) Then
                color(arg0\Field8, arg0\Field9, arg0\Field10)
            Else
                color($64, $64, $64)
            EndIf
        Else
            color(arg0\Field8, arg0\Field9, arg0\Field10)
        EndIf
        setfontex(fo\Field0[arg0\Field5])
        textex((Int (((Float (arg0\Field2 Sar $01)) * arg0\Field11) + (Float arg0\Field0))), (arg0\Field1 + (arg0\Field3 Sar $01)), arg0\Field4, (1.0 = arg0\Field11), $01)
        arg0\Field13 = $01
    EndIf
    Return $00
End Function
