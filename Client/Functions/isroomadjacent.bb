Function isroomadjacent%(arg0.rooms, arg1.rooms)
    Local local0%
    If (((arg0 = Null) Lor (arg1 = Null)) <> 0) Then
        Return $00
    EndIf
    If (arg0 = arg1) Then
        Return $01
    EndIf
    For local0 = $00 To $03 Step $01
        If (arg1 = arg0\Field19[local0]) Then
            Return $01
        EndIf
    Next
    Return $00
    Return $00
End Function
