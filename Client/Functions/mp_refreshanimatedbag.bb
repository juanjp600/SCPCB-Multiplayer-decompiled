Function mp_refreshanimatedbag%(arg0.items, arg1%)
    Select arg0\Field4\Field2
        Case $2D
            setanimtime(arg0\Field3, ((Float (arg1 = $00)) * 17.0), $00)
        Case $2E
            setanimtime(arg0\Field3, ((Float arg1) * 4.0), $00)
    End Select
    If (arg1 <> 0) Then
        arg0\Field17 = arg0\Field4\Field7
    Else
        arg0\Field17 = arg0\Field4\Field8
    EndIf
    Return $00
End Function
