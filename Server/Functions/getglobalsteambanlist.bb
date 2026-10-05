Function getglobalsteambanlist%()
    Local local0%
    local0 = downloadfile("https://raw.githubusercontent.com/FusionCreators/CentralServer-ListFetch/refs/heads/main/steambanlist.dat", "player_cache\global\steambanlist.dat")
    If (local0 = $00) Then
        addlog("[RCON] Global Steam banlist successfully downloaded.", $00, $00, $00, $00, $FF, $00)
    Else
        addlog("[WARNING][RCON] Global Steam banlist couldn't be downloaded. [Error code:", $00, $00, $00, $FF, $FF, $00)
    EndIf
    Return (local0 = $00)
    Return $00
End Function
