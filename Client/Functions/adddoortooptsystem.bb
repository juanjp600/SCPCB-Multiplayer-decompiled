Function adddoortooptsystem%(arg0.rooms, arg1.doors)
    Local local0%
    For local0 = $01 To $13 Step $01
        If (arg0\Field30[local0] = Null) Then
            arg0\Field31 = local0
            arg0\Field30[local0] = arg1
            Exit
        EndIf
    Next
    Return $00
End Function
