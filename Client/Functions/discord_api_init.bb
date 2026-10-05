Function discord_api_init%()
    If (discordrichpresence <> 0) Then
        discordactive = (blitzcordcreatecore("1055744400602447872") = $00)
        If (discordactive <> 0) Then
            blitzcordsetlargeimage("logo")
        EndIf
    EndIf
    Return $00
End Function
