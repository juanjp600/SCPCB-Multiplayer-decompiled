Function voice_isrecording%()
    Return ((((keydown(key_voice) And (networkserver\Field27 = $00)) And (consoleopen = $00)) And (menuopen = $00)) Or networkserver\Field26)
    Return $00
End Function
