Function deletegame%(arg0.save)
    Local local0%
    Local local1$
    arg0\Field0 = (("Saves\" + arg0\Field0) + "\")
    local0 = readdir(arg0\Field0)
    If (local0 <> $00) Then
        nextfile(local0)
        nextfile(local0)
        local1 = nextfile(local0)
        While (local1 <> "")
            deletefile((arg0\Field0 + local1))
            local1 = nextfile(local0)
        Wend
        closedir(local0)
        deletedir(arg0\Field0)
        savedgamesamount = (savedgamesamount - $01)
    EndIf
    Delete arg0
    Return $00
End Function
