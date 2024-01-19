Function object_getid%()
    Local local0%
    For local0 = $01 To $FE Step $01
        If (multiplayer_object[local0] = Null) Then
            Return local0
        EndIf
    Next
    Return $00
End Function
