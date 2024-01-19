Function findfreeroomid%()
    Local local0%
    For local0 = $01 To $C7 Step $01
        If (room[local0] = Null) Then
            Return local0
        EndIf
    Next
    Return $00
End Function
