Function getsteamfriends%()
    Local local0%
    For local0 = $00 To $7D0 Step $01
        steamfriends[local0] = ""
    Next
    For local0 = $00 To steam_getfriendcount() Step $01
        steamfriends[local0] = steam_idtostring(steam_getfriendidupper(local0), steam_getfriendidlower(local0))
    Next
    Return $00
End Function
