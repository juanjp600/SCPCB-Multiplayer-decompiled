Function findfreedoorid%()
    Local local0%
    For local0 = $01 To $1F3 Step $01
        If (multiplayer_door[local0] = Null) Then
            Return local0
        EndIf
    Next
    Return $00
End Function
