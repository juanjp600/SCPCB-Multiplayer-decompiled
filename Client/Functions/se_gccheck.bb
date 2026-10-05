Function se_gccheck%(arg0.se_value)
    If (arg0 = Null) Then
        Return $00
    EndIf
    If (arg0\Field0 = $07) Then
        If (arg0\Field6 <> Null) Then
            arg0\Field6\Field0 = (arg0\Field6\Field0 - $01)
        EndIf
    EndIf
    Return $00
End Function
