Function rcon_banip%(arg0$)
    Local local0$
    Local local1.players
    Local local2.banned
    Local local3%
    local0 = "player_cache\local\ipbanlist.dat"
    If (filetype(local0) = $00) Then
        createfile(local0)
    EndIf
    For local1 = Each players
        If (local1\Field40 = arg0) Then
            kick(local1\Field30, (("[RCON] " + local1\Field15) + " has been banned."), "You've been banned from the server.")
        EndIf
    Next
    local2 = (New banned)
    local2\Field1 = arg0
    local3 = openfile(local0)
    seekfile(local3, filesize(local0))
    writeline(local3, arg0)
    closefile(local3)
    Return $00
End Function
