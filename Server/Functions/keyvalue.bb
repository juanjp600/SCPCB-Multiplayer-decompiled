Function keyvalue$(arg0%, arg1$, arg2$)
    Local local0$
    Local local1%
    Local local2$
    Local local3$
    Local local4$
    local0 = entityname(arg0)
    local0 = replace(local0, chr($0D), "")
    arg1 = lower(arg1)
    Repeat
        local1 = instr(local0, chr($0A), $01)
        If (local1 <> 0) Then
            local2 = left(local0, (local1 - $01))
        Else
            local2 = local0
        EndIf
        local3 = piece(local2, $01, "=")
        local3 = trim(local3)
        local3 = replace(local3, chr($22), "")
        local3 = lower(local3)
        If (local3 = arg1) Then
            local4 = piece(local2, $02, "=")
            local4 = trim(local4)
            local4 = replace(local4, chr($22), "")
            Return local4
        EndIf
        If (local1 = $00) Then
            Return arg2
        EndIf
        local0 = right(local0, (len(local0) - local1))
    Forever
    Return ""
End Function
