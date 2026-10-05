Function getglobalbanlists%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    If (server\Field86 = $FFFFFFFF) Then
        Return $00
    EndIf
    If (filetype("player_cache") <> $02) Then
        createdir("player_cache")
    EndIf
    If (filetype("player_cache\global") <> $02) Then
        createdir("player_cache\global")
    EndIf
    If (filetype("player_cache\local") <> $02) Then
        createdir("player_cache\local")
    EndIf
    local1 = openfile("player_cache\info.dat")
    If (filesize("player_cache\info.dat") <> $00) Then
        local0 = (Int readline(local1))
    Else
        createfile("player_cache\info.dat")
        local1 = openfile("player_cache\info.dat")
    EndIf
    If (local0 < millisecs()) Then
        local2 = getglobalipbanlist()
        local3 = getglobalsteambanlist()
        seekfile(local1, $00)
        writeline(local1, (Str (millisecs() + server\Field86)))
    EndIf
    rcon_globalloadbaniplist((local2 = $00))
    rcon_globalloadbansteamlist((local3 = $00))
    closefile(local1)
    Return $00
End Function
