Function isfoldersecured%(arg0$)
    Local local0$
    Local local1%
    Local local2$
    Local local3$
    Local local5%
    If (((len(arg0) = $00) Or (len(arg0) > $F0)) <> 0) Then
        Return $00
    EndIf
    If (((left(arg0, $01) = "\") Or (left(arg0, $01) = "/")) <> 0) Then
        Return $00
    EndIf
    If (((instr(arg0, "..", $01) Or instr(arg0, "%", $01)) Or instr(arg0, "&", $01)) <> 0) Then
        Return $00
    EndIf
    local0 = ""
    For local1 = $01 To (len(arg0) + $01) Step $01
        local2 = "\"
        If (local1 <= len(arg0)) Then
            local2 = mid(arg0, local1, $01)
        EndIf
        If (((local2 = "\") Or (local2 = "/")) <> 0) Then
            If ((((len(local0) = $00) Or (right(local0, $01) = ".")) Or (right(local0, $01) = " ")) <> 0) Then
                Return $00
            EndIf
            local3 = lower(local0)
            If (instr(local3, ".", $01) <> 0) Then
                local3 = left(local3, (instr(local3, ".", $01) - $01))
            EndIf
            Select local3
                Case "con","conin$","conout$","prn","aux","nul","com0","com1","com2","com3","com4","com5","com6","com7","com8","com9","lpt0","lpt1","lpt2","lpt3","lpt4","lpt5","lpt6","lpt7","lpt8","lpt9"
                    Return $00
            End Select
            local0 = ""
        Else
            local5 = asc(local2)
            If (((local5 < $20) Or (local5 > $7E)) <> 0) Then
                Return $00
            EndIf
            If (instr(((":*?" + chr($22)) + "<>|"), local2, $01) <> 0) Then
                Return $00
            EndIf
            local0 = (local0 + local2)
        EndIf
    Next
    Select lower(right(arg0, $04))
        Case ".exe",".dll",".vbs",".bat",".cmd",".com",".scr",".pif",".hta",".lnk",".url",".reg",".msi"
            Return $00
    End Select
    Return $01
    Return $00
End Function
