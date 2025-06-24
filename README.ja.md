# Example Detekt - GitHub ActionsによるAndroid静的解析

[![Detekt Static Analysis](https://github.com/h-nimrod/example-detekt/actions/workflows/detekt.yml/badge.svg)](https://github.com/h-nimrod/example-detekt/actions/workflows/detekt.yml)

このプロジェクトは、Android開発において**Detekt**静的コード解析と**GitHub Actions**を統合する方法を実演します。プルリクエスト時の自動的なコード品質チェックの完全なセットアップを提供します。

## 🎯 特徴

- ✅ **Detekt統合**: 最新バージョン（1.23.4）とAndroid固有のルール
- ✅ **GitHub Actionsワークフロー**: PR作成時の自動解析
- ✅ **PRコメント**: 解析結果の自動投稿
- ✅ **SARIFレポート**: GitHub Securityタブとの統合
- ✅ **複数レポート形式**: HTML、XML、Markdown、プレーンテキスト
- ✅ **Gradle統合**: シームレスなビルドプロセス統合

## 📋 Detektとは？

[Detekt](https://detekt.dev/)はKotlinプログラミング言語用の静的コード解析ツールです。Kotlinコンパイラから提供される抽象構文木を操作し、Androidプロジェクトを含む様々なプラットフォームで実行できます。

### メリット：
- **コード品質**: 潜在的なバグやコード臭を特定
- **一貫性**: チーム全体でのコーディング標準の強制
- **ベストプラクティス**: Kotlinの慣例に従った改善提案
- **技術的負債**: 技術的負債の計算と追跡

## 🚀 クイックスタート

### 1. リポジトリのクローン
```bash
git clone https://github.com/h-nimrod/example-detekt.git
cd example-detekt
```

### 2. Detektのローカル実行
```bash
./gradlew detekt
```

### 3. レポートの確認
Detekt実行後、以下でレポートを確認できます：
- **HTML**: `app/build/reports/detekt/detekt.html`
- **XML**: `app/build/reports/detekt/detekt.xml`
- **SARIF**: `app/build/reports/detekt/detekt.sarif`
- **Markdown**: `app/build/reports/detekt/detekt.md`

## 📁 プロジェクト構成

```
example-detekt/
├── .github/workflows/
│   └── detekt.yml                 # GitHub Actionsワークフロー
├── app/
│   ├── build.gradle.kts          # アプリモジュールのビルド設定
│   └── src/main/java/...         # Androidアプリのソースコード
├── detekt.yml                     # Detekt設定ファイル
├── build.gradle.kts              # プロジェクトビルド設定
└── gradle/libs.versions.toml     # 依存関係バージョン管理
```

## ⚙️ 設定詳細

### Detekt設定 (`detekt.yml`)

プロジェクトでは包括的なDetekt設定を使用：

- **複雑度ルール**: 循環複雑度、ネストブロック深度、長いメソッド
- **コード臭検出**: マジックナンバー、長いパラメータリスト、未使用コード
- **命名規則**: 関数名、変数名、パッケージ命名
- **例外処理**: 汎用例外キャッチ、スタックトレース出力
- **スタイルガイドライン**: 行の長さ、フォーマット、ドキュメント

### GitHub Actionsワークフロー (`.github/workflows/detekt.yml`)

ワークフローは自動的に：

1. **PRでトリガー**: プルリクエストの作成または更新時に実行
2. **Detekt実行**: Kotlinファイルの静的解析を実行
3. **レポート生成**: 複数形式のレポートを作成
4. **コメント投稿**: PRに結果を自動コメント
5. **SARIFアップロード**: GitHub Securityタブと統合
6. **アーティファクト処理**: 失敗したビルドのレポートを保存

### ビルド設定

#### プロジェクトレベル (`build.gradle.kts`)
```kotlin
plugins {
    alias(libs.plugins.detekt) apply false
}
```

#### アプリレベル (`app/build.gradle.kts`)
```kotlin
plugins {
    alias(libs.plugins.detekt)
}

// タスクレベル設定（新しいAPI）
tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    reports {
        html.required.set(true)
        xml.required.set(true)
        sarif.required.set(true)
        md.required.set(true)
    }
}
```

#### バージョン管理 (`gradle/libs.versions.toml`)
```toml
[versions]
detekt = "1.23.4"

[plugins]
detekt = { id = "io.gitlab.arturbosch.detekt", version.ref = "detekt" }
```

## 🔧 カスタマイズ

### Detektルールの調整

`detekt.yml`ファイルをカスタマイズして：

- **ルールの有効/無効化**: `active: true/false`を設定
- **閾値の調整**: 複雑度制限、行の長さなどを変更
- **パス除外**: テストディレクトリや特定ファイルを追加
- **カスタムルール**: 追加のルールセットを含める

例：
```yaml
complexity:
  LongMethod:
    active: true
    threshold: 60  # メソッド長制限の調整

style:
  MaxLineLength:
    active: true
    maxLineLength: 120  # 行の長さ制限の調整
```

### ワークフローのカスタマイズ

GitHub Actionsワークフローを変更して：

- **トリガー変更**: ブランチ、パス、またはイベントを変更
- **ステップ追加**: 追加のチェックや通知を含める
- **権限調整**: 必要に応じてアクセス権を変更
- **アーティファクト設定**: 保持期間や命名を変更

## 📊 レポートの理解

### 技術的負債の計算

Detektは以下に基づいて技術的負債を計算：
- **複雑度**: 循環複雑度を減らすための時間
- **コード臭**: スタイルと保守性の問題を修正する時間
- **バグリスク**: 潜在的なバグに対処する時間

### 重要度レベル

- **Error**: 即座に修正すべき重要な問題
- **Warning**: 対処すべき問題
- **Info**: 改善のための提案

## 🤝 コントリビューション

1. リポジトリをフォーク
2. フィーチャーブランチを作成
3. 変更を実施
4. Detektチェックが通ることを確認
5. プルリクエストを提出

## 📖 追加リソース

- [Detekt公式ドキュメント](https://detekt.dev/)
- [GitHub Actionsドキュメント](https://docs.github.com/en/actions)
- [Kotlinコーディング規約](https://kotlinlang.org/docs/coding-conventions.html)

## 📄 ライセンス

このプロジェクトは例として提供されており、[MITライセンス](LICENSE)の下で利用可能です。

---

**注意**: これは、Android開発ワークフローでDetektとGitHub Actionsを統合するベストプラクティスを示すデモンストレーションプロジェクトです。 