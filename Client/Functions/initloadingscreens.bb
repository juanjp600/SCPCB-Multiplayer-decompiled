Function initloadingscreens%(arg0$)
    Local local0.loadingscreens
    Local local1$
    Local local2%
    Local local3%
    Local local6%
    loadingscreenamount = $00
    For local0 = Each loadingscreens
        If (local0\Field1 <> $00) Then
            freeimage(local0\Field1)
        EndIf
        Delete local0
    Next
    local3 = openfile(arg0)
    While (eof(local3) = $00)
        local1 = trim(readline(local3))
        If (left(local1, $01) = "[") Then
            local1 = mid(local1, $02, (len(local1) - $02))
            local0 = (New loadingscreens)
            loadingscreenamount = (loadingscreenamount + $01)
            local0\Field2 = loadingscreenamount
            local0\Field3 = local1
            local0\Field0 = getinistring(arg0, local1, "image path", "")
            For local2 = $00 To $04 Step $01
                local0\Field7[local2] = getinistring(arg0, local1, ("text" + (Str (local2 + $01))), "")
                If (local0\Field7[local2] <> "") Then
                    local0\Field8 = (local0\Field8 + $01)
                EndIf
            Next
            local0\Field6 = getiniint(arg0, local1, "disablebackground", $00)
            Select lower(getinistring(arg0, local1, "align x", ""))
                Case "left"
                    local0\Field4 = $FFFFFFFF
                Case "middle","center"
                    local0\Field4 = $00
                Case "right"
                    local0\Field4 = $01
            End Select
            Select lower(getinistring(arg0, local1, "align y", ""))
                Case "top","up"
                    local0\Field5 = $FFFFFFFF
                Case "middle","center"
                    local0\Field5 = $00
                Case "bottom","down"
                    local0\Field5 = $01
            End Select
        EndIf
    Wend
    closefile(local3)
    loadingscreentext = $00
    local6 = rand($01, loadingscreenamount)
    For local0 = Each loadingscreens
        If (local0\Field2 = local6) Then
            If (local0\Field1 = $00) Then
                local0\Field1 = loadimage_strict(("Loadingscreens\" + local0\Field0))
                resizeimage(local0\Field1, ((Float imagewidth(local0\Field1)) * menuscale), ((Float imageheight(local0\Field1)) * menuscale))
            EndIf
            selectedloadingscreen = local0
            Exit
        EndIf
    Next
    Return $00
End Function
