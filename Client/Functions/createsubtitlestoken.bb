Function createsubtitlestoken%(arg0$, arg1.sound)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10$
    Local local11#
    Local local12#
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    If (((opt\Field25 = $00) Lor (subtitlesinit = $00)) <> 0) Then
        Return $00
    EndIf
    If (selecteddifficulty\Field0 = difficulties[$03]\Field0) Then
        Return $00
    EndIf
    local1 = jsongetvalue(localsubfile, arg0)
    If ((jsonisnull(local1) Lor (jsonisarray(local1) = $00)) <> 0) Then
        local2 = jsongetvalue(localsubfile, "fallback")
        If ((jsongetbool(local2) Lor jsonisnull(local2)) <> 0) Then
            local1 = jsongetvalue(subfile, arg0)
        EndIf
        If (jsonisarray(local1) = $00) Then
            Return $00
        EndIf
    EndIf
    local3 = jsongetarray(local1)
    local4 = jsongetarraysize(local3)
    For local0 = $00 To (local4 - $01) Step $01
        local5 = jsongetarrayvalue(local3, local0)
        local6 = jsongetvalue(local5, "text")
        local7 = jsongetvalue(local5, "delay")
        local8 = jsongetvalue(local5, "length")
        local10 = "missingno"
        local11 = 0.0
        local12 = 10.0
        local13 = $FF
        local14 = $FF
        local15 = $FF
        If (jsonisstring(local6) <> 0) Then
            local10 = jsongetstring(local6)
        EndIf
        If (jsonisfloat(local7) <> 0) Then
            local11 = jsongetfloat(local7)
        EndIf
        If (jsonisfloat(local8) <> 0) Then
            local12 = jsongetfloat(local8)
        EndIf
        If (jsonisnull(jsongetvalue(local5, "color")) = $00) Then
            local9 = jsongetvalue(subcolors, jsongetstring(jsongetvalue(local5, "color")))
            If (jsonisarray(local9) = $00) Then
                local9 = jsongetvalue(localsubcolors, jsongetstring(jsongetvalue(local5, "color")))
            EndIf
            If (jsonisarray(local9) <> 0) Then
                local16 = jsongetarray(local9)
                local13 = jsongetint(jsongetarrayvalue(local16, $00))
                local14 = jsongetint(jsongetarrayvalue(local16, $01))
                local15 = jsongetint(jsongetarrayvalue(local16, $02))
            EndIf
        EndIf
        queuesubtitlesmsg(arg0, arg1, local10, local11, local12, local13, local14, local15)
    Next
    Return $00
End Function
