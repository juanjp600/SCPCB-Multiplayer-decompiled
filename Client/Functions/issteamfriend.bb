Function issteamfriend%(arg0$)
    Local local0%
    For local0 = $00 To $7D0 Step $01
        If (steamfriends[local0] = "") Then
            Exit
        EndIf
        If (steamfriends[local0] = arg0) Then
            Return $01
        EndIf
    Next
    Return $00
    Return $00
End Function
