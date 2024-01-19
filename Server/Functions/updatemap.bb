Function updatemap%(arg0%)
    Local local0.rooms
    Local local1%
    If (framelimit > $00) Then
        delay((Int ((1000.0 / (Float framelimit)) - (Float (millisecs2() - loopdelay)))))
        loopdelay = millisecs2()
    EndIf
    If (playerroom = Null) Then
        For local0 = Each rooms
            If (local0\Field7\Field10 = "pocketdimension") Then
                playerroom = local0
                Exit
            EndIf
        Next
    EndIf
    If (fixedtimesteps <> 0) Then
        setcurrtime(millisecs2())
        addtotimingaccumulator((getcurrtime() - getprevtime()))
        setprevtime(getcurrtime())
        fpsfactor = gettickduration()
        fpsfactor2 = fpsfactor
        While (0.0 < ft\Field1)
            ft\Field1 = (ft\Field1 - gettickduration())
            If (getscripts() <> 0) Then
                local1 = public_inqueue($3C, $00)
                public_addparam(local1, (Str fpsfactor), $02)
                callback($00)
            EndIf
            updateservermain()
        Wend
    Else
        curtime = (Float microsecs())
        elapsedtime = ((curtime - prevtime) / 1000000.0)
        prevtime = curtime
        prevfpsfactor = fpsfactor
        fpsfactor = min(max((elapsedtime * 70.0), 0.000001), fpsfactorlimit)
        fpsfactor2 = fpsfactor
        If (getscripts() <> 0) Then
            local1 = public_inqueue($3C, $00)
            public_addparam(local1, (Str fpsfactor), $02)
            callback($00)
        EndIf
        updateservermain()
    EndIf
    Return $00
End Function
