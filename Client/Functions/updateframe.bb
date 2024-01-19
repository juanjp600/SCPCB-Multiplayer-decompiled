Function updateframe%(arg0%)
    If (arg0 <> 0) Then
        setcurrtime(millisecs2())
        addtotimingaccumulator((getcurrtime() - getprevtime()))
        setprevtime(getcurrtime())
        fpsfactor = gettickduration()
        fpsfactor2 = gettickduration()
        fpsfactornolimit = gettickduration()
        prevfpsfactor = gettickduration()
        curtime = (Float microsecs())
        deltamillisecs = (Int (curtime - prevtime))
        elapsedtime = ((Float deltamillisecs) / 1000000.0)
        prevtime = curtime
        factordelta = max(min((elapsedtime * 70.0), 5.0), 0.0001)
    Else
        curtime = (Float microsecs())
        deltamillisecs = (Int (curtime - prevtime))
        elapsedtime = ((curtime - prevtime) / 1000000.0)
        prevtime = curtime
        prevfpsfactor = fpsfactor
        fpsfactor = max(min((elapsedtime * 70.0), 5.0), 0.0001)
        fpsfactornolimit = max((elapsedtime * 70.0), 0.0001)
        fpsfactor2 = fpsfactor
    EndIf
    If (framelimit > $00) Then
        executeframelimit(framelimit, millisecs(), loopdelay)
        loopdelay = millisecs()
    ElseIf (networkserver\Field60 <> 0) Then
        executeframelimit($12C, millisecs(), loopdelay)
        loopdelay = millisecs()
    EndIf
    If (checkfps < millisecs2()) Then
        fps = elapsedloops
        elapsedloops = $00
        checkfps = (millisecs2() + $3E8)
    EndIf
    elapsedloops = (elapsedloops + $01)
    tickscount = (tickscount + $01)
    Return $00
End Function
