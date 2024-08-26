Function requestdatafromglobal%()
    Local local0%
    Local local1.steaminstances
    Local local2%
    Local local3$
    Local local4%
    Local local5%
    Local local6%
    Local local7$
    Local local8%
    If (centralserver\Field1 <> $00) Then
        closeudpstream(centralserver\Field1)
    EndIf
    centralserver\Field1 = createudpstream($00)
    tcptimeouts($2710, $00)
    local0 = downloadfile("http://127.0.0.1/SteamTags.txt")
    If (local0 <> $00) Then
        For local1 = Each steaminstances
            If (local1\Field5 <> 0) Then
                Delete local1
            EndIf
        Next
        While (eof(local0) = $00)
            If (readline(local0) = "ContainTag") Then
                local2 = (Int readline(local0))
                local3 = readline(local0)
                local4 = (Int readline(local0))
                local5 = (Int readline(local0))
                local6 = (Int readline(local0))
                createsteaminstance(local2, local3, local4, local5, local6, $01)
            EndIf
        Wend
        closetcpstream(local0)
    EndIf
    If (server\Field70 = $00) Then
        local0 = downloadfile("http://127.0.0.1/CentralServersUdp.txt")
        If (local0 <> $00) Then
            If (readline(local0) = "ContainServers") Then
                Delete Each centralserversegments
                While (eof(local0) = $00)
                    local7 = readline(local0)
                    local8 = (Int readline(local0))
                    addcentralserver(local7, local8)
                Wend
            EndIf
            closetcpstream(local0)
        EndIf
    Else
        startcentralservertcpproxy()
        addcentralserver("127.0.0.1", $3039)
    EndIf
    tcptimeouts($00, $00)
    Return $00
End Function
