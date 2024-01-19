Function getinistring$(arg0$, arg1$, arg2$, arg3$)
    Local local0$
    Local local1.inifile
    Local local2.inifile
    Local local3$
    local0 = ""
    local1 = Null
    For local2 = Each inifile
        If (local2\Field0 = lower(arg0)) Then
            local1 = local2
        EndIf
    Next
    If (local1 = Null) Then
        debuglog(("CREATE BANK FOR " + arg0))
        local1 = (New inifile)
        local1\Field0 = lower(arg0)
        local1\Field1 = $00
        updateinifile(local1\Field0)
    EndIf
    local1\Field2 = $00
    arg1 = lower(arg1)
    While (local1\Field2 < local1\Field3)
        local3 = readiniline(local1)
        If (left(local3, $01) = "[") Then
            local3 = lower(local3)
            If (mid(local3, $02, (len(local3) - $02)) = arg1) Then
                Repeat
                    local0 = readiniline(local1)
                    If (lower(trim(left(local0, (Int max((Float (instr(local0, "=", $01) - $01)), 0.0))))) = lower(arg2)) Then
                        Return trim(right(local0, (len(local0) - instr(local0, "=", $01))))
                    EndIf
                Until (((left(local0, $01) = "[") Or (local1\Field2 >= local1\Field3)) <> 0)
                Return arg3
            EndIf
        EndIf
    Wend
    Return arg3
    Return ""
End Function
