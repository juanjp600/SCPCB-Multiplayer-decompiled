Function loadinternetservers%(arg0$)
    Local local0$
    Local local1%
    Local local2$
    Local local3.blacklistedservers
    Local local4$
    Local local5%
    Local local6$
    Local local7$
    Local local8%
    Local local9%
    local0 = right(arg0, (len(arg0) - $07))
    local1 = downloadfile((arg0 + "BlacklistedServers.txt"))
    If (local1 <> $00) Then
        If (readline(local1) = "SCP-CB Multiplayer Mod Blacklisted Servers") Then
            While (eof(local1) = $00)
                local2 = readline(local1)
                local3 = (New blacklistedservers)
                local3\Field0 = local2
            Wend
        EndIf
    EndIf
    If (counthostips(left(local0, (len(local0) - $01))) <> $00) Then
        local1 = downloadfile((arg0 + "Servers.txt"))
        If (local1 <> $00) Then
            local5 = $00
            If (readline(local1) = "SCP-CB Multiplayer Mod Servers") Then
                While (eof(local1) = $00)
                    local6 = readline(local1)
                    local7 = piece(local6, $01, ",")
                    local2 = left(local7, (instr(local7, ":", $01) - $01))
                    local8 = (Int right(local7, (len(local7) - instr(local7, ":", $01))))
                    multiplayer_list_addserver(local2, local8, (Int piece(local6, $02, ",")), $00, $00)
                    local5 = $01
                Wend
            EndIf
            closetcpstream(local1)
        EndIf
        local1 = downloadfile((arg0 + "Button.txt"))
        If (local1 <> $00) Then
            host_server_button_text = readline(local1)
            multiplayer_get_limit = (Int readline(local1))
            update_doors_distance = (Int readline(local1))
            If (host_server_button_text = "") Then
                host_server_button_text = "CREATE LOBBY"
            EndIf
            closetcpstream(local1)
        EndIf
    EndIf
    If (local5 = $00) Then
        local1 = readfile("Data\servers")
        If (local1 <> $00) Then
            local5 = $00
            If (readline(local1) <> "SCP-CB Multiplayer Mod Servers") Then
                seekfile(local1, filesize((Str local9)))
            EndIf
            While (eof(local1) = $00)
                local6 = readline(local1)
                local7 = piece(local6, $01, ",")
                local2 = left(local7, (instr(local7, ":", $01) - $01))
                local8 = (Int right(local7, (len(local7) - instr(local7, ":", $01))))
                multiplayer_list_addserver(local2, local8, (Int piece(local6, $02, ",")), $00, $00)
                local5 = $01
            Wend
            closefile(local1)
        EndIf
    EndIf
    Return local1
    Return $00
End Function
