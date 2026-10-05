Function isvalidip%(arg0$)
    Local local0$
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6$
    arg0 = trim(arg0)
    If (arg0 = "") Then
        Return $00
    EndIf
    local1 = $01
    For local3 = $01 To $04 Step $01
        local2 = instr(arg0, ".", local1)
        If (local3 < $04) Then
            If (local2 = $00) Then
                Return $00
            EndIf
            local0 = mid(arg0, local1, (local2 - local1))
            local1 = (local2 + $01)
        Else
            If (local2 <> $00) Then
                Return $00
            EndIf
            local0 = mid(arg0, local1, $FFFFFFFF)
        EndIf
        If (local0 = "") Then
            Return $00
        EndIf
        If (len(local0) > $03) Then
            Return $00
        EndIf
        For local5 = $01 To len(local0) Step $01
            local6 = mid(local0, local5, $01)
            If (((local6 < "0") Or (local6 > "9")) <> 0) Then
                Return $00
            EndIf
        Next
        local4 = (Int local0)
        If (((local4 < $00) Or (local4 > $FF)) <> 0) Then
            Return $00
        EndIf
    Next
    Return $01
    Return $00
End Function
