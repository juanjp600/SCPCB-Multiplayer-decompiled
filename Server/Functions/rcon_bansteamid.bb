Function rcon_bansteamid%(arg0$, arg1%)
    Local local0.players
    Local local1.banned
    Local local2%
    If (filetype(arg0) = $00) Then
        createfile(arg0)
    EndIf
    For local0 = Each players
        If (local0\Field129 = arg1) Then
            kick(local0\Field30, (("[RCON] " + local0\Field15) + " has been banned."))
        EndIf
    Next
    local1 = (New banned)
    local1\Field2 = arg1
    local2 = openfile(arg0)
    seekfile(local2, filesize(arg0))
    writeline(local2, (Str arg1))
    closefile(local2)
    Return $00
End Function
