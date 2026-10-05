Function updateframe%()
    Local local0%
    If (framelimit > $00) Then
        capfps(framelimit)
    Else
        uncapfps()
    EndIf
    curtime = millisecs()
    local0 = (curtime - prevtime)
    prevtime = curtime
    prevfpsfactor = fpsfactor
    fpsfactor = min((((Float local0) / 1000.0) * 70.0), 5.0)
    fpsfactor2 = fpsfactor
    If (checkfps < curtime) Then
        fps = elapsedloops
        elapsedloops = $00
        checkfps = (curtime + $3E8)
    EndIf
    elapsedloops = (elapsedloops + $01)
    Return $00
End Function
