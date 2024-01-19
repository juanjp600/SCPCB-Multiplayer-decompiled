Function downloadfile%(arg0$)
    Local local0%
    Local local1$
    Local local2$
    Local local3%
    Local local4$
    Local local5%
    If (left(arg0, $08) = "https://") Then
        arg0 = right(arg0, (len(arg0) - $08))
    ElseIf (left(arg0, $07) = "http://") Then
        arg0 = right(arg0, (len(arg0) - $07))
    EndIf
    local0 = instr(arg0, "/", $01)
    If (local0 <> 0) Then
        local1 = left(arg0, (local0 - $01))
        arg0 = right(arg0, ((len(arg0) - local0) + $01))
    Else
        local1 = arg0
        arg0 = "/"
    EndIf
    If (local2 = "") Then
        local3 = len(arg0)
        While (local3 >= $01)
            local4 = mid(arg0, local3, $01)
            If (local4 = "/") Then
                local2 = right(arg0, (len(arg0) - local3))
                Exit
            EndIf
            local3 = (local3 + $FFFFFFFF)
        Wend
    EndIf
    If (counthostips(local1) <> $00) Then
        local5 = opentcpstream(local1, $50, $00)
        If (local5 = $00) Then
            Return $00
        EndIf
        writeline(local5, (("GET " + arg0) + " HTTP/1.1"))
        writeline(local5, ("Host: " + local1))
        writeline(local5, "User-Agent: SCP-CB Multiplayer Mod")
        writeline(local5, "Connection: Close")
        writeline(local5, "")
        Repeat
        Until (readline(local5) = "")
        Return local5
    EndIf
    Return $00
    Return $00
End Function
