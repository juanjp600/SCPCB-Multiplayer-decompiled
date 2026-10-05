Function updateconsole%()
    Local local0$
    Local local1$
    Local local2$
    Local local4$
    Local local5%
    Local local6$
    Local local7.players
    Local local8$
    Local local9%
    Local local10.banned
    local2 = console_readline()
    If (trim(local2) <> "") Then
        If (instr(local2, " ", $01) <> $00) Then
            local0 = left(trim(local2), (instr(local2, " ", $01) - $01))
            local1 = mid(trim(local2), (instr(local2, " ", $01) + $01), $FFFFFFFF)
        Else
            local0 = trim(local2)
        EndIf
        local0 = lower(local0)
        Select local0
            Case "help"
                addlog("quit/exit [opt:msg]", $00, $00, $00, $C0, $C0, $C0)
                addlog("restart", $00, $00, $00, $C0, $C0, $C0)
                addlog("say [req:msg]", $00, $00, $00, $C0, $C0, $C0)
                addlog("kick [req:id/name] [opt:msg]", $00, $00, $00, $C0, $C0, $C0)
                addlog("ban [req:id/name] [opt:msg]", $00, $00, $00, $C0, $C0, $C0)
            Case "quit","exit"
                console_setinputenabled($00)
                addlog("Shutting down...", $00, $00, $00, $C0, $C0, $C0)
                local4 = trim(local1)
                If (local4 = "") Then
                    local4 = "The server has shut down."
                Else
                    local4 = ("The server has shut down: " + local4)
                EndIf
                If (server\Field87\Field7 <> 0) Then
                    gs_logoff()
                    gs_shutdown()
                EndIf
                For local5 = $01 To $41 Step $01
                    If (player[local5] <> Null) Then
                        kick(local5, "", local4)
                    EndIf
                Next
                end()
            Case "restart"
                restartserver("")
            Case "say"
                addlog(("[SERVER]: " + local1), $00, $01, $00, $C0, $C0, $C0)
            Case "kick"
                If (instr(local1, " ", $01) <> $00) Then
                    local6 = left(trim(local1), (instr(local1, " ", $01) - $01))
                    local4 = mid(trim(local1), (instr(local1, " ", $01) + $01), $FFFFFFFF)
                Else
                    local6 = local1
                EndIf
                If (local4 = "") Then
                    local4 = "You've been kicked from the server."
                Else
                    local4 = ("You've been kicked from the server: " + local4)
                EndIf
                If (hasletters(local6) <> 0) Then
                    For local7 = Each players
                        If (local7\Field15 = local6) Then
                            kick(local7\Field30, (("[SERVER] " + local7\Field15) + " has been kicked."), local4)
                            Return $00
                        EndIf
                    Next
                ElseIf (player[(Int local6)] <> Null) Then
                    kick((Int local6), (("[SERVER] " + player[(Int local6)]\Field15) + " has been kicked."), local4)
                    Return $00
                EndIf
                addlog("This player does not exist.", $00, $00, $01, $C0, $C0, $C0)
            Case "ban"
                If (instr(local1, " ", $01) <> $00) Then
                    local8 = left(trim(local1), (instr(local1, " ", $01) - $01))
                    local4 = mid(trim(local1), (instr(local1, " ", $01) + $01), $FFFFFFFF)
                Else
                    local8 = local1
                EndIf
                If (local4 = "") Then
                    local4 = "You've been banned from the server."
                Else
                    local4 = ("You've been banned from the server: " + local4)
                EndIf
                If (instr(local1, ".", $01) <> $00) Then
                    If (filetype("player_cache\local\ipbanlist.dat") = $00) Then
                        createfile("player_cache\local\ipbanlist.dat")
                    EndIf
                    For local7 = Each players
                        If (local7\Field40 = local8) Then
                            kick(local7\Field30, (("[SERVER] " + local7\Field15) + " has been banned."), local4)
                        EndIf
                    Next
                    local10 = (New banned)
                    local10\Field1 = local8
                    local9 = openfile("player_cache\local\ipbanlist.dat")
                    seekfile(local9, filesize("player_cache\local\ipbanlist.dat"))
                    writeline(local9, local8)
                    closefile(local9)
                Else
                    If (filetype("player_cache\local\steambanlist.dat") = $00) Then
                        createfile("player_cache\local\steambanlist.dat")
                    EndIf
                    For local7 = Each players
                        If ((Str local7\Field131) = local8) Then
                            kick(local7\Field30, (("[SERVER] " + local7\Field15) + " has been banned."), local4)
                        EndIf
                    Next
                    local10 = (New banned)
                    local10\Field2 = (Int local8)
                    local9 = openfile("player_cache\local\steambanlist.dat")
                    seekfile(local9, filesize("player_cache\local\steambanlist.dat"))
                    writeline(local9, local8)
                    closefile(local9)
                EndIf
            Default
                addlog("Unknown command, type help for command list!", $00, $00, $00, $C0, $C0, $C0)
        End Select
    EndIf
    Return $00
End Function
