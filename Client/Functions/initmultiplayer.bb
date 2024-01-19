Function initmultiplayer%(arg0%, arg1%)
    Local local0%
    Local local2%
    If (arg0 <> $FFFFFFFF) Then
        local0 = arg0
    EndIf
    Repeat
        Select local0
            Case $00
                initmultiplayerimages()
                local0 = (local0 + $01)
            Case $01
                loadmultiplayeroptions($00)
                local0 = (local0 + $01)
            Case $02
                loadnecessaryentities()
                local0 = (local0 + $01)
            Case $03
                local0 = (local0 + $01)
            Case $04
                local2 = loadinternetservers("http://127.0.0.1/")
                local0 = (local0 + $01)
            Case $05
                local0 = (local0 + $01)
                Exit
        End Select
    Forever
    Return $00
End Function
