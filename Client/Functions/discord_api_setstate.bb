Function discord_api_setstate%(arg0$, arg1%)
    If (discord_inited <> 0) Then
        Select arg1
            Case $00
                discord_setstate(arg0)
            Case $01
                discord_setdetails(arg0)
            Case $02
                discord_resettimer()
        End Select
    EndIf
    Return $00
End Function
